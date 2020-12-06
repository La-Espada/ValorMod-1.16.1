package com.Valor.ValorMod.tools;

import com.Valor.ValorMod.ValorMod;
import com.Valor.ValorMod.util.RegistryHandler;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.world.World;

public class OrangeLightsaberEdge extends Item {
    public OrangeLightsaberEdge() {
        super(new Properties().group(ValorMod.TAB));
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn) {
        ItemStack stack = playerIn .getHeldItem(handIn);
        playerIn.setHeldItem(handIn, RegistryHandler.ORANGE_LIGHTSABER.get().getDefaultInstance());
        return super.onItemRightClick(worldIn, playerIn, handIn);
    }
}
