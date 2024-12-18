import java.io.*;
import java.util.*;

public class countingrooms {

  static int n, m;

  public static void main(String[] args) throws IOException{
    FastReader fr = new FastReader();
    PrintWriter pr = new PrintWriter(new OutputStreamWriter(System.out));
    n = fr.nextInt();
    m = fr.nextInt();
    char[][] arr = new char[n][m];
    
    // I/O routine
    for (int i = 0; i < n; i++) {
        String in = fr.nextLine();
        for (int j = 0; j < m; j++) {
            arr[i][j] = in.charAt(j);
        }
    }

    // loop through all rooms
    int ans = 0;
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < m; j++) {
            if (arr[i][j] == '.') {
                ans++;
                isValid(arr, i, j);
            }
        }
    }

    pr.println(ans);
    pr.close();
  }

  // recursive functions that fills the space of the room
  static void isValid(char[][] arr, int x, int y) {
      if (x < 0 || x >= n || y < 0 || y >= m) return;
      if (arr[x][y] != '.') return; 
      
      arr[x][y] = '#';

      isValid(arr, x+1, y);
      isValid(arr, x-1, y);
      isValid(arr, x, y+1);
      isValid(arr, x, y-1);
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
