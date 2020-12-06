package com.Valor.ValorMod.util;

import com.Valor.ValorMod.ValorMod;
import com.Valor.ValorMod.client.render.HogRenderer;
import com.Valor.ValorMod.entities.ModEntityTypes;
import com.Valor.ValorMod.screens.OvenScreen;
import net.minecraft.client.gui.ScreenManager;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

@Mod.EventBusSubscriber(modid = ValorMod.MOD_ID,bus = Mod.EventBusSubscriber.Bus.MOD,value = Dist.CLIENT)
public class ClientEventBusSubscriber  {

    @SubscribeEvent
    public static void onClientSetup(FMLClientSetupEvent event){
        RenderingRegistry.registerEntityRenderingHandler(ModEntityTypes.HOG.get(), HogRenderer::new);
        ScreenManager.registerFactory(RegistryHandler.OVEN_CONTAINER.get(), OvenScreen::new);
    }



}
