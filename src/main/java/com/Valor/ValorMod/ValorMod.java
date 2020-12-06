package com.Valor.ValorMod;


import com.Valor.ValorMod.entities.HogEntity;
import com.Valor.ValorMod.entities.ModEntityTypes;
import com.Valor.ValorMod.items.ItemBase;
import com.Valor.ValorMod.util.RegistryHandler;
import jdk.nashorn.internal.objects.Global;
import net.minecraft.entity.ai.attributes.GlobalEntityTypeAttributes;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.DeferredWorkQueue;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

//MOD_ID
@Mod("valormod")
public class ValorMod {

    public static final Logger LOGGER = LogManager.getLogger();
    public static final String MOD_ID = "valormod";

    public ValorMod() {

        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::doClientStuff);
        RegistryHandler.init();

        ModEntityTypes.ENTITY_TYPES.register(FMLJavaModLoadingContext.get().getModEventBus());

        MinecraftForge.EVENT_BUS.register(this);
    }

    private void setup(final FMLCommonSetupEvent event) {
        DeferredWorkQueue.runLater(()->{
            GlobalEntityTypeAttributes.put(ModEntityTypes.HOG.get(), HogEntity.setCustomAttributes().create());
        });

    }

    private void doClientStuff(final FMLClientSetupEvent event) {

    }

    // custom Tab for ItemGroup
    public static final ItemGroup TAB = new ItemGroup("valorTab") {
        @Override
        public ItemStack createIcon() {
            //ItemStack(item which we already created)/or you can use vanilla item
            return new ItemStack(RegistryHandler.RUBY.get());
        }
    };





}
