package io.github.debuggyteam.architecture_extensions.mixin;

import java.util.List;
import java.util.Map;

import org.quiltmc.loader.api.minecraft.ClientOnly;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import org.spongepowered.asm.mixin.injection.callback.LocalCapture;

import io.github.debuggyteam.architecture_extensions.resource.LanguageGeneration;
import net.minecraft.client.resource.language.LanguageDefinition;
import net.minecraft.client.resource.language.TranslationStorage;
import net.minecraft.resource.ResourceManager;

@ClientOnly
@Mixin(TranslationStorage.class)
public abstract class TranslationStorageMixin {
	@Inject(
		method = "load(Lnet/minecraft/resource/ResourceManager;Ljava/util/List;Z)Lnet/minecraft/client/resource/language/TranslationStorage;",
		at = @At(value = "INVOKE", target = "Lcom/google/common/collect/ImmutableMap;copyOf(Ljava/util/Map;)Lcom/google/common/collect/ImmutableMap;", remap = false),
		locals = LocalCapture.CAPTURE_FAILHARD
	)
	private static void architecture_extensions$onLangLoad(
		ResourceManager resourceManager,
		List<LanguageDefinition> definitions,
		boolean rightToLeft,
		CallbackInfoReturnable<TranslationStorage> cir,
		Map<String, String> langEntries)
	{
		LanguageGeneration.generate(langEntries);
	}
}
