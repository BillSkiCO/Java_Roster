/**********************************************************
 * Program Name    : Sports Team Stats
 * Authors         : William Golembieski, Brandon Willis, Narayan Neopane, Rayan Vakil
 * Date            : 4/11/2018
 * Course/Section  : 803
 * Program Description:  In class programming assignment for
 *    inputing and displaying sports team data
 **********************************************************/

import javax.swing.JFrame;
import java.util.*;

/**********************************************************
 * Class Name     : SportsStatsDriver
 * Author         :
 * Date           : 4/16/2018
 * Course/Section : CSC264 - 801
 * Program Description:  Class for team stats
 *
 * Methods:
 * -------
 * main - main method for driver
 **********************************************************/

public class SportsStatsDriver
{
    // Class constants
	private static final int QUIT = -1;

	// Class variables

	/**********************************************************
	* Method Name    : main
	* Author         :
	* Date           : 4/16/2018
	* Course/Section : CSC264 - 801
	*
	* BEGIN main
	*    get user choice
	*    WHILE the user wants to update stats
	*       SWITCH(correct team to update)
	*          CASE BASEBALL
	*             call method updateBaseball
	*          CASE BASKETBALL
	*             call method updateBasketball
	*          CASE FOOTBALL
	*             call method updateFootball
	*       END SWITCH
	*       get next user choice
	*    END WHILE
	* END main
	**********************************************************/
    public static void main (String[] args)
    {
		//local constants
		final char BASEBALL   = '1';
 		final char BASKETBALL = '2';
		final char FOOTBALL   = '3';
		final char QUIT       = '4';

		//local variables
		char choice;                                                // user choice of team to edit
		BasketballTeamStats basketTeam = new BasketballTeamStats(); // Instantiate basketball team
		BaseballTeamStats baseballTeam = new BaseballTeamStats();   // Instantiate baseball team
		FootballTeamStats footballTeam = new FootballTeamStats();   // Instantiate football team

		/**********************************************************/

		//get user choice
		choice = menu();

		//while the user wants to update stats
		while(choice != QUIT)
		{
			//select the correct team to update
			switch(choice)
			{
				case BASEBALL:

					updateBaseball(baseballTeam);
					break;

				case BASKETBALL:

					updateBasketball(basketTeam);
					break;

				case FOOTBALL:

					updateFootball(footballTeam);
					break;

				default:

					System.out.println("\n\n\n" +
					                   Util.setLeft(27 , "**************************") +
					                   Util.setLeft(27 , "*                        *") +
					                   Util.setLeft(27 , "* Invalid User Selection *") +
					                   Util.setLeft(27 , "*                        *") +
					                   Util.setLeft(27 , "**************************") +
					                   "\n\n\n\n\n");

		    }//end switch

		    //get next user choice
		    choice = menu();

		}//end while

    }//end main

	/**********************************************************
	* Method Name    : menu
	* Author         :
	* Date           : 4/16/2018
	* Course/Section : CSC264 - 801
	*
	* BEGIN menu
	*    display menu
	*    get user choice for menu
	*    clear screen
	*    return user's selection
	* END menu
	**********************************************************/

    public static char menu()
    {
		//local constants

		//local variables
		char userChoice;                          // User's menu choice
		Scanner reader = new Scanner(System.in);  // object to read user input
		OutputControl op = new OutputControl();   // used to clear and pause screen

		/******************************************************/

		//display menu
		System.out.print("\n\n\n\n\n"                           +
		Util.setLeft(32,"Sports Stats Menu") + "\n\n\n"         +
		                   Util.setLeft(32,"1. Baseball")       + "\n"   +
		                   Util.setLeft(32,"2. Basketball")     + "\n"   +
		                   Util.setLeft(32,"3. Football")       + "\n\n" +
		                   Util.setLeft(32,"4. Quit")           + "\n\n" +
		                   Util.setLeft(32,"Enter Choice:  "));

		//get user choice for menu
		userChoice = reader.next().charAt(0);

		//clear screen
		op.clearScreen();

		//return user's selection
		return userChoice;

	}//end menu method

