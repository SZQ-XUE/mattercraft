package com.szqxue.mattercraft.data;

import com.szqxue.mattercraft.init.Block.ModBlocks;
import com.szqxue.mattercraft.init.Item.ModItems;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.LanguageProvider;

/**
 * @author SZQ23
 */
public class ModZhCnLangProvider extends LanguageProvider {


    public ModZhCnLangProvider(PackOutput output, String modid, String locale) {
        super(output, modid, locale);
    }

    @Override
    protected void addTranslations() {
        add("itemGroup.mattercraft", "物质科技");
        add("itemGroup.mattercraft_building_blocks", "物质科技建筑块");

        addItem(ModItems.SPACE_GEM, "空间之石");
        addBlock(ModBlocks.SPACE_GEM_BLOCK, "空间之石块");
    }
}
