/**********************************************************
 * Program Name    : Sports Team Stats
 * Authors         : William Golembieski, Brandon Willis, Narayan Neopane, Rayan Vakil
 * Date            : 4/11/2018
 * Course/Section  : 803
 * Program Description:  In class programming assignment for
 *    inputing and displaying sports team data
 **********************************************************/

 import java.util.*;
 import java.io.*;

/************************************************************************************
 * Program Name   : Lab FootballTeamStats
 * Author         : Brandon Willis
 * Date           : April 11, 2018
 * Course/Section : CSC264 - 801
 * Program Description: This program keeps track of a team's stats. It first initializes
 *    the team's stats to zero and updates and displays their stats every time new stats
 *    are entered.
 *
 * Methods:
 * -------
 * FootballTeamStats - Initializes class data to 0
 * addToStats        - Updates class data
 * toString          - Prints out stats
 ***************************************************************************************/
public class FootballTeamStats extends SportsTeamStats
{
   // Class constants

   // Class variables
   private int   touchdowns;        //Total number of touchdowns
   private int   fieldgoals;        //Total number of field goals
   private int   extraPoints;       //Total number of extra points
   private int   twoPtConversions;  //Total number of two point conversions
   private int   safties;           //Total number of safties
   private int   totalPts;          //Total number of points for season
   private float ptsPerGame;        //Total number of points per game
   private int   numGames;          //Total number of games played currently

   /******************************************************
    * Method Name    : FootballTeamStats
    * Author         : Brandon Willis
    * Date           : April 11, 2018
    * Course/Section : CSC264 - 801
    * Method Description: Initializes class data to 0
    * BEGIN FootballTeamStats
    *    Inherit from SportsTeamStats parent class
    *    Initialize class data to 0
    * END FootballTeamStats
    ******************************************************/

   public FootballTeamStats()
   {
	  // Inherit from SportsTeamStats parent class
	  super("FootBallers", "James L");

      //local constants

      //local variables

      /********************************************************/

      //Initialize class data to 0
      touchdowns       = 0;
      fieldgoals       = 0;
      extraPoints      = 0;
      twoPtConversions = 0;
      safties          = 0;
      totalPts         = 0;
      ptsPerGame       = 0;
      numGames         = 0;

   } //End FootballTeamStats

   /***********************************************************
    * Method Name    : addToStats
    * Author         : Brandon Willis
    * Date           : April 11, 2018
    * Course/Section : CSC264 - 801
    * Method Description: Updates class data
    * BEGIN addToStats
    *    Store instance data
    *    Increment number of games
    *    Calc points per game
    *    Calc total points per season
    *    Return total points
    * END addToStats
    **********************************************************/

   public int addToStats(int tds, int fgs, int pats, int twoPointers, int inSafties)
   {
      //local constants

      //local variables

      /*******************************************************/

      //Store instance data
      fieldgoals       = fieldgoals       + fgs;
      touchdowns       = touchdowns       + tds;
      extraPoints      = extraPoints      + pats;
      twoPtConversions = twoPtConversions + twoPointers;
      safties          = safties          + inSafties;

      //Increment number of games
      numGames += 1;

      //Calc total points
      totalPts = totalPts + (tds*6 + fgs*3 + pats*1 + twoPointers*2 + inSafties*2);

      //Calc points per game
      ptsPerGame = ((float)totalPts / numGames);

      //Return total points
      return totalPts;

   } //End addToStats

   /***********************************************************
    * Method Name    : toString
    * Author         : Brandon Willis
    * Date           : April 11, 2018
    * Course/Section : CSC264 - 801
    * Method Description: Prints out stats
    * BEGIN toString
    *    Format output
    *    Return output
    * END toString
    *******************************************************/

   public String toString()
   {
      //local constants
      final int NUM_SPACES = 31;
      final int DATA_WIDTH = 4;
      final String TDS = touchdowns + "";
      final String FGS = fieldgoals + "";
      final String EPS = extraPoints + "";
      final String TWOP = twoPtConversions + "";
      final String SAFE = safties + "";
      final String TOT_P = totalPts + "";
      final String PPG = ptsPerGame + "";

      //local variables
      String title[] = super.rosterTitleNoTie();  //Contains roster title, stats, and coach
      String output = "";                         //Output for stats

      /********************************************************************/

      //Format output
      output = title[0] +
               Util.setLeft(NUM_SPACES, "TDs         : ") + Util.setRight(DATA_WIDTH,TDS) + "\n" +
               Util.setLeft(NUM_SPACES, "FGs         : ") + Util.setRight(DATA_WIDTH,FGS) + "\n" +
               Util.setLeft(NUM_SPACES, "PATs        : ") + Util.setRight(DATA_WIDTH,EPS) + "\n" +
               Util.setLeft(NUM_SPACES, "2Pt Convs   : ") + Util.setRight(DATA_WIDTH,TWOP)+ "\n" +
               Util.setLeft(NUM_SPACES, "Safeties    : ") + Util.setRight(DATA_WIDTH,SAFE)+ "\n" +
               Util.setLeft(NUM_SPACES, "Total pts   : ") + Util.setRight(DATA_WIDTH,TOT_P)+ "\n" +
               Util.setLeft(NUM_SPACES, "Pts per game: ") + Util.setRight(DATA_WIDTH,PPG)+ "\n\n" +
               title[1];

      //Return output
      return output;

   } //End toString

} //End FootballTeamStats