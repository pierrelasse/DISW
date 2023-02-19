package lol.pierrelasse.DISW;

import org.bukkit.World;
import org.bukkit.WorldBorder;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityDeathEvent;

public class Listeners implements Listener {

    // This method is getting called when an entity takes damage.
    @EventHandler
    public void onEntityDamage(final EntityDamageEvent e) {

        // Checks if the event-entity is a player.
        if (e.getEntity().getType() == EntityType.PLAYER) {
            // Shortcuts
            Entity p = e.getEntity();
            World world = p.getWorld();
            WorldBorder worldBorder = world.getWorldBorder();

            // Gets the WorldBorder's size.
            double initialSize = worldBorder.getSize();

            // Adds 1 block to the WorldBorder's size in 1 second.
            worldBorder.setSize(initialSize + 1, 1);

        }

    }


    // This method is getting called when an entity DIES. 💀
    @EventHandler
    public void onEntityDeath(final EntityDeathEvent e) {

        // Checks if the event-entity is a player.
        if (e.getEntity().getType() == EntityType.PLAYER) {
            // Shortcuts
            Entity p = e.getEntity();
            World world = p.getWorld();
            WorldBorder worldBorder = world.getWorldBorder();

            // Gets the WorldBorder's size.
            double initialSize = worldBorder.getSize();

            // Checks if the WorldBorder's size is more than 10.
            if (worldBorder.getSize() > 10) {
                // Removes 10 blocks from the WorldBorder's size in 5 seconds.
                worldBorder.setSize(initialSize - 10, 5);
            }

        }

    }

}
