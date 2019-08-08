/**********************************************************
 * Program Name    : Sports Team Stats
 * Authors         : William Golembieski, Brandon Willis, Narayan Neopane, Rayan Vakil
 * Date            : 4/11/2018
 * Course/Section  : 803
 * Program Description:  In class programming assignment for
 *    inputing and displaying sports team data
 **********************************************************/

//import statement
import java.text.NumberFormat;
import java.text.DecimalFormat;

/**********************************************************
 * Class Name     : BaseballTeamStats
 * Author         : Rayan Vakil
 * Date           : 4/16/2018
 * Course/Section : CSC264 - 801
 * Program Description:  Class for team stats
 *
 * Methods:
 * -------
 * BaseballTeamStats - constructor for BaseballTeamStats
 * updtateStats - update stats of team to new stats
 * toString - display all stats formatted
 * setLeft - used for centering
 **********************************************************/

public class BaseballTeamStats extends SportsTeamStats
{
    // Class constants

    // Class variables
	private int totalRuns    ; //total runs scored
	private int totalHits    ; //total hits when at bat
	private int totalAtBats  ; //total number of at bats
	private float teamAvg    ; //(totalHits/totalAtBats)
	private float runsPerGame; //number of runs per game
	private int numGames     ; //number of games played

	/**********************************************************
	* Method Name    : BaseballTeamStats
	* Author         : Rayan Vakil
	* Date           : 4/16/2018
	* Course/Section : CSC264 - 801
	* Program Description:  constructor
	*
	* BEGIN BaseballTeamStats
	*    Inherit from SportsTeamStats parent class
	*    Set to stats to 0
	* END BaseballTeamStats
	**********************************************************/

	public BaseballTeamStats()
	{
		// Inherit from SportsTeamStats parent class
		super("BaseBallers", "Kim M");

		//local constants

		//local variables

		/****************************/

		//set to stats to 0
		totalRuns    = 0;
		totalHits    = 0;
		totalAtBats  = 0;
		teamAvg      = 0f;
		runsPerGame  = 0f;
		numGames     = 0;

	}//END BaseballTeamStats

	/**********************************************************
	* Method Name    : updateStats
	* Author         : Rayan Vakil
	* Date           : 4/16/2018
	* Course/Section : CSC264 - 801
	* Program Description:  update stats of team
	*
	* BEGIN updateStats
	*	update runs
	*	update hits
	*	update atBats
	*	update team average
	*	increment games
	*	update runs per game
	* END updtateStats
	**********************************************************/

	public void updateStats(int runs, int hits, int atBats)
	{
		//local constants

		//local variables

		/****************************/

		//update runs
		totalRuns   += runs;

		//update hits
		totalHits   += hits;

		//update atBats
		totalAtBats += atBats;

		//update team average
		teamAvg     = (float)totalHits / totalAtBats;

		//increment games
		numGames++;

		//update runs per game
		runsPerGame = (float)totalRuns/numGames;

	}//end updateStats

	/**********************************************************
	* Method Name    : toString
	* Author         : Rayan Vakil
	* Date           : 4/16/2018
	* Course/Section : CSC264 - 801
	* Program Description:  display team stats formatted
	*
	* BEGIN toString
	*	Display all stats formatted
	* END toString
	**********************************************************/

	public String toString()
	{
		//local constants
		final int NUM_SPACES       = 29;
		final int DATA_WIDTH       = 5;
		final String TOTAL_RUNS    = totalRuns + "";
		final String TOTAL_HITS    = totalHits + "";
		final String TOTAL_AT_BATS = totalAtBats + "";

		//local variables
		NumberFormat format      = new DecimalFormat("#0.000");     //format for decimals
		String baseballTeamStats = "\n";                            //empty string
		String TEAM_AV           = format.format(teamAvg) + "";     //team average formatted
		String RUNS_P_GAME       = format.format(runsPerGame) + ""; //runs per game formatted
		String title[]           = super.rosterTitle();             //roster title + coach name

		/*********************************/

		// Display all stats formatted
		baseballTeamStats += title[0];
		baseballTeamStats += Util.setLeft(NUM_SPACES,"Total runs     : "
		                                  + Util.setRight(DATA_WIDTH, TOTAL_RUNS)) + "\n";
		baseballTeamStats += Util.setLeft(NUM_SPACES,"Total hits     : "
		                                  + Util.setRight(DATA_WIDTH, TOTAL_HITS)) + "\n";
		baseballTeamStats += Util.setLeft(NUM_SPACES,"Total atBats   : "
		                                  + Util.setRight(DATA_WIDTH, TOTAL_AT_BATS)) + "\n";
		baseballTeamStats += Util.setLeft(NUM_SPACES,"Team avg       : "
		                                  + Util.setRight(DATA_WIDTH, TEAM_AV)) + "\n";
		baseballTeamStats += Util.setLeft(NUM_SPACES,"Runs per game  : "
		                                  + Util.setRight(DATA_WIDTH, RUNS_P_GAME)) + "\n\n";
		baseballTeamStats += title[1];

		// Return baseballTeamStats String
		return baseballTeamStats;

	}//END toString

}//END BaseballTeamStats class