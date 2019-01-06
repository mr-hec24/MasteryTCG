import java.util.*;

public class FillDeck
	{
		
		public static ArrayList<Card> fillDeck()
		{
			ArrayList<Card> deck = new ArrayList<Card>();
			
			ArrayList<Effects> drunkPyro = new ArrayList<Effects>();
			drunkPyro.add(new Attack("Fireball", "The Drunk Pyromancer conjures a fireball in his hand and blasts it to his enemies when he is drunk.", 2, 2, 4));
			drunkPyro.add(new Attack("Flamethrower", "The Drunk Pyromancer cups his mouth with his hand, and blows, creating a flamethrower.", 2, 2, 6));
			deck.add(new Hero("Drunk Pyromancer", "This pyromancer was drunk when he attepted to set fire to water. Surprisingly he succeeded.", "DrunkPyro.png", 1, 10, 1, drunkPyro, 1, 4));
			
			// Sneaky Ninja
			ArrayList<Effects> sneakNin = new ArrayList<>();
			sneakNin.add(new Attack("Katana", "The Sneaky Ninja uses this katana to silence his enemies for the Ninja Brotherhood.", 1, 1, 12));
			sneakNin.add(new Attack("Shuriken", "When the Sneaky Ninja is too far away to reach his enemies, he distracts them witht these shurikens.", 2, 3, 6));
			sneakNin.add(new Ability("Stealth", "The Sneaky Ninja stealthily sets traps.", "You can set a trap 1 square away from your new position.", 1));
			deck.add(new Hero("Sneaky Ninja", "No one has ever seen the sneaky ninja in action. The only reason we know he exists is because he has a Facebook account.", "DrunkPyro.png", 2, 17, 2, sneakNin, 2, 6));
//			effects.clear();
			
			// Margarita Mixer
//			effects.add(new Attack("Acidic Stream", "If it hits, the target can't move next turn. You can't use this attack for 2 turns.", 2, 6, 4));
//			effects.add(new Attack("Flamethrower", "The Drunk Pyromancer cups his mouth with his hand, and blows, creating a flamethrower.", 2, 2, 6));
//			Image i;
//			deck.add(new Hero("Drunk Pyromancer", "This pyromancer was drunk when he attepted to set fire to water. Surprisingly he succeeded.", i, 1, 10, 1, effects, 1, 4));
//			effects.clear();
//			
//			effects.add(new Attack("Fireball", "The Drunk Pyromancer conjures a fireball in his hand and blasts it to his enemies when he is drunk.", 2, 2, 4));
//			effects.add(new Attack("Flamethrower", "The Drunk Pyromancer cups his mouth with his hand, and blows, creating a flamethrower.", 2, 2, 6));
//			Image i;
//			deck.add(new Hero("Drunk Pyromancer", "This pyromancer was drunk when he attepted to set fire to water. Surprisingly he succeeded.", i, 1, 10, 1, effects, 1, 4));
//			effects.clear();
			
			
			return deck;
		}
	}
