import java.io.*;
import java.util.*;

public class ComputerGame {
  public static void main(String[] args) throws IOException{
    FastReader fr = new FastReader();
    PrintWriter pr = new PrintWriter(new OutputStreamWriter(System.out));
    int t = fr.nextInt();

    while (t-- > 0) {
      int k = fr.nextInt(), n = fr.nextInt(), a = fr.nextInt(), b = fr.nextInt();

      int maxa = k % a == 0 ? (k / a) - 1 : k / a;

      // it made more sense to break on the first value i found, starting from max a
      // oof and the time limit is 3s lmao
      // i just need to rearrange the inequality in such a way that i can binary search for i

      int ans = binarysearch(k,n,a,b,maxa);

      pr.println(ans);
    }

    pr.close();
  }

  static int binarysearch(int k, int n, int a, int b, int maxa) {
    int lo = 0;
    int hi = Math.min(maxa, n);
    int ans = -1;
    while (lo <= hi) {
      int mid = (lo + hi) / 2;
      int tempb =  (k - (mid * a)) % b == 0 ? ((k-(mid * a)) / b - 1) : (k - (mid * a)) / b;
      if (k > tempb * b + mid * a && mid + tempb >= n) {
        lo = mid + 1;
        ans = mid;
      } else hi = mid - 1;
    }

    return ans;
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
