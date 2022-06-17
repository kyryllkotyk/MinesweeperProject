//Students Alisa Bajenova, Kyryll Kotyk, Eric Lindquist
// 6.16.2022
// CSE 142 AP COMP SCI
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.event.*;
/**
 *This will start the game when it's run, end the game, create pop ups for win/loss
 *Registers mouse clicks and uses the information given from the clicks 
 */
public class GuiController extends MouseInputAdapter{
   public boolean isOver = false;
   private int time;
   private int flagCount;
   private Time timer;
   private Difficulty diff;
   public Bombs bomb;
   /**
    *Constructs GuiController class
    *@param dif - Constructor of difficulty class
    */
   public GuiController(Difficulty dif){
      diff = dif;
      flagCount = diff.getNumberOfMines();
      row = diff.colCount();
      col = diff.rowCount();
      flags = new boolean[row][col];
      bombs = new boolean[row][col];
      numbers = new int[row][col];
   }
   /**
    *Runs the game
    */
   public void runGame(){
      JFrame frame = new JFrame();
      frame.addMouseListener(this);
      Difficulty diff = new Difficulty();
      int sizeX = diff.colCount()*diff.tileSize();
      int sizeY = diff.rowCount()*diff.tileSize()+70;
      frame.setSize(sizeX+11, sizeY);
      frame.setTitle("Minesweeper");
      gui = new NewGui(diff);
      gui.setSize(sizeX,sizeY);
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.add(gui, BorderLayout.CENTER);
      frame.setVisible(true);
   }
   public NewGui gui;
   public int click;
   public int row;
   public int col;
   public boolean[][] flags;
   public boolean[][] bombs;
   public int[][] numbers;
   public int x1;
   public int y1;
   /**
    *Reacts to a mouse event(clicking)
    *@param event - constructor of MouseEvent
    */
   public void mousePressed(MouseEvent event){
      x1 = event.getX()/diff.tileSize();
      y1 = (event.getY()-20-diff.tileSize())/diff.tileSize();
      click = event.getButton();
      if(!isOver){
         whatToDo();
      }
   }
   /**
    *Uses the information from mousePressed and performs certain things 
    *depending on what click it is.
    */
   public void whatToDo(){
      int number = diff.getNumberOfMines();
      int flagCount = diff.getNumberOfMines();
      if(bomb == null){
         bomb = new Bombs(bombs, x1, y1, number);
         timer = new Time(gui);
         timer.newGame();
      }
      int winCondition = 40;
      //Left click
      if(click == 1){
         if(flags[x1][y1] == false){
            if(bomb.bombsAdjacent(x1,y1) != -1){
               numbers[x1][y1] = bomb.bombsAdjacent(x1, y1);
               int x2 = x1;
               int y2 = y1;
               if(numbers[x1][y1] == 0){
                  numbers[x1][y1] = 9;
                  for(int i = x1 - 1; i <= x1 + 1; i++){
                     for(int j = y1 - 1; j <= y1 + 1; j++){
                        if(i >= 0 && j >= 0 && i <= 17 && j <= 13){
                           x2 = i;
                           y2 = j;  
                           numbers[x2][y2] = bomb.bombsAdjacent(x2,y2);
                           if(numbers[x2][y2] == 0){
                              numbers[x2][y2] = 9;
                              zero(i,j);
                           }
                        //if 0, x3 y3, then replace x1 y1 with it.
                        }
                     }
                  }
               
                  x1 = x2;
                  y1 = y2;
               }
               gui.updateGrid(numbers);
               for(int i = 0; i<numbers.length; i++){
                  for(int j = 0; j<numbers[0].length; j++){
                     if(numbers[i][j] == 0 || numbers[i][j] == 10){
                        winCondition--;
                     }
                  }
               }
               if(winCondition == 0){
                  youWin();
               }
            }
            else{
               gameOver();
            }
         }
      }
         //Middle click
      if(click == 2){
         int count = 0;
         //Runs through adjacent(and the tile clicked on) and checks for flags
         for(int i = x1 - 1; i <= x1 + 1; i++){
            for(int j = y1 - 1; j <= y1 + 1; j++){
                  //Counts the amount of flags in the proximity
               if(i >= 0 && j >= 0 && i <= 17 && j <= 13){    
                  if(numbers[i][j] == 10){
                     count++;
                  }
               }
               
            }
         }
         if(count == bomb.bombsAdjacent(x1,y1)){
            if(numbers[x1][y1] != 10){
               numbers[x1][y1] = bomb.bombsAdjacent(x1, y1);
               for(int i = x1 - 1; i <= x1 + 1; i++){
                  for(int j = y1 - 1; j <= y1 + 1; j++){
                          
                     if(i >= 0 && j >= 0 && i <= 17 && j <= 13){ 
                        if(flags[i][j] == false){
                           numbers[i][j] = bomb.bombsAdjacent(i,j);
                           if(numbers[i][j] == -1){
                              gameOver();
                           }
                           if(numbers[i][j] == 0){
                              numbers[i][j] = 9;
                              zero(i,j);
                           }
                        }
                     }
                  }
               }
                  
            }
            gui.updateGrid(numbers);
            for(int i = 0; i<numbers.length; i++){
               for(int j = 0; j<numbers[0].length; j++){
                  if(numbers[i][j] == 0 || numbers[i][j] == 10){
                     winCondition--;
                  }
               }
            }
            if(winCondition == 0){
               youWin();
            }
         } 
      } 
         //Right click
      if(click == 3){
         flags[x1][y1] = !flags[x1][y1];
         if(numbers[x1][y1] == 0 || numbers[x1][y1] == 10){
            if(flags[x1][y1] == true){
               flagCount--;
               numbers[x1][y1] = 10;
            }
            else{
               flagCount++;
               numbers[x1][y1] = 0;
            }
         }
         gui.updateGrid(numbers);
      }
      gui.repaint();
   }
   /**
    *Reveals all tiles adjacent to the 0 tile
    *@param x3 - x coordinate of the 0 tile
    *@param y3 - y coordinate of the 0 tile
    */
   public void zero(int x3, int y3){
      for(int i = x3 - 1; i <= x3 + 1; i++){
         for(int j = y3 - 1; j <= y3 + 1; j++){
            if(i >= 0 && j >= 0 && i <= 17 && j <= 13){
               int x2 = i;
               int y2 = j; 
               if(numbers[x2][y2] != 9){
                  numbers[x2][y2] = bomb.bombsAdjacent(x2,y2);
               }
               if(numbers[x2][y2] == 0){
                  numbers[x2][y2] = 9;
                  zero(i,j);
               }
            }
         }
      }
   }
   /**
    *Ends the game and makes a pop up that lets you exit or play again
    */
   public void gameOver(){
      isOver = true;
      JFrame frame1 = new JFrame();
      frame1.setSize(300, 300);
      frame1.setBackground(Color.black);
      JLabel label = new JLabel("You lost!");
      JPanel panel = new JPanel(new BorderLayout());
      panel.setSize(300,300);
      frame1.add(label);
      panel.add(label, BorderLayout.SOUTH);
      panel.setLayout(new FlowLayout());
      JButton playAgain = new JButton("Play again");
      playAgain.addActionListener(new PlayAgainListener());
      JButton exit = new JButton("Exit game");
      exit.addActionListener(new EndGameListener());
      panel.add(playAgain);
      panel.add(exit);
      frame1.add(panel);
      frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame1.show();
   }
   /**
    *Creates a pop-up with time it took to beat the game and lets the player play again or exit
    */
   public void youWin(){
      int score = timer.getTime();
      isOver = true;
      JFrame frame1 = new JFrame();
      frame1.setSize(300, 300);
      frame1.setBackground(Color.black);
      JLabel label = new JLabel("You won!    Time: " + score);
      JPanel panel = new JPanel(new BorderLayout());
      panel.setSize(300,300);
      frame1.add(label);
      panel.add(label, BorderLayout.SOUTH);
      panel.setLayout(new FlowLayout());
      JButton playAgain = new JButton("Play again");
      playAgain.addActionListener(new PlayAgainListener());
      JButton exit = new JButton("Exit game");
      exit.addActionListener(new EndGameListener());
      panel.add(playAgain);
      panel.add(exit);
      frame1.add(panel);
      frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame1.show();
   }
}
