import java.io.*;
import java.util.*;

public class NewTheatreSquare {
  public static void main(String[] args) throws IOException{
    FastReader fr = new FastReader();
    PrintWriter pr = new PrintWriter(new OutputStreamWriter(System.out));
    int t = fr.nextInt();

    while (t-- > 0) {
      int n = fr.nextInt();
      int m = fr.nextInt();
      int x = fr.nextInt();
      int y = fr.nextInt();

      int sum = 0;

      for (int i = 0; i < n; i++) {
        String s = fr.nextLine();

        int j = 0;

        while (j < m) {
            if (s.charAt(j) == '*') {
              j++;
              continue;
            }

            if (j < m - 1) {
              if (s.charAt(j+1) == '.' && y < x * 2) {
                sum += y;
                j += 2;
              } else {
                sum += x;
                j++;
              }
            } else {
              sum += x;
              j++;
            }
        }
      }

      pr.println(sum);      
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
