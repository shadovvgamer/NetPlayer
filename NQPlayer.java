package NQPlayer;

import org.bukkit.ChatColor;
import org.bukkit.World;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class NQPlayer
  extends JavaPlugin
  implements Listener
{
  @Override
public void onEnable()
  {
	  getServer().getPluginManager().registerEvents(this, this);
  }
  @EventHandler
  public void joinplayer(PlayerJoinEvent event)
  {
    event.setJoinMessage(ChatColor.GREEN + "+ " + ChatColor.DARK_GREEN + event.getPlayer().getName() + ChatColor.WHITE);
  }
  
  @EventHandler
  public void quitplayer(PlayerQuitEvent event)
  {
    event.setQuitMessage(ChatColor.RED + "- " + ChatColor.DARK_RED + event.getPlayer().getName() + ChatColor.WHITE);
  }
  @EventHandler
  public void onEntityDeath(EntityDeathEvent event)
  {
    Entity e = event.getEntity();
    if ((e instanceof Player))
    {
      Player p = (Player)e;
      World pWorld = p.getWorld();
      pWorld.strikeLightning(p.getLocation());
    }
}
}