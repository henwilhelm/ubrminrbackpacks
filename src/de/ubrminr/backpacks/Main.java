package de.ubrminr.backpacks;

import de.ubrminr.backpacks.store.InventoryStore;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * Created on 07.05.2016.
 */
public class Main extends JavaPlugin {

    public static String META_DATA_LORE_IDENTIFIER = "Backpack";

    private InventoryStore inventoryStore;

    @Override
    public void onEnable() {
        inventoryStore = new InventoryStore();

        this.registerCommands();
        this.createRecipes();
        this.registerEventListeners();
    }

    @Override
    public void onDisable() {

    }

    private void registerCommands() {
        this.getCommand("ubp").setExecutor(new CommandUbp());
    }

    private void createRecipes() {
        Recipes r = new Recipes();
        r.load();
    }

    private void registerEventListeners() {
        getServer().getPluginManager().registerEvents(new BackpackListener(
                inventoryStore
        ), this);
    }
}
