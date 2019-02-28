import java.util.*;

public class Documentization
	{
		
		public static ArrayList<Effects> documentEffects()
		{
			ArrayList<Effects> documentedEffects = new ArrayList<Effects>();
/*			
  			documentedEffects.add(new Attack(Name, Description, Range, NumberOfDice, TypeOfDice));					// Attack that does NOT have an effect
			documentedEffects.add(new Attack(Name, Description, Effect, Range, NumberOfDice, TypeOfDice));			// Attack that HAS an effect
			documentedEffects.add(new Ability(Name, Description, Effect));											// Non-rolling abilities
			documentedEffects.add(new Ability(Name, Description, Effect, Range));									// Non-rolling ranged abilities
			documentedEffects.add(new Ability(Name, Description, Effect, Range, NumberOfDice, TypeOfDice));			// Ranged rolling ability
			documentedEffects.add(new Ability(Name, Description, Effect, NumberOfDice, TypeOfDice));				// Non-Ranged rolling ability 			
*/
/*EFFECT ID*/
/*#000*/	documentedEffects.add(new Attack("Fireball", "The Drunk Pyromancer conjures a fireball in his hand and blasts it to his enemies when he is drunk.", 2, 2, 4));
/*#001*/	documentedEffects.add(new Attack("Flamethrower", "The Drunk Pyromancer cups his mouth with his hand, and blows, creating a flamethrower.", 2, 2, 6));
/*#002*/	documentedEffects.add(new Attack("Katana", "The Sneaky Ninja uses this katana to silence his enemies for the Ninja Brotherhood.", 1, 1, 12));
/*#003*/	documentedEffects.add(new Attack("Shuriken", "When the Sneaky Ninja is too far away to reach his enemies, he distracts them witht these shurikens.", 2, 3, 6));
/*#004*/	documentedEffects.add(new Ability("Stealth", "The Sneaky Ninja stealthily sets traps.", "You can set a trap 1 square away from your new position.", 1));
/*#005*/	documentedEffects.add(new Attack("Acidic Margarita", "He shoots a line of acidic margarita to his enemies.", 2, 6, 4));
/*#006*/	documentedEffects.add(new Ability("Curse", "The Holy Hector detects an evil aura from far away. So he sends out a curse to that evil aura.","Any item cards the cursed enemy has doesn't have any effects for 1 turn. Can't use this attack again in a row.", 3));
/*#007*/	documentedEffects.add(new Attack("Holy Water", "The Holy Hector sprinkles his target with holy water.", "If target is an enemy, deal damage. Else, heal damage.", 1, 12, 4));
/*#008*/	documentedEffects.add(new Attack("Smite","With his wrathfulness, BDEN brings down the power from Above upon it's enemy.",1,11,6));
/*#009*/	documentedEffects.add(new Attack("Torture","His wrath is channeled from his body to his enemy's body, torturing them.",1,9,8));
			
			return documentedEffects;
		}
		
		public static ArrayList<Card> documentCards()
		{
			final ArrayList<Effects> documentedEffects = documentEffects();
			final ArrayList<Card> documentedCards = new ArrayList<Card>();
			
			// Hero Cards
			{
				// Drunk Pyromancer
				ArrayList<Effects> drunkPyro = new ArrayList<Effects>();
				drunkPyro.add(documentedEffects.get(0));
				drunkPyro.add(documentedEffects.get(1));
				documentedCards.add(new Hero("Drunk Pyromancer", "This pyromancer was drunk when he attempted to set fire to water. Surprisingly he succeeded.", "DrunkPyro.png", 1, 10, 1, drunkPyro, 1, 4));
				
				// Sneaky Ninja
				ArrayList<Effects> sneakNin = new ArrayList<>();
				sneakNin.add(documentedEffects.get(2));
				sneakNin.add(documentedEffects.get(3));
				sneakNin.add(documentedEffects.get(4));
				documentedCards.add(new Hero("Sneaky Ninja", "No one has ever seen the sneaky ninja in action. The only reason we know he exists is because he has a Facebook account.", "", 2, 17, 2, sneakNin, 2, 6));
				
				// Margarita Mixer
				ArrayList<Effects> margaritaMixer = new ArrayList<>();
				margaritaMixer.add(documentedEffects.get(5));
				documentedCards.add(new Hero("Margarita Mixer", "When this man was drunk on margarita's, he created a weapon that shoots acidic margarita.", "", 3, 24, 2, margaritaMixer, 3, 8));
				
				// The Holy Hector
				ArrayList<Effects> holyHec = new ArrayList<>();
				holyHec.add(documentedEffects.get(6));
				holyHec.add(documentedEffects.get(7));
				documentedCards.add(new Hero("The Holy Hector", "Betraying the Almighty BDEN, the Holy Hector strives to save humanity from its sins.", "", 6, 50, 2, holyHec, 6, 13));
				
				// BDEN
				ArrayList<Effects> bden = new ArrayList<>();
				bden.add(documentedEffects.get(8));
				bden.add(documentedEffects.get(9));
				documentedCards.add(new Hero("BDEN", "BDEN is the almighty overlord seeking to destroy humanity and it's evil actions.", "", 8, 70, 1, bden, 8, 18));
			}
				
			// Supporter Cards
			{
				// The Researcher
				documentedCards.add(new Supporter("The Researcher", "This man researches JUST FOR FUN! So here he is to help you out on that essay you SHOULD be doing.", "Draw 3 cards. Then search your deck for any card you want and add it to your hand.", ""));
			
				// The Wanna-Be Kryptonian
				documentedCards.add(new Supporter("The Wanna-Be Kryptonian", "This guy loves DC so much, that he believes himself to be a Kryptonian, just like Superman.", "All your Heroes in the Players' Arena gain 2 more AC during this turn. They all deal 5 more damage next turn.", ""));
			
				// The Optimistic Sisters
				documentedCards.add(new Supporter("The Optimistic Sisters","Whenever in doubt and sadness, call these three sisters! They'll make you happy soon enough","Roll a d4. You may either darw cards two times the number you rolled, or draw cards equal to what you rolled.",""));
			}
			
			// Trap Cards
			{
				// The Exploding Tennis Ball
				documentedCards.add(new Trap("The Exploding Tennis Ball", "This is an invention of the Drunk Pyromancer, created to kill off his enemies, anonymously.", "image.jpg", "The Hero that lands on this Trap takes 6 fire damage.", true));
				
				//The Shoe Trap
				documentedCards.add(new Trap("The Shoes Trap", "This is another invention of the Margarita Mixer, who uses them when he's thirsty for blood", "image.jpg", "The Hero that lands on this Trap cannot move from this square for 2 rounds.", true));
				
				// Cholesterol Club
				documentedCards.add(new Trap("Cholesterol Club", "This club dedicates its time to block out hallways in it's school, just like the cholesterol in your blood.", "image.jpg", "No Hero can land on or go over the square this Trap is on for 3 rounds.", false));
			}
			
			// Item Cards
			{
				// Amulet Of Health
				documentedCards.add(new Item("Amulet Of Health", "This Amulet was discovered on the 1200 year old space captain, the Mullen Meme Master", "image.jpg", "The Host's base HP is increased by 5."));
				
				// Dagger
				documentedCards.add(new Item("Dagger","This is an ordinary, pointy, dangerous dagger, confiscated from the Ninja Bretheren","image.jpg","The Host's base To Hit Modifier is incresed by 2."));
				
				// Boots Of Speed
				documentedCards.add(new Item("Boots Of Speed","Several Olympians were caught cheating in races by wearing these speed enhancing boots.","image.jpg","The Host's speed is incresed by 1."));
			}
			
			// Spell Cards
			{
				// Ray Of Frost
				documentedCards.add(new Spell("Ray Of Frost", "You concentrate all your energy to your fingers. Finally, a ray of frost shoots from them.", "image.jpg", "All Heroes on the Players' Arena cannot move for 1 round. (Heroes from the Summoning Portal still move)", 2));
				
				// Fog Of Misdirection
				documentedCards.add(new Spell("Fog Of Misdirection", "As you close your eyes, you extend your hands as a thick fog comes out of them, engulfing everyone around you.", "image.jpg", "For 3 rounds, when a Player wants to move a Hero, roll a d4 to determine where they go. (1=up, 2=down, 3=left, 4=right)", 3));
				
				// Rain Of Arrows
				documentedCards.add(new Spell("Rain Of Arrows", "As you hear the thunder far off, you look up and notice that this storm, is not a regular one.", "image.jpg", "Deal 5 damage to all Heroes on the Players' Arena", 1));
			}
			
			return documentedCards;
		}
	}
