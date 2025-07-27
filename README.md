# Sprunki Identity Addon

A Minecraft Forge mod that bridges the Sprunki mod and Identity mod, allowing players to use Sprunki music abilities when morphed into Sprunki entities.

It also fixes a null exception in the Sprunki mod when trying to do multiplayer.

## Background

My son has been bit by Sprunki madness... He wanted a modpack with the Sprunki's and a morph mod. 
I put one together and whenever we tried to play together, regardless of who hosted, the other
person couldn't join without getting the following error:

```
Internal Exception:  java.lang.NullPointerException: Cannot invoke "net.minecraft.nbt.CompoundTag.m_128459_(string)" because "nbt"  is null
```

I dug around and found ```PlayerVariables.readNBT()``` was trying to cast the joining user's NBT data to CompoundTag without checking if it's null first.

While fixing that, my son realized he couldn't play the music when he morphed into a Sprunki, so the Forge event system was used to make that work.

## Requirements

- **Minecraft:** 1.20.1
- **Forge:** 47.4.0 
- **[Identity Fix (Morph)](https://www.curseforge.com/minecraft/mc-mods/identity-fix-morph):** 2.8.5 - by [gaboouu](https://www.curseforge.com/members/gaboouu/projects)
- **[Sprunki](https://www.curseforge.com/minecraft/mc-mods/sprunki):** 1.0.9 - by [kategirlsk](https://www.curseforge.com/members/kategirlsk/projects)

## Installation

1. Install Minecraft Forge 1.20.1 (version 47.4.0)
2. Download and install the Identity mod (2.8.5) 
3. Download and install the Sprunki mod (1.0.9)
4. Download the Sprunki Identity Addon JAR file
5. Place all three mod JARs in your `mods/` folder
6. Launch Minecraft with the Forge profile

## Usage

While morphed, press your configured ability key (default: R) to play that Sprunki's unique music

## Build Information

- **Version:** 1.0.0
- **Built for:** Minecraft 1.20.1, Forge 47.4.0
- **Build size:** ~17.5KB

## License

This mod is released under the Unlicense and is in the public domain. See the LICENSE file for details.