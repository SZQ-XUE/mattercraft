package com.szqxue.mattercraft.init.Item;

import net.minecraft.core.registries.Registries;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

import static com.szqxue.mattercraft.MatterCraft.MODID;
import static com.szqxue.mattercraft.init.Block.ModBlocks.EXAMPLE_BLOCK;

/**
 * @author SZQ23
 */
public class ModItems {

    // Create a Deferred Register to hold Items which will all be registered under the "mattercraft" namespace
    public static final DeferredRegister.Items ITEMS =
            DeferredRegister.createItems(MODID);
    // Creates a new BlockItem with the id "mattercraft:example_block", combining the namespace and path
    public static final DeferredItem<BlockItem> EXAMPLE_BLOCK_ITEM =
            ITEMS.registerSimpleBlockItem("example_block", EXAMPLE_BLOCK);

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }

    // Creates a new food item with the id "mattercraft:example_id", nutrition 1 and saturation 2
    public static final DeferredItem<Item> EXAMPLE_ITEM =
            ITEMS.registerSimpleItem("example_item", new Item.Properties().food(new FoodProperties.Builder()
            .alwaysEdible().nutrition(1).saturationModifier(2f).build()));
}
