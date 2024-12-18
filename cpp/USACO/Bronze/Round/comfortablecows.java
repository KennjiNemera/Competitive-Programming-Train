import java.io.*;
import java.util.*;

public class comfortablecows {

  static int[][] arr = new int[1000][1000];
  static boolean[][] cowMap = new boolean[1000][1000];
  static int[][] moves = {{1,0}, {-1,0}, {0,1}, {0, -1}};
  static int comfy = 0;
  public static void main(String[] args) throws IOException{
    FastReader fr = new FastReader();
    PrintWriter pr = new PrintWriter(new OutputStreamWriter(System.out));
    int n = fr.nextInt();
    for (int i = 0; i < n; i++) {
      int x = fr.nextInt();
      int y = fr.nextInt();
      cowMap[x][y] = true;
      for (int[] move : moves) {
        int mx = x + move[0];
        int my = y + move[1];
        if (!isValid(mx, my)) continue;
        if (cowMap[mx][my]) {
          arr[mx][my]++;
          arr[x][y]++;
          // System.out.println(mx + " " + my + " " + arr[mx][my]);
          if (arr[mx][my] == 3) {
            // System.out.println("MADE COMFy: " + mx + " " + my);
            comfy++;
          } else if (arr[mx][my] > 3) comfy--;
        }
      }
      // System.out.println(x + " " + y + " " + arr[x][y]);
      if (arr[x][y] == 3) comfy++;
      pr.println(comfy);
    }

    pr.close();
  }

  static boolean isValid(int x, int y) {
    if (x < 0 || x >= 1000 || y < 0 || y >= 1000) return false;
    return true;
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
