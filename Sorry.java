/**
 * Sorry.java
 * Assignment: Final Project
 * Purpose: This class is my main class that
 *   runs the game and allows the user to play
 *   the game through the console.
 *
 * @version 06/21/16
 * @author Isabel McGough
 */

import java.awt.*;
import java.io.*;
import java.util.*;

public class Sorry{

   public static void main(String[] args) throws FileNotFoundException{
      //creates 4 players
      Player user = new Player("You", 0); 
      Player comp1 = new Player("Team Blue", 1);
      Player comp2 = new Player("Team Yellow", 2);
      Player comp3 = new Player("Team Green", 3);
      //creates a pawn array for each player that hold all of their pawns
      RedPawn redPawns[] = new RedPawn[4]; 
      BluePawn bluePawns[] = new BluePawn[4];
      YellowPawn yellowPawns[] = new YellowPawn[4];
      GreenPawn greenPawns[] = new GreenPawn[4];
      for(int i = 0; i < 4; i++){ //sets all the pawns to their starting location and adds them to the board               
         redPawns[i] = new RedPawn(i); 
         redPawns[i].setToStart(i);
         Board.getDisplay().add(redPawns[i], 0);            
         bluePawns[i] = new BluePawn(i); 
         bluePawns[i].setToStart(i);
         Board.getDisplay().add(bluePawns[i], 0);            
         yellowPawns[i] = new YellowPawn(i); 
         yellowPawns[i].setToStart(i);
         Board.getDisplay().add(yellowPawns[i], 0); 
         greenPawns[i] = new GreenPawn(i); 
         greenPawns[i].setToStart(i);
         Board.getDisplay().add(greenPawns[i], 0);               
      }      
      Board.getDisplay().repaint();                             
      Board.getDisplay().revalidate();
      Scanner console = new Scanner(System.in);
      intro(console);  
      while(user.hasWon() == false && comp1.hasWon() == false && comp2.hasWon() == false && comp3.hasWon() == false){ //runs until the user or a "computer" wins the game
         oneUserTurn(user, redPawns, console); 
         console.nextLine();
         oneCompTurn(comp1, bluePawns, console);
         oneCompTurn(comp2, yellowPawns, console);
         oneCompTurn(comp3, greenPawns, console);
      }        
   }
   
   public static void intro(Scanner console){ //gives user brief instructions of game
      System.out.println("Welcome to SORRY!");
      System.out.println();
      System.out.println("In this game, you (the red team) will be racing against");
      System.out.println("the other teams in attempt to make it back to your \"home\"");
      System.out.println("first and win!");
      System.out.println();
      System.out.println("A pawn can leave start when a 1 or 2 is drawn.");
      System.out.println("Once a pawn is on the board, it can be moved the number of");
      System.out.println("squares that matches the value on the card drawn.");
      System.out.println();
      System.out.println("Good luck!");
      System.out.println();
      System.out.println("Press enter to continue");
      console.nextLine(); 
   }
   
   public static void oneUserTurn(Player player, RedPawn[] pawns, Scanner console){ //called each time the it's the user's turn
      Card card = getCard(player.getName()); //creates new card   
      if(allInStart(pawns) == true && card.getValue() != 1 && card.getValue() != 2){ //tests if any pawns can be moved 
         System.out.println("No pawns can be moved at this time.");
      }
      else{
         card.aboutCard();
         boolean validPawn = false;
         while(!validPawn){
            System.out.println("Which pawn would you like to move?");
            System.out.println("(Roll your mouse over a pawn to see it's number)");
            int pawnToMove = Integer.parseInt(console.next()) - 1;
            validPawn = canBeMoved(card, pawns[pawnToMove], pawns);
            if(validPawn){
               pawns[pawnToMove].movePawn(card.getValue());
            }
            else{
               System.out.println("Please select a valid pawn.");
            }         
         }
         Board.getDisplay().repaint();                             
         Board.getDisplay().revalidate();      
         if(card.getValue() == 2){ 
            System.out.println("Draw again!");
            oneUserTurn(player, pawns, console); //recursion (called if the player gets a 2 allowing them to draw again)
            console.nextLine();
                   
         }
         else{
            System.out.println();            
         } 
         if(checkWinner(pawns) == true){ //tests if player has won 
            player.winner();
         }      
      }
   }
   
