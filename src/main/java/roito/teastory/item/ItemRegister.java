package roito.teastory.item;

import net.minecraft.client.renderer.block.model.ModelBakery;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.init.Blocks;
import net.minecraft.item.*;
import net.minecraft.util.NonNullList;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import roito.teastory.TeaStory;
import roito.teastory.block.BlockRegister;
import roito.teastory.common.CreativeTabsRegister;
import roito.teastory.item.drink.*;

@Mod.EventBusSubscriber(modid = TeaStory.MODID)
public final class ItemRegister
{
    // 茶叶 Tea Leaves
    public static Item tea_leaf = new TSItem("tea_leaf", 64, CreativeTabsRegister.tabTeaStory);
    public static Item half_dried_tea = new TSItem("half_dried_tea", 64, CreativeTabsRegister.tabTeaStory);
    public static Item matcha_leaf = new TSItem("matcha_leaf", 64, CreativeTabsRegister.tabTeaStory);
    public static Item wet_tea = new TSItem("wet_tea", 64, CreativeTabsRegister.tabTeaStory);
    public static Item broken_tea = new TSItem("broken_tea", 64, CreativeTabsRegister.tabTeaStory);
    public static Item tea_seeds = new TeaSeeds();
    public static Item tea_residue = new TeaResidue();

    public static ItemTeaLeaf dried_tea = new ItemTeaLeaf("dried_tea", 64);
    public static ItemTeaLeaf matcha_powder = new ItemTeaLeaf("matcha_powder", 64);
    public static ItemTeaLeaf black_tea_leaf = new ItemTeaLeaf("black_tea_leaf", 64);
    public static ItemTeaLeaf yellow_tea_leaf = new ItemTeaLeaf("yellow_tea_leaf", 64);
    public static ItemTeaLeaf white_tea_leaf = new ItemTeaLeaf("white_tea_leaf", 64);
    public static ItemTeaLeaf oolong_tea_leaf = new ItemTeaLeaf("oolong_tea_leaf", 64);
    public static ItemTeaLeaf puer_tea_leaf = new ItemTeaLeaf("puer_tea_leaf", 64);

    public static Item empty_tea_bag = new TSItem("empty_tea_bag", 64, CreativeTabsRegister.tabTeaStory);
    public static ItemTeaLeaf green_tea_bag = new ItemTeaLeaf("green_tea_bag", 64);
    public static ItemTeaLeaf black_tea_bag = new ItemTeaLeaf("black_tea_bag", 64);
    public static ItemTeaLeaf yellow_tea_bag = new ItemTeaLeaf("yellow_tea_bag", 64);
    public static ItemTeaLeaf white_tea_bag = new ItemTeaLeaf("white_tea_bag", 64);
    public static ItemTeaLeaf oolong_tea_bag = new ItemTeaLeaf("oolong_tea_bag", 64);
    public static ItemTeaLeaf puer_tea_bag = new ItemTeaLeaf("puer_tea_bag", 64);

    // 稻米 Rice
    public static Item xian_rice_seeds = new ItemSeeds(BlockRegister.xian_rice_seedling, Blocks.FARMLAND).setTranslationKey("xian_rice_seeds").setRegistryName(new ResourceLocation(TeaStory.MODID, "xian_rice_seeds")).setCreativeTab(CreativeTabsRegister.tabRice);
    public static Item xian_rice_seedlings = new ItemRiceSeedling();
    public static Item straw = new TSItem("straw", 64, CreativeTabsRegister.tabRice)
    {
        @Override
        public int getItemBurnTime(ItemStack itemStack)
        {
            return 200;
        }
    };
    public static Item xian_rice = new TSItem("xian_rice", 64, CreativeTabsRegister.tabRice);
    public static Item washed_rice = new TSItem("washed_rice", 64, CreativeTabsRegister.tabRice);
    public static Item wooden_lid = new TSItem("wooden_lid", 64, CreativeTabsRegister.tabRice);
    public static Item straw_rope = new TSItem("straw_rope", 64, CreativeTabsRegister.tabRice)
    {
        @Override
        public int getItemBurnTime(ItemStack itemStack)
        {
            return 400;
        }
    };

