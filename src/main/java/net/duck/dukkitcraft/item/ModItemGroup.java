package net.duck.dukkitcraft.item;

import net.duck.dukkitcraft.DukkitCraft;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItemGroup {
    public static ItemGroup dctab;

    public static void registerItemGroups(){
        dctab = FabricItemGroup.builder(new Identifier(DukkitCraft.MOD_ID, "dctab"))
                .displayName(Text.translatable("itemgroup.dctab"))
                .icon(() -> new ItemStack(ModItems.uraniumIngot)).build();
    }
}
