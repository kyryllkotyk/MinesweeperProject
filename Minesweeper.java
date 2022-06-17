//Students Alisa Bajenova, Kyryll Kotyk, Eric Lindquist
// 6.16.2022
// CSE 142 AP COMP SCI
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
/**
 *Uses Difficulty and GuiController classes to create and run the game.
 */
public class Minesweeper{
   public static void main(String[] args){
      Difficulty diff = new Difficulty();
      GuiController gui = new GuiController(diff);
      gui.runGame();
   }
}
