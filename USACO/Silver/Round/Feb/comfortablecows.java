import java.io.*;
import java.util.*;

public class comfortablecows {

  static Pair[][] arr = new Pair[2000][2000];
  static boolean[][] cowMap = new boolean[2000][2000];
  static int numFalseCows;
  static int[][] moves = {{1,0}, {-1,0}, {0,1}, {0, -1}};
  public static void main(String[] args) throws IOException{
    FastReader fr = new FastReader();
    PrintWriter pr = new PrintWriter(new OutputStreamWriter(System.out));
    int n = fr.nextInt();
    for (int i = 0; i < n; i++) {
      numFalseCows = 0;
      int x = fr.nextInt() + 1000;
      int y = fr.nextInt() + 1000;
      if (cowMap[x][y]) {
        arr[x][y].isFalse = true;
      } else {
        arr[x][y] = new Pair(x, y, getSurroundings(x, y), true);
      }
      for (int[] move : moves) {
        int mx = x + move[0];
        int my = y + move[1];
        if (!isValid(mx, my)) continue;
        if (cowMap[mx][my]) {
          arr[mx][my].val++;
          if (arr[mx][my].isFalse == true) arr[x][y].val++;
          if (arr[mx][my].val == 3) {
            System.out.println(x + " " + y);
            pushFalse(mx, my);
          }
        } 
      }
      System.out.println(arr[x][y].val);
      if (arr[x][y].val == 3) {
        System.out.println("push");
        pushFalse(x, y);
      }
      pr.println(numFalseCows);
    }

    pr.close();
  }

  static void pushFalse(int x, int y) {
    numFalseCows++;
    for (int[] move : moves) {
      int mx = x + move[0];
      int my = y + move[1];
      if (cowMap[mx][my] == false) {
        arr[mx][my] = new Pair(mx, my, getSurroundings(mx, my), false);
        cowMap[mx][my] = true;
      }
    }
  }

  static int getSurroundings(int x, int y) {
    int count = 0;
    for (int[] move : moves) {
      int mx = x + move[0];
      int my = y + move[1];
      if (cowMap[mx][my]) count++; 
    }
    if (count == 3) pushFalse(x, y);
    return count;
  }

  static boolean isValid(int x, int y) {
    if (x < 0 || x >= 2000 || y < 0 || y >= 2000) return false;
    return true;
  }

  static class Pair {
      boolean isFalse;
      int x, y, val;
      public Pair(int x, int y, int val, boolean isFalse) {
          this.x = x;
          this.y = y;
          this.val = val;
          this.isFalse = isFalse;
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
          br = new BufferedReader(new InputStreamReader(System.in)); 
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
