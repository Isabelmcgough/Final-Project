/**
 * Board.java
 * Assignment: Final Project
 * Purpose: This class creates the JFrame
 *   that allows the user to see the board
 *   and all the pawns
 *
 * @version 06/21/16
 * @author Isabel McGough
 */

import java.awt.Color;
import javax.swing.*;

public class Board extends JFrame{

   private static Board board = new Board();
   private static JPanel display;
   
   private Board(){
      new JFrame("SORRY!"); //creates JFrame
      setSize(725, 743);
      setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);    
      display = new JPanel(); //creates a JPanel in the JFrame
      display.setLayout(null);
      display.setSize(700,700);
      add(display);
      JLabel background = new JLabel(new ImageIcon("board.jpg")); //adds image of sorry board to JPanel
      background.setSize(display.getSize());
      background.setLocation(0,0);
      display.add(background, -1);
      JLabel credits = new JLabel("Sorry board image from: forevertwentysomethings.com/2012/02/17/what-i-learned-from-the-best-board-games-ever/");
      credits.setSize(700,17);
      credits.setLocation(3,699);
      display.add(credits, 0);
      
      setVisible(true);
      setResizable(false);
   }
   
   public static JPanel getDisplay(){ //returns the JPanel (called in main)
      return display;
   }

}