import java.text.DecimalFormat;
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
/*CARD ID*/	
/*#000*/		// Drunk Pyromancer
			ArrayList<Effects> drunkPyro = new ArrayList<Effects>();
			drunkPyro.add(documentedEffects.get(0));
			drunkPyro.add(documentedEffects.get(1));
			documentedCards.add(new Hero("Drunk Pyromancer", "This pyromancer was drunk when he attempted to set fire to water. Surprisingly he succeeded.", "DrunkPyro.png", 1, 10, 1, drunkPyro, 1, 4, 0));
			
/*#001*/		// Sneaky Ninja
			ArrayList<Effects> sneakNin = new ArrayList<>();
			sneakNin.add(documentedEffects.get(2));
			sneakNin.add(documentedEffects.get(3));
			sneakNin.add(documentedEffects.get(4));
			documentedCards.add(new Hero("Sneaky Ninja", "No one has ever seen the sneaky ninja in action. The only reason we know he exists is because he has a Facebook account.", "", 2, 17, 2, sneakNin, 2, 6, 1));
			
/*#002*/		// Margarita Mixer
			ArrayList<Effects> margaritaMixer = new ArrayList<>();
			margaritaMixer.add(documentedEffects.get(5));
			documentedCards.add(new Hero("Margarita Mixer", "When this man was drunk on margarita's, he created a weapon that shoots acidic margarita.", "", 3, 24, 2, margaritaMixer, 3, 8, 2));
			
/*#003*/		// The Holy Hector
			ArrayList<Effects> holyHec = new ArrayList<>();
			holyHec.add(documentedEffects.get(6));
			holyHec.add(documentedEffects.get(7));
			documentedCards.add(new Hero("The Holy Hector", "Betraying the Almighty BDEN, the Holy Hector strives to save humanity from its sins.", "", 6, 50, 2, holyHec, 6, 13, 3));
			
/*#004*/		// BDEN
			ArrayList<Effects> bden = new ArrayList<>();
			bden.add(documentedEffects.get(8));
			bden.add(documentedEffects.get(9));
			documentedCards.add(new Hero("BDEN", "BDEN is the almighty overlord seeking to destroy humanity and it's evil actions.", "", 8, 70, 1, bden, 8, 18, 4));
	
/*#005*/		// The Researcher
			documentedCards.add(new Supporter("The Researcher", "This man researches JUST FOR FUN! So here he is to help you out on that essay you SHOULD be doing.", "Draw 3 cards. Then search your deck for any card you want and add it to your hand.", "", 5));
		
/*#006*/		// The Wanna-Be Kryptonian
			documentedCards.add(new Supporter("The Wanna-Be Kryptonian", "This guy loves DC so much, that he believes himself to be a Kryptonian, just like Superman.", "All your Heroes in the Players' Arena gain 2 more AC during this turn. They all deal 5 more damage next turn.", "", 6));
		
/*#007*/		// The Optimistic Sisters
			documentedCards.add(new Supporter("The Optimistic Sisters","Whenever in doubt and sadness, call these three sisters! They'll make you happy soon enough","Roll a d4. You may either darw cards two times the number you rolled, or draw cards equal to what you rolled.","", 7));
	
/*#008*/		// The Exploding Tennis Ball
			documentedCards.add(new Trap("The Exploding Tennis Ball", "This is an invention of the Drunk Pyromancer, created to kill off his enemies, anonymously.", "image.jpg", "The Hero that lands on this Trap takes 6 fire damage.", true, 8));
			
/*#009*/		//The Shoe Trap
			documentedCards.add(new Trap("The Shoe Trap", "This is another invention of the Margarita Mixer, who uses them when he's thirsty for blood", "image.jpg", "The Hero that lands on this Trap cannot move from this square for 2 rounds.", true, 9));
			
