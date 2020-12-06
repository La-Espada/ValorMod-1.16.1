package com.Valor.ValorMod.client.render;

import com.Valor.ValorMod.ValorMod;
import com.Valor.ValorMod.client.model.HogModel;
import com.Valor.ValorMod.entities.HogEntity;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;

public class HogRenderer extends MobRenderer<HogEntity, HogModel<HogEntity>> {

    protected  static final ResourceLocation TEXTURE = new ResourceLocation(ValorMod.MOD_ID,"textures/entity/hog.png");

    public HogRenderer(EntityRendererManager renderManagerIn) {
        super(renderManagerIn,new HogModel<>(),0.7f);
    }

    @Override
    public ResourceLocation getEntityTexture(HogEntity entity) {
        return TEXTURE;
    }
}
