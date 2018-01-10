public class GameController
{
   // instance variables (properties) ********************

   private boolean myGameRunning;            // true if game is running, false otherwise
   private int myPlayerTurn;                 // ID # of player who has next turn

   // default constructor *******************************

   public GameController()
   {
       myGameRunning = true;
       myPlayerTurn = 1;
   }

   // accessor methods ************************************
   
   // accessor method for myGameRunning
   // also is predicate method that returns true or false 
   public boolean isGameRunning()
   {
       return myGameRunning;
   }

   public int getPlayerTurn()
   {
       return myPlayerTurn;
   }

   // modifier methods ***********************************

   public void setGameRunning(boolean gameRunning)
   {
       myGameRunning = gameRunning;
   }

   public void setPlayerTurn(int playerTurn)
   {
       myPlayerTurn = playerTurn;
   }

   // interesting methods *******************************

   // postcondition: updates game for next player to take a turn (i.e. to act)
   public void togglePlayerTurn()
   {
   
       if (myPlayerTurn == 1)
       {
           myPlayerTurn = 2;
       }
       else
       {
           myPlayerTurn = 1;
       }
       
   }

}// end of GameController class
