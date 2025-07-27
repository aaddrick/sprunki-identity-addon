package com.sprunkiidentity.registry;

import com.sprunkiidentity.ability.SprunkiMusicAbility;
import draylar.identity.ability.AbilityRegistry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraftforge.registries.ForgeRegistries;
import com.mojang.logging.LogUtils;
import org.slf4j.Logger;

import java.util.HashMap;
import java.util.Map;

public class SprunkiAbilityRegistry {
    private static final Logger LOGGER = LogUtils.getLogger();
    private static final Map<String, String> ENTITY_SOUNDS = new HashMap<>();
    
    static {
        // Normal Sprunki entities
        ENTITY_SOUNDS.put("sprunki_mod:sprunki_oren", "sprunki_mod:sprunki_oren_normal_version");
        ENTITY_SOUNDS.put("sprunki_mod:sprunki_raddy", "sprunki_mod:sprunki_raddy_normal_version");
        ENTITY_SOUNDS.put("sprunki_mod:sprunki_clurk", "sprunki_mod:sprunki_clurk_normal_version");
        ENTITY_SOUNDS.put("sprunki_mod:sprunki_fun_bot", "sprunki_mod:sprunki_fun_bot_normal_version");
        ENTITY_SOUNDS.put("sprunki_mod:sprunki_vineria", "sprunki_mod:sprunki_vineria_normal_version");
        ENTITY_SOUNDS.put("sprunki_mod:sprunki_gray", "sprunki_mod:sprunki_gray_normal_version");
        ENTITY_SOUNDS.put("sprunki_mod:sprunki_brud", "sprunki_mod:sprunki_brud_normal_version");
        ENTITY_SOUNDS.put("sprunki_mod:sprunki_garnold", "sprunki_mod:sprunki_garnold_normal_version");
        ENTITY_SOUNDS.put("sprunki_mod:sprunki_owakcx", "sprunki_mod:sprunki_owakcx_normal_version");
        ENTITY_SOUNDS.put("sprunki_mod:sprunki_sky", "sprunki_mod:sprunki_sky_normal_version");
        ENTITY_SOUNDS.put("sprunki_mod:sprunki_mr_sun", "sprunki_mod:sprunki_mr_sun_normal_version");
        ENTITY_SOUNDS.put("sprunki_mod:sprunki_durple", "sprunki_mod:sprunki_durple_normal_version");
        ENTITY_SOUNDS.put("sprunki_mod:sprunki_mr_tree", "sprunki_mod:sprunki_mr_tree_normal_version");
        ENTITY_SOUNDS.put("sprunki_mod:sprunki_simon", "sprunki_mod:sprunki_simon_normal_version");
        ENTITY_SOUNDS.put("sprunki_mod:sprunki_tunner", "sprunki_mod:sprunki_tunner_normal_version");
        ENTITY_SOUNDS.put("sprunki_mod:sprunki_mr_fun_computer", "sprunki_mod:sprunki_mr_fun_computer_normal_version");
        ENTITY_SOUNDS.put("sprunki_mod:sprunki_wenda", "sprunki_mod:sprunki_wenda_normal_version");
        ENTITY_SOUNDS.put("sprunki_mod:sprunki_pinki", "sprunki_mod:sprunki_pinki_normal_version");
        ENTITY_SOUNDS.put("sprunki_mod:sprunki_jevin", "sprunki_mod:sprunki_jevin_normal_version");
        ENTITY_SOUNDS.put("sprunki_mod:sprunki_black", "sprunki_mod:sprunki_black_normal_version");
        
        // Horror Sprunki entities  
        ENTITY_SOUNDS.put("sprunki_mod:sprunki_horror_oren", "sprunki_mod:sprunki_oren_horror_version");
        ENTITY_SOUNDS.put("sprunki_mod:sprunki_horror_raddy", "sprunki_mod:sprunki_raddy_horror_mode");
        ENTITY_SOUNDS.put("sprunki_mod:sprunki_horror_clurk", "sprunki_mod:sprunki_clurk_horror_version");
        ENTITY_SOUNDS.put("sprunki_mod:sprunki_horror_fun_bot", "sprunki_mod:sprunki_fun_bot_horror_mode");
        ENTITY_SOUNDS.put("sprunki_mod:sprunki_horror_vineria", "sprunki_mod:sprunki_vineria_horror_mode");
        ENTITY_SOUNDS.put("sprunki_mod:sprunki_horror_gray", "sprunki_mod:sprunki_gray_horror_mode");
        ENTITY_SOUNDS.put("sprunki_mod:sprunki_horror_brud", "sprunki_mod:sprunki_brud_horror_mode");
        ENTITY_SOUNDS.put("sprunki_mod:sprunki_horror_garnold", "sprunki_mod:sprunki_garnold_horror_mode");
        ENTITY_SOUNDS.put("sprunki_mod:sprunki_horror_lime", "sprunki_mod:sprunki_owakcx_horror_mode");
        ENTITY_SOUNDS.put("sprunki_mod:sprunki_horror_sky", "sprunki_mod:sprunki_sky_horror_version");
        ENTITY_SOUNDS.put("sprunki_mod:sprunki_horror_mr_sun", "sprunki_mod:sprunki_mr_sun_horror_version");
        ENTITY_SOUNDS.put("sprunki_mod:sprunki_horror_durple", "sprunki_mod:sprunki_durple_horror_mode");
        ENTITY_SOUNDS.put("sprunki_mod:sprunki_horror_mr_tree", "sprunki_mod:sprunki_mr_tree_horror_version");
        ENTITY_SOUNDS.put("sprunki_mod:sprunki_horror_simon", "sprunki_mod:sprunki_simon_horror_mode");
        ENTITY_SOUNDS.put("sprunki_mod:sprunki_horror_tunner", "sprunki_mod:sprunki_tunner_horror_mode");
        ENTITY_SOUNDS.put("sprunki_mod:sprunki_horror_mr_fun_computer", "sprunki_mod:sprunki_mr_fun_computer_horror_version");
        ENTITY_SOUNDS.put("sprunki_mod:sprunki_horror_wenda", "sprunki_mod:sprunki_wenda_horror_mode");
        ENTITY_SOUNDS.put("sprunki_mod:sprunki_horror_pinki", "sprunki_mod:sprunki_pinki_horror_version");
        ENTITY_SOUNDS.put("sprunki_mod:sprunki_horror_jevin", "sprunki_mod:sprunki_jevin_horror_mode");
        ENTITY_SOUNDS.put("sprunki_mod:sprunki_horror_mr_black", "sprunki_mod:sprunki_mr_black_horror_mode");
        
        // OC Sprunki entities (Original Characters)
        ENTITY_SOUNDS.put("sprunki_mod:oc_sprunki_mroona_and_wyrum", "sprunki_mod:oc_sprunki_mroona_normal_version");
        ENTITY_SOUNDS.put("sprunki_mod:oc_sprunki_mroona", "sprunki_mod:oc_sprunki_mroona_normal_version");
        ENTITY_SOUNDS.put("sprunki_mod:oc_sprunki_mard", "sprunki_mod:oc_sprunki_mard_normal_version");
        ENTITY_SOUNDS.put("sprunki_mod:oc_sprunki_bailey", "sprunki_mod:oc_sprunki_bailey_normal_version");
        ENTITY_SOUNDS.put("sprunki_mod:oc_sprunki_lily", "sprunki_mod:oc_sprunki_lily_normal_version");
        ENTITY_SOUNDS.put("sprunki_mod:oc_sprunki_aqua", "sprunki_mod:oc_sprunki_aqua_normal_version1");
        ENTITY_SOUNDS.put("sprunki_mod:oc_sprunki_tele", "sprunki_mod:oc_sprunki_tele_normal_version");
        ENTITY_SOUNDS.put("sprunki_mod:oc_sprunki_jama", "sprunki_mod:oc_sprunki_jama_normal_version");
        
        // OC Horror variants
        ENTITY_SOUNDS.put("sprunki_mod:oc_horror_sprunki_mroona", "sprunki_mod:oc_sprunki_mroona_horror_version");
        ENTITY_SOUNDS.put("sprunki_mod:oc_horror_sprunki_mard", "sprunki_mod:oc_sprunki_mard_horror_version");
        ENTITY_SOUNDS.put("sprunki_mod:oc_horror_sprunki_bailey", "sprunki_mod:oc_sprunki_bailey_horror_version");
        
        // Special entities
        ENTITY_SOUNDS.put("sprunki_mod:sprunki_pyramixed_tox", "sprunki_mod:sprunki_pyramixed_tox_normal");
        ENTITY_SOUNDS.put("sprunki_mod:sprunki_pyramixed_acid", "sprunki_mod:sprunki_pyramixed_acid_normal");
        ENTITY_SOUNDS.put("sprunki_mod:sprunki_oc_horror_black_sister_1", "sprunki_mod:sprunki_mr_black_horror_mode");
    }
    
