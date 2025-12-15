package com.szqxue.mattercraft.init;

import com.szqxue.mattercraft.init.Item.ModItems;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

import static com.szqxue.mattercraft.MatterCraft.MODID;

/**
 * @author SZQ23
 */
public class ModCreativeTabs {
    // Create a Deferred Register to hold CreativeModeTabs which will all be registered under the "mattercraft" namespace
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, MODID);

    // Creates a creative tab with the id "mattercraft:example_tab" for the example item, that is placed after the combat tab
    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> MATTERCRAFT_TAB =
            CREATIVE_MODE_TABS.register("mattercraft", () -> CreativeModeTab.builder()
                    //The language key for the title of your CreativeModeTab
            .title(Component.translatable("itemGroup.mattercraft"))
            .withTabsBefore(CreativeModeTabs.COMBAT)
            .icon(() -> ModItems.SPACE_GEM.get().getDefaultInstance())
            .displayItems((parameters, output) -> {
                output.accept(ModItems.SPACE_GEM.get());
            }).build());

    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> MATTERCRAFT_BUILDING_BLOCKS =
            CREATIVE_MODE_TABS.register("mattercraft_building_blocks", () -> CreativeModeTab.builder()
            .title(Component.translatable("itemGroup.mattercraft_building_blocks"))
            .withTabsBefore(CreativeModeTabs.COMBAT)
            .icon(() ->  ModItems.SPACE_GEM_BLOCK.get().getDefaultInstance())
            .displayItems((parameters, output) -> {
                output.accept( ModItems.SPACE_GEM_BLOCK.get());
            }).build());

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
        eventBus.addListener(ModCreativeTabs::addCreative);
    }

    // Add the example block item to Minecraft's creative tab
    /**
    * CreativeModeTabs includes many built-in tabs, such as Building Blocks, Combat, and Food & Drinks.
    * You can create your own tabs and add items to them.
    * */
    private static void addCreative(BuildCreativeModeTabContentsEvent event) {
        // Add the example block item to Building Blocks tab
        if (event.getTabKey() == CreativeModeTabs.BUILDING_BLOCKS) {
            //event.accept(ModItems.SPACE_GEM.get().getDefaultInstance());
        }
    }
}
