/**********************************************************
 * Program Name    : Sports Team Stats
 * Authors         : William Golembieski, Brandon Willis, Narayan Neopane, Rayan Vakil
 * Date            : 4/11/2018
 * Course/Section  : 803
 * Program Description:  In class programming assignment for
 *    inputing and displaying sports team data
 **********************************************************/

import java.text.DecimalFormat;

/**********************************************************
 * Class Name     : BasketballTeamStats
 * Author         : William Golembieski
 * Date           : 4/11/2018
 * Course/Section : 803
 * Program Description:  This is an in class programing assigment
 *
 * Methods:
 * -------
 * BasketballTeamStats - Constructor
 * addToStats - adds scores to stats
 * toString   - returns the string representation of out stats
 **********************************************************/

public class BasketballTeamStats extends SportsTeamStats
{
	// Class constants

	// Class variables
	private int fieldGoals;
	private int freeThrows;
	private int totalPoints;
	private float ptsPerGame;
	private int numGames;

   /**********************************************************
	* Method Name    : BasketballTeamStats
	* Author         : William Golembieski
	* Date           : 4/11/2018
	* Course/Section : 803
	* Method Description:  This is an in class programing assigment
    *
	* BEGIN BasketballTeamStats
	*    Inherit from SportsTeamStats parent class
    *    Iinitalize all values to 0
	* END BasketballTeamStats
	**********************************************************/

	public BasketballTeamStats()
	{
		// Inherit from SportsTeamStats parent class
		super("BasketBallers", "Tim S");

		// Local constants

		// Local variables

		/*************************/

		// Iinitalize all values to 0
		fieldGoals = 0;
		freeThrows = 0;
		totalPoints = 0;
		ptsPerGame = 0.0f;
		numGames = 0;

	}// END BasketballTeamStats

   /**********************************************************
	* Method Name    : addToStats
	* Author         : William Golembieski
	* Date           : 4/11/2018
	* Course/Section : 803
	* Method Description:  This adds scores to our teams stats
    *
	* BEGIN addToStats
    *    Add total field goal points
    *    Add total free throw points
    *    Increment number of games played
    *    Compute total points and average points
    *    Return total points
	* END addToStats
	**********************************************************/

	public int addToStats(int fgs, int fts)
	{
		// Local constants

		// Local variables

		/*************************/

		// Add total field goal points
        fieldGoals += (fgs * 2);

        // Add total free throw points
        freeThrows += (fts * 1);

        // Increment number of games played
        numGames++;

        // Compute total points and average points
        totalPoints = fieldGoals + freeThrows;
        ptsPerGame = totalPoints / (float)numGames;

        // Return total points
        return totalPoints;

	}//END addToStats

   /**********************************************************
	* Method Name    : main
	* Author         : William Golembieski
	* Date           : 4/11/2018
	* Course/Section : 803
	* Program Description:  This is an in class programing assigment
    *
	* BEGIN toString
	*   Build outputString
	*   Return outputString
	* END toString
	**********************************************************/

	public String toString()
	{
		// Local constants
		final DecimalFormat ft   = new DecimalFormat("0.00");

		final String NUM_GAMES   = numGames + "";
		final String FGS_NUM     = fieldGoals + "";
		final String FTS_NUM     = freeThrows + "";
		final String PPTS        = ft.format(ptsPerGame);
		final int SCREEN_WIDTH   = 80;
		final int DATA_WIDTH     = 6;
		final String PLAYED      = "Played :";
		final String PLAYED_STND = Util.addPostSpace(DATA_WIDTH - NUM_GAMES.length(),
		                                             Util.setLeft((SCREEN_WIDTH -
		                                                           PLAYED.length()) / 2
		                                                           - (DATA_WIDTH / 2), PLAYED))
		                                             + numGames;
		final String FG          = "FGs    :";
		final String FG_STND     = Util.addPostSpace(DATA_WIDTH - FGS_NUM.length(),
		                                             Util.setLeft((SCREEN_WIDTH - FG.length()) / 2
		                                             - (DATA_WIDTH / 2), FG))
		                                             + fieldGoals;
		final String FT          = "FTs    :";
		final String FT_STND = Util.addPostSpace(DATA_WIDTH - FTS_NUM.length(),
		                                         Util.setLeft((SCREEN_WIDTH - FT.length()) / 2
		                                         - (DATA_WIDTH / 2), FT))
		                                         + freeThrows;
		final String PTS         = "PPG    :";
		final String PTS_STND    = Util.setLeft((SCREEN_WIDTH - PTS.length()) / 2
		                                         - (DATA_WIDTH / 2), PTS)
		                                         + Util.setRight(DATA_WIDTH, PPTS);

		final String PPG         = "Pts    :";
		final String PPG_STND    = Util.setLeft((SCREEN_WIDTH - PPG.length()) / 2
		                                         - (DATA_WIDTH / 2), PPG)
		                                         + Util.setRight(DATA_WIDTH, totalPoints + "");

		// Local variables
		String outputString = "";                       // Represents the roster title and stats
		String title[]      = super.rosterTitleNoTie(); // Array that contains title and coach

		/*************************/

		// Build outputString
		outputString += title[0];
		outputString += FG_STND + "\n";
		outputString += FT_STND + "\n";
		outputString += PPG_STND + "\n";
		outputString += PTS_STND + "\n\n";
		outputString += title[1] + "\n\n\n\n\n";

		// Return outputString
		return outputString;

	}//END toString

}//END BasketballTeamStats class
