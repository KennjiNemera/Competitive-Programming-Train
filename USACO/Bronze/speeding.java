import java.io.*;
import java.util.*;

public class speeding {
  public static void main(String[] args) throws IOException{
    FastReader fr = new FastReader();
    PrintWriter pr = new PrintWriter(new FileWriter(new File("speeding.out")));
    int n = fr.nextInt();
    int m = fr.nextInt();
    Pair[] road = new Pair[n];
    Pair[] bes = new Pair[m];

    // IO routine
    int prefix = 0;
    for (int i = 0; i < road.length; i++) {
      prefix += fr.nextInt();
      road[i] = new Pair(prefix, fr.nextInt());
    }

    prefix = 0;

    for (int i = 0; i < bes.length; i++) {
      prefix += fr.nextInt();
      bes[i] = new Pair(prefix, fr.nextInt());
    }

    int i = 0, j = 0;
    int maxTicket = 0;
    while (i < n && j < m) {
      maxTicket = Math.max(maxTicket, bes[j].y - road[i].y);
      if (road[i].x == bes[j].x) {
        i++; j++;
      } else {
        if (road[i].x < bes[j].x) {
          i++;
        } else j++;
      }
    }
    pr.println(maxTicket);
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
          br = new BufferedReader(new FileReader("speeding.in")); 
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
