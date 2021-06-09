import java.io.*;
import java.util.*;

public class BoboniuColorBalls {
  public static void main(String[] args) throws IOException{
    FastReader fr = new FastReader();
    PrintWriter pr = new PrintWriter(new OutputStreamWriter(System.out));
    int t = fr.nextInt();

    while (t-- > 0) {
      int r = fr.nextInt(), g = fr.nextInt(), b = fr.nextInt(), w = fr.nextInt();

      if (getverdict(r, g, b, w)) {
        pr.println("Yes");
      } else {
        pr.println("No");
      }
    }

    pr.close();
  }

  static boolean getverdict(int r, int g, int b, int w) {
    int count = 0;
    while (count < 4) {
      if ((r + g + b + w) % 2 == 0) {
        if (countoddfull(r, g, b, w) == 0) return true;
      } else {
        if (countoddfull(r, g, b, w) == 1) return true;
      }
      if (nozero(r, g, b)) {
        r--;
        g--;
        b--;
        w += 3;    
      } else break;
      count++;
    }
    return false;
  } 

  static boolean nozero(int r, int g, int b) {
    if (r == 0 || g == 0 || b == 0) return false;
    return true;
  }

  static int countoddfull(int r, int g, int b, int w) {

    int count = 0;

    if (r % 2 != 0) count++;
    if (g % 2 != 0) count++;
    if (b % 2 != 0) count++;
    if (w % 2 != 0) count++;

    return count;
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
