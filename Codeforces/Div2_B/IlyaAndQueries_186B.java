import java.io.*;
import java.util.*;

public class IlyaAndQueries_186B {
  public static void main(String[] args) throws IOException{
    FastReader fr = new FastReader();
    PrintWriter pr = new PrintWriter(new OutputStreamWriter(System.out));
    char[] arr = fr.nextLine().toCharArray();

    int[] dp = new int[arr.length];

    int count = 0;
    for (int i = 0; i < dp.length-1; i++) {
      if (arr[i] == arr[i+1]) count++;
      dp[i] = count;
    }

    dp[dp.length-1] = count;
    int m = fr.nextInt();

    while (m-- > 0) {
      int a = fr.nextInt()-1;
      int b = fr.nextInt()-2;

      if (a == 0) {
        pr.println(dp[b]);
      } else {
        pr.println(dp[b] - dp[a-1]);
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
