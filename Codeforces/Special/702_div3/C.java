import java.io.*;
import java.util.*;

public class C {
  public static void main(String[] args) throws IOException{
    FastReader fr = new FastReader();
    PrintWriter pr = new PrintWriter(new OutputStreamWriter(System.out));
    int n = fr.nextInt();

    while (n-- > 0) {
      boolean found = false;
      long val = fr.nextLong();
      for (long i = (long) Math.cbrt(val); Math.pow(i, 3) + Math.pow(i, 3) >= val && !found; i--) {
        long lo = 1;
        long hi = i;
        long ans = -1;
        while (lo <= hi) {
          long mid = (lo + hi) / 2;
          if (Math.pow(mid, 3) + Math.pow(i, 3) <= val) {
            ans = mid;
            lo = mid + 1;
          } else {
            hi = mid-1;
          }
        }
        if (Math.pow(ans, 3) + Math.pow(i, 3) == val) {
          found = true;
        } 
      }
      String out = found == true ? "YES" : "NO";
      pr.println(out);
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
