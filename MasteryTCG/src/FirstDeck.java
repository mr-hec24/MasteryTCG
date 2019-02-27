import java.util.*;

public class FirstDeck
	{
		
		public static ArrayList<Card> fillDeck()
		{
			ArrayList<Card> deck = new ArrayList<Card>();
			
			// Hero Cards
			{
				// Drunk Pyromancer
				ArrayList<Effects> drunkPyro = new ArrayList<Effects>();
				drunkPyro.add(new Attack("Fireball", "The Drunk Pyromancer conjures a fireball in his hand and blasts it to his enemies when he is drunk.", 2, 2, 4));
				drunkPyro.add(new Attack("Flamethrower", "The Drunk Pyromancer cups his mouth with his hand, and blows, creating a flamethrower.", 2, 2, 6));
				deck.add(new Hero("Drunk Pyromancer", "This pyromancer was drunk when he attempted to set fire to water. Surprisingly he succeeded.", "DrunkPyro.png", 1, 10, 1, drunkPyro, 1, 4));
				
				// Sneaky Ninja
				ArrayList<Effects> sneakNin = new ArrayList<>();
				sneakNin.add(new Attack("Katana", "The Sneaky Ninja uses this katana to silence his enemies for the Ninja Brotherhood.", 1, 1, 12));
				sneakNin.add(new Attack("Shuriken", "When the Sneaky Ninja is too far away to reach his enemies, he distracts them witht these shurikens.", 2, 3, 6));
				sneakNin.add(new Ability("Stealth", "The Sneaky Ninja stealthily sets traps.", "You can set a trap 1 square away from your new position.", 1));
				deck.add(new Hero("Sneaky Ninja", "No one has ever seen the sneaky ninja in action. The only reason we know he exists is because he has a Facebook account.", "", 2, 17, 2, sneakNin, 2, 6));
				
				// Margarita Mixer
				ArrayList<Effects> margaritaMixer = new ArrayList<>();
				margaritaMixer.add(new Attack("Acidic Margarita", "He shoots a line of acidic margarita to his enemies.", 2, 6, 4));
				deck.add(new Hero("Margarita MIxer", "When this man was drunk on margarita's, he created a weapon that shoots acidic margarita.", "", 3, 24, 2, margaritaMixer, 3, 8));
				
				// The Holy Hector
				ArrayList<Effects> holyHec = new ArrayList<>();
				holyHec.add(new Ability("Curse", "The Holy Hector detects an evil aura from far away. So he sends out a curse to that evil aura.","Any item cards the cursed enemy has doesn't have any effects for 1 turn. Can't use this attack again.", 3));
				holyHec.add(new Attack("Holy Water", "The Holy Hector sprinkles his target with holy water.", "If target is an enemy, deal damage. Else, heal damage.", 1, 12, 4));
				deck.add(new Hero("The Holy Hector", "Betraying the Almighty BDEN, the Holy Hector strives to save humanity from its sins.", "", 6, 50, 2, holyHec, 6, 13));
				
				// BDEN
				ArrayList<Effects> bden = new ArrayList<>();
				bden.add(new Attack("Smite","With his wrathfulness, BDEN brings down the power from Above upon it's enemy.",1,11,6));
				bden.add(new Attack("Torture","His wrath is channeled from his body to his enemy's body, torturing them.",1,9,8));
				deck.add(new Hero("BDEN", "BDEN is the almighty overlord seeking to destroy humanity and it's evil actions.", "", 8, 70, 1, bden, 8, 18));
			}
				
			// Supporter Cards
			{
				// The Researcher
				deck.add(new Supporter("The Researcher", "This man researches JUST FOR FUN! So here he is to help you out on that essay you SHOULD be doing.", "Draw 3 cards. Then search your deck for any card you want and add it to your hand.", ""));
			
				// The Wanna-Be Kryptonian
				deck.add(new Supporter("The Wanna-Be Kryptonian", "This guy loves DC so much, that he believes himself to be a Kryptonian, just like Superman.", "All your Heroes in the Players' Arena gain 2 more AC during this turn. They all deal 5 more damage next turn.", ""));
			
				// The Optimistic Sisters
				deck.add(new Supporter("The Optimistic Sisters","","",""));
			}
			
			// Trap Cards
			{
				// The Exploding Tennis Ball
				deck.add(new Trap("The Exploding Tennis Ball", "This is an invention of the Drunk Pyromancer, created to kill off his enemies, anonymously.", "image.jpg", "The Hero that lands on this Trap takes 6 fire damage.", true));
				
				//The Shoe Trap
				deck.add(new Trap("The Shoes Trap", "This is another invention of the Margarita Mixer, who uses them when he's thirsty for blood", "image.jpg", "The Hero that lands on this Trap cannot move from this square for 2 rounds.", true));
				
				// Cholesterol Club
				deck.add(new Trap("Cholesterol Club", "This club dedicates its time to block out hallways in it's school, just like the cholesterol in your blood.", "image.jpg", "No Hero can land on or go over the square this Trap is on for 3 rounds.", false));
			}
			
			// Item Cards
			{
				// Amulet Of Health
				deck.add(new Item("Amulet Of Health", "This Amulet was discovered on the 1200 year old space captain, the Mullen Meme Master", "image.jpg", "The Host's base HP is increased by 5."));
				
				// Dagger
				deck.add(new Item("Dagger","This is an ordinary, pointy, dangerous dagger, confiscated from the Ninja Bretheren","image.jpg","The Host's base To Hit Modifier is incresed by 2."));
				
				// Boots Of Speed
				deck.add(new Item("Boots Of Speed","Several Olympians were caught cheating in races by wearing these speed enhancing boots.","image.jpg","The Host's speed is incresed by 1."));
			}
			
			// Spell Cards
			{
				// Ray Of Frost
				deck.add(new Spell("Ray Of Frost", "You concentrate all your energy to your fingers. Finally, a ray of frost shoots from them.", "image.jpg", "All Heroes on the Players' Arena cannot move for 1 round. (Heroes from the Summoning Portal still move)", 2));
				
				// Fog Of Misdirection
				deck.add(new Spell("Fog Of Misdirection", "As you close your eyes, you extend your hands as a thick fog comes out of them, engulfing everyone around you.", "image.jpg", "For 3 rounds, when a Player wants to move a Hero, roll a d4 to determine where they go. (1=up, 2=down, 3=left, 4=right)", 3));
				
				// Rain Of Arrows
				deck.add(new Spell("Rain Of Arrows", "As you hear the thunder far off, you look up and notice that this storm, is not a regular one.", "image.jpg", "Deal 5 damage to all Heroes on the Players' Arena", 1));
			}
			
			return deck;
		}
	}
