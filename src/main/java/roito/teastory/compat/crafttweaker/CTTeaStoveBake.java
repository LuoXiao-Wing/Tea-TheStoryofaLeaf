package roito.teastory.compat.crafttweaker;

import crafttweaker.IAction;
import crafttweaker.annotations.ZenRegister;
import crafttweaker.api.item.IIngredient;
import crafttweaker.api.item.IItemStack;
import crafttweaker.api.minecraft.CraftTweakerMC;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import roito.teastory.api.recipe.TeaMakingRecipe;
import roito.teastory.common.RecipeRegister;
import roito.teastory.helper.CraftTweakerHelper;
import stanhebben.zenscript.annotations.ZenClass;
import stanhebben.zenscript.annotations.ZenMethod;

@ZenClass("mods.teastory.TeaStove.Bake")
@ZenRegister
public class CTTeaStoveBake
{
    @ZenMethod
    public static void add(IIngredient input, IItemStack output)
    {
        ItemStack out = CraftTweakerMC.getItemStack(output);
        RecipeRegister.actions.add(new Addition(CraftTweakerHelper.getItemStacks(input), out));
    }

    private static final class Addition implements IAction
    {
        private final NonNullList<ItemStack> inputs;
        private final ItemStack output;

        private Addition(NonNullList<ItemStack> inputs, ItemStack output)
        {
            this.inputs = inputs;
            this.output = output;
        }

        @Override
        public void apply()
        {
            RecipeRegister.managerStoveDrying.add(new TeaMakingRecipe(inputs, output));
        }

        @Override
        public String describe()
        {
            return String.format("Add Tea Stove bake recipe: input %s -> output %s", inputs, output);
        }
    }

    @ZenMethod
    public static void remove(IIngredient input, IItemStack output)
    {
        ItemStack out = CraftTweakerMC.getItemStack(output);
        RecipeRegister.actions.add(new Removal(CraftTweakerHelper.getItemStacks(input), out));
    }

    private static final class Removal implements IAction
    {
        private final NonNullList<ItemStack> inputs;
        private final ItemStack output;

        private Removal(NonNullList<ItemStack> inputs, ItemStack output)
        {
            this.inputs = inputs;
            this.output = output;
        }

        @Override
        public void apply()
        {
            RecipeRegister.managerStoveDrying.remove(inputs, output);
        }

        @Override
        public String describe()
        {
            return null;
        }
    }

    @ZenMethod
    public static void removeAll()
    {
        RecipeRegister.actions.add(new Clear());
    }

    private static final class Clear implements IAction
    {
        @Override
        public void apply()
        {
            RecipeRegister.managerStoveDrying.removeAll();
        }

        @Override
        public String describe()
        {
            return "Removing all bake recipes from Tea Stove";
        }
    }
}