/*#010*/		// Cholesterol Club
			documentedCards.add(new Trap("Cholesterol Club", "This club dedicates its time to block out hallways in it's school, just like the cholesterol in your blood.", "image.jpg", "No Hero can land on or go over the square this Trap is on for 3 rounds.", false, 10));
	
/*#011*/		// Amulet Of Health
			documentedCards.add(new Item("Amulet Of Health", "This Amulet was discovered on the 1200 year old space captain, the Mullen Meme Master", "image.jpg", "The Host's base HP is increased by 5.", 11));
			
/*#012*/		// Dagger
			documentedCards.add(new Item("Dagger","This is an ordinary, pointy, dangerous dagger, confiscated from the Ninja Bretheren","image.jpg","The Host's base To Hit Modifier is incresed by 2.", 12));
			
/*#013*/		// Boots Of Speed
			documentedCards.add(new Item("Boots Of Speed","Several Olympians were caught cheating in races by wearing these speed enhancing boots.","image.jpg","The Host's speed is incresed by 1.", 13));
		
/*#014*/		// Ray Of Frost
			documentedCards.add(new Spell("Ray Of Frost", "You concentrate all your energy to your fingers. Finally, a ray of frost shoots from them.", "image.jpg", "All Heroes on the Players' Arena cannot move for 1 round. (Heroes from the Summoning Portal still move)", 2, 14));
			
/*#015*/		// Fog Of Misdirection
			documentedCards.add(new Spell("Fog Of Misdirection", "As you close your eyes, you extend your hands as a thick fog comes out of them, engulfing everyone around you.", "image.jpg", "For 3 rounds, when a Player wants to move a Hero, roll a d4 to determine where they go. (1=up, 2=down, 3=left, 4=right)", 3, 15));
			
/*#016*/		// Rain Of Arrows
			documentedCards.add(new Spell("Rain Of Arrows", "As you hear the thunder far off, you look up and notice that this storm, is not a regular one.", "image.jpg", "Deal 5 damage to all Heroes on the Players' Arena", 1, 16));
		
/*#017*/		// Socialist Revolution
			documentedCards.add(new Environment("Socialist Revolution", "In 2033, Zeke and his socialist party succeeded in turning America into a socialist country.", "image.jpg", "On your turn, you can use the opponent's Charged Energy to cast spells. Any Charged Energy you used will be Charging for the opponent's upcoming turn.", 17));
			
/*#018*/		// Communist Revolution
			documentedCards.add(new Environment("Communist Revolution","By 2033, Moises reestablished the USSr and is now under way of spreading Communism.","","During your turn, you may force the opponent to discard a card you choose without looking.", 18));
		
/*#019*/		// Basic Energy
			documentedCards.add(new Energy(1, 18));
			
/*#020*/		// Double Energy
			documentedCards.add(new Energy(2, 19));
			
/*#021*/		// Triple Energy
			documentedCards.add(new Energy(3, 20));

/*#022*/		// Healing Energy
			documentedCards.add(new Energy("Healing Energy", "This is healing energy. Very surprising...", "image.jpg", 1, "When you use this Energy to cast a Spell, a Hero of your choice heals 5 HP.", 21));

/*#023*/		// The Jacobian Council
			documentedCards.add(new Card());
			
/*#024*/		//	King Dorian
			documentedCards.add(new Card());
			
/*#025*/		// Gizmo
			documentedCards.add(new Card());
			
/*#026*/		// Legendary Lil' Tony
			documentedCards.add(new Card());
			
/*#027*/		//
			documentedCards.add(new Card());
			
/*#028*/		//
			documentedCards.add(new Card());
			
/*#029*/		//
			documentedCards.add(new Card());
			
/*#030*/		//
			documentedCards.add(new Card());
			
/*#031*/		//
			documentedCards.add(new Card());
			
/*#032*/		//
			documentedCards.add(new Card());
			
