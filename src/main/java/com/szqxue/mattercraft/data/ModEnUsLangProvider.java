package com.szqxue.mattercraft.data;

import com.szqxue.mattercraft.init.Block.ModBlocks;
import com.szqxue.mattercraft.init.Item.ModItems;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.LanguageProvider;

/**
 * @author SZQ23
 */
public class ModEnUsLangProvider extends LanguageProvider {
    public ModEnUsLangProvider(PackOutput output, String modid, String locale) {
        super(output, modid, locale);
    }

    @Override
    protected void addTranslations() {

        add("itemGroup.mattercraft", "Mattercraft");
        add("itemGroup.mattercraft_building_blocks", "Mattercraft Building Blocks");


        addItem(ModItems.SPACE_GEM, "Space Gem");
        addBlock(ModBlocks.SPACE_GEM_BLOCK, "Space Gem Block");

    }
}
