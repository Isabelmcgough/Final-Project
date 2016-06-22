/**
 * GreenPawn.java
 * Assignment: Final Project
 * Purpose: This class is an extention 
 *   of Pawn. It changes certain numbers
 *   such as its starting and ending location.
 *
 * @version 06/21/16
 * @author Isabel McGough
 */

import java.awt.*;
import java.io.*;
import java.util.*;
import javax.swing.*;

public class GreenPawn extends Pawn{

   public GreenPawn(int i)throws FileNotFoundException{
      super(new ImageIcon("green.png"), i);  //gets image of a green pawn
      startSquare = 43;
      homeSquare = 41;
      this.pawnNum = pawnNum;     
   }
   
   public void setToStart(int pawnNum){ //moves pawn to green team's start

      x = 537;
      y = 180;
      super.setToStart(pawnNum, x, y); 
   }
   
   public void leaveStart(){ //moves pawn to first square outside of green team's start
      x = 632;
      y = 207;
      squareNum = 43;
      super.leaveStart();
   }
   
   public void movePawn(int card){ //moves pawn around board based on the card drawn
      int squaresMoved = 0;
      if(start){
         leaveStart();
      }
      else{
         while(squaresMoved < card){ //runs until the squares moved euqals the cards value       
            if(squareNum == homeSquare){
               if(distFromHome == 0){
                  home = true;
               }
               else{
                  x = x - 42; 
                  distFromHome--;    
               }    
               safeZone = true;            
            }
            else if(squareNum >= 11 && squareNum < 25){
               y = y - 43;
            }
            else if(squareNum >= 25 && squareNum < 39){
               x = x + 42;
            }
            else if(squareNum >=39 && squareNum < 53){
               y = y + 43;
            }
            else{
               x = x - 42;
            }
            setLocation(x, y);
            if(!safeZone){
               if(squareNum < 56){
                  squareNum++;
               }
               else{
                  squareNum = 1;
               }
            }
            squaresMoved++;   
         }
      }
   }

}