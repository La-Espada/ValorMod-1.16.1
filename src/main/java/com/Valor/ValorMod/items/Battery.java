package com.Valor.ValorMod.items;

import com.Valor.ValorMod.ValorMod;
import net.minecraft.item.Item;

public class Battery extends Item {

    public int energyLevel = 64;


    public Battery() {
        super(new Item.Properties().group(ValorMod.TAB));
    }

    public int getEnergyLevel(){
        return  energyLevel;
    }

    public void decreaseEnergyLevel(){
        if(energyLevel != 0) {
            energyLevel--;
        }
    }
    public void increaseEnergyLevel(){
        if(energyLevel != 64) {
            energyLevel++;
        }
    }

}
