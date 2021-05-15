import java.io.*;
import java.util.*;

public class C {
  public static void main(String[] args) throws IOException{
    FastReader fr = new FastReader();
    PrintWriter pr = new PrintWriter(new OutputStreamWriter(System.out));
    int t = fr.nextInt();

    while (t-- > 0) {
      int m = fr.nextInt();
      int n = (int) Math.pow(m, 2);
      if (n == 4) {
        pr.println(-1);
        continue;
      }

      boolean flip = false;
      int i = 1;
      int j = (int) Math.ceil(n/2);

      int[][] arr = new int[m][m];

      for (int l = 0; l < m; l++) {
        for (int k = 0; k < m; k++) {
          if ((l + k) % 2 == 0) {
            arr[l][k] = i;
            i++;
          } else {
            arr[l][k] = j;
            j++;
          }
        }
      }

      for (int[] row : arr) {
        for (int a : row) {
          pr.print(a + " ");
        }
        pr.print("\n");
      }
    }

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
