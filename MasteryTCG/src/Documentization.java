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
			
/*#000*/		documentedEffects.add(new Attack("Fireball", "The Drunk Pyromancer conjures a fireball in his hand and blasts it to his enemies when he is drunk.", 2, 2, 4));
/*#001*/		documentedEffects.add(new Attack("Flamethrower", "The Drunk Pyromancer cups his mouth with his hand, and blows, creating a flamethrower.", 2, 2, 6));

/*#002*/		documentedEffects.add(new Attack("Katana", "The Sneaky Ninja uses this katana to silence his enemies for the Ninja Brotherhood.", 1, 1, 12));
/*#003*/		documentedEffects.add(new Attack("Shuriken", "When the Sneaky Ninja is too far away to reach his enemies, he distracts them witht these shurikens.", 2, 3, 6));
/*#004*/		documentedEffects.add(new Ability("Stealth", "The Sneaky Ninja stealthily sets traps.", "You can set a trap 1 square away from your new position.", 1));

/*#005*/		documentedEffects.add(new Attack("Acidic Margarita", "He shoots a line of acidic margarita to his enemies.", 2, 6, 4));

/*#006*/		documentedEffects.add(new Ability("Curse", "The Holy Hector detects an evil aura from far away. So he sends out a curse to that evil aura.","Any item cards the cursed enemy has doesn't have any effects for 1 turn. Can't use this attack again in a row.", 3));
/*#007*/		documentedEffects.add(new Attack("Holy Water", "The Holy Hector sprinkles his target with holy water.", "If target is an enemy, deal damage. Else, heal damage.", 1, 12, 4));

/*#008*/		documentedEffects.add(new Attack("Smite","With his wrathfulness, BDEN brings down the power from Above upon it's enemy.",1,11,6));
/*#009*/		documentedEffects.add(new Attack("Torture","His wrath is channeled from his body to his enemy's body, torturing them.",1,9,8));

/*#010*/		documentedEffects.add(new Attack("Intense Stare", "The Jacobian Council is well known for it's stare, because the stare can kill", 1, 10, 6));
/*#011*/		documentedEffects.add(new Attack("Plasma Blast", "The Jacobian Council shoots acidic plasma from their hands.", 2, 6, 10));
/*#012*/		documentedEffects.add(new Ability("Multi-Target", "Due to the Jacobian Council consisting of three persons, it can target multiple enemies.", "You can target two different Heroes in range."));

/*#013*/		documentedEffects.add(new Attack("Quill Attack", "In defense, to any attacks, King Dorain shoots quills from itself.", 2, 7, 4));
/*#014*/		documentedEffects.add(new Attack("Nibble", "When King Dorian is near an enemy, he nibbles on the enemy", 1, 4, 8));
/*#015*/		documentedEffects.add(new Ability("Rivalry", "Born as brothers, lived as friends, Dorian and Gizmo are now enemies.", "If the target is Gizmo, deal twice the damage."));

/*#016*/		documentedEffects.add(new Attack("Quill Attack", "In defense, to any attacks, Gizmo shoots quills from itself.", 2, 5, 6));
/*#017*/		documentedEffects.add(new Attack("Quill Stab", "When Gizmo is near an enemy, he stabs the enemy with one his quills.", 1, 9, 4));
/*#018*/		documentedEffects.add(new Ability("Rivalry", "Born as brothers, lived as friends, Dorian and Gizmo are now enemies.", "If the target is Dorian, deal twice the damage."));

/*#019*/		documentedEffects.add(new Attack("Legendary Smite", "Lil' Tony casts down a thunderous smite upon his enemies", "Deals damage to all Heroes 1 sqaure around the target as well. Can't use this attack 2 times in a row.", 1, 11, 8));
/*#020*/		documentedEffects.add(new Ability("Conditioning", "idk", "Everytime Lil' Tony misses an attack, his base AC drops by 4."));

/*#021*/		documentedEffects.add(new Attack("Fireball", "The Fire Dragon Slayer conjures a fireball in his hand and blasts it to his enemies.", 2, 2, 10));
/*#022*/		documentedEffects.add(new Attack("Flamethrower", "The Fire Dragon Slayer cups his mouth with his hand, and blows, creating a flamethrower.", 2, 2, 12));
/*#023*/		documentedEffects.add(new Ability("Fiery Presence", "As a proffesional at slaying fire dragons, you have a fiery presence.", "Any target that attacks this Hero gets Burned for two turns."));

/*#024*/		documentedEffects.add(new Attack("Laser Gun", "Its a laser gun...", 2, 10, 4));
/*#025*/		documentedEffects.add(new Attack("Stun Grenade", "Its a stun grenade...", 2, 7, 6));

