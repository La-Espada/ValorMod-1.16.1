package com.Valor.ValorMod.util;

import com.Valor.ValorMod.Container.OvenContainer;
import com.Valor.ValorMod.TileEntity.OvenTile;
import com.Valor.ValorMod.ValorMod;
import com.Valor.ValorMod.armor.ModArmorMaterial;
import com.Valor.ValorMod.armor.ValorBoots;
import com.Valor.ValorMod.blocks.*;
import com.Valor.ValorMod.items.Battery;
import com.Valor.ValorMod.items.ItemBase;
import com.Valor.ValorMod.items.PoisonApple;
import com.Valor.ValorMod.tools.*;
import net.minecraft.block.Block;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.inventory.container.ContainerType;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.BowItem;
import net.minecraft.item.Item;
import net.minecraft.item.SwordItem;
import net.minecraft.tileentity.TileEntityType;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.common.extensions.IForgeContainerType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class RegistryHandler {
    // list for registering items and blocks
    public static final DeferredRegister<Item> ITEMS =  DeferredRegister.create(ForgeRegistries.ITEMS, ValorMod.MOD_ID);
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, ValorMod.MOD_ID);
    public static final DeferredRegister<TileEntityType<?>> TILE_ENTITY_TYPES = DeferredRegister.create(ForgeRegistries.TILE_ENTITIES,ValorMod.MOD_ID);
    public static final DeferredRegister<ContainerType<?>> CONTAINERS = DeferredRegister.create(ForgeRegistries.CONTAINERS, ValorMod.MOD_ID);

    public static void init(){
   //registering items and blocks
        ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());
        BLOCKS.register(FMLJavaModLoadingContext.get().getModEventBus());
        TILE_ENTITY_TYPES.register(FMLJavaModLoadingContext.get().getModEventBus());
        CONTAINERS.register(FMLJavaModLoadingContext.get().getModEventBus());
    }

    // Items-Test
    public static final RegistryObject<Item> RUBY =ITEMS.register("ruby", ItemBase::new);
    public static final RegistryObject<PoisonApple> POISON_APPLE = ITEMS.register("poison_apple",PoisonApple::new);

    //Items
    public static final RegistryObject<Item> BLUE_CRISTAL =ITEMS.register("blue_cristal", ItemBase::new);
    public static final RegistryObject<Item>  BLUE_LIGHTSABER_EDGE =ITEMS.register("blue_lightsaber_edge", BlueLightsaberEdge::new);
    public static final RegistryObject<Item> BLUE_LIGHTSABER_EDGE_WITHOUT_CRISTAL =ITEMS.register("lightsaber_edge_without_cristal", ItemBase::new);

    public static final RegistryObject<Item> RED_CRISTAL =ITEMS.register("red_cristal", ItemBase::new);
    public static final RegistryObject<Item>  RED_LIGHTSABER_EDGE =ITEMS.register("red_lightsaber_edge", RedLightsaberEdge::new);
    public static final RegistryObject<Item> RED_LIGHTSABER_EDGE_WITHOUT_CRISTAL =ITEMS.register("red_lightsaber_edge_without_cristal", ItemBase::new);

    public static final RegistryObject<Item> DARK_CRISTAL =ITEMS.register("dark_cristal", ItemBase::new);
    public static final RegistryObject<Item>  DARK_LIGHTSABER_EDGE =ITEMS.register("dark_lightsaber_edge", DarkLightsaberEdge::new);
    public static final RegistryObject<Item> DARK_LIGHTSABER_EDGE_WITHOUT_CRISTAL =ITEMS.register("dark_lightsaber_edge_without_cristal", ItemBase::new);

    public static final RegistryObject<Item> YELLOW_CRISTAL =ITEMS.register("yellow_cristal", ItemBase::new);
    public static final RegistryObject<Item>  YELLOW_LIGHTSABER_EDGE =ITEMS.register("yellow_lightsaber_edge", YellowLightsaberEdge::new);
    public static final RegistryObject<Item> YELLOW_LIGHTSABER_EDGE_WITHOUT_CRISTAL =ITEMS.register("yellow_lightsaber_edge_without_cristal", ItemBase::new);

    public static final RegistryObject<Item> PURPLE_CRISTAL =ITEMS.register("purple_cristal", ItemBase::new);
    public static final RegistryObject<Item>  PURPLE_LIGHTSABER_EDGE =ITEMS.register("purple_lightsaber_edge", PurpleLightsaberEdge::new);
    public static final RegistryObject<Item> PURPLE_LIGHTSABER_EDGE_WITHOUT_CRISTAL =ITEMS.register("purple_lightsaber_edge_without_cristal", ItemBase::new);

    public static final RegistryObject<Item> ORANGE_CRISTAL =ITEMS.register("orange_cristal", ItemBase::new);
    public static final RegistryObject<Item>  ORANGE_LIGHTSABER_EDGE =ITEMS.register("orange_lightsaber_edge", OrangeLightsaberEdge::new);
    public static final RegistryObject<Item> ORANGE_LIGHTSABER_EDGE_WITHOUT_CRISTAL =ITEMS.register("orange_lightsaber_edge_without_cristal", ItemBase::new);

    public static final RegistryObject<Item> DARK_IRON_INGOT =ITEMS.register("dark_iron_ingot", ItemBase::new);

    public static final RegistryObject<Item> BATTERY = ITEMS.register("battery", Battery::new);


    //Tools
    public static final RegistryObject<SwordItem> SWORD_OF_VALOR = ITEMS.register("sword_of_valor", ()->
            new SwordItem(ModItemTier.SWORD_OF_VALOR,2, -2.4f, new Item.Properties().group(ValorMod.TAB)));// baseAttackspeed 4 -2.5

    public static final RegistryObject<SwordItem> VALOR_SWORD = ITEMS.register("valor_sword", ()->
            new SwordItem(ModItemTier.SWORD_OF_VALOR,2, -2.4f, new Item.Properties().group(ValorMod.TAB)));

    public static final RegistryObject<SwordItem> VALOR_SWORD_1 = ITEMS.register("valor_sword_1", ()->
            new SwordItem(ModItemTier.SWORD_OF_VALOR,2, -2.4f, new Item.Properties().group(ValorMod.TAB)));

    public static final RegistryObject<SwordItem> BLUE_LIGHTSABER = ITEMS.register("blue_lightsaber", ()->
            new BlueLightsaber(ModItemTier.BLUE_LIGHTSABER,2, -2.4f, new Item.Properties().group(ValorMod.TAB)));

    public static final RegistryObject<BowItem> SHADOW_BOW = ITEMS.register("shadow_bow",()->
            new BowItem(new Item.Properties().group(ValorMod.TAB)));

    public static final RegistryObject<SwordItem> RED_LIGHTSABER = ITEMS.register("red_lightsaber",()->
            new RedLightsaber(ModItemTier.RED_LIGHTSABER,3,-3.4f,new Item.Properties().group(ValorMod.TAB)));

    public static final RegistryObject<SwordItem> YELLOW_LIGHTSABER = ITEMS.register("yellow_lightsaber",()->
            new RedLightsaber(ModItemTier.YELLOW_LIGHTSABER,3,-3.4f,new Item.Properties().group(ValorMod.TAB)));

    public static final RegistryObject<SwordItem> PURPLE_LIGHTSABER = ITEMS.register("purple_lightsaber",()->
            new RedLightsaber(ModItemTier.PURPLE_LIGHTSABER,3,-3.4f,new Item.Properties().group(ValorMod.TAB)));

    public static final RegistryObject<SwordItem> DARK_LIGHTSABER = ITEMS.register("dark_lightsaber",()->
            new RedLightsaber(ModItemTier.DARK_LIGHTSABER,3,-3.4f,new Item.Properties().group(ValorMod.TAB)));

    public static final RegistryObject<SwordItem> ORANGE_LIGHTSABER = ITEMS.register("orange_lightsaber",()->
            new RedLightsaber(ModItemTier.ORANGE_LIGHTSABER,3,-3.4f,new Item.Properties().group(ValorMod.TAB)));


    //Armor
    public static final RegistryObject<ArmorItem> RUBY_HELMET = ITEMS.register("ruby_helmet",
            ()-> new ArmorItem(ModArmorMaterial.RUBY, EquipmentSlotType.HEAD,new Item.Properties().group(ValorMod.TAB)));
    public static final RegistryObject<ArmorItem> RUBY_CHEASTPLATE = ITEMS.register("ruby_chestplate",
            ()-> new ArmorItem(ModArmorMaterial.RUBY, EquipmentSlotType.CHEST,new Item.Properties().group(ValorMod.TAB)));
    public static final RegistryObject<ArmorItem> RUBY_LEGGINGS= ITEMS.register("ruby_leggings",
            ()-> new ArmorItem(ModArmorMaterial.RUBY, EquipmentSlotType.LEGS,new Item.Properties().group(ValorMod.TAB)));
    public static final RegistryObject<ArmorItem> RUBY_BOOTS = ITEMS.register("ruby_boots",
            ()-> new ArmorItem(ModArmorMaterial.RUBY, EquipmentSlotType.FEET,new Item.Properties().group(ValorMod.TAB)));

    public static final RegistryObject<ArmorItem> CRISTAL_GLASSES= ITEMS.register("valor_glasses",
            ()-> new ArmorItem(ModArmorMaterial.VALOR, EquipmentSlotType.HEAD,new Item.Properties().group(ValorMod.TAB)));
    public static final RegistryObject<ArmorItem> CRISTAL_CHESTPLATE = ITEMS.register("valor_chestplate",
            ()-> new ArmorItem(ModArmorMaterial.VALOR, EquipmentSlotType.CHEST,new Item.Properties().group(ValorMod.TAB)));
    public static final RegistryObject<ArmorItem> CRISTAL_LEGGINGS= ITEMS.register("valor_leggings",
            ()-> new ArmorItem(ModArmorMaterial.VALOR, EquipmentSlotType.LEGS,new Item.Properties().group(ValorMod.TAB)));
    public static final RegistryObject<ArmorItem> CRISTAL_BOOTS = ITEMS.register("valor_boots",
            ()-> new ValorBoots(new Item.Properties().group(ValorMod.TAB)));

    public static final RegistryObject<ArmorItem> FOURTH_COMMANDER_HELMET = ITEMS.register("4_commander_helmet",
            ()-> new ArmorItem(ModArmorMaterial.DARK_IRON_INGOT, EquipmentSlotType.HEAD,new Item.Properties().group(ValorMod.TAB)));
    public static final RegistryObject<ArmorItem> FOURTH_COMMANDER_CHESTPLATE = ITEMS.register("4_commander_chestplate",
            ()-> new ArmorItem(ModArmorMaterial.DARK_IRON_INGOT, EquipmentSlotType.CHEST,new Item.Properties().group(ValorMod.TAB)));
    public static final RegistryObject<ArmorItem> FOURTH_COMMANDER_LEGGINGS= ITEMS.register("4_commander_leggings",
            ()-> new ArmorItem(ModArmorMaterial.DARK_IRON_INGOT, EquipmentSlotType.LEGS,new Item.Properties().group(ValorMod.TAB)));
    public static final RegistryObject<ArmorItem> FOURTH_COMMANDER_BOOTS = ITEMS.register("4_commander_boots",
            ()-> new ArmorItem(ModArmorMaterial.DARK_IRON_INGOT,EquipmentSlotType.FEET,new Item.Properties().group(ValorMod.TAB)));





    //Blocks
    public static final RegistryObject<Block> RUBY_BLOCK =BLOCKS.register("ruby_block", RubyBlock::new);
    public static final RegistryObject<Block> DARK_IRON_ORE =BLOCKS.register("dark_iron_ore",  DarkIronOre::new);
    public static final RegistryObject<Block> OVEN =BLOCKS.register("oven", Oven::new);
    public static final RegistryObject<Block> DARK_GRASS =BLOCKS.register("dark_grass",  DarkGrass::new);




    //Block Items
    public static final RegistryObject<Item> DARK_IRON_ORE_ITEM =ITEMS.register("dark_iron_ore", ()-> new BlockItemBase( DARK_IRON_ORE.get()));
    public static final RegistryObject<Item> OVEN_ITEM = ITEMS.register("oven", ()-> new BlockItemBase( OVEN.get()));
    public static final RegistryObject<Item> DARK_GRASS_ITEM =ITEMS.register("dark_grass", ()-> new BlockItemBase( DARK_GRASS.get()));


    //Tile Entity
    public static final RegistryObject<TileEntityType<OvenTile>> OVEN_TILE_ENTITY = TILE_ENTITY_TYPES.register
            ("electrifier_tile_entity",()->TileEntityType.Builder.create(()->new OvenTile(), OVEN.get()).build(null));


    //Containers
    public static final RegistryObject<ContainerType<OvenContainer>> OVEN_CONTAINER =
            CONTAINERS.register("oven_container",()-> IForgeContainerType.create((((windowId, inv, data) -> {
                BlockPos pos = data.readBlockPos();
                World world = inv.player.getEntityWorld();
                return new OvenContainer(windowId,world,pos,inv,inv.player);
            }))));



}
