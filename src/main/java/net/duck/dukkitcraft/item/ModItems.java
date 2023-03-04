package net.duck.dukkitcraft.item;

import net.duck.dukkitcraft.DukkitCraft;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {
    public static final Item uraniumIngot = registerItem("uranium_ingot",
            new Item(new FabricItemSettings()));
    public static final Item uraniumDust = registerItem("uranium_dust",
            new Item(new FabricItemSettings()));

    private static Item registerItem(String name, Item item){
        return Registry.register(Registries.ITEM, new Identifier(DukkitCraft.MOD_ID, name), item);
    }

    public static void addItemsToItemGroup(){
       // Vanilla creative tabs -- addToItemGroup(ItemGroups.INGREDIENTS, FirstItem);
        addToItemGroup(ModItemGroup.dctab, uraniumIngot);
        addToItemGroup(ModItemGroup.dctab, uraniumDust);
    }

    private static void addToItemGroup(ItemGroup group, Item item){
        ItemGroupEvents.modifyEntriesEvent(group).register(entries -> entries.add(item));
    }

    public static void registerModItems(){
        DukkitCraft.LOGGER.info("Registering Mod Items for" + DukkitCraft.MOD_ID);

        addItemsToItemGroup();
    }

}
