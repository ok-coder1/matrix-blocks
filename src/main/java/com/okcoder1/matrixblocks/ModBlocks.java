package com.okcoder1.matrixblocks;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.*;
import net.minecraft.block.BlockSetType;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.BlockItem;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.minecraft.registry.Registry;
import net.minecraft.registry.Registries;
import net.minecraft.registry.RegistryKey;
import net.minecraft.sound.BlockSoundGroup;


public class ModBlocks {
    public static final RegistryKey<ItemGroup> CUSTOM_ITEM_GROUP_KEY = RegistryKey.of(Registries.ITEM_GROUP.getKey(), new Identifier(MatrixBlocks.MOD_ID, "item_group"));
    public static final ItemGroup CUSTOM_ITEM_GROUP = FabricItemGroup.builder()
            .icon(() -> new ItemStack(ModBlocks.MATRIX_BLOCK))
            .displayName(Text.translatable("itemGroup.matrix_blocks"))
            .build();

    public static Block register(Block block, String name, boolean shouldRegisterItem) {
        Identifier id = new Identifier(MatrixBlocks.MOD_ID, name);

        if (shouldRegisterItem) {
            BlockItem blockItem = new BlockItem(block, new Item.Settings());
            Registry.register(Registries.ITEM, id, blockItem);
        }

        return Registry.register(Registries.BLOCK, id, block);
    }

    public static final Block MATRIX_BLOCK = register(
            new Block(AbstractBlock.Settings.create().sounds(BlockSoundGroup.BONE)),
            "matrix_block",
            true
    );
    public static final Block FADING_MATRIX_BLOCK = register(
            new Block(AbstractBlock.Settings.create().sounds(BlockSoundGroup.NETHER_BRICKS)),
            "fading_matrix_block",
            true
    );

    public static final Block MATRIX_STAIRS = register(
            new StairsBlock(ModBlocks.MATRIX_BLOCK.getDefaultState(), AbstractBlock.Settings.create().sounds(BlockSoundGroup.AMETHYST_BLOCK)),
            "matrix_stairs",
            true
    );
    public static final Block FADING_MATRIX_STAIRS = register(
            new StairsBlock(ModBlocks.FADING_MATRIX_BLOCK.getDefaultState(), AbstractBlock.Settings.create().sounds(BlockSoundGroup.NETHERITE)),
            "fading_matrix_stairs",
            true
    );

    public static final Block MATRIX_SLAB = register(
            new SlabBlock(AbstractBlock.Settings.create().sounds(BlockSoundGroup.COPPER)),
            "matrix_slab",
            true
    );
    public static final Block FADING_MATRIX_SLAB = register(
            new SlabBlock(AbstractBlock.Settings.create().sounds(BlockSoundGroup.COPPER)),
            "fading_matrix_slab",
            true
    );

    public static final Block MATRIX_BUTTON = register(
            new ButtonBlock(BlockSetType.IRON, 15, FabricBlockSettings.copyOf(Blocks.IRON_BLOCK)),
            "matrix_button",
            true
    );

    public static void initialize() {
        Registry.register(Registries.ITEM_GROUP, CUSTOM_ITEM_GROUP_KEY, CUSTOM_ITEM_GROUP);
        ItemGroupEvents.modifyEntriesEvent(CUSTOM_ITEM_GROUP_KEY).register(itemGroup -> {
            itemGroup.add(ModBlocks.MATRIX_BLOCK);
            itemGroup.add(ModBlocks.FADING_MATRIX_BLOCK);
            itemGroup.add(ModBlocks.MATRIX_STAIRS);
            itemGroup.add(ModBlocks.FADING_MATRIX_STAIRS);
            itemGroup.add(ModBlocks.MATRIX_SLAB);
            itemGroup.add(ModBlocks.FADING_MATRIX_SLAB);
            itemGroup.add(ModBlocks.MATRIX_BUTTON);
        });
    }
}
