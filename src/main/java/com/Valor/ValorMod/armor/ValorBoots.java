package com.Valor.ValorMod.armor;

import net.minecraft.entity.Entity;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.IArmorMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.world.World;

import java.util.jar.Attributes;

public class ValorBoots extends ArmorItem {

    private AttributeModifier movementSpeed;


    public ValorBoots(Properties builderIn) {

        super(ModArmorMaterial.VALOR,EquipmentSlotType.FEET,builderIn);
        this.movementSpeed = new AttributeModifier("ValorBootsMovementSpeedModifer",0.15F, AttributeModifier.Operation.MULTIPLY_TOTAL);
    }

    @Override
    public void inventoryTick(ItemStack stack, World worldIn, Entity entityIn, int itemSlot, boolean isSelected) {

        if(entityIn instanceof PlayerEntity){
            PlayerEntity player = (PlayerEntity) entityIn;
            if(player.getItemStackFromSlot(EquipmentSlotType.FEET).getItem() == this ){
                player.addPotionEffect(new EffectInstance(Effects.SPEED));
            }

        }
        super.inventoryTick(stack, worldIn, entityIn, itemSlot, isSelected);
    }
}
