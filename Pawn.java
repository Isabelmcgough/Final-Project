/**
 * Pawn.java
 * Assignment: Final Project
 * Purpose: This class is the parent
 *   class for the RedPawn, BlueBawn, 
 *   YellowPawn, and GreenPawn classes.
 *
 * @version 06/21/16
 * @author Isabel McGough
 */

import java.awt.*;
import java.io.*;
import java.util.*;
import javax.swing.*;

public class Pawn extends JLabel{

   public boolean start;
   public boolean home;
   public boolean safeZone;
   public int x; 
   public int y;
   public int squareNum;
   public int startSquare;
   public int homeSquare; 
   public int pawnNum;
   public int distFromHome;
   
   
   public Pawn(ImageIcon image, int i)throws FileNotFoundException{ //constructor sets all defualts
      setIcon(image);    
      start = true;
      home = false; 
      safeZone = false; 
      setVisible(true); 
      setSize(30,30);
      setOpaque(false); 
      pawnNum = i + 1;
      setToolTipText("" + pawnNum);
      distFromHome = 61;
            
   }
   
   public boolean inStart(){ //returns true if pawn is in start
      return start;
   }
   
   public void setToStart(int pawnNum, int x, int y){ //moves pawn to its starting location
      this.x = x;
      this.y = y;
      if(pawnNum == 1){
         x += 35;
      }
      else if(pawnNum == 2){
         y += 35;
      }
      else if(pawnNum == 3){
         x += 35;
         y += 35;
      }
      setLocation(x,y);  
      start = true;   
      home = false; 
      squareNum = 0;
      distFromHome = 57;
   }
   
   public void leaveStart(){ //moves pawn to the first square outside of start
      setLocation(x, y);
      home = false;
      start = false;
      distFromHome--;
   }
   public boolean isHome(){ //returns true if pawn it in home
      return home;
   }
   
   public boolean isInSafeZone(){ //returns true if pawn is in the "safe zone"
      return safeZone;
   }
   
   public int distFromHome(){ //returns how many squares aqay from home the pawn is
      return distFromHome;
   }  
   
   public int pawnNum(){ //returns the pawn's number (1, 2, 3, or 4)
      return pawnNum;
   }
   
   public int squareNum(){ //returns the number of the square that the pawn is currently on
      return squareNum;
   } 
 
}