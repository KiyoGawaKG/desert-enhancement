
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package kg.init;

import org.checkerframework.checker.units.qual.kg;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.world.BiomeLoadingEvent;

import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.Holder;

import kg.world.features.plants.TriodiaFeature;
import kg.world.features.plants.TallGrassFeature;

import kg.DesertEnhancementMod;

import java.util.function.Supplier;
import java.util.Set;
import java.util.List;
import java.util.ArrayList;

@Mod.EventBusSubscriber
public class DesertEnhancementModFeatures {
	public static final DeferredRegister<Feature<?>> REGISTRY = DeferredRegister.create(ForgeRegistries.FEATURES, DesertEnhancementMod.MODID);
	private static final List<FeatureRegistration> FEATURE_REGISTRATIONS = new ArrayList<>();
	public static final RegistryObject<Feature<?>> TRIODIA = register("triodia", TriodiaFeature::feature,
			new FeatureRegistration(GenerationStep.Decoration.VEGETAL_DECORATION, TriodiaFeature.GENERATE_BIOMES, TriodiaFeature::placedFeature));
	public static final RegistryObject<Feature<?>> TALL_TRIODIA = register("tall_triodia", TallGrassFeature::feature,
			new FeatureRegistration(GenerationStep.Decoration.VEGETAL_DECORATION, TallGrassFeature.GENERATE_BIOMES, TallGrassFeature::placedFeature));

	private static RegistryObject<Feature<?>> register(String registryname, Supplier<Feature<?>> feature, FeatureRegistration featureRegistration) {
		FEATURE_REGISTRATIONS.add(featureRegistration);
		return REGISTRY.register(registryname, feature);
	}

	@SubscribeEvent
	public static void addFeaturesToBiomes(BiomeLoadingEvent event) {
		for (FeatureRegistration registration : FEATURE_REGISTRATIONS) {
			if (registration.biomes() == null || registration.biomes().contains(event.getName()))
				event.getGeneration().getFeatures(registration.stage()).add(registration.placedFeature().get());
		}
	}

	private static record FeatureRegistration(GenerationStep.Decoration stage, Set<ResourceLocation> biomes,
			Supplier<Holder<PlacedFeature>> placedFeature) {
	}
}
