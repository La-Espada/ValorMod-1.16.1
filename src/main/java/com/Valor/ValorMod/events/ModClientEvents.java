package com.Valor.ValorMod.events;

import com.Valor.ValorMod.ValorMod;
import com.Valor.ValorMod.util.RegistryHandler;
import net.java.games.input.Mouse;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screen.inventory.CraftingScreen;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.passive.SheepEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.potion.*;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.GuiOpenEvent;
import net.minecraftforge.client.event.GuiScreenEvent;
import net.minecraftforge.client.event.InputEvent;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.event.entity.player.AttackEntityEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = ValorMod.MOD_ID,bus = Mod.EventBusSubscriber.Bus.FORGE, value = Dist.CLIENT)
public class ModClientEvents {

    @SubscribeEvent// LivingEntity func_233580_cy_() ----> getPosition
public static void onJumpWithStick(LivingEvent.LivingJumpEvent event){
        LivingEntity player = event.getEntityLiving();
        if(player.getHeldItemMainhand().getItem() == Items.STICK){
    ValorMod.LOGGER.info("Player tried to jump with a stick!");
    World world = player.getEntityWorld();
    world.setBlockState(player.getPosition().add(0,-1,0), RegistryHandler.RUBY_BLOCK.get().getDefaultState() );
        }
    }
    @SubscribeEvent
    public static void onDamageSheep(AttackEntityEvent event){
        if(event.getEntityLiving().getHeldItemMainhand().getItem() == RegistryHandler.POISON_APPLE.get()){
             if(event.getTarget().isAlive()){
                 LivingEntity target = (LivingEntity) event.getTarget();
                 if(target instanceof SheepEntity){

                     PlayerEntity player = event.getPlayer();
                     target.addPotionEffect(new EffectInstance(Effects.POISON,10*20));
                     target.setGlowing(true);

                     if(event.getPlayer().getEntityWorld().isRemote){
                         String msg = TextFormatting.RED +"That Sheep isnt feeling so weel......";
                         player.sendMessage(new StringTextComponent(msg),player.getUniqueID());
                     }
                 }
             }
        }
    }




    @SubscribeEvent
    public static void onDamageTarget(AttackEntityEvent event){
        if(event.getEntityLiving().getHeldItemMainhand().getItem() == RegistryHandler.BLUE_LIGHTSABER.get()){
            if(event.getTarget().isAlive()){
                LivingEntity target =(LivingEntity) event.getTarget();
                PlayerEntity playerEntity = event.getPlayer();
                target.setFire(10*20);
            }
        }
        else if(event.getEntityLiving().getHeldItemMainhand().getItem() == RegistryHandler.RED_LIGHTSABER.get()){
            if(event.getTarget().isAlive()){
                LivingEntity target =(LivingEntity) event.getTarget();
                PlayerEntity playerEntity = event.getPlayer();
               // target.addPotionEffect(new EffectInstance(Effects.))
                target.setFire(10*20);
            }
        }
    }






    public static void onCraftingTableOpen(GuiOpenEvent event){
     if(event.isCancelable()){
         if(event.getGui() instanceof CraftingScreen){
             event.setCanceled(true);
             ValorMod.LOGGER.info("Player tried to open a crafting table!!");
         }
     }
    }
}
