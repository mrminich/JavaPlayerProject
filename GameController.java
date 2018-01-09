public class GameController
{
   // instance variables (properties) ********************

   private boolean myGameRunning;
   private int myPlayerTurn;   

   // default constructor *******************************

   public GameController()
   {
       myGameRunning = true;
       myPlayerTurn = 1;
   }

   // accessor methods ************************************
   
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

}// end of GameState class
