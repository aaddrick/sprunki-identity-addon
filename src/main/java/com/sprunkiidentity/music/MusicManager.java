package com.sprunkiidentity.music;

import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.registries.ForgeRegistries;
import com.mojang.logging.LogUtils;
import org.slf4j.Logger;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * Manages looping music for players using Sprunki abilities
 */
public class MusicManager {
    private static final Logger LOGGER = LogUtils.getLogger();
    private static final int MUSIC_LOOP_INTERVAL = 100; // 5 seconds (100 ticks)
    private static final int PARTICLE_INTERVAL = 20; // 1 second (20 ticks)
    
    private static final Map<UUID, MusicState> activeMusicPlayers = new HashMap<>();
    private static MusicManager instance;
    
    public static class MusicState {
        public final String soundResource;
        public int ticksSinceLastMusic = 0;
        public int ticksSinceLastParticles = 0;
        
        public MusicState(String soundResource) {
            this.soundResource = soundResource;
        }
    }
    
    public static MusicManager getInstance() {
        if (instance == null) {
            instance = new MusicManager();
            MinecraftForge.EVENT_BUS.register(instance);
        }
        return instance;
    }
    
    public void toggleMusic(Player player, String soundResource) {
        UUID playerId = player.getUUID();
        
        if (activeMusicPlayers.containsKey(playerId)) {
            // Stop current music
            activeMusicPlayers.remove(playerId);
            LOGGER.debug("Stopped music for player {}", player.getName().getString());
        } else {
            // Start new music
            activeMusicPlayers.put(playerId, new MusicState(soundResource));
            LOGGER.debug("Started music {} for player {}", soundResource, player.getName().getString());
            
            // Play immediately
            playSound(player, soundResource);
        }
    }
    
    public boolean isMusicPlaying(Player player) {
        return activeMusicPlayers.containsKey(player.getUUID());
    }
    
    @SubscribeEvent
    public void onServerTick(TickEvent.ServerTickEvent event) {
        if (event.phase != TickEvent.Phase.END) return;
        
        // Update all active music players
        activeMusicPlayers.entrySet().removeIf(entry -> {
            UUID playerId = entry.getKey();
            MusicState state = entry.getValue();
            
            // Find the player in the world
            Player player = null;
            for (ServerLevel level : event.getServer().getAllLevels()) {
                player = level.getPlayerByUUID(playerId);
                if (player != null) break;
            }
            
            if (player == null) {
                // Player is offline, remove from tracking
                return true;
            }
            
            // Update timers
            state.ticksSinceLastMusic++;
            state.ticksSinceLastParticles++;
            
            // Play music if it's time
            if (state.ticksSinceLastMusic >= MUSIC_LOOP_INTERVAL) {
                playSound(player, state.soundResource);
                state.ticksSinceLastMusic = 0;
            }
            
            // Spawn particles if it's time
            if (state.ticksSinceLastParticles >= PARTICLE_INTERVAL) {
                spawnParticles(player);
                state.ticksSinceLastParticles = 0;
            }
            
            return false; // Keep the entry
        });
    }
    
    private void playSound(Player player, String soundResource) {
        Level world = player.level();
        if (world == null || world.isClientSide) return;
        
        BlockPos pos = player.blockPosition();
        SoundEvent soundEvent = ForgeRegistries.SOUND_EVENTS.getValue(ResourceLocation.parse(soundResource));
        
        if (soundEvent != null) {
            world.playSound(null, pos, soundEvent, SoundSource.PLAYERS, 1.0f, 1.0f);
            LOGGER.debug("Looping sound {} for player {}", soundResource, player.getName().getString());
        } else {
            LOGGER.warn("Sound event not found: {}", soundResource);
        }
    }
    
    private void spawnParticles(Player player) {
        Level world = player.level();
        if (!(world instanceof ServerLevel serverLevel)) return;
        
        try {
            for (int i = 0; i < 4; i++) {
                double offsetX = (world.random.nextDouble() - 0.5) * 2.0;
                double offsetY = world.random.nextDouble() * 2.0 + 1.0;
                double offsetZ = (world.random.nextDouble() - 0.5) * 2.0;
                
                serverLevel.sendParticles(
                    ParticleTypes.NOTE,
                    player.getX() + offsetX,
                    player.getY() + offsetY,
                    player.getZ() + offsetZ,
                    1, 0.0, 0.0, 0.0, 1.0
                );
            }
        } catch (Exception e) {
            LOGGER.debug("Could not spawn particles: {}", e.getMessage());
        }
    }
    
    public void stopAllMusic() {
        activeMusicPlayers.clear();
        LOGGER.debug("Stopped all music playback");
    }
}