package de.ubrminr.backpacks.store;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

import java.util.HashMap;

/**
 * Created by on 08.05.2016.
 */
public class InventoryStore {

    private HashMap<String, Inventory> inventories = new HashMap<>();

    private HashMap<String, String> opendInventories = new HashMap<>();

    public Inventory openInventory(Player player, String inventoryId) {
        if (!inventories.containsKey(inventoryId)) {
            inventories.put(inventoryId, Bukkit.getServer().createInventory(player, 9, inventoryId));
        }
        Inventory inventory = inventories.get(inventoryId);
        opendInventories.put(player.getUniqueId().toString(), inventoryId);
        return inventory;
    }

    public boolean hasOpenInventory(Player player) {
        return opendInventories.containsKey(player.getUniqueId().toString());
    }

    public void closeInventory(Player player) {
        String inventoryId = opendInventories.get(player.getUniqueId().toString());;
        opendInventories.remove(player.getUniqueId().toString(), inventoryId);
    }
}
