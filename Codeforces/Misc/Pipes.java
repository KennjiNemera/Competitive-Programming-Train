import java.io.*;
import java.util.*;

public class Pipes {
  public static void main(String[] args) throws IOException{
    FastReader fr = new FastReader();
    PrintWriter pr = new PrintWriter(new OutputStreamWriter(System.out));
    int q = fr.nextInt();

    while (q-- > 0) {
        int n = fr.nextInt();

        String[][] arr = new String[2][n];

        arr[0] = fr.nextLine().split("");
        arr[1] = fr.nextLine().split("");

        int crow = 1, ccol = 1;
        boolean vertchange = false;
        boolean possible = true;

        while (ccol <= n) {
            if (toInt(arr[crow-1][ccol-1]) <= 2) {
                if (vertchange) {
                    possible = false;
                    break;
                }
                vertchange = false;
                ccol++;
            } else {
                if (!vertchange) {
                    crow = crow % 2 == 0 ? 1 : 2;
                    vertchange = true;
                } else {
                    ccol++;
                    vertchange = false;
                }
            }   
        }

        if (possible && crow != 2) possible = false; 

        if (possible) {
            pr.println("YES");
        } else {
            pr.println("NO");
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
