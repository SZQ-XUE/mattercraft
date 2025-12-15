package com.szqxue.mattercraft.data;

import com.szqxue.mattercraft.init.Block.ModBlocks;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.client.model.generators.BlockStateProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

/**
 * @author SZQ23
 */
public class ModBlockStateProvider extends BlockStateProvider {

    public ModBlockStateProvider(PackOutput output, String modid, ExistingFileHelper exFileHelper) {
        super(output, modid, exFileHelper);
    }

    // Generates the block states and models for the blocks
    @Override
    protected void registerStatesAndModels() {
        simpleBlockWithItem(ModBlocks.SPACE_GEM_BLOCK.get(),
                cubeAll(ModBlocks.SPACE_GEM_BLOCK.get()));
    }
}
