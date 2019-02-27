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
		
		public Hero (String n, String d, String i, int lvl, int hp, int sp, ArrayList<Effects> c, int hm, int ac)
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
		}
		
		public void attatchItem(Item item)
			{
				this.item = item; 
			}

		public int getLevel()
			{
				return level;
			}

		public void setLevel(int level)
			{
				this.level = level;
			}

		public int getHitpoints()
			{
				return hitpoints;
			}

		public void setHitpoints(int hitpoints)
			{
				this.hitpoints = hitpoints;
			}

		public int getSpeed()
			{
				return speed;
			}

		public void setSpeed(int speed)
			{
				this.speed = speed;
			}

		public ArrayList<Effects> getCardAbilities()
			{
				return cardAbilities;
			}

		public void setCardAbilities(ArrayList<Effects> cardAbilities)
			{
				this.cardAbilities = cardAbilities;
			}

		public int getToHitModifier()
			{
				return toHitModifier;
			}

		public void setToHitModifier(int toHitModifier)
			{
				this.toHitModifier = toHitModifier;
			}

		public int getArmorClass()
			{
				return armorClass;
			}

		public void setArmorClass(int armorClass)
			{
				this.armorClass = armorClass;
			}
	}
