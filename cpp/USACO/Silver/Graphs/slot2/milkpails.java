import java.io.*;
import java.util.*;

public class milkpails {
  public static void main(String[] args) throws IOException{
    FastReader fr = new FastReader();
    PrintWriter pr = new PrintWriter(new FileWriter(new File("pails.out")));
    int x = fr.nextInt(), y = fr.nextInt(), k = fr.nextInt(), m = fr.nextInt();
    boolean[][] pos = new boolean[x+1][y+1]; // reason for 1-index is because we are going to use the co-ordinate values as the sums
    pos[0][0] = true;

    // we want to perform this flood fill, k amount of times to complete the process
    for (int i = 0; i < k; i++) {
      // ignore false cells
      boolean[][] next = new boolean[x+1][y+1];
      for (int j = 0; j <= x; j++) {
        for (int n = 0; n <= y; n++) {
          if (!pos[j][n]) continue;

          // run a dfs in the form of pushing to the valid states
          /* State 1: Remain the same;
             State 2: Empty X
             State 3: Empty Y
             State 4: Max out X
             State 5: Max out Y
             State 6,7: Pour out da ting
          */

          next[j][n] = true; // 1
          next[0][n] = true; // 2
          next[j][0] = true; // 3
          next[x][n] = true; // 4
          next[j][y] = true; // 5

          int pourRight = Math.min(j, y - n);
          next[j - pourRight][n + pourRight] = true;

          int pourLeft = Math.min(n, x - j);
          next[j + pourLeft][n - pourLeft] = true;
         }
      }
      pos = next;
    }
    
    // find the minimum set
    int ret = Integer.MAX_VALUE;
    for (int i = 0; i < pos.length; i++) {
      for (int j = 0; j < pos[i].length; j++) {
        if (pos[i][j]) {
          ret = Math.min(ret, Math.abs((i + j) - m));
        }
      }
    }

    pr.println(ret);
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