    public static Item rice_ball = new ItemFood(8, 0.6F, false).setTranslationKey("rice_ball").setRegistryName(new ResourceLocation(TeaStory.MODID, "rice_ball")).setCreativeTab(CreativeTabsRegister.tabRice);
    public static Item porkchop_rice = new TSItemFoodWithBowl("porkchop_rice", 19, 0.5F);
    public static Item steak_rice = new TSItemFoodWithBowl("steak_rice", 19, 0.5F);
    public static Item chicken_rice = new TSItemFoodWithBowl("chicken_rice", 17, 0.5F);
    public static Item potato_rice = new TSItemFoodWithBowl("potato_rice", 15, 0.5F);
    public static Item rabbit_rice = new TSItemFoodWithBowl("rabbit_rice", 15, 0.5F);

    // 茶具 Tea Sets
    public static Item pot_stone = new ItemEmptyPot("pot_stone");
    public static Item pot_iron = new ItemEmptyPot("pot_iron");
    public static Item pot_porcelain = new ItemEmptyPot("pot_porcelain");
    public static Item pot_zisha = new ItemEmptyPot("pot_zisha");
    public static Item pot_clay = new TSItem("pot_clay", 64, CreativeTabsRegister.tabDrink);
    public static Item pot_zisha_clay = new TSItem("pot_zisha_clay", 64, CreativeTabsRegister.tabDrink);
    public static Item cw_pot_stone = new TSItem("cold_water_pot_stone", 64, CreativeTabsRegister.tabDrink);
    public static Item cw_pot_iron = new TSItem("cold_water_pot_iron", 64, CreativeTabsRegister.tabDrink);
    public static Item cw_pot_porcelain = new TSItem("cold_water_pot_porcelain", 64, CreativeTabsRegister.tabDrink);
    public static Item cw_pot_zisha = new TSItem("cold_water_pot_zisha", 64, CreativeTabsRegister.tabDrink);
    public static Item clay_cup = new TSItem("clay_cup", 64, CreativeTabsRegister.tabDrink);
    public static Item zisha_clay_cup = new TSItem("zisha_clay_cup", 64, CreativeTabsRegister.tabDrink);
    public static Item cup = new ItemCup();
    public static Item tea_whisk = new TSItem("tea_whisk", 1, CreativeTabsRegister.tabDrink).setMaxDamage(64);

    public static Item zisha_clay = new TSItem("zisha_clay", 64, CreativeTabsRegister.tabDrink);

    // 茶饮 Tea Drink
    public static Item hw_pot_stone = new ItemWaterPot("pot_stone", 2);
    public static Item hw_pot_iron = new ItemWaterPot("pot_iron", 4);
    public static Item hw_pot_porcelain = new ItemWaterPot("pot_porcelain", 8);
    public static Item hw_pot_zisha = new ItemWaterPot("pot_zisha", 16);

    public static ItemTeaDrink green_tea = new GreenTea();
    public static ItemTeaDrink matcha_drink = new MatchaDrink();
    public static ItemTeaDrink black_tea = new BlackTea();
    public static ItemTeaDrink milk_tea = new MilkTea();
    public static ItemTeaDrink lemon_tea = new LemonTea();
    public static ItemTeaDrink yellow_tea = new YellowTea();
    public static ItemTeaDrink white_tea = new WhiteTea();
    public static ItemTeaDrink oolong_tea = new OolongTea();
    public static ItemTeaDrink puer_tea = new PuerTea();

    public static ItemFood tea_egg = new TeaEgg();
    public static ItemFood matcha_cookie = new MatchaCookie();

