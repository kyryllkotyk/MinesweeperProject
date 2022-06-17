// Students Alisa Bajenova, Kyryll Kotyk, Eric Lindquist
// 6.16.2022
// CSE 142 AP COMP SCI

import java.awt.event.*;
import javax.swing.*;
import java.awt.*;
/**
 *Play again button listener
 *Will detect if the play again buttton is pressed
 *If so it will start a new game
 */
public class PlayAgainListener implements ActionListener{
   /**
   * if it detects a click it starts a new program
   * @param event - the event detection
   */
   public void actionPerformed(ActionEvent event){
      Difficulty diff = new Difficulty();
      GuiController gui = new GuiController(diff);
      gui.runGame();
   }
}
