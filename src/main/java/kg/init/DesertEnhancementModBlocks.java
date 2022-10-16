
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package kg.init;

import org.checkerframework.checker.units.qual.kg;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.level.block.Block;

import kg.block.TriodiaBlock;
import kg.block.TallGrassBlock;

import kg.DesertEnhancementMod;

public class DesertEnhancementModBlocks {
	public static final DeferredRegister<Block> REGISTRY = DeferredRegister.create(ForgeRegistries.BLOCKS, DesertEnhancementMod.MODID);
	public static final RegistryObject<Block> TRIODIA = REGISTRY.register("triodia", () -> new TriodiaBlock());
	public static final RegistryObject<Block> TALL_TRIODIA = REGISTRY.register("tall_triodia", () -> new TallGrassBlock());

	@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
	public static class ClientSideHandler {
		@SubscribeEvent
		public static void clientSetup(FMLClientSetupEvent event) {
			TriodiaBlock.registerRenderLayer();
			TallGrassBlock.registerRenderLayer();
		}
	}
}
