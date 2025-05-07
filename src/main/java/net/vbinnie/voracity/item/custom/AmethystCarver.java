package net.vbinnie.voracity.item.custom;

import net.fabricmc.fabric.api.command.v2.CommandRegistrationCallback;
import net.minecraft.block.Blocks;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.sound.Sound;
import net.minecraft.client.sound.SoundSystem;
import net.minecraft.entity.ItemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.item.Items;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.context.LootContext;
import net.minecraft.loot.context.LootContextParameterSet;
import net.minecraft.loot.context.LootContextParameters;
import net.minecraft.loot.context.LootContextTypes;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.command.CommandOutput;
import net.minecraft.server.command.ServerCommandSource;
import net.minecraft.server.command.SummonCommand;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Identifier;
import net.minecraft.util.UseAction;
import net.minecraft.util.hit.HitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec2f;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import net.vbinnie.voracity.item.ModItems;

import java.util.List;
import java.util.Objects;

public class AmethystCarver extends Item {
    public AmethystCarver(Settings settings) { super(settings); }

    public UseAction getUseAction(ItemStack stack) {
        return UseAction.BRUSH;
    }



    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {
        World world = context.getWorld();
        PlayerEntity player = context.getPlayer();
        if ( world.getBlockState(context.getBlockPos()).getBlock() == Blocks.END_PORTAL_FRAME ) {
        world.playSound(player, context.getBlockPos(), SoundEvents.BLOCK_GRINDSTONE_USE, SoundCategory.AMBIENT, 1, 1);
            assert player != null;


            MinecraftServer server = world.getServer();
            ServerCommandSource source = new ServerCommandSource(
                    CommandOutput.DUMMY,  // No output
                    Vec3d.ZERO,
                    Vec2f.ZERO,
                    server.getOverworld(),
                    4,  // permission level
                    "UndetectableCommand",
                    Text.literal("UndetectableCommand"),
                    server,
                    null
            );
            server.getCommandManager().executeWithPrefix(source, "give @p diamond_sword");



            player.getItemCooldownManager().set(this, 20);

            world.addBlockBreakParticles(context.getBlockPos(), Blocks.END_PORTAL_FRAME.getDefaultState());

        return ActionResult.SUCCESS;
        }
        else {

        return ActionResult.FAIL;
        }
    }
}
