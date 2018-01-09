// methods adapted from College Board's Magpie Lab

public class Parser
{

	/**
	 * Search for one word in phrase. The search is not case
	 * sensitive. This method will check that the given goal
	 * is not a substring of a longer string (so, for
	 * example, "I know" does not contain "no").
	 *
	 * @param statement
	 *            the string to search
	 * @param goal
	 *            the string to search for
	 * @param startPos
	 *            the character of the string to begin the
	 *            search at
	 * @return the index of the first occurrence of goal in
	 *         statement or -1 if it's not found
	 */
	public static int findKeyword(String statement, String goal, int startPos)
	{
      String phrase = statement.trim().toLowerCase(); // phrase = "i want to earn a good grade in java"
		goal = goal.toLowerCase(); // i want to

		// The only change to incorporate the startPos is in the line below
		int position = phrase.indexOf(goal, startPos); // 0

		// Refinement--make sure the goal isn't part of a word
		while (position >= 0)
		{
			// Find the string of length 1 before and after the word
			String before = " ";
            String after = " ";
			
         if (position > 0)
			{
				before = phrase.substring(position - 1, position);
			}
			
			if (position + goal.length() < phrase.length())
			{
				after = phrase.substring(position + goal.length(), position + goal.length() + 1);
			}

			// If before and after aren't letters, we've found the word
			if (((before.compareTo("a") < 0) || (before.compareTo("z") > 0))
					&& ((after.compareTo("a") < 0) || (after.compareTo("z") > 0)))
			{
				return position;
			}

			// The last position didn't work, so let's find the next, if there is one.
			position = phrase.indexOf(goal, position + 1);
		}

		return -1;
	}
	
	/**
	 * Search for one word in phrase.  The search is not case 
	 * sensitive. This method will check that the given goal 
	 * is not a substring of a longer string (so, for 
	 * example, "I know" does not contain "no"). 
	 * The search begins at the very beginning of the string (index position 0.)
     * 
	 * @param statement 
       *           the string to search
	 * @param goal 
       *           the string to search for
	 * @return 
       *           the index of the first occurrence of goal in statement or -1 if it's not found
	 */
	public static int findKeyword(String statement, String goal)
	{
		return findKeyword(statement, goal, 0);
	}
   
}// end of Parser class