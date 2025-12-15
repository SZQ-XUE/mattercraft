package com.szqxue.mattercraft.init.Item;


import com.szqxue.mattercraft.init.Block.ModBlocks;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

import static com.szqxue.mattercraft.MatterCraft.MODID;

/**
 * @author SZQ23
 */
public class ModItems {

    // Create a Deferred Register to hold Items which will all be registered under the "mattercraft" namespace
    public static final DeferredRegister.Items ITEMS =
            DeferredRegister.createItems(MODID);

    public static final DeferredItem<Item> SPACE_GEM =
            ITEMS.register("space_gem", () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> SPACE_GEM_BLOCK =
            ITEMS.register("space_gem_block", () -> new BlockItem(ModBlocks.SPACE_GEM_BLOCK.get(), new Item.Properties()));



    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }


}
