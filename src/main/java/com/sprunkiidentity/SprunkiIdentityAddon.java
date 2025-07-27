package com.sprunkiidentity;

import com.mojang.logging.LogUtils;
import com.sprunkiidentity.music.MusicManager;
import com.sprunkiidentity.registry.SprunkiAbilityRegistry;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.server.ServerStartedEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;

@Mod(SprunkiIdentityAddon.MODID)
public class SprunkiIdentityAddon {
    public static final String MODID = "sprunkiidentityaddon";
    private static final Logger LOGGER = LogUtils.getLogger();

    public SprunkiIdentityAddon(FMLJavaModLoadingContext context) {
        LOGGER.info("Sprunki Identity Addon initializing...");
        
        // Register ourselves for server and other game events
        MinecraftForge.EVENT_BUS.register(this);
        
        // Initialize the music manager
        MusicManager.getInstance();
        
        LOGGER.info("Sprunki Identity Addon initialized - will register abilities on server start");
    }

    @SubscribeEvent
    public void onServerStarted(ServerStartedEvent event) {
        LOGGER.info("Sprunki Identity Addon: Server started, registering Sprunki abilities...");
        try {
            SprunkiAbilityRegistry.registerAbilities();
            LOGGER.info("Sprunki Identity Addon: Successfully registered Sprunki abilities");
        } catch (Exception e) {
            LOGGER.error("Sprunki Identity Addon: Failed to register abilities: {}", e.getMessage(), e);
        }
    }
}