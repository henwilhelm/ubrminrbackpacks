package de.ubrminr.backpacks;

import org.bukkit.plugin.java.JavaPlugin;

/**
 * Created by hendrik on 07.05.2016.
 */
public class Main extends JavaPlugin {

    @Override
    public void onEnable() {
        this.registerCommands();
        this.createRecipes();
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
}
