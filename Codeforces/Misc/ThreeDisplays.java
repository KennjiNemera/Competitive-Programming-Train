import java.io.*;
import java.util.*;

public class ThreeDisplays {
  public static void main(String[] args) throws IOException{
    FastReader fr = new FastReader();
    PrintWriter pr = new PrintWriter(new OutputStreamWriter(System.out));
    int n = fr.nextInt();
    int g = 1000000002;

    int[] arr = new int[n];
    int[] cost = new int[n];

    for (int i = 0; i < cost.length; i++) {
        arr[i] = fr.nextInt();
    }

    for (int i = 0; i < cost.length; i++) {
        cost[i] = fr.nextInt();
    }

    // run a loop for some j and search for a minimum cost
    boolean found = false;
    long ans = Long.MAX_VALUE;

    for (int i = 1; i < cost.length - 1; i++) {
        
        long total = cost[i];
        long min = Long.MAX_VALUE;

        for (int j = 0; j < i; j++) {
            if (arr[j] < arr[i]) min = Math.min(min, cost[j]);
        }

        if (min == Long.MAX_VALUE) {
            continue;
        }

        total += min;
        min = Long.MAX_VALUE;

        for (int j = i + 1; j < cost.length; j++) {
            if (arr[j] > arr[i]) min = Math.min(min, cost[j]);
        }

        if (min == Long.MAX_VALUE) {
            continue;
        }

        total += min;
        found = true;

        ans = Math.min(ans, total);
    }

    if (found) {
        pr.println(ans);
    } else {
        pr.println(-1);
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
