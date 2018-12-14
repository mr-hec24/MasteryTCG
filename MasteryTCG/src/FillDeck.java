
import java.awt.Image;
import java.util.*;

public class FillDeck
	{
		public static ArrayList<Card> fillDeck()
		{
			ArrayList<Card> deck = new ArrayList<Card>();
			ArrayList<Effects> effects = new ArrayList<Effects>();
			effects.add(new Attack("Fireball", "The Drunk Pyromancer conjures a fireball in his hand and blasts it to his enemies when he is drunk.", 2, 2, 4));
			effects.add(new Attack("Flamethrower", "The Drunk Pyromancer cups his mouth with his hand, and blows, creating a flamethrower.", 2, 2, 6));
			Image i;
			deck.add(new Hero("Drunk Pyromancer", "This pyromancer was drunk when he attepted to set fire to water. Surprisingly he succeeded.", i, 1, 10, 1, effects, 1, 4));
			effects.clear();
			
			effects.add(new Attack("Katana", "The Sneaky Ninja uses this katana to silence his enemies for the Ninja Brotherhood.", 1, 1, 12));
			effects.add(new Attack("Shuriken", "When the Sneaky Ninja is too far away to reach his enemies, he distracts them witht these shurikens.", 2, 3, 6));
			Image i;
			//Finish Sneaky ninja
			deck.add(new Hero("Sneaky Ninja", "This pyromancer was drunk when he attepted to set fire to water. Surprisingly he succeeded.", i, 1, 10, 1, effects, 1, 4));
			effects.clear();
			
			effects.add(new Attack("Fireball", "The Drunk Pyromancer conjures a fireball in his hand and blasts it to his enemies when he is drunk.", 2, 2, 4));
			effects.add(new Attack("Flamethrower", "The Drunk Pyromancer cups his mouth with his hand, and blows, creating a flamethrower.", 2, 2, 6));
			Image i;
			deck.add(new Hero("Drunk Pyromancer", "This pyromancer was drunk when he attepted to set fire to water. Surprisingly he succeeded.", i, 1, 10, 1, effects, 1, 4));
			effects.clear();
			
			effects.add(new Attack("Fireball", "The Drunk Pyromancer conjures a fireball in his hand and blasts it to his enemies when he is drunk.", 2, 2, 4));
			effects.add(new Attack("Flamethrower", "The Drunk Pyromancer cups his mouth with his hand, and blows, creating a flamethrower.", 2, 2, 6));
			Image i;
			deck.add(new Hero("Drunk Pyromancer", "This pyromancer was drunk when he attepted to set fire to water. Surprisingly he succeeded.", i, 1, 10, 1, effects, 1, 4));
			effects.clear();
			
			
			
			
			return deck;
		}
	}
