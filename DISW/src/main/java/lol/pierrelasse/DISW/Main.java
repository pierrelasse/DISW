package lol.pierrelasse.DISW;

import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin implements Listener {

    // This method is getting called when the Plugin gets enabled.
    @Override
    public void onEnable() {

        // Sets the executed method of the command /resetborder to the ResetBorderCommand class thing.
        this.getCommand("resetborder").setExecutor(new ResetBorderCommand());

        // Registers all listeners from the Listeners class.
        this.getServer().getPluginManager().registerEvents(new Listeners(), this);

    }

}