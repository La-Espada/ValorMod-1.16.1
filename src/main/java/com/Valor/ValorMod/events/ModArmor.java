package com.Valor.ValorMod.events;

import com.Valor.ValorMod.util.RegistryHandler;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.IArmorMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.world.World;

public class ModArmor extends ArmorItem {

    public ModArmor(IArmorMaterial materialIn, EquipmentSlotType slot, Properties builderIn) {
        super(materialIn, slot, builderIn);
    }

    @Override
    public void onArmorTick(ItemStack stack, World world, PlayerEntity player) {
        for (ItemStack s : player.getArmorInventoryList() ){
            if(s.getItem().equals(RegistryHandler.CRISTAL_BOOTS)){
                player.addPotionEffect(new EffectInstance(Effects.SPEED));
            }
        }
    }
}
