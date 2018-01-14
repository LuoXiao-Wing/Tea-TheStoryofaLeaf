package cateam.teastory.block;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Nullable;

import cateam.teastory.item.ItemLoader;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.items.ItemHandlerHelper;

public class TeaDrinkEmpty extends TeaDrink
{
	public TeaDrinkEmpty(float hardness, String name, Material materialIn, SoundType soundType, int level)
	{
		super(hardness, name, materialIn, soundType, level);
	}

	@Override
	public ArrayList getDrops(IBlockAccess world, BlockPos pos, IBlockState blockstate, int fortune)
	{
		ArrayList drops = new ArrayList();
		drops.add(new ItemStack(ItemLoader.cup, 1, meta));
		return drops;
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void getSubBlocks(Item itemIn, CreativeTabs tab, List list) {
		list.add(new ItemStack(ItemLoader.cup, 1, meta));
	}

	@Override
	public ItemStack getItem(World worldIn, BlockPos pos, IBlockState state)
	{
		return new ItemStack(ItemLoader.cup, 1, meta);
	}

	@Override
	public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumHand hand, @Nullable ItemStack heldItem, EnumFacing side, float hitX, float hitY, float hitZ)
	{
		if (playerIn.isSneaking())
		{
			ItemHandlerHelper.giveItemToPlayer(playerIn, new ItemStack(ItemLoader.cup, 1, meta));
			worldIn.setBlockState(pos, Blocks.AIR.getDefaultState());
			return true;
		}
		return false;
	}
}
