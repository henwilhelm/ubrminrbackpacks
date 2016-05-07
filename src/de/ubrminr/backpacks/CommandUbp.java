package de.ubrminr.backpacks;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

/**
 * Created by hendrik on 07.05.2016.
 */
public class CommandUbp implements CommandExecutor {


    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;

            Inventory inventory = Bukkit.getServer().createInventory(player, 9);

            player.openInventory(inventory);
        }
        return true;
    }
}
