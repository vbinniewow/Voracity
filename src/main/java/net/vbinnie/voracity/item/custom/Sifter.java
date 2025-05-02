package net.vbinnie.voracity.item.custom;

import net.minecraft.block.Blocks;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.ActionResult;
import net.minecraft.util.UseAction;
import net.minecraft.world.World;
import net.vbinnie.voracity.block.ModBlocks;
import net.vbinnie.voracity.item.ModItems;

import java.util.Objects;

public class Sifter extends Item {
    public Sifter(Settings settings) { super(settings); }

    public UseAction getUseAction(ItemStack stack) {
        return UseAction.BRUSH;
    }

    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {
        World world = context.getWorld();
        PlayerEntity player = context.getPlayer();
        if ( world.getBlockState(context.getBlockPos()).getBlock() == ModBlocks.END_MINERAL_BLOCK) {
            world.playSound(player, context.getBlockPos(), SoundEvents.BLOCK_SAND_PLACE, SoundCategory.AMBIENT, 1, 1);

            Objects.requireNonNull(context.getPlayer()).giveItemStack(ModItems.SIFTED_END_MINERAL.getDefaultStack());
            world.breakBlock(context.getBlockPos(), false);
            assert player != null;
            player.getItemCooldownManager().set(this, 20);

            world.addBlockBreakParticles(context.getBlockPos(), Blocks.END_PORTAL_FRAME.getDefaultState());

            return ActionResult.SUCCESS;
        }
        else {

            return ActionResult.FAIL;
        }
    }
}

