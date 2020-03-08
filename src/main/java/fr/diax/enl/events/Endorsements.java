package fr.diax.enl.events;

import fr.diax.enl.enlMain;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.configuration.file.YamlConfiguration;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;


import java.io.File;


public class Endorsements implements Listener {

    enlMain main;
    Player player;

    public Endorsements(enlMain min) {
        min = main;

    }

    YamlConfiguration enderchestcustom = YamlConfiguration.loadConfiguration(new File(main.getDataFolder(), player.getDisplayName() + ".yml"));

    @EventHandler
    public void onInteract(PlayerInteractEvent event) {

        Block b = event.getClickedBlock();
        Player p = event.getPlayer();
        Inventory inv = Bukkit.createInventory(p, 3 * 9, "§8EC §9- §6" + p.getName());


        if (b != null && b.getType().equals(Material.ENDER_CHEST)) {
            if (event.getAction().equals(Action.RIGHT_CLICK_BLOCK)) {

                event.setCancelled(true);
                p.sendMessage("bonjour");
                enderchestcustom.getList("Enderchest");

                p.openInventory(inv);


            }
        }
    }

    @EventHandler
    public void onInteract(InventoryCloseEvent event) {

        Player p = (Player) event.getPlayer();
        Inventory inv = p.getInventory();


        if (event.getView().getTitle().equals("§8EC §9- §6" + p.getName())) {
            enderchestcustom.set("Enderchest", inv.getSize());

        }


    }

    @EventHandler
    public void onBlockedInventory(InventoryClickEvent event) {
        Player p = (Player) event.getWhoClicked();

        if (event.getView().getTitle().equals("§8EC §9- §6" + p.getName()))  {
            event.setCancelled(true);
        }
    }


}
