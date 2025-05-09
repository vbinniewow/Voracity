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
import net.minecraft.state.property.Properties;
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
    public AmethystCarver(Settings settings) { 
        super(settings.maxDamage(250)); // Set durability to 250
    }

    public UseAction getUseAction(ItemStack stack) {
        return UseAction.BRUSH;
    }

    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {
        World world = context.getWorld();
        PlayerEntity player = context.getPlayer();
        BlockPos blockPos = context.getBlockPos();

        if (world.getBlockState(blockPos).getBlock() == Blocks.END_PORTAL_FRAME) {
            boolean hasEye = world.getBlockState(blockPos).get(Properties.EYE);

            if (hasEye) {
                // Remove the eye and drop it
                world.setBlockState(blockPos, world.getBlockState(blockPos).with(Properties.EYE, false));
                world.spawnEntity(new ItemEntity(world, blockPos.getX() + 0.5, blockPos.getY() + 0.75, blockPos.getZ() + 0.5, new ItemStack(Items.ENDER_EYE)));
                world.playSound(player, blockPos, SoundEvents.BLOCK_GRINDSTONE_USE, SoundCategory.AMBIENT, 1, 1);
            } else {
                // Existing behavior for empty End Portal Frame
                world.playSound(player, blockPos, SoundEvents.BLOCK_GRINDSTONE_USE, SoundCategory.AMBIENT, 1, 1);
                assert player != null;

                if (!world.isClient) { // Ensure this runs only on the server
                    ServerWorld serverWorld = (ServerWorld) world;
                    Identifier lootTableId = new Identifier("voracity", "blocks/end_portal_frame_carve");
                    LootTable lootTable = serverWorld.getServer().getLootManager().getLootTable(lootTableId);

                    LootContextParameterSet parameterSet = new LootContextParameterSet.Builder(serverWorld)
                        .add(LootContextParameters.ORIGIN, Vec3d.ofCenter(blockPos))
                        .add(LootContextParameters.THIS_ENTITY, player)
                        .build(LootContextTypes.CHEST);

                    List<ItemStack> loot = lootTable.generateLoot(parameterSet);

                    for (ItemStack stack : loot) {
                        world.spawnEntity(new ItemEntity(world, blockPos.getX() + 0.5, blockPos.getY() + .75, blockPos.getZ() + 0.5, stack));
                    }
                }

                world.addBlockBreakParticles(blockPos, Blocks.END_PORTAL_FRAME.getDefaultState());
            }

            // Reduce durability by 1
            context.getStack().damage(1, player, (p) -> p.sendToolBreakStatus(context.getHand()));

            player.getItemCooldownManager().set(this, 10);
            return ActionResult.SUCCESS;
        } else {
            return ActionResult.FAIL;
        }
    }
}