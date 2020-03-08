package fr.diax.enl;

import fr.diax.enl.events.Endorsements;
import org.bukkit.plugin.java.JavaPlugin;

public class enlMain extends JavaPlugin {

    enlMain main;

    @Override
    public void onEnable() {

        getServer().getPluginManager().registerEvents(new Endorsements(this), this);
    
    }

    @Override
    public void onDisable() {

    }
}
