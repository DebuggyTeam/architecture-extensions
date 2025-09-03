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
import gay.debuggy.architecture_extensions.resource.DataGeneration;
import net.minecraft.resource.MultiPackResourceManager;
import net.minecraft.resource.ReloadableResourceManager;
import net.minecraft.resource.ResourceReload;
import net.minecraft.resource.ResourceType;
import net.minecraft.resource.pack.ResourcePack;
import net.minecraft.util.Unit;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.ModifyArg;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;

@Mixin(ReloadableResourceManager.class)
public class ReloadableResourceManagerMixin {
	@Shadow
	@Final
	private ResourceType type;


	@Inject(
		method = "reload",
		at = @At(
			value = "INVOKE",
			target = "Lnet/minecraft/resource/MultiPackResourceManager;<init>(Lnet/minecraft/resource/ResourceType;Ljava/util/List;)V",
			shift = At.Shift.BEFORE
		)
	)
	private void archEx$reloadGeneratedData(Executor prepareExecutor, Executor applyExecutor, CompletableFuture<Unit> initialStage, List<ResourcePack> packs, CallbackInfoReturnable<ResourceReload> cir) {
		var temp = new MultiPackResourceManager(type, packs);
		// TODO: figure out exactly what to reload in here when someone reloads resources. 
		//  also figure out whether or not generating twice can work on a (headless) server
		DataGeneration.generate(type);
		System.out.println("did we actually generate anything?");

		// might not be needed since we're not giving "temp" to any datageneration method
		temp.close();
	}

	@ModifyArg(
		method = "reload",
		at = @At(
			value = "INVOKE",
			target = "Lnet/minecraft/resource/MultiPackResourceManager;<init>(Lnet/minecraft/resource/ResourceType;Ljava/util/List;)V"
		)
	)
	private List<ResourcePack> archEx$getPacks(List<ResourcePack> old) {
		var packs = new ArrayList<>(old);
		packs.add(ArchitectureExtensions.RESOURCE_PACK); // add arch-ex's virtual resource pack
		System.out.println("did we actually generate anything too?");
		return packs;
	}
}
