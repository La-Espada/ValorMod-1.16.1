package com.Valor.ValorMod.blocks;


import com.Valor.ValorMod.Container.OvenContainer;
import com.Valor.ValorMod.TileEntity.OvenTile;
import com.Valor.ValorMod.util.RegistryHandler;
import net.minecraft.block.*;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.inventory.container.Container;
import net.minecraft.inventory.container.INamedContainerProvider;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.state.DirectionProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.Mirror;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.shapes.IBooleanFunction;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.fml.network.NetworkHooks;

import javax.annotation.Nullable;
import java.util.stream.Stream;

public class Oven extends Block {

    private boolean opened = false;

    private static  final DirectionProperty FACING = HorizontalBlock.HORIZONTAL_FACING;
    private static final VoxelShape SHAPE_N = Stream.of(
            Block.makeCuboidShape(2, 1, 3, 14, 6, 13),
            Block.makeCuboidShape(1, 0, 11, 2, 3, 13),
            Block.makeCuboidShape(1, 0, 3, 2, 3, 5),
            Block.makeCuboidShape(14, 0, 11, 15, 3, 13),
            Block.makeCuboidShape(14, 0, 3, 15, 3, 5),
            Block.makeCuboidShape(1, 5, 3, 2, 6, 13),
            Block.makeCuboidShape(1, 5, 13, 15, 6, 14),
            Block.makeCuboidShape(14, 5, 2, 15, 6, 13),
            Block.makeCuboidShape(1, 5, 2, 14, 6, 3),
            Block.makeCuboidShape(2, 6, 3, 14, 7, 4),
            Block.makeCuboidShape(2, 6, 4, 3, 7, 13),
            Block.makeCuboidShape(3, 6, 12, 14, 7, 13),
            Block.makeCuboidShape(13, 6, 4, 14, 7, 12),
            Block.makeCuboidShape(3, 7, 4, 13, 7, 12),
            Block.makeCuboidShape(8, 7, 5, 10, 10, 7)
    ).reduce((v1, v2) -> {return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);}).get();

    private static final VoxelShape SHAPE_E =Stream.of(
            Block.makeCuboidShape(3, 1, 2, 13, 6, 14),
            Block.makeCuboidShape(3, 0, 1, 5, 3, 2),
            Block.makeCuboidShape(11, 0, 1, 13, 3, 2),
            Block.makeCuboidShape(3, 0, 14, 5, 3, 15),
            Block.makeCuboidShape(11, 0, 14, 13, 3, 15),
            Block.makeCuboidShape(3, 5, 1, 13, 6, 2),
            Block.makeCuboidShape(2, 5, 1, 3, 6, 15),
            Block.makeCuboidShape(3, 5, 14, 14, 6, 15),
            Block.makeCuboidShape(13, 5, 1, 14, 6, 14),
            Block.makeCuboidShape(12, 6, 2, 13, 7, 14),
            Block.makeCuboidShape(3, 6, 2, 12, 7, 3),
            Block.makeCuboidShape(3, 6, 3, 4, 7, 14),
            Block.makeCuboidShape(4, 6, 13, 12, 7, 14),
            Block.makeCuboidShape(4, 7, 3, 12, 7, 13),
            Block.makeCuboidShape(9, 7, 8, 11, 10, 10)
    ).reduce((v1, v2) -> {return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);}).get();

    private static final VoxelShape SHAPE_S =Stream.of(
            Block.makeCuboidShape(2, 1, 3, 14, 6, 13),
            Block.makeCuboidShape(14, 0, 3, 15, 3, 5),
            Block.makeCuboidShape(14, 0, 11, 15, 3, 13),
            Block.makeCuboidShape(1, 0, 3, 2, 3, 5),
            Block.makeCuboidShape(1, 0, 11, 2, 3, 13),
            Block.makeCuboidShape(14, 5, 3, 15, 6, 13),
            Block.makeCuboidShape(1, 5, 2, 15, 6, 3),
            Block.makeCuboidShape(1, 5, 3, 2, 6, 14),
            Block.makeCuboidShape(2, 5, 13, 15, 6, 14),
            Block.makeCuboidShape(2, 6, 12, 14, 7, 13),
            Block.makeCuboidShape(13, 6, 3, 14, 7, 12),
            Block.makeCuboidShape(2, 6, 3, 13, 7, 4),
            Block.makeCuboidShape(2, 6, 4, 3, 7, 12),
            Block.makeCuboidShape(3, 7, 4, 13, 7, 12),
            Block.makeCuboidShape(6, 7, 9, 8, 10, 11)
    ).reduce((v1, v2) -> {return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);}).get();

    private static final VoxelShape SHAPE_W =Stream.of(
            Block.makeCuboidShape(3, 1, 3, 13, 6, 15),
            Block.makeCuboidShape(11, 0, 15, 13, 3, 16),
            Block.makeCuboidShape(3, 0, 15, 5, 3, 16),
            Block.makeCuboidShape(11, 0, 2, 13, 3, 3),
            Block.makeCuboidShape(3, 0, 2, 5, 3, 3),
            Block.makeCuboidShape(3, 5, 15, 13, 6, 16),
            Block.makeCuboidShape(13, 5, 2, 14, 6, 16),
            Block.makeCuboidShape(2, 5, 2, 13, 6, 3),
            Block.makeCuboidShape(2, 5, 3, 3, 6, 16),
            Block.makeCuboidShape(3, 6, 3, 4, 7, 15),
            Block.makeCuboidShape(4, 6, 14, 13, 7, 15),
            Block.makeCuboidShape(12, 6, 3, 13, 7, 14),
            Block.makeCuboidShape(4, 6, 3, 12, 7, 4),
            Block.makeCuboidShape(4, 7, 4, 12, 7, 14),
            Block.makeCuboidShape(5, 7, 7, 7, 10, 9)
    ).reduce((v1, v2) -> {return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);}).get();

    public Oven() {
        super(AbstractBlock.Properties.create(Material.IRON)
        .hardnessAndResistance(3.5f,4.0f)
        .sound(SoundType.ANVIL)
        .harvestLevel(0)
        .harvestTool(ToolType.PICKAXE)
        .setRequiresTool()
        );
    }

    @Override
    public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
        switch(state.get(FACING)){
            case NORTH:
                return SHAPE_N;
            case EAST:
                return SHAPE_E;
            case SOUTH:
                return SHAPE_S;
            case WEST:
                return SHAPE_W;
            default:
                return  SHAPE_N;
        }

    }

    @SuppressWarnings("deprecation")
    @Override
    public ActionResultType onBlockActivated(BlockState state, World worldIn, BlockPos pos, PlayerEntity player, Hand handIn, BlockRayTraceResult hit) {
       System.out.println("the oven can open");
       opened = true;
       if(!worldIn.isRemote()){
           TileEntity tileEntity = worldIn.getTileEntity(pos);
           if(tileEntity instanceof OvenTile){
               INamedContainerProvider containerProvider = new INamedContainerProvider() {
                   @Override
                   public ITextComponent getDisplayName() {
                       return new TranslationTextComponent("screen.valormod.oven");
                   }


                   @Override
                   public Container createMenu(int i, PlayerInventory playerInventory, PlayerEntity playerEntity) {


                       return new OvenContainer(i,worldIn,pos,playerInventory,playerEntity);

                   }
               };
               NetworkHooks.openGui((ServerPlayerEntity) player,containerProvider,tileEntity.getPos());
           }
           else{
               throw new IllegalStateException("Our Container provider is missing!");
           }
       }
       return ActionResultType.SUCCESS;
    }

    @Override
    public TileEntity createTileEntity(BlockState state, IBlockReader world) {
        return RegistryHandler.OVEN_TILE_ENTITY.get().create();
    }

    @Override
    public boolean hasTileEntity(BlockState state) {
        return true;
    }

    @Nullable
    @Override
    public BlockState getStateForPlacement(BlockItemUseContext context){
        return this.getDefaultState().with(FACING,context.getPlacementHorizontalFacing().getOpposite());
    }

    @Override
    public BlockState rotate(BlockState state, Rotation rot) {
        return state.with(FACING, rot.rotate(state.get(FACING)));
    }

    @Override
    public BlockState mirror(BlockState state, Mirror mirrorIn) {
        return state.rotate(mirrorIn.toRotation(state.get(FACING)));
    }

    @Override
    protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
        builder.add(FACING);
    }

    @Override
    public float getAmbientOcclusionLightValue(BlockState state, IBlockReader worldIn, BlockPos pos) {
        return 0.6f;
    }
}
