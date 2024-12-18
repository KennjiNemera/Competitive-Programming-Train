import java.io.*;
import java.util.*;

public class clockwisefence {

  static PrintWriter pr = new PrintWriter(new OutputStreamWriter(System.out));
  public static void main(String[] args) throws IOException{
    FastReader fr = new FastReader();
    int n = fr.nextInt();

    while (n-- > 0) {
      solve(fr.nextLine());
    }

    pr.close();
  }

  static void solve(String s) {
    int dir = 0;
    for (int i = 0; i < s.length()-1; i++) {
      if (s.charAt(i) != s.charAt(i+1)) {
        switch(s.charAt(i)) {
          case 'N': if (s.charAt(i+1) == 'E') dir++; else dir--;
                break;
          case 'E': if (s.charAt(i+1) == 'S') dir++; else dir--; 
                break;
          case 'S': if (s.charAt(i+1) == 'W') dir++; else dir--; 
                break;
          case 'W': if (s.charAt(i+1) == 'N') dir++; else dir--;
                break;
        }     
      }
    }

    if (dir < 0) {
      counterClock();
    } else {
      clockwise();
    }
  } 

  static void counterClock() {
    pr.println("CCW");
  }

  static void clockwise() {
    pr.println("CW");
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