/*#033*/		//
			documentedCards.add(new Card());
			
			return documentedCards;
		}

		public static void printOutDocumentedInformation()
		{
			ArrayList<Card> deck = Documentization.documentCards();
			int cardId = 0;
			for (Card c : deck)
			{
				DecimalFormat number = new DecimalFormat("000");
				System.out.println("CARD ID #" + number.format(cardId));
				
				if (c instanceof Hero) // If The Card Is A Hero Card
					{
						ArrayList<Effects> effects = ((Hero)c).cardAbilities;
						
						// Prints out the basic info of a Hero Card
						System.out.printf("%-20s     Hit Points: %-2d      Armor Class: %-2d", ((Hero)c).name, ((Hero)c).hitpoints, ((Hero)c).armorClass);
						System.out.printf("\nLevel %-2d                 Speed: %d            To Hit Modifier: +%-2d \n", ((Hero)c).level, ((Hero)c).speed, ((Hero)c).toHitModifier);
						System.out.printf("%-100s\n \n", ((Hero)c).description);
						
						for (Effects e : effects)
							{
								// If The Effect Of A Hero Is An Attack, Print Out Attack Information
								if (e instanceof Attack)
									{
										System.out.printf("%-20s     Range: %-2d     Damage: %2d d %-2d \n", e.name, ((Attack)e).range, ((Attack)e).numberOfDice, ((Attack)e).typeOfDice);
										System.out.printf("%-100s\n\n", e.description);
									}
								// Else, Print Out Ability Information
								else
									{
										if (((Ability)e).typeOfDice == 0 && ((Ability)e).range == 0)
										{
											System.out.println(e.name);
											System.out.println(((Ability)e).effect);
											
										}
										else if (((Ability)e).typeOfDice == 0)
										{
											System.out.printf("%-20s     Range: %-2d \n",e.name, ((Ability)e).range);
											System.out.println(((Ability)e).effect + "\n");
										}
										else
										{
											System.out.printf("%-20s     Range: %-2d     Damage %2d d %-2d \n",e.name, ((Ability)e).range, ((Ability)e).numberOfDice, ((Ability)e).typeOfDice);
											System.out.println(((Ability)e).effect + "\n");
										}
									}
							}

						System.out.println("__________________________________________________________________________________________________________________________________\n");					
						System.out.println(" ");
					}
				
				else if (c instanceof Supporter) // If The Card Is A Supporter Card
					{
						System.out.printf("%-20s \n", c.name);
						System.out.printf("%-100s \n", c.description);
						System.out.printf("%-100s \n", ((Supporter)c).effect);
						System.out.println("\n__________________________________________________________________________________________________________________________________\n");					
						System.out.println(" ");
					}
				
				else if (c instanceof Item) // If The Card Is An Item Card
					{
						System.out.printf("%-20s \n", c.name);
						System.out.printf("%-100s \n", c.description);
						System.out.printf("%-100s \n", ((Item)c).effect);
						System.out.println("\n__________________________________________________________________________________________________________________________________\n");					
						System.out.println(" ");
					}
				
				else if (c instanceof Spell) // If The Card Is A Spell Card
					{
						System.out.printf("%-20s          Cost: %-2dEnergy\n", c.name, ((Spell)c).cost);
						System.out.printf("%-100s \n", c.description);
						System.out.printf("%-100s \n", ((Spell)c).effect);
						System.out.println("\n__________________________________________________________________________________________________________________________________\n");					
						System.out.println(" ");
					}
				
				else if (c instanceof Trap) // If The Card Is A Trap Card
					{
						System.out.printf("%-20s     " + "" + "\n", c.name);
						System.out.printf("%-100s \n", c.description);
						System.out.printf("%-100s \n", ((Trap)c).effect);
						System.out.println("\n__________________________________________________________________________________________________________________________________\n");					
						System.out.println(" ");
					}
				
				else if (c instanceof Energy) // If The Card Is A Energy Card
					{
						
					}
				
				else
					{
						
					}
				
				cardId++;
			}
		}
	}
