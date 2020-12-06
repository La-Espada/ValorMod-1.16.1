package com.Valor.ValorMod.blocks;


import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.client.audio.Sound;
import net.minecraftforge.common.ToolType;

public class RubyBlock extends Block {
    public RubyBlock() {
        super(Block.Properties.create(Material.IRON)
            .hardnessAndResistance(5.0f,6.0f) //hardness how long to build up / resistance how easy it is to destroy it
                .sound(SoundType.METAL)//setting sound
                .harvestLevel(2) //declerating the argument with 0-3 minimum require material      to destroy the block 0...wood , 1...stone , 2...iron , 3...diamond
                .harvestTool(ToolType.PICKAXE)
        );

    }
}
