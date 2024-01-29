package com.cmdpro.runology.init;

import com.cmdpro.runology.Runology;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.EntityTypeTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

public class TagInit {
    public static class Blocks {
        public static final TagKey<Block> SHATTERSTONEREPLACEABLE = tag("shatterstonereplaceable");
        public static final TagKey<Block> SHATTERWOODREPLACEABLE = tag("shatterwoodreplaceable");
        public static final TagKey<Block> SHATTERREMOVES = tag("shatterremoves");
        public static final TagKey<Block> MYSTERIUMOREREPLACEABLE = tag("mysteriumorereplaceable");
        private static TagKey<Block> tag(String name) {
            return BlockTags.create(new ResourceLocation(Runology.MOD_ID, name));
        }
    }
    public static class Items {
        public static final TagKey<Item> GAUNTLETS = tag("gauntlets");
        private static TagKey<Item> tag(String name) {
            return ItemTags.create(new ResourceLocation(Runology.MOD_ID, name));
        }
    }
    public static class EntityTypes {
        public static final TagKey<EntityType<?>> IMPURE = tag("impure");
        private static TagKey<EntityType<?>> tag(String name) {
            return TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation(Runology.MOD_ID, name));
        }
    }
}
