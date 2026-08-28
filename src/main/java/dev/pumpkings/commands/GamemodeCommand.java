package dev.pumpkings.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.GameMode;

import org.jetbrains.annotations.NotNull;

public class GamemodeCommand implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String @NotNull [] args) {

        if (!(sender instanceof Player)) {
        sender.sendMessage("Solo jugadores pueden ejecutar esto.");
        return true;
        }

        if (sender instanceof Player player)

        if (player.hasPermission("meowtils.gamemode.creative")) {
            switch (label) {
                case "gmc":
                    player.setGameMode(GameMode.CREATIVE);
                    player.sendMessage(ChatColor.GREEN + "Cambiaste tu modo de juego a creativo.");
                    break;

                case "gms":
                    player.setGameMode(GameMode.SURVIVAL);
                    player.sendMessage(ChatColor.GREEN + "Cambiaste tu modo de juego a survival.");
                    break;

                case "gmsp":
                    player.setGameMode(GameMode.SPECTATOR);
                    player.sendMessage(ChatColor.GREEN + "Cambiaste tu modo de juego a espectador.");
                    break;
            }

        } else {
            player.sendMessage(ChatColor.RED + "¡No tienes permisos para esto!");
        }
        return true;

    }
}
