package net.duck.dukkitcraft.block;

import net.duck.dukkitcraft.DukkitCraft;
import net.duck.dukkitcraft.item.ModItemGroup;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.ExperienceDroppingBlock;
import net.minecraft.block.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.intprovider.UniformIntProvider;

//EACH BLOCK REQUIRES ITS OWN blockstates JSON file, block model JSON file, item model JSON file

public class ModBlocks {

    public static final Block FirstBlock = registerBlock("firstblock",
            new Block(FabricBlockSettings.of(Material.METAL).strength(4.0F).requiresTool()), ModItemGroup.dctab);

    public static final Block SecondBlock = registerBlock("secondblock",
            new ExperienceDroppingBlock(FabricBlockSettings.of(Material.STONE).strength(4.0F).requiresTool(),
                    UniformIntProvider.create(2, 5)), ModItemGroup.dctab);//(2, 5) is xp amount.. can change it
                                                             //middle mouse click to find xp values for vanilla ores

    public static final Block ThirdBlock = registerBlock("thirdblock",
            new Block(FabricBlockSettings.of(Material.METAL).strength(4.0F).requiresTool()), ModItemGroup.dctab);

    private static Block registerBlock(String name, Block block, ItemGroup group){
        registerBlockItem(name, block, group);
        return Registry.register(Registries.BLOCK, new Identifier(DukkitCraft.MOD_ID, name), block);
    }

    private static Item registerBlockItem(String name, Block block, ItemGroup group) {
        Item item = Registry.register(Registries.ITEM, new Identifier(DukkitCraft.MOD_ID, name),
                new BlockItem(block, new FabricItemSettings()));
        ItemGroupEvents.modifyEntriesEvent(group).register(entries -> entries.add(item));
        return item;
    }


    public static void registerModBlocks(){
        DukkitCraft.LOGGER.info("Registering ModBlocks for" + DukkitCraft.MOD_ID);
    }
}
