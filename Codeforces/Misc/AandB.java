import java.io.*;
import java.util.*;

public class AandB {
  public static void main(String[] args) throws IOException{
    FastReader fr = new FastReader();
    PrintWriter pr = new PrintWriter(new OutputStreamWriter(System.out));
    int t = fr.nextInt();

    while (t-- > 0) {
        int a = fr.nextInt();
        int b = fr.nextInt();
        int dif = Math.abs(b - a);
        int p = binarySearch(dif);
        while (getsum(p) % 2 != dif % 2) p++;
        pr.println(p);
    }

    pr.close();
  }

  static int binarySearch(int n) {
      int lo = 0;
      int hi = 1000000;
      int ans = -1;
      while (lo <= hi) {
          int mid = (lo + hi) / 2;
          if (getsum(mid) >= n) {
              hi = mid - 1;
              ans = mid;
          } else lo = mid + 1;
      }
      return ans;
  }

  static long getsum(int n) {
      double a = n;
      return (long)((a * (a + 1.0)) / 2);
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