/*#026*/		documentedEffects.add(new Attack("Domination", "idk ", 1, 5, 10));
/*#027*/		documentedEffects.add(new Attack("Crossbow", "idk", 2, 9, 6));


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
			ArrayList<Effects> jacob = new ArrayList<>();
			jacob.add(documentedEffects.get(10));
			jacob.add(documentedEffects.get(11));
			jacob.add(documentedEffects.get(12));
			documentedCards.add(new Hero("Jacobian Council", "The Supreme Council of the universe created by BDEN, whose main purpose is to kill the Holy Hector", "image.jpg", 7, 60, 1, jacob, 7, 15, 23));
			
/*#024*/		//	King Dorian
			ArrayList<Effects> dorian = new ArrayList<>();
			dorian.add(documentedEffects.get(13));
			dorian.add(documentedEffects.get(14));
			dorian.add(documentedEffects.get(15));
			documentedCards.add(new Hero("King Dorian", "Prohpesized by the Holy Hector, King Dorian is the only creature that can stand up to BDEN's wrath.", "kingDorian.png", 4, 36, 1, dorian, 4, 7, 24));
			
/*#025*/		// Gizmo
			ArrayList<Effects> gizmo = new ArrayList<>();
			gizmo.add(documentedEffects.get(16));
			gizmo.add(documentedEffects.get(17));
			gizmo.add(documentedEffects.get(18));
			documentedCards.add(new Hero("Gizmo", "Growing up in the shadows of King Dorian, he pledged BDEN to kill King Dorian", "gizmo.jpg", 4, 28, 2, gizmo, 4, 10, 25));
			
/*#026*/		// Legendary Lil' Tony
			ArrayList<Effects> tony = new ArrayList<>();
			tony.add(documentedEffects.get(19));
			tony.add(documentedEffects.get(20));
			documentedCards.add(new Hero("Legendary Lil' Tony", "Growing up as a normal kid, he became a legend by following the Holy Hector", "tony.jpg", 10, 80, 2, tony, 10, 20, 26));
			
/*#027*/		// Fire Dragon Slayer
			ArrayList<Effects> slayer = new ArrayList<>();
			slayer.add(documentedEffects.get(21));
			slayer.add(documentedEffects.get(22));
			slayer.add(documentedEffects.get(23));
			documentedCards.add(new Hero("Fire Dragon Slayer", "This is a professional at slaying fire dragons.", "slayer.jpg", 3, 25, 1, slayer, 3, 6, 27));
			
/*#028*/		// Mullen Meme Master
			ArrayList<Effects> mmm = new ArrayList<>();
			mmm.add(documentedEffects.get(24));
			mmm.add(documentedEffects.get(25));
			documentedCards.add(new Hero("Mullen Meme Master", "Captain of a spaceship, the Mullen Meme Master visits Earth for the first time.", "mullenMemeMaster.jpg", 5, 39, 2, mmm, 5, 10, 28));
			
/*#029*/		// Supreme Leader
			ArrayList<Effects> supreme = new ArrayList<>();
			supreme.add(documentedEffects.get(26));
			supreme.add(documentedEffects.get(27));
			documentedCards.add(new Hero("Supreme Leader", "This independent woman is the supreme leader of the whole entire world.", "supreme.jpg", 6, 44, 1, supreme, 6, 10, 29));
			
/*#030*/		// Eternal Ethan
			documentedCards.add(new Supporter("Eternal Ethan", "The Eternal Ethan was awaken from near death expeirences.", "Choose a damaged Hero on the board. Return that Hero to your hand, ad remove all effects and damage.", ".jpg", 30));
			
/*#031*/		// Shahanocorrect
			documentedCards.add(new Supporter("Shahanocorrect", "Always trying to correct people, the Shahanocorrect is pretty annoying.", "Look at the top five Cards of yours Opponent's Deck and change thier order.", ".jpg", 31));
			
/*#032*/		// Chemistry Nerd
			documentedCards.add(new Supporter("Chemistry Nerd", "Using his knowledge of chemistry, the Chemistry Nerd can create new Spells.", "Search through your Deck for 2 Spell Cards", ".jpg", 32));
			
/*#033*/		// The Information Dealer
			documentedCards.add(new Supporter("The Information Dealer", "The Information Dealer shares any illegal form of information.", "Search for 2 Trap Cards from the Discard Pile and shuffle them back into your Deck", ".jpg", 33));
			
