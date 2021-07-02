import java.io.*;
import java.util.*;

public class BlockAdventure {
  public static void main(String[] args) throws IOException{
    FastReader fr = new FastReader();
    PrintWriter pr = new PrintWriter(new OutputStreamWriter(System.out));
    int t = fr.nextInt();

    while (t-- > 0) {
      int n = fr.nextInt(), m = fr.nextInt(), k = fr.nextInt();

      int cur = fr.nextInt();
      boolean canreach = true;

      for (int i = 0; i < n-1; i++) {

        int next = fr.nextInt();
        // check that we are able to climb
        if (cur + m < next - k && canreach) {
          canreach = false;
        } else if (cur > next - k && canreach) {
          m += Math.min(cur, cur - (next - k)); // prevent digging more than needed.
        } else if (cur < next - k && canreach) {
          m -= (next - k) - cur;
        }

        cur = next;
      }

      if (canreach) {
        pr.println("YES");
      } else {
        pr.println("NO");
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
