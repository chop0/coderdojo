package scarymonsters;

import net.canarymod.plugin.Plugin;
import net.canarymod.logger.Logman;
import net.canarymod.Canary;
import net.canarymod.commandsys.*;
import net.canarymod.chat.MessageReceiver;
import net.canarymod.api.entity.living.humanoid.Player;
import net.canarymod.api.entity.living.monster.Spider;
import net.canarymod.api.entity.living.monster.Creeper;
import net.canarymod.api.entity.living.animal.Pig;
import net.canarymod.api.entity.living.animal.Bat;
import net.canarymod.api.world.position.Location;
import net.canarymod.api.factory.EntityFactory;
import net.canarymod.api.factory.PotionFactory;
import net.canarymod.api.potion.PotionEffect;
import net.canarymod.api.potion.PotionEffectType;
import net.canarymod.api.entity.EntityType;
import net.canarymod.api.entity.living.EntityLiving;
import com.pragprog.ahmine.ez.EZPlugin;

public class ScaryMonsters extends EZPlugin {

  @Command(aliases = { "makehungry" },
            description = "/makehungry",
            permissions = { "" },
            toolTip = "/makehungry")
  public void bfcCommand(MessageReceiver caller, String[] args) {
    if (caller instanceof Player) {
	Player who = Canary.getServer().getPlayer(args[1]);
//	Canary.instance().getServer().broadcastMessage(args[1]);
	who.setHunger(0);
    }
}



  @Command(aliases = { "creeperjockey" },
            description = "Pure. Terror.",
            permissions = { "" },
            toolTip = "/creeperjockey")
  public void fcCommand(MessageReceiver caller, String[] args) {
    if (caller instanceof Player) { 
      Player me = (Player)caller;
      Location loc = me.getLocation();
      loc.setY(loc.getY());
      
      EntityFactory factory = Canary.factory().getEntityFactory();
      EntityLiving spider = factory.newEntityLiving(EntityType.SPIDER, loc);
      EntityLiving creep = factory.newEntityLiving(EntityType.CREEPER, loc);
      spider.spawn(creep);
    
//      PotionFactory potfact = Canary.factory().getPotionFactory();
//      PotionEffect potion = 
//	potfact.newPotionEffect(PotionEffectType.INVISIBILITY, 
//		Integer.MAX_VALUE, 1);
    //  spider.addPotionEffect(potion);
    }
}

  @Command(aliases = { "flyingpig" },
            description = "Lovely pigs.Ban factory farming!",
            permissions = { "" },
            toolTip = "/flyingpig")
  public void afcCommand(MessageReceiver caller, String[] args) {
    if (caller instanceof Player) {
      Player me = (Player)caller;
      Location loc = me.getLocation();
      loc.setY(loc.getY());

      EntityFactory factory = Canary.factory().getEntityFactory();
      EntityLiving bat = factory.newEntityLiving(EntityType.BAT, loc);
      EntityLiving pig = factory.newEntityLiving(EntityType.PIG, loc);
      bat.spawn(pig);

      PotionFactory potfact = Canary.factory().getPotionFactory();
      PotionEffect potion =
      potfact.newPotionEffect(PotionEffectType.INVISIBILITY,
              Integer.MAX_VALUE, 1);
      bat.addPotionEffect(potion);
    }

  }
}
