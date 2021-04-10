import java.io.*;
import java.util.*;

public class div7 {
  public static void main(String[] args) throws IOException{
    FastReader fr = new FastReader();
    PrintWriter pr = new PrintWriter(new FileWriter(new File("div7.out")));
    int n = fr.nextInt();

    int[] first = new int[7];
    int[] last = new int[7];

    Arrays.fill(first, Integer.MAX_VALUE);

    int curPref = 0;
    for (int i = 1; i <= n; i++) {
      int a = fr.nextInt();
      curPref += a;
      curPref %= 7;

      first[curPref] = Math.min(first[curPref], i);
      last[curPref] = i;
    }

    // find max set
    int ret = 0;
    for (int i = 0; i < 7; i++) {
      ret = Math.max(ret , last[i] - first[i]);
    }


    pr.println(ret);
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
          br = new BufferedReader(new FileReader("div7.in")); 
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