    // 其他工具 Other Tools
    public static Item wooden_mortar_and_pestle = new MortarAndPestle("wooden_mortar_and_pestle", 128);
    public static Item soil_detection_meter = new SoilDetectionMeter();
    public static Item straw_blanket = new ItemStrawBlanket()
    {
        @Override
        public int getItemBurnTime(ItemStack itemStack)
        {
            return 800;
        }
    };
    public static Item sickle = new ItemSickle();
    public static Item lemon = new ItemLemon();
    public static ItemSword shennongruler = new ShennongRuler();

    // 唱片 Records
    public static ItemRecord caichawuqu_g20 = new Record("caichawuqu_g20", "record_caichawuqu_g20", new ResourceLocation(TeaStory.MODID, "records.caichawuqu_g20"));
    public static ItemRecord caichawuqu_folk = new Record("caichawuqu_folk", "record_caichawuqu_folk", new ResourceLocation(TeaStory.MODID, "records.caichawuqu_folk"));
    public static ItemRecord bubugao = new Record("bubugao", "record_bubugao", new ResourceLocation(TeaStory.MODID, "records.bubugao"));
    public static ItemRecord caichaji_erhu = new Record("caichaji_erhu", "record_caichaji_erhu", new ResourceLocation(TeaStory.MODID, "records.caichaji_erhu"));
    public static ItemRecord chunjiexuqu = new Record("chunjiexuqu", "record_chunjiexuqu", new ResourceLocation(TeaStory.MODID, "records.chunjiexuqu"));
    public static ItemRecord huahaoyueyuan = new Record("huahaoyueyuan", "record_huahaoyueyuan", new ResourceLocation(TeaStory.MODID, "records.huahaoyueyuan"));
    public static ItemRecord jinshekuangwu = new Record("jinshekuangwu", "record_jinshekuangwu", new ResourceLocation(TeaStory.MODID, "records.jinshekuangwu"));
    public static ItemRecord xiyangyang = new Record("xiyangyang", "record_xiyangyang", new ResourceLocation(TeaStory.MODID, "records.xiyangyang"));
    public static ItemRecord yangliuqing = new Record("yangliuqing", "record_yangliuqing", new ResourceLocation(TeaStory.MODID, "records.yangliuqing"));
    public static ItemRecord zizhudiao = new Record("zizhudiao", "record_zizhudiao", new ResourceLocation(TeaStory.MODID, "records.zizhudiao"));

    public ItemRegister()
    {
        MinecraftForge.EVENT_BUS.register(this);
    }

    @SideOnly(Side.CLIENT)
    public static void initModels()
    {
        registerRender(tea_leaf);
        registerRender(half_dried_tea);
        registerRender(dried_tea);
        registerRender(green_tea);
        registerRender(black_tea);
        registerRender(wet_tea);
        registerRender(broken_tea);
        registerRender(matcha_powder);
        registerRender(wooden_mortar_and_pestle);
        registerRender(soil_detection_meter);
        registerRender(black_tea_leaf);
        registerRender(matcha_leaf);
        registerRender(yellow_tea_leaf);
        registerRender(white_tea_leaf);
        registerRender(oolong_tea_leaf);
        registerRender(puer_tea_leaf);
        registerRender(clay_cup);
        registerRender(cup);
        registerRender(tea_seeds);
        registerRender(matcha_drink);
        registerRender(lemon_tea);
        registerRender(milk_tea);
        registerRender(yellow_tea);
        registerRender(white_tea);
        registerRender(oolong_tea);
        registerRender(puer_tea);
        registerRender(tea_residue);
        registerRender(empty_tea_bag);
        registerRender(green_tea_bag);
        registerRender(black_tea_bag);
        registerRender(yellow_tea_bag);
        registerRender(white_tea_bag);
        registerRender(oolong_tea_bag);
        registerRender(puer_tea_bag);
        registerRender(tea_egg);
        registerRender(shennongruler);
        registerRender(caichawuqu_g20);
        registerRender(caichawuqu_folk);
        registerRender(bubugao);
        registerRender(caichaji_erhu);
        registerRender(chunjiexuqu);
        registerRender(huahaoyueyuan);
        registerRender(jinshekuangwu);
        registerRender(xiyangyang);
        registerRender(yangliuqing);
        registerRender(zizhudiao);
        registerRender(xian_rice_seeds);
        registerRender(xian_rice_seedlings);
        registerRender(straw);
        registerRender(xian_rice);
        registerRender(washed_rice);
        registerRender(wooden_lid);
        registerRender(rice_ball);
        registerRender(straw_rope);
        registerRender(straw_blanket);
        registerRender(sickle);
        registerRender(porkchop_rice);
        registerRender(steak_rice);
        registerRender(chicken_rice);
        registerRender(potato_rice);
        registerRender(rabbit_rice);
        registerRender(tea_whisk);
        registerRender(lemon);
        registerRender(pot_stone);
        registerRender(pot_iron);
        registerRender(pot_porcelain);
        registerRender(pot_zisha);
        registerRender(pot_clay);
        registerRender(pot_zisha_clay);
        registerRender(cw_pot_zisha);
        registerRender(cw_pot_porcelain);
        registerRender(cw_pot_iron);
        registerRender(cw_pot_stone);
        registerRender(hw_pot_zisha);
        registerRender(hw_pot_porcelain);
        registerRender(hw_pot_iron);
        registerRender(hw_pot_stone);
        registerRender(zisha_clay);
        registerRender(zisha_clay_cup);
        registerRender(matcha_cookie);
    }

