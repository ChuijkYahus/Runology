package com.cmdpro.runology.registry;

import com.cmdpro.runology.Runology;
import com.cmdpro.runology.api.shatteredflow.ShatteredFlowConnectable;
import com.cmdpro.runology.api.shatteredflow.ShatteredFlowNetwork;
import com.cmdpro.runology.block.transmission.ShatteredFocusBlockEntity;
import com.cmdpro.runology.block.transmission.ShatteredRelayBlockEntity;
import com.cmdpro.runology.block.world.ShatterBlockEntity;
import com.mojang.serialization.Codec;
import net.neoforged.neoforge.attachment.AttachmentType;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.NeoForgeRegistries;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

public class AttachmentTypeRegistry {
    public static final DeferredRegister<AttachmentType<?>> ATTACHMENT_TYPES = DeferredRegister.create(NeoForgeRegistries.Keys.ATTACHMENT_TYPES,
            Runology.MODID);
    public static final Supplier<AttachmentType<Integer>> SHATTER_ITEM_CONVERSION_TIMER =
            register("shatter_item_conversion_timer", () -> AttachmentType.builder(() -> 0).serialize(Codec.INT).build());
    public static final Supplier<AttachmentType<Integer>> HEAT_FOCUS_SMELT_TIMER =
            register("heat_focus_smelt_timer", () -> AttachmentType.builder(() -> 0).serialize(Codec.INT).build());
    public static final Supplier<AttachmentType<Integer>> BLINK_COOLDOWN =
            register("blink_cooldown", () -> AttachmentType.builder(() -> 0).serialize(Codec.INT).build());
    public static final Supplier<AttachmentType<Boolean>> PLAYER_POWER_MODE =
            register("player_power_mode", () -> AttachmentType.builder(() -> false).build());
    public static final Supplier<AttachmentType<Integer>> PLAYER_POWER_INVINCIBILITY =
            register("player_power_invincibility", () -> AttachmentType.builder(() -> 0).build());
    public static final Supplier<AttachmentType<ArrayList<ShatterBlockEntity>>> SHATTERS =
            register("shatters", () -> AttachmentType.builder(() -> new ArrayList<ShatterBlockEntity>()).build());
    public static final Supplier<AttachmentType<ArrayList<ShatteredFlowConnectable>>> SHATTERED_FLOW_CONNECTABLES =
            register("shattered_flow_connectables", () -> AttachmentType.builder(() -> new ArrayList<ShatteredFlowConnectable>()).build());
    public static final Supplier<AttachmentType<ArrayList<ShatteredFlowNetwork>>> SHATTERED_FLOW_NETWORKS =
            register("shattered_flow_networks", () -> AttachmentType.builder(() -> new ArrayList<ShatteredFlowNetwork>()).serialize(ShatteredFlowNetwork.CODEC.listOf().xmap((a) -> {
                if (a instanceof ArrayList<ShatteredFlowNetwork> array) {
                    return array;
                }
                return new ArrayList<>(a);
            }, (a) -> (List<ShatteredFlowNetwork>)a)).build());

    private static <T extends AttachmentType<?>> Supplier<T> register(final String name, final Supplier<T> attachment) {
        return ATTACHMENT_TYPES.register(name, attachment);
    }
}