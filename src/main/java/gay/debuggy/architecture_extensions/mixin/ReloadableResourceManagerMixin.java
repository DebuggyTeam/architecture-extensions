/*
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at https://mozilla.org/MPL/2.0/.
 */

/*
 * <a href="https://github.com/Sweet-Berry-Collective/Wandering-Wizardry/blob/1.21/common/src/main/java/dev/sweetberry/wwizardry/mixin/Mixin_ReloadableResourceManager.java">
 *     Borrowed from Wandering Wizardry with Octal's permission.
 * </a>
 */
package gay.debuggy.architecture_extensions.mixin;

import gay.debuggy.architecture_extensions.ArchitectureExtensions;
import gay.debuggy.architecture_extensions.DeferredRegistration;
import gay.debuggy.architecture_extensions.resource.DataGeneration;
import net.fabricmc.fabric.api.resource.ResourceManagerHelper;
import net.minecraft.resource.MultiPackResourceManager;
import net.minecraft.resource.ResourceReload;
import net.minecraft.resource.pack.ResourcePack;
import net.minecraft.util.Unit;
import net.minecraft.resource.ResourceType;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArg;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;

public class ReloadableResourceManagerMixin {
	@Shadow
	@Final
	ResourceType type;


	@Inject(
		method = "createReload",
		at = @At(
			value = "INVOKE",
			target = "Lnet/minecraft/resource/MultiPackResourceManager;<init>(Lnet/minecraft/resource/ResourceType;Ljava/util/List;)V",
			shift = At.Shift.BEFORE
		)
	)
	private void archEx$reloadGeneratedData(Executor prepareExecutor, Executor applyExecutor, CompletableFuture<Unit> initialStage, List<ResourcePack> packs, CallbackInfoReturnable<ResourceReload> cir) {
		var temp = new MultiPackResourceManager(type, packs);
		try {
			// TODO: figure out exactly what to reload in here when someone reloads resources. 
			//  also figure out whether or not generating twice can work on a (headless) server
			
		} catch (IOException ex) {
			ArchitectureExtensions.LOGGER.error(ex.toString());
		}
		temp.close();
	}

	@ModifyArg(
		method = "createReload",
		at = @At(
			value = "INVOKE",
			target = "Lnet/minecraft/server/packs/resources/MultiPackResourceManager;<init>(Lnet/minecraft/server/packs/PackType;Ljava/util/List;)V"
		)
	)
	private List<ResourcePack> archEx$getPacks(List<ResourcePack> old) {
		var packs = new ArrayList<>(old);
		packs.add(ArchitectureExtensions.RESOURCE_PACK); // add arch-ex's virtual resource pack
		return packs;
	}
}
