import java.util.ArrayList;
import java.awt.Image;

public class Hero extends Card
	{
		protected int level;
		protected int hitpoints;
		protected int speed;
		protected ArrayList<Effects> cardAbilities;
		protected int toHitModifier;
		protected int armorClass;
		protected Item item;

		protected int baseHitpoints;
		protected int baseSpeed;
		protected int baseToHitModifier;
		protected int baseArmorClass;
		
		
		
		public Hero (String n, String d, String i, int lvl, int hp, int sp, ArrayList<Effects> c, int hm, int ac, int id)
		{
			name = n;
			description = d;
			image = i;
			level = lvl;
			hitpoints = hp;
			speed = sp;
			cardAbilities = c;
			toHitModifier = hm; 
			armorClass = ac;
			item = null;
			cardId = id;

			baseHitpoints = hitpoints;
			baseSpeed = speed;
			baseToHitModifier = toHitModifier;
			baseArmorClass = armorClass;
			
		}
		
		public Hero(Card c)
		{
			name = ((Hero)c).name;
			description = ((Hero)c).description;
			image = ((Hero)c).image;
			level = ((Hero)c).level;
			hitpoints = ((Hero)c).hitpoints;
			speed = ((Hero)c).speed;
			cardAbilities = ((Hero)c).cardAbilities;
			toHitModifier = ((Hero)c).toHitModifier; 
			armorClass = ((Hero)c).armorClass;
			item = ((Hero)c).item;
			cardId = ((Hero)c).cardId;

			baseHitpoints = hitpoints;
			baseSpeed = speed;
			baseToHitModifier = toHitModifier;
			baseArmorClass = armorClass;
		}

		public void attatchItem(Item item)
			{
				this.item = item;
				item.host = this;
			}
		

	}
