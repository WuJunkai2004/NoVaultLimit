package com.skytendo.novaultlimit.mixin;

import net.minecraft.block.vault.VaultServerData;
import net.minecraft.entity.player.PlayerEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(VaultServerData.class)
public abstract class VaultServerDataMixin {

    /**
     * hasRewardedPlayer() injection (HEAD)
     *
     * Makes sure the server NEVER thinks of a player as "already rewarded"
     * This injection basically removes the entire only-open-once-per-player-mechanic, nearly everything else is for the visible representation
     */
    @Inject(method = "hasRewardedPlayer(Lnet/minecraft/entity/player/PlayerEntity;)Z", at = @At("HEAD"))
    public boolean hasRewardedPlayer(PlayerEntity playerEntity, CallbackInfoReturnable<Boolean> cir) {
        return false;
    }
}
