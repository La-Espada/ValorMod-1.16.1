package com.Valor.ValorMod.world.gen;

import com.Valor.ValorMod.ValorMod;
import com.Valor.ValorMod.entities.ModEntityTypes;
import net.minecraft.entity.EntityClassification;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLLoadCompleteEvent;
import net.minecraftforge.registries.ForgeRegistries;

@Mod.EventBusSubscriber(modid = ValorMod.MOD_ID,bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModEntitiySpawns {

    @SubscribeEvent
    public static void spawnEntities(FMLLoadCompleteEvent event){
        for(Biome biome: ForgeRegistries.BIOMES){
            //Nether Mobs
            if(biome.getCategory() == Biome.Category.NETHER){ }

            //End Mobs
            else if(biome.getCategory() == Biome.Category.THEEND){

            }
            //Overworld Mobs
            else{
                if(biome.getCategory() != Biome.Category.OCEAN){
                    biome.getSpawns(EntityClassification.CREATURE)
                            .add(new Biome.SpawnListEntry(ModEntityTypes.HOG.get(),10,3,5 ));
                }
            }


        }
    }
}
