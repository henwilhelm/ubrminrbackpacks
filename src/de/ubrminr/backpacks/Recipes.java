package de.ubrminr.backpacks;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.meta.ItemMeta;

/**
 * Created by hendrik on 07.05.2016.
 */
public class Recipes {

    public void load() {
        this.createBackpackItemRecipe();
    }

    private void createBackpackItemRecipe() {
        int size = 9;
        ItemStack backpack = new ItemStack(Material.CHEST);

        ItemMeta meta = backpack.getItemMeta();
        // @todo chatcolor
        meta.setDisplayName("Backpack " + size);
        backpack.setItemMeta(meta);

        ShapedRecipe recipe = new ShapedRecipe(backpack);

        recipe.shape("LLL", "LCL", "LLL");
        recipe.setIngredient('L', Material.LEATHER);
        recipe.setIngredient('C', Material.CHEST);

        Bukkit.addRecipe(recipe);
    }
}
