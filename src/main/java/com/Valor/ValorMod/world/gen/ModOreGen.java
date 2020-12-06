package com.Valor.ValorMod.world.gen;

import com.Valor.ValorMod.ValorMod;
import com.Valor.ValorMod.util.RegistryHandler;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.pattern.BlockMatcher;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.Biomes;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import net.minecraft.world.gen.placement.ConfiguredPlacement;
import net.minecraft.world.gen.placement.CountRangeConfig;
import net.minecraft.world.gen.placement.Placement;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLLoadCompleteEvent;
import net.minecraftforge.registries.ForgeRegistries;

@Mod.EventBusSubscriber(modid = ValorMod.MOD_ID,bus =  Mod.EventBusSubscriber.Bus.MOD)
public class ModOreGen {

    public static OreFeatureConfig.FillerBlockType END_STONE = OreFeatureConfig.FillerBlockType.create("END_STONE",
            "end_stone",new BlockMatcher(Blocks.END_STONE));

    @SubscribeEvent
    public static void generateOres(FMLLoadCompleteEvent event) {
        for(Biome biome : ForgeRegistries.BIOMES){
            //Nether Generation
            if(biome.getCategory() == Biome.Category.NETHER){
                genOre(biome,15,8,5,50,OreFeatureConfig.FillerBlockType.NETHERRACK,
                        RegistryHandler.RUBY_BLOCK.get().getDefaultState(),3);

            }//END Generation
            else if(biome.getCategory() == Biome.Category.THEEND){
                genOre(biome,15,8,5,50,END_STONE,
                        RegistryHandler.RUBY_BLOCK.get().getDefaultState(),3);
            }//World
            else{
                if(biome == Biomes.DESERT) {
                    genOre(biome, 15, 8, 5, 50, OreFeatureConfig.FillerBlockType.NATURAL_STONE,
                            RegistryHandler.RUBY_BLOCK.get().getDefaultState(), 6);
                }
            }
        }
    }
    private  static void genOre(Biome biome, int count, int bottomOffset, int topOffset, int max, OreFeatureConfig.FillerBlockType filler, BlockState defaultBlockState, int size){
        CountRangeConfig range = new CountRangeConfig(count, bottomOffset,topOffset,max);
        OreFeatureConfig feature = new OreFeatureConfig(filler,defaultBlockState,size);
        ConfiguredPlacement config = Placement.COUNT_RANGE.configure(range);
        biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(feature).withPlacement(config));

    }
}
