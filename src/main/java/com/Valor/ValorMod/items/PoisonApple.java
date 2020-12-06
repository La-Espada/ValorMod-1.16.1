package com.Valor.ValorMod.items;

import com.Valor.ValorMod.ValorMod;
import net.minecraft.item.Food;
import net.minecraft.item.Item;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;

public class PoisonApple extends Item {


    public PoisonApple() {
        super(new Item.Properties()
        .group(ValorMod.TAB)
                        .food(new Food.Builder()
                                .hunger(4)//divided by 2
                                .saturation(1.2f)//how long it takes to lose hunger
                                .effect(new EffectInstance(Effects.NAUSEA,300,1),1)
                                .build())//ends



        );
    }
}
