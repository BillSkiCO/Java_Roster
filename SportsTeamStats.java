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
 * class Name: SportsTeamStats
 * Description : This program will calculate the sports stats
 *    for the team
 *
 * Methods:
 * -------
 *        main()
 *        getTeamName()
 *        updateGameStts()
 *        toString()
 ***********************************************************/

public class SportsTeamStats
{
	// class constants

	// class variables
	private String teamName;                                // team name
	private String coach;                                   // coach name
	private float winningPct;                               // winning point
	private int wins;                                       // number of wins
	private int losses;                                     // number of losses
	private int tie;                                        // number of tie
	private int gamesPlayed;                                // number of games played
	private DecimalFormat df = new DecimalFormat("#0.000"); //instantiate DecimalFormat

	/**********************************************************
	 * Constructor Name : SportsTeamStats
	 * Description      : This constructor will initialized the
	 *    all the init variables to zero and team and coach name to
	 *    provided value from driver class
	 *
	 * BEGIN SportsTeamStats
	 *    Initialize all stats to 0
	 * END SportsTeamStats
	 ***********************************************************/

	public SportsTeamStats(String team, String coachName)
	{
		// local constants

		// locla variables

		/*****************************************************/

		// initliaze wins to zero
		wins = 0;

		// initliaze losses to zero
		losses = 0;

		// initliaze tie to zero
		tie = 0;

		// initliaze gamesPlayed to zero
		gamesPlayed = 0;

		// set team name
		teamName = team;

		// set coach name
		coach = coachName;

	} // end SportsTeamStats

	/**********************************************************
	 * Method Name : getTeamName
	 * Description : This method will return the team name
	 * BEGIN getTeamName
	 *    return teamName
	 * END getTeamName
	 ***********************************************************/

	public String getTeamName()
	{
		// local constants

		// locla variables

		/*****************************************************/

		// return team name
		return teamName;

	} // end getTeamName

	/**********************************************************
	 * Method Name : updateGameResults
	 * Description : This method will update the game stats
	 * BEGIN updateGameResult
	 *   SWITCH(enter option)
	 *      case '1' update wins
	 *      case '2' update loss
	 *      case '3' update ties
	 *   END Switch
	 *   Calculate winningPct
	 * END updateGameResult
	 ***********************************************************/

	public void updateGameResults(char option)
	{
		// local constants;
		final char WIN    = '1';
		final char LOSSES = '2';
		final char TIE    = '3';

		// local variables

		/*******************************************************/

		// count number of games entered
		gamesPlayed++;

		switch(option)
		{
			//char 1 for win
			case WIN:
			wins++;
			break;

			// char 2 for loss
			case LOSSES:
			losses++;
			break;

			//char 3 for tie
			case TIE:
			tie++;
			break;

			default: System.out.println("\tEnter either option 1 for win , 2 for loss or 3 for tie");
			gamesPlayed--;

		} // end switch

		// winning pct of the game, wins/ total game played
		winningPct = (float)wins/gamesPlayed;

	} //updateGameResults

	/**********************************************************
	 * Method Name : rosterTitle()
	 * Description : this method will return the formated class
	 *   data
	 * BEGIN rosterTitle()
	 *    format output string
	 *    return output
	 * END rosterTitle()
	 ***********************************************************/

	 public String[] rosterTitle()
	 {
	    // local constants
	    final int NUM_SPACES           = 27;
	    final int SCREEN_WIDTH         = 80;
	    final String GAMES_PLAYED      = "Games Played :  ";
	    final String RECORD            = "Record(W-L-T):  ";
	    final String WIN_PCT           = "Win Percent  :  ";
	    final int DATA_WIDTH           = 5;
	    final String GAMES_PLAYED_DATA = gamesPlayed + "";

	    // local variables
	    String output;                          // output string
	    String outputArray[] = new String[2];   // output array to store coach as well

        /*******************************************************/

		// Format output string
		output = "\n" +
		  		 Util.setLeft((SCREEN_WIDTH - getTeamName().length() - DATA_WIDTH)/2,
		  		               getTeamName() +"\n\n")+
		  		 Util.setLeft((SCREEN_WIDTH - GAMES_PLAYED.length() - DATA_WIDTH)/2,
		  		              (GAMES_PLAYED +
		  		               Util.setRight(DATA_WIDTH, GAMES_PLAYED_DATA)))+ "\n" +
		  		 Util.setLeft((SCREEN_WIDTH - RECORD.length() - DATA_WIDTH)/2,
		  		              (RECORD + wins + "-" + losses + "-" + tie))+ "\n" +
		  		 Util.setLeft((SCREEN_WIDTH - WIN_PCT.length() - DATA_WIDTH)/2,
		  		              (WIN_PCT + df.format(winningPct)))+ "\n\n";

		// Store title and stats
		outputArray[0] = output;

		// Store coach with formatting
		outputArray[1] = Util.setLeft((SCREEN_WIDTH -
		                               "Coach: ".concat(coach).length() - DATA_WIDTH)/2,
		                               "Coach: "+ coach)+ "\n";

		// return output
		return outputArray;

	  } // end rosterTitle

      /**********************************************************
	   * Method Name : rosterTitleNoTie()
	   * Description : this method will return the formated class
	   *   data
	   * BEGIN rosterTitleNoTie()
	   *    format output string
	   *    return output
	   * END rosterTitleNoTie()
	   ***********************************************************/
	  public String[] rosterTitleNoTie()
	  {
		  // local constants
		  final int NUM_SPACES           = 27;
		  final int SCREEN_WIDTH         = 80;
		  final int DATA_WIDTH           = 5;
		  final String GAMES_PLAYED      = "Games Played : ";
		  final String RECORD            = "Record(W-L)  : ";
		  final String WIN_PCT           = "Win Percent  : ";
		  final String GAMES_PLAYED_DATA = gamesPlayed + "";
		  final String WIN_LOSS          = wins + "-" + losses;

		  // local variables
		  String output;                          // output for title and stats
		  String outputArray[] = new String[2];   // output array to store coach as well

          /*******************************************************/

		  // format output string
		  output = "\n"+
		  		   Util.setLeft((SCREEN_WIDTH - getTeamName().length() - DATA_WIDTH)/2,
		  		                 getTeamName() +"\n\n")+
		  		   Util.setLeft((SCREEN_WIDTH - GAMES_PLAYED.length() - DATA_WIDTH)/2,
		  		                (GAMES_PLAYED + Util.setRight(DATA_WIDTH ,GAMES_PLAYED_DATA)))+ "\n" +
		  		   Util.setLeft((SCREEN_WIDTH - RECORD.length() - DATA_WIDTH)/2,
		  		                (RECORD + Util.setRight(DATA_WIDTH ,WIN_LOSS)))+ "\n" +
		  		   Util.setLeft((SCREEN_WIDTH - WIN_PCT.length() - DATA_WIDTH)/2,
		  		                (WIN_PCT + df.format(winningPct)))+ "\n\n";

		  // Store title and stats
		  outputArray[0] = output;

		  // Store coach with formatting
		  outputArray[1] = Util.setLeft((SCREEN_WIDTH -
		                                 "Coach: ".concat(coach).length() - DATA_WIDTH)/2,
		                                 "Coach: "+ coach)+ "\n";

		  // return output
		  return outputArray;

	  } // end toString

} // end SportsTeamStats