// Students Alisa Bajenova, Kyryll Kotyk, Eric Lindquist
// 6.16.2022
// CSE 142 AP COMP SCI

import java.awt.event.*;
import javax.swing.*;
/**
 *Game over button listener
 *Will detect if the end game button is pressed
 *If it was, the program(game) will be terminated
 */
public class EndGameListener implements ActionListener{
   /**
   * if it detects a click it ends the program
   * @param event - the event detection
   */
   public void actionPerformed(ActionEvent event){
      System.exit(0);
   }
}