    @SubscribeEvent
    public void registerItems(RegistryEvent.Register<Item> event)
    {
        event.getRegistry().registerAll(
                tea_leaf, half_dried_tea, dried_tea, matcha_leaf, matcha_powder, black_tea_leaf, yellow_tea_leaf, white_tea_leaf, oolong_tea_leaf, puer_tea_leaf, wet_tea, broken_tea, tea_seeds,
                cup, clay_cup, zisha_clay, zisha_clay_cup,
                empty_tea_bag, green_tea_bag, black_tea_bag, yellow_tea_bag, white_tea_bag, oolong_tea_bag, puer_tea_bag,
                wooden_mortar_and_pestle, soil_detection_meter, tea_whisk, lemon,
                green_tea, matcha_drink, black_tea, milk_tea, lemon_tea, yellow_tea, white_tea, oolong_tea, puer_tea,
                tea_residue, matcha_cookie, tea_egg,
                shennongruler, caichawuqu_g20, caichawuqu_folk, bubugao, caichaji_erhu, chunjiexuqu, huahaoyueyuan, jinshekuangwu, xiyangyang, yangliuqing, zizhudiao,
                xian_rice_seeds, xian_rice_seedlings, straw, xian_rice, washed_rice, wooden_lid, rice_ball, straw_rope, straw_blanket, sickle,
                porkchop_rice, steak_rice, chicken_rice, potato_rice, rabbit_rice,
                pot_stone, pot_iron, pot_porcelain, pot_zisha, pot_clay, pot_zisha_clay,
                cw_pot_zisha, cw_pot_porcelain, cw_pot_iron, cw_pot_stone,
                hw_pot_zisha, hw_pot_porcelain, hw_pot_iron, hw_pot_stone);
    }

    @SideOnly(Side.CLIENT)
    private static void registerRender(Item item)
    {
        if (item.getHasSubtypes())
        {
            NonNullList<ItemStack> subItems = NonNullList.create();
            item.getSubItems(item.getCreativeTab(), subItems);
            for (ItemStack subItem : subItems)
            {
                String subItemName = item.getTranslationKey(subItem);
                subItemName = subItemName.substring(subItemName.indexOf(".") + 1);

                ModelBakery.registerItemVariants(item, new ResourceLocation(TeaStory.MODID, subItemName));
                ModelLoader.setCustomModelResourceLocation(item, subItem.getMetadata(), new ModelResourceLocation(TeaStory.MODID + ":" + subItemName, "inventory"));
            }
        }
        else
        {
            ModelLoader.setCustomModelResourceLocation(item, 0, new ModelResourceLocation(TeaStory.MODID + ":" + item.delegate.name().getPath(), "inventory"));
        }
    }
}

