package dev.pumpkings;

import org.bukkit.plugin.java.JavaPlugin;
import dev.pumpkings.commands.GamemodeCommand;

public final class Meowtils extends JavaPlugin {

    @Override
    public void onEnable() {
        getLogger().info("[meowtils] Plugin enabled!");
        getCommand("gmc").setExecutor(new GamemodeCommand());

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
