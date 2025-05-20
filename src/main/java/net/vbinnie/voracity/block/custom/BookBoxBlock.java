package net.vbinnie.voracity.block.custom;


import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.nbt.NbtList;
import net.minecraft.nbt.NbtString;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.state.property.EnumProperty;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.World;




public class BookBoxBlock extends Block {

    public BookBoxBlock(Settings settings) {
        super(settings);
    }
    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos,
                              PlayerEntity player, Hand hand, BlockHitResult hit) {
        if (!world.isClient && player instanceof ServerPlayerEntity serverPlayer) {
            ItemStack book = new ItemStack(Items.WRITTEN_BOOK);


            NbtList pages = new NbtList();
            Random random = world.getRandom();
            int pageCount = 1 + random.nextInt(5); // 1 to 5 pages

            for (int i = 0; i < pageCount; i++) {
                String randomText = generateRandomText(random, 16 + random.nextInt(70));
                pages.add(NbtString.of(Text.Serializer.toJson(Text.literal(randomText))));
            }


                    book.getOrCreateNbt().put("pages", pages);
                    book.getOrCreateNbt().putString("author", "BCSMP S5");
                    book.getOrCreateNbt().putString("title", generateRandomText(random, 1 + random.nextInt(16)));
            // Drop the book
            player.dropItem(book, false);
        }

        return ActionResult.SUCCESS;
    }

    private String generateRandomText(Random random, int length) {
        StringBuilder sb = new StringBuilder();
        String chars = "abcdefghijklmnopqrstuvwxyz ᔑʖᓵ↸ᒷ⎓⊣⍑╎⋮ꖌꖎᒲリ¡ᑑ⚍∷ᓭℸ ̣ ⍊∴|| ̇/⨅";

        for (int i = 0; i < length; i++) {
            sb.append(chars.charAt(random.nextInt(chars.length())));
        }

        return sb.toString();
    }
}
