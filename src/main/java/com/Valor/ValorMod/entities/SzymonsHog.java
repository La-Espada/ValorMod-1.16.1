package com.Valor.ValorMod.entities;

import net.minecraft.entity.AgeableEntity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.world.World;


public class SzymonsHog extends AnimalEntity {

    public SzymonsHog(EntityType<? extends AnimalEntity> type, World worldIn){

        super(type, worldIn);

    }

    @Override
    public AgeableEntity createChild(AgeableEntity ageable) {
        return ModEntityTypes.HOG.get().create(this.world);
    }



}
