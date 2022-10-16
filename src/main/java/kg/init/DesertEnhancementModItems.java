
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package kg.init;

import org.checkerframework.checker.units.qual.kg;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.DoubleHighBlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.BlockItem;

import kg.item.TriodiaMilletItem;
import kg.item.TriodiaBreadItem;

import kg.DesertEnhancementMod;

public class DesertEnhancementModItems {
	public static final DeferredRegister<Item> REGISTRY = DeferredRegister.create(ForgeRegistries.ITEMS, DesertEnhancementMod.MODID);
	public static final RegistryObject<Item> TRIODIA = block(DesertEnhancementModBlocks.TRIODIA, CreativeModeTab.TAB_DECORATIONS);
	public static final RegistryObject<Item> TALL_TRIODIA = doubleBlock(DesertEnhancementModBlocks.TALL_TRIODIA, CreativeModeTab.TAB_DECORATIONS);
	public static final RegistryObject<Item> TRIODIA_MILLET = REGISTRY.register("triodia_millet", () -> new TriodiaMilletItem());
	public static final RegistryObject<Item> TRIODIA_BREAD = REGISTRY.register("triodia_bread", () -> new TriodiaBreadItem());

	private static RegistryObject<Item> block(RegistryObject<Block> block, CreativeModeTab tab) {
		return REGISTRY.register(block.getId().getPath(), () -> new BlockItem(block.get(), new Item.Properties().tab(tab)));
	}

	private static RegistryObject<Item> doubleBlock(RegistryObject<Block> block, CreativeModeTab tab) {
		return REGISTRY.register(block.getId().getPath(), () -> new DoubleHighBlockItem(block.get(), new Item.Properties().tab(tab)));
	}
}