	/**********************************************************
	* Method Name    : updateBaseball
	* Author         :
	* Date           : 4/16/2018
	* Course/Section : CSC264 - 801
	*
	* BEGIN updateBaseball
	*    prompt user for runs or -1 to quit
	*    WHILE(the user has games to enter)
	*       clear screen
	*       prompt user for number of hits
	*       clear screen
	*       prompt user for number of at bats
	*       clear screen
	*       prompt user for number of shots made for this game
	*       Record win loss or tie
	*       update baseball team stats
	*       clear screen
	*       prompt user for runs or -1 to quit
	*    END WHILE
	*    clear screen
	*    display baseball stats
	*    pause screen
	*    clear screen
	* END updateBaseball
	**********************************************************/

     public static void updateBaseball(BaseballTeamStats baseballTeam)
	 {
		//local constants

		//local variables
		int runs;                               // number of runs scored
		int hits;                               // number of hits scored
		int atBat;                              // number of at bats
		char winLossTie;                        // user choice of win loss or tie
		Scanner reader = new Scanner(System.in);// reads user input
		OutputControl op = new OutputControl(); // used to clear and pause screen


		/******************************************************/

		//prompt user for number of runs
		System.out.print("\n\n\n" + Util.setLeft(24, "Input Runs Scored (-1 to quit): "));
		runs = reader.nextInt();

		//while the user has games to enter
		while(runs != QUIT)
		{
			//clear screen
			op.clearScreen();

			//prompt user for number of hits
		    System.out.print("\n\n\n" + Util.setLeft(24, "Input hits: "));
		    hits = reader.nextInt();

			//clear screen
		    op.clearScreen();

			//prompt user for number of at bats
		    System.out.print("\n\n\n" + Util.setLeft(24, "Input at bats: "));
		    atBat = reader.nextInt();

			//clear screen
		    op.clearScreen();

			//prompt user for number of shots made for this game
			System.out.print("\n\n\n" + Util.setLeft(25, "Enter 1 for win , 2 for loss: "));
			winLossTie = reader.next().charAt(0);

			// Record win loss or tie
			baseballTeam.updateGameResults(winLossTie);

			//update baseball team stats
		    baseballTeam.updateStats(runs, hits, atBat);

			//clear screen
		    op.clearScreen();

		    // Input runs or -1 to quit
		    System.out.print("\n\n\n" + Util.setLeft(24, "Input Runs Scored (-1 to quit): "));
		    runs = reader.nextInt();

	    }//end while

		//clear screen
		op.clearScreen();

		//display baseball stats
		System.out.print("\n\n" + baseballTeam.toString() + "\n\n");

		//pause screen
		op.pause();

		//clear screen
		op.clearScreen();

	 }//end update baseball stats

	/**********************************************************
	* Method Name    : updateBasketball
	* Author         :
	* Date           : 4/16/2018
	* Course/Section : CSC264 - 801
	*
	* BEGIN updateBasketball
	*    prompt user for shots made or -1 to quit
	*    clear screen
	*    WHILE(the user has games to enter)
	*       clear screen
	*       get free throws made for his game
	*       clear screen
	*       prompt user for number of shots made for this game
	*       Record win loss or tie
	*       call method to update basketball stats
	*       clear screen
	*       prompt user for shots made or -1 to quit
	*    END WHILE
	*    clear screen
	*    display baskeball stats
	*    pause screen
	*    clear screen
	* END updateBasketball
	**********************************************************/

     public static void updateBasketball(BasketballTeamStats basketTeam)
	 {
		//local constants

		//local variables
		int fieldGoals;                             // shots made
		int freeThrows;                             // freethrows made
		char winLossTie;                            // win loss or tie for game
		Scanner reader   = new Scanner(System.in);  // reads user input
		OutputControl op = new OutputControl();     // used to clear and pause screen
		/******************************************************/

		//prompt user for shots made or -1 to quit
		System.out.print("\n\n\n" + Util.setLeft(25, "Input Shots Made(-1 to quit): "));
		fieldGoals = reader.nextInt();

		//WHILE(the user has games to enter)
		while(fieldGoals != QUIT)
		{
			//clear screen
			op.clearScreen();

			//get free throws made for his game
			System.out.print("\n\n\n" + Util.setLeft(25, "Input Free Throws Made      : "));
			freeThrows = reader.nextInt();

			//clear screen
			op.clearScreen();

			//prompt user for number of shots made for this game
			System.out.print("\n\n\n" + Util.setLeft(25, "Enter 1 for win , 2 for loss: "));
			winLossTie = reader.next().charAt(0);

			// Record win loss or tie
			basketTeam.updateGameResults(winLossTie);

			//call method to update basketball stats
			basketTeam.addToStats(freeThrows,fieldGoals);

			//clear screen
			op.clearScreen();

			//prompt user for number of shots made for this game or -1 to quit
			System.out.print("\n\n\n" + Util.setLeft(25, "Input Shots Made(-1 to quit): "));
			fieldGoals = reader.nextInt();

		}//end while

		//clear screen
		op.clearScreen();

		//display baskeball stats
		System.out.print("\n\n\n\n\n" + basketTeam.toString() + "\n\n");

		//pause screen
		op.pause();

		//clear screen
		op.clearScreen();

	 }//end update Baskeball stats

