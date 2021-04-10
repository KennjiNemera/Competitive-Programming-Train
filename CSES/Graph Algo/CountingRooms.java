import java.util.*;

public class CountingRooms {

   static char[][] grid;
   
   public static void main (String[] args) {
      Scanner scan = new Scanner(System.in);
      int n = scan.nextInt();
      int m = scan.nextInt();
      
      scan.nextLine();
      
      grid = new char[n][m];
      
      for (int i = 0; i < n; i++) {
         char[] temp = scan.nextLine().toCharArray();
         grid[i] = temp;
      }
      
      System.out.println(countRooms());
   }
   
   public static int countRooms() {
      int count = 0;
      for (int i = 0; i < grid.length; i++) {
         for (int j = 0; j < grid[i].length; j++) {
            if (grid[i][j] == '.') {
               count++;
               countArea(i,j);
            }
         }
      }
      
      return count;
   }
   
   public static void countArea (int i, int j) {
      if (i < 0 || i >= grid.length || j < 0 || j >= grid[i].length || grid[i][j] == '#') return;
      
      grid[i][j] = '#';
      
      countArea(i,j+1);
      countArea(i,j-1);
      countArea(i+1,j);
      countArea(i-1,j);
   }
   
   public static void printGrid() {
      for (int i = 0; i < grid.length; i++) {
         for (int j = 0; j < grid[i].length; j++) {
            System.out.print(grid[i][j]);
         }
         System.out.println();
      }
   }
}