import java.util.ArrayList;

public class World
{
   // instance variables (properties) ********************
   
   private ArrayList<Player> objects;  // list of all players in the world
    
   // class constants ************************************

   public final static int SIZE = 51;                // length of one-dimensional world
   public final static int NUM_BLANK_LINES = 0;      // blank lines to clear the console
    
   // default constructor *******************************

   public World()
   {
      objects = new ArrayList();      // instantiating an empty list of players
   }
    
   // interesting methods *******************************
    
   // postcondition: a new player is placed into the world
   public void placePlayer(Player player)
   {
      objects.add(player);
   }
    
   // postcondition: display all the players in the world
   public void display()
   {
      String[] strip = new String[SIZE];        // number line 
        
      for (int i = 0; i < objects.size(); i++)  // looping thru the list of players
      {
         int numLivePlayers = 0;
         Player nextPlayer = objects.get(i);
            
         if (nextPlayer.isAlive())
         {
            numLivePlayers++;
               
            if (nextPlayer.getDirection() == 1) // if current player points east
            {
               strip[nextPlayer.getX() + SIZE/2] = ">";  // place correct marker into strip at proper place
            }                                            //     adding SIZE/2 due to the negative portion of x axis
            else if (nextPlayer.getDirection() == -1)        
            {
               strip[nextPlayer.getX() + SIZE/2] = "<";
            }
               
         } 
         else
         {
            objects.remove(nextPlayer);
         }
            
      }
      
      clearScreen();
        
      // display the strip of direction markers
      System.out.print("\n|");
        
      for (int i = 0; i < strip.length; i++)
      {
            
         if (strip[i] == null)
         {
            System.out.print("-");       // display blank space if current spot has no player
         }
         else
         {
            System.out.print(strip[i]);  // display the correct direction marker
         }
            
      }
        
      System.out.println("|");
         
      for (Player nextPlayer : objects)   // looping thru the list of players
      {
        
         if (nextPlayer.isAlive())
         {  
            System.out.println(nextPlayer.toString());  // display status
         }
         else
         {
            objects.remove(nextPlayer);
         }
         
      }
            
   }// end of display method
   
   // postcondition: many blank lines clear the console screen
   public void clearScreen()
   {
   
      for (int i = 0; i < NUM_BLANK_LINES; i++)
      {
         System.out.println();
      }
        
   }// end of clearScreen method
   
}// end of World class