	/**********************************************************
	* Method Name    : updateFootball
	* Author         :
	* Date           : 4/16/2018
	* Course/Section : CSC264 - 801
	*
	* BEGIN updateBasketball
	*    prompt user for number of touchdowns or -1 to quit
	*    clear screen
	*    WHILE(the user has games to enter)
	*       clear screen
	*       get extra points made for his game
	*       clear screen
	*       get field goals made for his game
	*       clear screen
	*       get 2 pt conversions scored for his game
	*       clear screen
	*       get safeties scored for his game
	*       clear screen
	*       prompt user for win or loss
	*       Record win loss or tie
	*       call method to update football stats
	*       clear screen
	*       prompt user for number of touchdowns or -1 to quit
	*    END WHILE
	*    clear screen
	*    display football stats
	*    pause screen
	*    clear screen
	* END updateBasketball
	**********************************************************/

	 public static void updateFootball(FootballTeamStats footballTeam)
	 {
		//local constants

		//local variables
		int touchdowns;                            // touchdowns scored
		int extraPoints;                           // extra points made
		int twoPtConversions;                      // two point conversions
		int safeties;                              // safties
		int fieldGoals;                            // fieldgoals
		char winLossTie;                           // win loss or tie for game
		Scanner reader   = new Scanner(System.in); // reads user input
		OutputControl op = new OutputControl();    // used to clear and pause screen

		/******************************************************/

		//prompt user for number of touchdowns or -1 to quit
		System.out.print("\n\n\n" + Util.setLeft(25, "Input Touchdowns (-1 to Quit): "));
		touchdowns = reader.nextInt();

		//clear screen
		op.clearScreen();

		//while the user has games to enter
		while(touchdowns != QUIT)
		{
			//clear screen
			op.clearScreen();

			//get extra points made for his game
			System.out.print("\n\n\n" + Util.setLeft(25, "Input Extra Points           : "));
			extraPoints = reader.nextInt();

			//clear screen
			op.clearScreen();

			//get field goals made for his game
			System.out.print("\n\n\n" + Util.setLeft(25, "Input Field Goals Made       : "));
			fieldGoals = reader.nextInt();

			//clear screen
			op.clearScreen();

			//get 2 pt conversions scored for his game
			System.out.print("\n\n\n" + Util.setLeft(25, "Input 2 Pt Conversions       : "));
			twoPtConversions = reader.nextInt();

			//clear screen
			op.clearScreen();

			//get safeties scored for his game
			System.out.print("\n\n\n" + Util.setLeft(25, "Input Safeties Scored        : "));
			safeties = reader.nextInt();

			//clear screen
			op.clearScreen();

			//prompt user for win or loss
			System.out.print("\n\n\n" + Util.setLeft(25, "Enter 1 for win or 2 for loss: "));
			winLossTie = reader.next().charAt(0);

			// Record win loss or tie
			footballTeam.updateGameResults(winLossTie);

			//call method to update football stats
			footballTeam.addToStats(touchdowns, fieldGoals, extraPoints, twoPtConversions, safeties);

			//clear screen
			op.clearScreen();

			//prompt user for number of touchdowns or -1 to quit
			System.out.print("\n\n\n" + Util.setLeft(25, "Input Touchdowns (-1 to Quit): "));
			touchdowns = reader.nextInt();

		}//end while

		//clear screen
		op.clearScreen();

		//display football stats
		System.out.print("\n\n" + footballTeam.toString() + "\n\n");

		//pause screen
		op.pause();

		//clear screen
		op.clearScreen();

	 }//end updateFootball

}//end SportsStatsDriver