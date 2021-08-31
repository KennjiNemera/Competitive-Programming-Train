import java.io.*;
import java.util.*;

public class C {
  public static void main(String[] args) throws IOException{
    FastReader fr = new FastReader();
    PrintWriter pr = new PrintWriter(new OutputStreamWriter(System.out));
    int t = fr.nextInt();

    while (t-- > 0) {
      int k = fr.nextInt(), n = fr.nextInt(), m = fr.nextInt();

      int i = 0, j = 0;

      String[] a = fr.nextLine().split(" ");
      String[] b = fr.nextLine().split(" ");

      String out = "";
      boolean possible = true;

      while (i + j <= n + m - 1 && possible) {
        if (i < n && toInt(a[i]) <= k) {
          if (a[i].equals("0")) k++;
          out += a[i] + " ";
          i++;
        } else if (j < m && toInt(b[j]) <= k) {
          if (b[j].equals("0")) k++;
          out += b[j] + " ";
          j++;
        } else {
          possible = false;
          break;
        }
      }

      if (possible) {
        pr.println(out.trim());
      } else pr.println(-1);
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