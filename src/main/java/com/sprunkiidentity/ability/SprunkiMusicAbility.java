package com.sprunkiidentity.ability;

import draylar.identity.ability.IdentityAbility;
import com.sprunkiidentity.music.MusicManager;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import com.mojang.logging.LogUtils;
import org.slf4j.Logger;

public class SprunkiMusicAbility<E extends LivingEntity> extends IdentityAbility<E> {
    private static final Logger LOGGER = LogUtils.getLogger();
    
    protected final String soundResourceLocation;
    protected final Item icon;
    protected final int cooldownTicks;
    
    public SprunkiMusicAbility(String soundResourceLocation, Item icon, int cooldownTicks) {
        this.soundResourceLocation = soundResourceLocation;
        this.icon = icon;
        this.cooldownTicks = cooldownTicks;
    }
    
    public SprunkiMusicAbility(String soundResourceLocation) {
        this(soundResourceLocation, Items.NOTE_BLOCK, 40); // Default 2 seconds cooldown
    }
    
    @Override
    public void onUse(Player player, E identity, Level world) {
        if (world == null || player == null) {
            LOGGER.warn("Null player or world in ability use");
            return;
        }
        
        if (!world.isClientSide) {
            // Toggle music on/off using the MusicManager
            MusicManager.getInstance().toggleMusic(player, soundResourceLocation);
            
            boolean isPlaying = MusicManager.getInstance().isMusicPlaying(player);
            LOGGER.debug("Toggled music {} for player {} - now {}", 
                soundResourceLocation, 
                player.getName().getString(), 
                isPlaying ? "playing" : "stopped"
            );
        }
    }
    
    @Override
    public int getCooldown(E entity) {
        return cooldownTicks;
    }
    
    @Override
    public Item getIcon() {
        return icon;
    }
    
    @Override
    public String toString() {
        return "SprunkiMusicAbility{sound=" + soundResourceLocation + ", cooldown=" + cooldownTicks + "}";
    }
}