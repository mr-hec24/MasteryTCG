import java.util.ArrayList;
import java.text.*;

public class TestRunner
	{
		public static void main(String[] args)
		{
			ArrayList<Card> deck = Documentization.documentCards();
			int cardId = 0;
			for (Card c : deck)
			{
				DecimalFormat number = new DecimalFormat("000");
				System.out.println(number.format(cardId));
				
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
