/**
 * Player Project
 * @author John Doe Per 2
 */

// CLIENT CLASS ***********************************************

import java.util.ArrayList;
import java.util.Scanner;

public class PlayerDemo 
{

    public static void main(String[] args) 
    {            
        World world = new World();                    // the world where players live      
        GameController game = new GameController();   // the game
        
        Player humanPlayer = new Player(1, 1, 1);        // human's player object (direction, speed, position)
        world.placePlayer(humanPlayer);
        
        Player computerPlayer = new Player(-1, 1, -2);   // computer player (direction, speed, position)
        world.placePlayer(computerPlayer);
                
        world.display();
        
        Scanner keyboard = new Scanner(System.in);
        String command = "";
        
        while (game.isGameRunning() == true)
        {
            Player nextUp = null;
            
            if (game.getPlayerTurn() == 1)
            {  
               nextUp = humanPlayer;
               System.out.print("\nHuman player #" + game.getPlayerTurn() + ". Input a command (move, turn, or exit): ");
               command = keyboard.nextLine();
               
               if (Parser.findKeyword(command, "turn") > -1)
               {
                  nextUp.turn();
               }
               else if (Parser.findKeyword(command, "move") > -1)
               {
                  nextUp.move();
               }
               else if (Parser.findKeyword(command, "exit") > -1)
               {
                  game.setGameRunning(false);
               } 
                             
            }
            else if (game.getPlayerTurn() == 2)
            {
               nextUp = computerPlayer;
               int num = (int) (Math.random() * 2) + 1; // random integer 1 or 2
               
               if (num == 1)        // computer either turns or moves forward
               {
                  nextUp.turn();
               }
               else if (num == 2)
               {
                  nextUp.move();
               }
               
               System.out.println("After computer player's turn.");
            }         
                 
            world.display();
            game.togglePlayerTurn();
        }
        
    }// end of main method
    
}// end of PlayerDemo class