package com.songoda.ultimateclaims.claim;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.util.List;

public class PowerCell {

    private Location location;

    private Inventory inventory;

    public PowerCell() {
        this.inventory = Bukkit.createInventory(null, 54, "test");
    }

    public PowerCell(List<ItemStack> items) {
        this.inventory = Bukkit.createInventory(null, 54, "test");
        int i = 10;
        for (ItemStack item : items) {
            inventory.setItem(i++, item);
        }
    }

    public Inventory getInventory() {
        return inventory;
    }

    public Location getLocation() {
        return location.clone();
    }

    public boolean hasLocation() {
        return location != null;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public void destroy() {
        for (ItemStack item : inventory.getContents()) {
            if (item == null) continue;
            location.getWorld().dropItemNaturally(location, item);
        }
        inventory.clear();
        location = null;
    }
}
