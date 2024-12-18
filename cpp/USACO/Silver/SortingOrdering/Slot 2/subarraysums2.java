import java.io.*;
import java.util.*;

public class subarraysums2 {
  public static void main(String[] args) throws IOException{
    FastReader fr = new FastReader();
    PrintWriter pr = new PrintWriter(new OutputStreamWriter(System.out));
    int n = fr.nextInt();
    int x = fr.nextInt();
    Map<Long, Long> map = new HashMap<>();
    long curSum = 0;
    long ans = 0;

    for (int i = 0; i < n; i++) {
      curSum += fr.nextInt();
      if (curSum == x) ans++;

      // check that there int another val that could be used to achieve x through their difference
      if (map.containsKey(curSum - x)) {
        ans += map.get(curSum - x);
      }

      // push values to map
      if (map.containsKey(curSum)) {
        map.put(curSum, map.get(curSum) + 1);
      } else map.put(curSum, (long)1);
    }

    pr.println(ans);
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
