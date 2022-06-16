//Students Alisa Bajenova, Kyryll Kotyk, Eric Lindquist
// 6.16.2022
// CSE 142 AP COMP SCI
//Creates a timer and runs it when the game starts.
import java.util.*;

public class Time{
   public int time;
   private Timer clock;
   private NewGui gui;
   /**
    *Constructs the Time class
    *@param GUI - Constructor of GUI
    */
   public Time(NewGui GUI){
      gui = GUI;
   }
   /**
    *Resets the timer
    */
   public void newGame(){
      Timer clock = new Timer();
      time = 0;
      clock.scheduleAtFixedRate(task, 1000, 1000);
   }
   //This handles the timer
   TimerTask task = 
      new TimerTask(){
      /**
       *Starts the timer
       */
         public void run(){
            time++;
            gui.setTime(time);
            gui.repaint();
         }
      };
   /**
    *@return the time
    */
   public int getTime(){
      return time;
   }

}