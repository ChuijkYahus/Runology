package com.cmdpro.runology.api;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexFormat;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;
import team.lodestar.lodestone.handlers.RenderHandler;
import team.lodestar.lodestone.registry.client.LodestoneRenderTypeRegistry;
import team.lodestar.lodestone.systems.rendering.VFXBuilders;

import java.awt.*;

public class ClientRunologyUtil {
    public static void drawSphere(VFXBuilders.WorldVFXBuilder builder, PoseStack stack, Color color, float alpha, float radius, int longs, int lats) {
        builder.setPosColorTexLightmapDefaultFormat().setColor(color).setAlpha(alpha).renderSphere(RenderHandler.DELAYED_RENDER.getBuffer(LodestoneRenderTypeRegistry.TRANSPARENT_TEXTURE.applyWithModifierAndCache(new ResourceLocation("textures/misc/white.png"), b -> b.replaceVertexFormat(VertexFormat.Mode.TRIANGLES).setCullState(LodestoneRenderTypeRegistry.NO_CULL))), stack, radius, longs, lats);
    }
    public static void drawLine(ParticleOptions particle, Vec3 point1, Vec3 point2, Level level, double space) {
        double distance = point1.distanceTo(point2);
        Vec3 vector = point2.subtract(point1).normalize().multiply(space, space, space);
        double length = 0;
        for (Vec3 point = point1; length < distance; point = point.add(vector)) {
            level.addParticle(particle, point.x, point.y, point.z, 0, 0, 0);
            length += space;
        }
    }
}
