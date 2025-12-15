package com.szqxue.mattercraft.init.Block;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;

import static com.szqxue.mattercraft.MatterCraft.MODID;

/**
 * @author SZQ23
 */
public class ModBlocks {
    // Create a Deferred Register to hold Blocks which will all be registered under the "mattercraft" namespace
    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(MODID);

    // Creates a new Block with the id "mattercraft:example_block", combining the namespace and path
    public static final DeferredBlock<Block> SPACE_GEM_BLOCK = BLOCKS.register("space_gem_block",
            () -> new Block(BlockBehaviour.Properties.of().mapColor(MapColor.STONE)));

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