   public static void oneCompTurn(Player player, Pawn[] pawns, Scanner console){ //called each time it's a "computer's" turn
      Card card = getCard(player.getName()); //gets a new card
      if(card.getValue() == 0){
         card.setValue();
      }
      if(allInStart(pawns) == true && card.getValue() != 1 && card.getValue() != 2){ //tests if any pawns can be moved
         System.out.println("No pawns can be moved at this time.");
      }
      else{
         int pawnToMove = whichPawnToMove(player, pawns, card); 
         //makes the pawn array into an array the corresponds to its color
         if(pawns[pawnToMove] instanceof BluePawn){
            ((BluePawn) pawns[pawnToMove]).movePawn(card.getValue());
         }
         else if(pawns[pawnToMove] instanceof YellowPawn){
            ((YellowPawn) pawns[pawnToMove]).movePawn(card.getValue());
         } 
         else{
            ((GreenPawn) pawns[pawnToMove]).movePawn(card.getValue());                
         }
         if(card.getValue() == 1){
            System.out.println(player.getName() + " moved their pawn 1 space");
         }
         else{
            System.out.println(player.getName() + " moved their pawn " + card.getValue() + " spaces");      
         }      
      }
      Board.getDisplay().repaint();                             
      Board.getDisplay().revalidate();     
      if(card.getValue() == 2){
         System.out.println("Draw again!");
         oneCompTurn(player, pawns, console); //recursion (called if the player gets a 2 allowing them to draw again)
      }
      else{
         console.nextLine(); 
      } 
   }
   
   public static Card getCard(String word){ //returns a card and tells the user which card they got
      Random rand = new Random();  
      int n = rand.nextInt(10) + 1;
      Card card = new Card(n);
      if(n == 0){
         System.out.println(word + " got a SORRY!");
      }
      else{
         
         if(card.getValue() == 8 || card.getValue() == 11){
            System.out.println(word + " got an " + card.getValue());
         }
         else{
            System.out.println(word + " got a " + card.getValue());
         }
      }
      return card;     
   }
   
   public static boolean allInStart(Pawn[] pawns){ //tests if all pawns in an array are in "start"
      for(int i = 0; i < 4; i++){
         if(pawns[i].inStart() == false){
            return false;     
         }
      }
      return true;
   }
   
   public static boolean checkWinner(Pawn[] pawns){ //tests if all pawns are in home (meaning that player has won)
      for(int i = 0; i < 4; i++){
         if(pawns[i].isHome() == false){
            return false;     
         }
      }
      return true;
   }
   
   public static int whichPawnToMove(Player player, Pawn[] pawns, Card card){ //creates a random number and tests if that numbered pawn can be moved with the drawn card
      Random rand = new Random();
      boolean validNum = false;
      int n = 0;
      while(!validNum){//runs until a valid number for a pawn to move is generated
         n = rand.nextInt(4);
         validNum = canBeMoved(card, pawns[n], pawns);
      }
      return n; // returns a number representing which pawn will be moved    
   }
   
   public static boolean canBeMoved(Card card, Pawn pawn, Pawn[] pawns){//returns true if the pawn is able to be moved based on the drawn card
      if(pawn.isHome()){
         return false;
      }
      if(!squareIsFree(card, pawn, pawns)){
         return false;
      }
      if(pawn.inStart() && !(card.getValue() == 1 || card.getValue() == 2)){
         return false;
      }
      return true;     
   }
   
   public static boolean squareIsFree(Card card, Pawn pawn, Pawn[] pawns){//tests if the square the the pawn if going to be moved to already contains a pawn      
      for(int i = 0; i < 4; i++){
         if(pawn.pawnNum() == i){
            i++;
         }
         else if(!pawn.inStart()){ 
            if(pawn.squareNum() + card.getValue() == pawns[i].squareNum()){
               return false;
            }
         }
         else if(pawns[i].distFromHome() == 60){
            return false;
         }
      }
      return true;
   }
   
}