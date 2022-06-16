//Students Alisa Bajenova, Kyryll Kotyk, Eric Lindquist
// 6.16.2022
// CSE 142 AP COMP SCI
// Uses Difficulty and GuiController classes to create the game.
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Minesweeper{
   public static void main(String[] args){
      Difficulty diff = new Difficulty();
      GuiController gui = new GuiController(diff);
      gui.runGame();
   }
}