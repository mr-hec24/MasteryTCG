import java.util.ArrayList;

public class Turn
	{
		protected ArrayList<Condition> conditions = new ArrayList<Condition>();
		
		public void nextTurn()
		{
			for (int i = 0; i < conditions.size(); i++)
				{
					conditions.get(i).duration -= 1;
					if (conditions.get(i).duration == 0)
						{
							conditions.remove(i);
							i--;
						}
				}
		}
		
//		public void goThroughTurn()
//		{
//			for (Condition c: conditions)
//				{
//					// Basically going to call a method from a different class to put these conditions into effect
//				}
//		}
	}
