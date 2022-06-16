public class Difficulty{
   public String diff;
   /**
    *Constructs the class
    */
   public Difficulty(){
      diff = "Normal";
   }
   /**
    *@return the row count
    */
   public int rowCount(){
         return 14;
   }
   /**
    *@return the column count
    */
   public int colCount(){
         return 18;
   }
   /**
    *@return the size of the tiles
    */
   public int tileSize(){
         return 40;
   }
   /**
    *@return the number of mines
    */
   public int getNumberOfMines(){
         return 40;
   }
  
}