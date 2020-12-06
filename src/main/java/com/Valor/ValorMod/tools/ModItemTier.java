package com.Valor.ValorMod.tools;

import com.Valor.ValorMod.util.RegistryHandler;
import net.minecraft.item.IItemTier;
import net.minecraft.item.crafting.Ingredient;

import java.util.function.Supplier;

public enum ModItemTier  implements IItemTier {

    SWORD_OF_VALOR(3,800,7.0f,3.0f,12,()->{
        return Ingredient.fromItems(RegistryHandler.RUBY.get());
    }),
   BLUE_LIGHTSABER(3,2000,7.0f,6.0f,12,()->{
        return Ingredient.fromItems(RegistryHandler.RUBY.get());
    }),
    RED_LIGHTSABER(5,5000,8.0f,8.0f,18,()->{
        return Ingredient.fromItems(RegistryHandler.RUBY.get());
    }),
    DARK_LIGHTSABER(5,5000,8.0f,8.0f,18,()->{
        return Ingredient.fromItems(RegistryHandler.RUBY.get());
    }),
    YELLOW_LIGHTSABER(5,5000,8.0f,8.0f,18,()->{
        return Ingredient.fromItems(RegistryHandler.RUBY.get());
    }),
    PURPLE_LIGHTSABER(5,5000,8.0f,8.0f,18,()->{
        return Ingredient.fromItems(RegistryHandler.RUBY.get());
    }),
    ORANGE_LIGHTSABER(5,5000,8.0f,8.0f,18,()->{
        return Ingredient.fromItems(RegistryHandler.RUBY.get());
    }),
    VALOR_SWORD(3,2000,7.0f,6.0f,12,()->{
        return Ingredient.fromItems(RegistryHandler.RUBY.get());
    }),
    VALOR_SWORD_1(3,2000,7.0f,6.0f,12,()->{
        return Ingredient.fromItems(RegistryHandler.RUBY.get());
    }),
    SHADOW_BOW(3,2000,8.0f,6.0f,12,()->{
        return Ingredient.fromItems(RegistryHandler.RUBY.get());
   });

    private final int harvestLevel;
    private final int maxUsers;
    private final float efficiency;
    private final float attackDamage;
    private final int  enchantability;
    private final Supplier<Ingredient> repairMaterial;

    // 1 + baseDamage(3) + addedDamage (2)
    ModItemTier(int harvestLevel,int maxUsers,float efficiency,float attackDamage,int enchantability, Supplier<Ingredient> repairMaterial){
        this.harvestLevel = harvestLevel;
        this.maxUsers = maxUsers;
        this.efficiency = efficiency;
        this.attackDamage = attackDamage;
        this.enchantability = enchantability;
        this.repairMaterial = repairMaterial;
        System.out.println("Cemil " + getMaxUses());
        System.out.println("Cemil " + getHarvestLevel());
    }
    @Override
    public int getMaxUses() {

        return maxUsers;
    }

    @Override
    public float getEfficiency() {

        return efficiency;
    }

    @Override
    public float getAttackDamage() {

        return attackDamage;
    }

    @Override
    public int getHarvestLevel() {

        return harvestLevel;
    }

    @Override
    public int getEnchantability() {

        return enchantability;
    }

    @Override
    public Ingredient getRepairMaterial() {

        return repairMaterial.get();
    }
}
