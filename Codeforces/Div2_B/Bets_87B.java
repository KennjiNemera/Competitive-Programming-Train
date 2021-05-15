import java.io.*;
import java.util.*;

public class Bets_87B {
  public static void main(String[] args) throws IOException{
    FastReader fr = new FastReader();
    PrintWriter pr = new PrintWriter(new OutputStreamWriter(System.out));
    int n = fr.nextInt();
    int m = fr.nextInt();
    int[][] arr = new int[n][2];

    while (m-- > 0) {
      int l = fr.nextInt()-1;
      int r = fr.nextInt()-1;
      int t = fr.nextInt();
      int c = fr.nextInt();

      for (int i = l; i <= r; i++) {
        if (arr[i][1] == 0) {
          arr[i][1] = t;
          arr[i][0] = c;
        } else {
          if (arr[i][1] > t) {
            arr[i][1] = t;
            arr[i][0] = c;
          }
        }
      }
    }

    long total = 0;
    for (int[] is : arr) {
      total += is[0];
    }

    pr.println(total);
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
