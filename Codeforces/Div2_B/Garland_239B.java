import java.io.*;
import java.util.*;

public class Garland_239B {
  public static void main(String[] args) throws IOException{
    FastReader fr = new FastReader();
    PrintWriter pr = new PrintWriter(new OutputStreamWriter(System.out));

    int[] have = new int[26];
    int[] need = new int[26];
  
    String in = fr.nextLine();
    String out = fr.nextLine();

    for (int i = 0; i < in.length(); i++) {
      have[in.charAt(i) - 'a']++;
    }

    for (int i = 0; i < out.length(); i++) {
      need[out.charAt(i) - 'a']++;
    }

    int total = 0;
    int pieces = 0;

    for (int i = 0; i < need.length; i++) {
      if (need[i] > 0 && have[i] > 0) {
        total += Math.min(need[i], have[i]);
        pieces += need[i];
      }
    }

    if (pieces != out.length()) {
      pr.println(-1);
    } else pr.println(total);
    
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
