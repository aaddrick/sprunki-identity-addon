package com.sprunkiidentity.mixin;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.Tag;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import com.mojang.logging.LogUtils;
import org.slf4j.Logger;

/**
 * Mixin to add null safety to SprunkiModModVariables.PlayerVariables.readNBT()
 * This prevents crashes when the NBT data is null or not a CompoundTag
 */
@Mixin(targets = "net.mcreator.sprunkimod.network.SprunkiModModVariables$PlayerVariables", remap = false)
public class PlayerVariablesMixin {
    private static final Logger LOGGER = LogUtils.getLogger();
    
    // Shadow the fields that need to be reset to defaults
    @Shadow(remap = false)
    public double dievar;
    
    @Shadow(remap = false)
    public double MusicTick;
    
    @Shadow(remap = false)
    public double MusicWait;
    
    @Shadow(remap = false)
    public boolean MusicLock;
    
    @Shadow(remap = false)
    public boolean MusicReplace;
    
    @Shadow(remap = false)
    public String MusicPlay;
    
    @Shadow(remap = false)
    public double heart;
    
    @Shadow(remap = false)
    public boolean item;
    
    @Inject(method = "readNBT", at = @At("HEAD"), cancellable = true, remap = false)
    public void addNullSafetyToReadNBT(Tag tag, CallbackInfo ci) {
        if (tag == null || !(tag instanceof CompoundTag)) {
            LOGGER.warn("PlayerVariables.readNBT received null or invalid tag, resetting to defaults");
            
            // Reset all fields to their default values
            this.dievar = 0.0;
            this.MusicTick = 0.0;
            this.MusicWait = 0.0;
            this.MusicLock = false;
            this.MusicReplace = false;
            this.MusicPlay = "\"\"";
            this.heart = 0.0;
            this.item = false;
            
            // Cancel the original method execution
            ci.cancel();
        }
    }
}