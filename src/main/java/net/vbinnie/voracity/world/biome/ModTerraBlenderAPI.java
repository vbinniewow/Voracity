package net.vbinnie.voracity.world.biome;

import net.minecraft.util.Identifier;

import net.vbinnie.voracity.Voracity;
import net.vbinnie.voracity.world.biome.surface.ModMaterialRules;
import terrablender.api.Regions;
import terrablender.api.SurfaceRuleManager;
import terrablender.api.TerraBlenderApi;

public class ModTerraBlenderAPI implements TerraBlenderApi {

    @Override
    public void onTerraBlenderInitialized() {
        Regions.register(new ModOverworldRegion(Identifier.of(Voracity.MOD_ID, "overworld"), 4));


        SurfaceRuleManager.addSurfaceRules(SurfaceRuleManager.RuleCategory.OVERWORLD, Voracity.MOD_ID, ModMaterialRules.makeRules());
    }


}
