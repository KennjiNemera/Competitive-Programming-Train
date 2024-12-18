import java.io.*;
import java.util.*;

public class maxdist {
  public static void main(String[] args) throws IOException{
    FastReader fr = new FastReader();
    int n = fr.nextInt();
    Pair[] arr = new Pair[n];

    String[] a = fr.nextLine().split(" ");
    String[] b = fr.nextLine().split(" ");

    for (int i = 0; i < n; i++) {
      arr[i] = new Pair(toInt(a[i]), toInt(b[i]));
    }

    // Loop through all combinations of points
    long max = 0;
    for (int i = 0; i < n-1; i++) {
      for (int j = i+1; j < n; j++) {
        int x = Math.max(arr[i].x, arr[j].x) - Math.min(arr[i].x, arr[j].x);
        int y = Math.max(arr[i].y, arr[j].y) - Math.min(arr[i].y, arr[j].y);
        double dist = Math.pow(x, 2) + Math.pow(y, 2);
        max = Math.max(max, (long) dist);
      }
    }

    System.out.println(max);
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
