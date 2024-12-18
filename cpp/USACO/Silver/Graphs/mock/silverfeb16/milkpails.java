import java.io.*;
import java.util.*;

public class milkpails {

  static int min = Integer.MAX_VALUE;
  static int x, y, k, m;
  public static void main(String[] args) throws IOException{
    FastReader fr = new FastReader();
    PrintWriter pr = new PrintWriter(new FileWriter(new File("pails.out")));
    x = fr.nextInt(); y = fr.nextInt(); k = fr.nextInt(); m = fr.nextInt();
    boolean[][] can = new boolean[x + 1][y + 1];
    can[0][0] = true;
    for (int op = 0; op < k; op++) {
      boolean[][] possible = new boolean[x+1][y + 1];
      for (int i = 0; i <= x; i++) {
        for (int j = 0; j <= y; j++) {
          if (can[i][j]) {
            possible[i][j] = true;
            possible[x][j] = true;
            possible[i][y] = true;
            possible[0][j] = true;
            possible[i][0] = true;
            possible[i + Math.min(x - i, j)][j - Math.min(x - i, j)] = true;
            possible[i - Math.min(i, y - j)][j + Math.min(i, y - j)] = true;
          }
        }
      }
      can = possible;    
    }

    // find the min possibility
    for (int i = 0; i < can.length; i++) {
      for (int j = 0; j < can[i].length; j++) {
        if (!can[i][j]) continue;
        min = Math.min(Math.abs((i + j) - m), min);
      }
    }

    pr.println(min);
    pr.close();
  }

  static class Pair {
      int x, y;
      public Pair(int x, int y) {
          this.x = x;
          this.y = y;
      }
  }

  static int toInt(String s) {
    return Integer.parseInt(s);
  }

  static class FastReader 
  { 
      BufferedReader br; 
      StringTokenizer st; 

      public FastReader() throws FileNotFoundException 
      { 
          br = new BufferedReader(new FileReader("pails.in")); 
      } 

      String next() 
      { 
          while (st == null || !st.hasMoreElements()) 
          { 
              try
              { 
                  st = new StringTokenizer(br.readLine()); 
              } 
              catch (IOException  e) 
              { 
                  e.printStackTrace(); 
              } 
          } 
          return st.nextToken(); 
      } 

      int nextInt() 
      { 
          return Integer.parseInt(next()); 
      } 

      long nextLong() 
      { 
          return Long.parseLong(next()); 
      } 

      double nextDouble() 
      { 
          return Double.parseDouble(next()); 
      } 

      String nextLine() 
      { 
          String str = ""; 
          try
          { 
              str = br.readLine(); 
          } 
          catch (IOException e) 
          { 
              e.printStackTrace(); 
          } 
          return str; 
      } 
  }
}
