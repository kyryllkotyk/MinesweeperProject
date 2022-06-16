// Students Alisa Bajenova, Kyryll Kotyk, Eric Lindquist
// 6.16.2022
// CSE 142 AP COMP SCI
// game over button Listener
// will detect if the end game button is pressed.
// If so it will terminate the program

import java.awt.event.*;
import javax.swing.*;

public class EndGameListener implements ActionListener{
   /**
   * if it detects a click it ends the program
   * @param event - the event detection
   */
   public void actionPerformed(ActionEvent event){
      System.exit(0);
   }
}
