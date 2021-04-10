import java.io.*;
import java.util.*;

class Main {
  public static void main(String[] args) throws IOException{
    FastReader fr = new FastReader();
    PrintWriter pr = new PrintWriter(new OutputStreamWriter(System.out));
    int t = fr.nextInt();
    int c = 0; // case count

    while (t-- > 0) {
      int n = fr.nextInt();
      int k = fr.nextInt();
      int goodness = 0;
      StringBuilder sb = new StringBuilder();
      sb.append(fr.nextLine());

      for (int i = 0; i < n / 2; i++) {
        if (sb.charAt(i) == sb.charAt(n - 1 - i)) goodness++;
      }

      k -= goodness;
      int operations = 0;

      for (int i = 0; i < n / 2; i++) {
        if (k == 0) break;
        if (sb.charAt(n-1-i) != sb.charAt(i)) {
          operations++;
        }
      }

      c++;
      pr.println("Case #" + c + ": " + operations);
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
