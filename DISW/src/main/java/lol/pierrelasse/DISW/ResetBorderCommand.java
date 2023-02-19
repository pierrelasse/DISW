package lol.pierrelasse.DISW;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ResetBorderCommand implements CommandExecutor {

    // This method is called when /resetborder is getting executed.
    public boolean onCommand(CommandSender cs, org.bukkit.command.Command command, String label, String[] args) {
        // Checks if the CommandSender is a player.
        if (cs instanceof Player) {
            // Shortcut
            final Player p = (Player)cs;

            // Loops all online players.
            for (Player p2 : Bukkit.getServer().getOnlinePlayers())
                // Teleports the looped player to the CommandSender if the looped player is not the CommandSender.
                if (p != p2) p2.teleport(p);

            // Shortcut
            Location loc = p.getLocation();
            // Sets the WorldBorder's center to the CommandSender's x & z coordinate.
            p.getWorld().getWorldBorder().setCenter(loc.getX(), loc.getZ());
            // Sets the WorldBorder's size to 1.
            p.getWorld().getWorldBorder().setSize(1);

            // Sends a success message.
            p.sendMessage("§aThe WorldBorder was reset!");

        // Sends an error if the CommandSender is not a player.
        } else {
            cs.sendMessage("§cOnly players can execute this command!");
        }

        return false;
    }

}