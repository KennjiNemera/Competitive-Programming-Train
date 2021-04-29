import java.io.*;
import java.util.*;

public class SerejaAndSuffixes_217B {
  public static void main(String[] args) throws IOException{
    FastReader fr = new FastReader();
    PrintWriter pr = new PrintWriter(new OutputStreamWriter(System.out));
    int n = fr.nextInt();
    int m = fr.nextInt();

    int[] arr = new int[n];
    int[] count = new int[100001];
    int[] dp = new int[n];
    int dist = 0; // counts the number of distinct values in total

    for (int i = 0; i < n; i++) {
      int a = fr.nextInt();
      arr[i] = a;
      if (count[a] == 0) dist++;
      count[a]++;
    }

    for (int i = 0; i < n; i++) {
      dp[i] = dist;
      count[arr[i]]--;
      if (count[arr[i]] <= 0) dist--; 
    }

    while (m-- > 0) {
      pr.println(dp[fr.nextInt()-1]);
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
