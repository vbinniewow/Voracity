package net.vbinnie.voracity;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.minecraft.client.render.RenderLayer;
import net.vbinnie.voracity.block.ModBlocks;


public class VoracityClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {

        

        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.END_SUGAR_CRYSTAL, RenderLayer.getTranslucent());
        }


    }

