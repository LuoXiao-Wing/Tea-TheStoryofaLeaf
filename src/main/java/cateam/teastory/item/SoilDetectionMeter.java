package cateam.teastory.item;

import java.util.List;

import cateam.teastory.achievement.AchievementLoader;
import cateam.teastory.block.Barrel;
import cateam.teastory.block.BlockLoader;
import cateam.teastory.block.Teapan;
import cateam.teastory.block.Teaplant;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemDye;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraft.util.text.translation.I18n;
import net.minecraft.world.EnumSkyBlock;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class SoilDetectionMeter extends TSItem
{
	public SoilDetectionMeter() {
		super("soil_detection_meter", 1);
	}
	
	@Override
	public void addInformation(ItemStack itemstack, EntityPlayer entityplayer, List list, boolean b)
    {
        list.add(I18n.translateToLocal("teastory.tooltip.soil_detection_meter"));
    }
	
	@Override
	public EnumActionResult onItemUse(ItemStack stack, EntityPlayer playerIn, World worldIn, BlockPos pos, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ)
    {
		if(worldIn.isRemote)
		{
		    Biome biome = worldIn.getBiome(pos);
            float humidity = biome.getRainfall();
            float temperature = biome.getFloatTemperature(pos);
            String temp = (temperature >= 0.15F) ? (temperature >= 0.5F) ? (temperature > 0.95F) ? I18n.translateToLocal("teastory.soil_detection_meter.temperature.hot") : I18n.translateToLocal("teastory.soil_detection_meter.temperature.warm") : I18n.translateToLocal("teastory.soil_detection_meter.temperature.cold") : I18n.translateToLocal("teastory.soil_detection_meter.temperature.snowy");
            String rainfall = (humidity >= 0.2F) ? (humidity >= 0.5F) ? (humidity >= 0.8F) ? I18n.translateToLocal("teastory.soil_detection_meter.humidity.humid") : I18n.translateToLocal("teastory.soil_detection_meter.humidity.semi-humid") : I18n.translateToLocal("teastory.soil_detection_meter.humidity.semi-arid") : I18n.translateToLocal("teastory.soil_detection_meter.humidity.arid");
            int height = pos.getY();
            playerIn.addChatMessage(new TextComponentTranslation("teastory.soil_detection_meter.message.total", temp, rainfall, ("\u00a78" + String.valueOf(height)), ("\u00a7b" + biome.getBiomeName())));
            
            float FermentationChance = Barrel.getFermentationChance(worldIn, pos, true);
            String fermentation1 = (FermentationChance >= 0.50F) ? (FermentationChance >= 1.00F) ? I18n.translateToLocal("teastory.soil_detection_meter.fast") : I18n.translateToLocal("teastory.soil_detection_meter.normal") : I18n.translateToLocal("teastory.soil_detection_meter.slow");
            String fermentation2 = ((FermentationChance/2) >= 0.50F) ? ((FermentationChance/2) >= 1.00F) ? I18n.translateToLocal("teastory.soil_detection_meter.fast") : I18n.translateToLocal("teastory.soil_detection_meter.normal") : I18n.translateToLocal("teastory.soil_detection_meter.slow");
            String fermentationRate1 =  (FermentationChance >= 0.50F) ? (FermentationChance >= 1.00F) ? String.valueOf("\u00a7a" + (int)(FermentationChance * 100) + "%") : String.valueOf("\u00a7e" + (int)(FermentationChance * 100) + "%") : String.valueOf("\u00a7c" + (int)(FermentationChance / 2.0F * 100) + "%");
            String fermentationRate2 =  ((FermentationChance/2) >= 0.50F) ? ((FermentationChance/2) >= 1.00F) ? String.valueOf("\u00a7a" + (int)(FermentationChance / 2.0F * 100) + "%") : String.valueOf("\u00a7e" + (int)(FermentationChance / 2.0F * 100) + "%") : String.valueOf("\u00a7c" + (int)(FermentationChance / 4.0F * 100) + "%");
            playerIn.addChatMessage(new TextComponentTranslation("teastory.soil_detection_meter.message.fermentation", fermentation1, fermentationRate1, fermentation2, fermentationRate2));
            
            float DryingChance1 = Teapan.getDryingChance(worldIn, pos, true) * 1.5F;
            float DryingChance2 = Teapan.getDryingChance(worldIn, pos, false) * 1.5F;
            String drying1 = ((DryingChance1) >= 0.50F) ? ((DryingChance1) >= 1.0F) ? I18n.translateToLocal("teastory.soil_detection_meter.fast") : I18n.translateToLocal("teastory.soil_detection_meter.normal") : I18n.translateToLocal("teastory.soil_detection_meter.slow");
            String drying2 = ((DryingChance2) >= 0.50F) ? ((DryingChance2) >= 1.0F) ? I18n.translateToLocal("teastory.soil_detection_meter.fast") : I18n.translateToLocal("teastory.soil_detection_meter.normal") : I18n.translateToLocal("teastory.soil_detection_meter.slow");
            String dryingRate1 =  ((DryingChance1) >= 0.50F) ? ((DryingChance1) >= 1.0F) ? String.valueOf("\u00a7a" + (int)(DryingChance1 * 100) + "%") : String.valueOf("\u00a7e" + (int)(DryingChance1 * 100) + "%") : String.valueOf("\u00a7c" + (int)(DryingChance1 * 100) + "%");
            String dryingRate2 =  ((DryingChance2) >= 0.50F) ? ((DryingChance2) >= 1.0F) ? String.valueOf("\u00a7a" + (int)(DryingChance2 * 100) + "%") : String.valueOf("\u00a7e" + (int)(DryingChance2 * 100) + "%") : String.valueOf("\u00a7c" + (int)(DryingChance2 * 100) + "%");
            playerIn.addChatMessage(new TextComponentTranslation("teastory.soil_detection_meter.message.drying", drying1, dryingRate1, drying2, dryingRate2));
            
            int chance = (int)(Teaplant.environmentChance(worldIn, pos) * 250);
            String f = (chance < 80) ? (chance < 40) ? String.valueOf("\u00a7c" + chance + "%") : String.valueOf("\u00a7e" + chance + "%") : String.valueOf("\u00a7a" + chance + "%");
            String h = (height <= 110) ? (height < 80) ? I18n.translateToLocal("teastory.soil_detection_meter.height.low") : I18n.translateToLocal("teastory.soil_detection_meter.height.medium") : I18n.translateToLocal("teastory.soil_detection_meter.height.high");
            playerIn.addChatMessage(new TextComponentTranslation("teastory.soil_detection_meter.message.teaplant", f, h));
            return EnumActionResult.SUCCESS;
		}
		else 
		{
			playerIn.addStat(AchievementLoader.soilDetectionMeter);
			return EnumActionResult.SUCCESS;
		}
    }
}
