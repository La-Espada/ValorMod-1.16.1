package com.Valor.ValorMod.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraftforge.common.ToolType;

public class DarkGrass extends Block {
    public DarkGrass() {
        super(Block.Properties.create(Material.EARTH)
                .hardnessAndResistance(1.0f,1.0f) //hardness how long to build up / resistance how easy it is to destroy it
                .sound(SoundType.GROUND)//setting sound
                .harvestLevel(0) //declerating the argument with 0-3 minimum require material      to destroy the block 0...wood , 1...stone , 2...iron , 3...diamond
                .harvestTool(ToolType.SHOVEL)
        );

    }
}