    public static void registerAbilities() {
        LOGGER.info("Starting Sprunki ability registration...");
        
        int registered = 0;
        int failed = 0;
        
        for (Map.Entry<String, String> entry : ENTITY_SOUNDS.entrySet()) {
            String entityId = entry.getKey();
            String soundResource = entry.getValue();
            
            try {
                if (registerAbilityForEntity(entityId, soundResource)) {
                    registered++;
                } else {
                    failed++;
                }
            } catch (Exception e) {
                LOGGER.error("Unexpected error registering ability for {}: {}", entityId, e.getMessage());
                failed++;
            }
        }
        
        LOGGER.info("Sprunki Identity Addon registration complete: {} successful, {} failed", registered, failed);
    }
    
    @SuppressWarnings({"unchecked", "rawtypes"})
    private static boolean registerAbilityForEntity(String entityId, String soundResource) {
        try {
            // Try to get the entity type from registry
            EntityType<?> entityType = ForgeRegistries.ENTITY_TYPES.getValue(ResourceLocation.parse(entityId));
            
            if (entityType == null) {
                LOGGER.debug("Entity type not found in registry: {}", entityId);
                return false;
            }
            
            // Verify this is a living entity - skip this check for now as we'll assume all Sprunki entities are LivingEntity
            // We can add this check back later if needed
            
            // Create the ability instance
            SprunkiMusicAbility ability = new SprunkiMusicAbility<>(soundResource);
            
            // Register with Identity's AbilityRegistry using unchecked casts to bypass generic issues
            // We know all Sprunki entities are LivingEntity types, so this cast is safe
            EntityType<LivingEntity> livingEntityType = (EntityType<LivingEntity>) entityType;
            AbilityRegistry.register(livingEntityType, ability);
            
            LOGGER.debug("Successfully registered ability for {} with sound {}", entityId, soundResource);
            return true;
            
        } catch (Exception e) {
            LOGGER.error("Error processing entity {}: {}", entityId, e.getMessage());
            return false;
        }
    }
}