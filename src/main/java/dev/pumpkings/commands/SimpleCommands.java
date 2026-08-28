package dev.pumpkings.commands;

import org.bukkit.*;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;

import java.util.stream.Stream;

public class SimpleCommands implements CommandExecutor{
        @Override
        public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String @NotNull [] args) {

            if (!(sender instanceof Player)) {
                sender.sendMessage("Solo jugadores pueden ejecutar esto.");
                return true;
            }

            Player player = (Player) sender;
            String cmdName = label.toLowerCase();

        if (!player.hasPermission("." + cmdName)) {
                player.sendMessage(ChatColor.RED + "No tienes permisos para usar este comando.");
                return true;
            }
            switch (cmdName) {
                        case "fly":
                            if (player.hasPermission("meowtils.fly")) {
                            if (player.getAllowFlight()) {
                            player.setAllowFlight(false);
                            player.sendMessage(ChatColor.RED + "Modo de vuelo desactivado.");
                            } else {
                                player.setAllowFlight(true);
                                player.sendMessage(ChatColor.GREEN + "Modo de vuelo activado.");
                            }
                            break;
                    }
                        case "god":
                            if (player.hasPermission("meowtils.god")) {
                            if  (player.isInvulnerable()) {
                            player.setInvulnerable(false);
                            player.sendMessage(ChatColor.RED + "Desactivaste el modo dios.");
                            player.playSound(player.getLocation(), Sound.BLOCK_NOTE_BLOCK_PLING, 1, 1);
                            } else {
                                player.setInvulnerable(true);
                                player.sendMessage(ChatColor.GREEN + "Activaste el modo dios.");
                                player.playSound(player.getLocation(), Sound.BLOCK_NOTE_BLOCK_BASS, 1, 1);
                            }
                            break;
                    }

                        case "hat":
                            if (player.hasPermission("meowtils.hat")) {
                            ItemStack hat = player.getInventory().getItemInMainHand();

                            if (hat.getType() == Material.AIR) {
                            player.sendMessage(ChatColor.RED + "Debes tener un objeto en la mano.");
                            break;
                            }

                            String itemName = hat.getType().name();
                             if (hat.hasItemMeta() && hat.getItemMeta().hasDisplayName()) {
                            itemName = hat.getItemMeta().getDisplayName();
                            }

                            player.getInventory().setHelmet(hat);
                            player.getInventory().setItemInMainHand(null);

                            player.sendMessage(ChatColor.GREEN + "Te equipaste " + itemName + ChatColor.GREEN + " de sombrero.");
                    } else {
                        player.sendMessage(ChatColor.RED + "No tienes permisos.");
                        }
                    break;
                    }

            return true;

        }
}