/*#034*/		// The Seer
			documentedCards.add(new Supporter("The Seer", "With his magical powers, he can not only see the future, but change aspects of it.", "Look at the top of 3 Cards of your Opponent's Deck, and choose 1 to Discard.", ".jpg", 34));
			
/*#035*/		// Wilson the Wise
			documentedCards.add(new Supporter("Wilson the Wise", "Gifted with his wisdom, Wilson the Wise can always give you advice.", "Search for 2 Item Cards, both from either Discard Pile or your Deck", ".jpg", 35));
			
/*#036*/		// Super Caddie
			documentedCards.add(new Supporter("Super Caddie", "He hates all those divots, so he always tries to fix them.", "Choose any facedown Trap and discard it.", ".jpg", 36));
			
/*#037*/		// Overachiever
			documentedCards.add(new Supporter("Overachiever", "Always trying to do everything, the Overachiever can help you overachieve in anything.", "Search for 3 total Cards from either your Discard Pile or Deck. Discard the top card of your Opponent's Deck.", ".jpg", 37));
			
/*#038*/		// Spy Drone
			documentedCards.add(new Supporter("Spy Drone", "Used by the government, Spy Drones are used to mess up your life.", "The Opponent reveals their Hand. Choose one Card to discard.", ".jpg", 38));
			
/*#039*/		// Chewed Sweater Lace
			documentedCards.add(new Item("Chewed Sweater Lace", "Its a Chewed Sweater Lace that no one wants to see.", ".jpg", "Decreases any adjacent Heroes' To Hit Modifier by 1.", 39));
			
/*#040*/		// Windfury Ring
			documentedCards.add(new Item("Windfury Ring", "A ring made out of feather.", ".jpg", "This Hero can attack twice.", 40));
			
/*#041*/		// Marker Of Fire
			documentedCards.add(new Trap("Marker Of Fire", "This marker is capapble of setting of the Fire Alarm at the worst times possible.", ".jpg", "All Opponent's Heroes must move towards this Trap for two turns.", false, 41));
			
/*#042*/		// Chili Dog Of Destiny
			documentedCards.add(new Item("Chili Dog Of Destiny", "", ".jpg", "The attached Hero deals an extra die for damage.", 42));
			
/*#043*/		// Decapitating Frisbee
			documentedCards.add(new Item("Decapitating Frisbee", "This frisbee can be easily mistaken for a normal frisbee.", ".jpg", "You can throw this Item to another Hero that isnt holding an Item. Any Opponent Heroes in the throw take 3d6 damage.", 43));
			
/*#044*/		// Hair OF Steel
			documentedCards.add(new Item("Hair Of Steel", "The Drunk Pyromancer's secret gel can turn your hair into steel.", ".jpg", "The attached Hero increases it's base AC by 5.", 44));
			
/*#045*/		// Trap Disarmer
			documentedCards.add(new Item("Trap Disarmer", "Its a trap disarmer", ".jpg", "When the attached Hero lands on a trap, roll a d20 + to hit Modifier to disarm. You suceed if you roll a 10 or higher.", 45));
			
/*#046*/		// Apple Of Death
			documentedCards.add(new Trap("Apple Of Death", "Its a poisoned apple... but worse.", ".jpg", "The Hero that eats the Apple Of Death takes 2d12 damage.", true, 46));
			
/*#047*/		// Cursed Chair
			documentedCards.add(new Trap("Cursed Chair", "Its a cursed chair.", ".jpg", "The Hero that sits on this Trap can't move and takes 2d4 damage for 2 turns.", true, 47));
			
/*#048*/		// Hector's Distress Call
			documentedCards.add(new Trap("Hector's Distress Call", "The holy Hector rees", ".jpg", "All Heroes on the Players Arena must spend their turn moving towards this Trap.", false, 48));
			
/*#049*/		// The Bar
			documentedCards.add(new Environment("The Bar", "It's a typical bar.", ".jpg", "Each turn, you can look at the top 3 Cards of a Deck of your choice, and Discard 1 Card.", 49));
			
/*#050*/		// Careful Cone
			documentedCards.add(new Spell("Careful Cone", "This spell summons a Careful Cone onto any Trap.", ".jpg", "When you cast this, all of your Opponent's Trap Cards are Disarmed and Discarded.", 4, 50));
			
/*#051*/		// Jennifer The Jeffer
			documentedCards.add(new Supporter("Jennifer the Jeffer", "This is a strange creature. No one actually know what it is.", ".jpg", "Shuffle a Hero and Item from your Hand into your Deck, then search for a different Hero and Item.", 51));
			
/*#052*/		// The Thang
			documentedCards.add(new Card());
			
/*#053*/		// The Formal Thang
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
