package com.github.nopothegamer.polylessnametag.mixin;

import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.entity.RendererLivingEntity;
import net.minecraft.entity.Entity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(RendererLivingEntity.class)
public class MixinRendererLivingEntity {


    // idk what these do exactly but this is what poly name tag was doing and these 2 looks the most relevent
    // the code came from patcher anyway, poly name tag didnt even come up with this
    @Redirect(method = "canRenderName(Lnet/minecraft/entity/EntityLivingBase;)Z", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/Minecraft;isGuiEnabled()Z"))
    private boolean gui() {
        return true;
    }

    @Redirect(method = "canRenderName(Lnet/minecraft/entity/EntityLivingBase;)Z", at = @At(value = "FIELD", target = "Lnet/minecraft/client/renderer/entity/RenderManager;livingPlayer:Lnet/minecraft/entity/Entity;"))
    private Entity cancelSelfCheck(RenderManager renderManager) {
        return null;
    }
}
