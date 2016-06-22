/**
 * Player.java
 * Assignment: Final Project
 * Purpose: This class creates a new
 *   player. Four players are created 
 *   for each game.
 *
 * @version 06/21/16
 * @author Isabel McGough
 */

public class Player{

   public String name;
   public boolean won;
   public int playerNum;
   
   public Player(String name, int playerNum){ //constructor creates a player with a name and number
      this.name = name;
      won = false;
      this.playerNum = playerNum;
   }
   
   public String getName(){ //return their name
      return name;
   }
   
   public boolean hasWon(){ //returns whether or not the user has won
      return won;
   }
   
   public void winner(){ //sets the player's "won" boolean to true. Called when all four of their pawn's are in home.
      won = true;
   }
   
}