// Students Alisa Bajenova, Kyryll Kotyk, Eric Lindquist
// 6.16.2022
// CSE 142 AP COMP SCI
// bomb location class 
// will create the bombs randomly
// other programs can ask how many bombs are adjacent

import java.util.*;
/**
 *A class that creates and generates bombs on the minefield.
 */
public class Bombs{
   private boolean[][] grid;
   /**
   * accepts a 2d array and fills it with bombs
   * @param bombs - the empty 2d array
   * @param x - the x value of the first click
   * @param y - the y value of the first click
   * @param number - the number of bombs to generate
   */
   public Bombs(boolean[][] bombs, int x, int y, int number){
      int total = number;
      Random r = new Random();
      grid = bombs;
      int bombsGenerated = 0;
      while(bombsGenerated<total){
         int x1 = r.nextInt(bombs.length);
         int y1 = r.nextInt(bombs[0].length);
         if(!(x1<=x+1 && y1<=y+1 && x1>=x-1 && y1>=y-1) && !bombs[x1][y1]){
            grid[x1][y1] = true;
            bombsGenerated++;
         }
      }
   }
   
   /**
   * gives the number of bombs adjacent to the given coordinate
   * @param x - the x value
   * @param y - the y value
   * @return the bombs adjacent
   */
   public int bombsAdjacent(int x, int y){
      boolean containsBomb = grid[x][y];
      if(containsBomb){
         return -1;
      }
      int adjacent = 0;
      for(int i = x-1; i<=x+1; i++){
         for(int j = y-1; j<=y+1; j++){
            if(!(i<0 || j<0 || i>grid.length-1 || j>grid[0].length-1)){
               containsBomb = grid[i][j];
               if(containsBomb){
                  adjacent++;
               }
            }
         }
      }
      return adjacent;
   }
}
