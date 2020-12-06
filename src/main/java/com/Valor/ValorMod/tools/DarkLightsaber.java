package com.Valor.ValorMod.tools;

import com.Valor.ValorMod.util.RegistryHandler;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.IItemTier;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.world.World;

public class DarkLightsaber extends SwordItem {


    public DarkLightsaber(IItemTier tier, int attackDamageIn, float attackSpeedIn, Properties builderIn) {
        super(tier, attackDamageIn, attackSpeedIn, builderIn);
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn) {
        ItemStack stack = playerIn .getHeldItem(handIn);
        playerIn.setHeldItem(handIn, RegistryHandler.DARK_LIGHTSABER_EDGE.get().getDefaultInstance());

        return super.onItemRightClick(worldIn, playerIn, handIn);
    }
}
