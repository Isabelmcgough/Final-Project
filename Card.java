/**
 * Card.java
 * Assignment: Final Project
 * Purpose: This class creates a new Card
 *   object containing a number value and
 *   a string of info about the card
 *
 * @version 06/21/16
 * @author Isabel McGough
 */

public class Card{

   public int value;
   
   public Card(int n){ //constructor asigns the card a number value based on a random number
      if(n < 6){
         value = n;
      }
      else if (n > 5 && n < 8 ){
         value = n + 1;
      }
      else if(n > 7){
         value = n + 2;
      }
   }
   
   public int getValue(){ //returns the card's value
      return value;
   }
   
   public void aboutCard(){ //prints a string of info about how the card can be used 
      if(value == 0){
         System.out.println("Move any one pawn from Start to a square occupied by any");
         System.out.println("opponent, sending that pawn back to its own Start.");
      }
      else if(value == 1){
         System.out.println("Move a pawn from Start or move a pawn one space forward.");
      }
      else if(value == 2){
         System.out.println("Move a pawn from Start or move a pawn two spaces forward.");
         System.out.println("Then draw again!");
      }
      else if(value == 3){
         System.out.println("Move a pawn three spaces forward.");
      }
      else if(value == 4){
         System.out.println("Move a pawn four spaces forward.");
         //System.out.println("Move a pawn four spaces backward.");
      }
      else if(value == 5){
         System.out.println("Move a pawn five spaces forward.");
      }
      else if(value == 7){
         System.out.println("Move one pawn seven spaces forward.");// or split the seven spaces"); 
         //System.out.println("Move one pawn seven spaces forward or split the seven spaces"); 
         //System.out.println("between two pawns.");
      }
      else if(value == 8){
         System.out.println("Move a pawn eight spaces forward.");
      }
      else if(value == 10){
         System.out.println("Move a pawn 10 spaces forward.");// or one space backward.");
         //System.out.println("Move a pawn 10 spaces forward or one space backward.");
         //System.out.println("If you cannot go forward 10 spaces, then you must move");
         //System.out.println("one pawn back one space.");
      }
      else if(value == 11){
         System.out.println("Move a pawn 11 spaces forward.");// or switch places with one opposing pawn.");
         //System.out.println("Move 11 spaces forward or switch places with one opposing pawn.");
         //System.out.println("If you cannot move 11 spaces, you can forfeit the turn.");
      }
      else{
         System.out.println("Move a pawn 12 spaces forward.");
      }
   }
   
   public void setValue(){
      value = 1;
   }
}