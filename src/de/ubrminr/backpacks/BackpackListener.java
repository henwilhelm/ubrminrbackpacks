package de.ubrminr.backpacks;

import org.bukkit.entity.Item;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.CraftItemEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.List;
import java.util.UUID;

/**
 * Created on 07.05.2016.
 */
public class BackpackListener implements Listener {

    @EventHandler
    public void onPlayerUse(PlayerInteractEvent event) {
        ItemStack item = event.getItem();

        if (!this.isBackpackStack(item)) {
            return;
        }

        event.setCancelled(true);
    }

    @EventHandler
    public void onCraft(CraftItemEvent event) {
        ItemStack item = event.getCurrentItem();

        if (!this.isBackpackStack(item)) {
            return;
        }

        ItemMeta meta = item.getItemMeta();
        List<String> lore = meta.getLore();
        String id = UUID.randomUUID().toString();
        lore.add("ID:" + id);
        meta.setLore(lore);
        item.setItemMeta(meta);
    }

    @EventHandler
    public void onDrop(PlayerDropItemEvent event) {
        if (this.isBackpack(event.getItemDrop())) {
            event.setCancelled(true);
        }
    }

    private boolean isBackpackStack(ItemStack item) {
        return item != null && item.hasItemMeta() && item.getItemMeta().hasLore() &&
                item.getItemMeta().getLore().contains(Main.META_DATA_LORE_IDENTIFIER);
    }

    private boolean isBackpack(Item item) {
        return this.isBackpackStack(item.getItemStack());
    }
}
