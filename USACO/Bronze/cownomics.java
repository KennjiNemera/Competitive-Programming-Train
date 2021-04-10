import java.io.*;
import java.util.*;

public class cownomics {
  public static void main(String[] args) throws IOException{
    FastReader fr = new FastReader();
    PrintWriter pr = new PrintWriter(new FileWriter(new File("cownomics.out")));
    int n = fr.nextInt();
    int m = fr.nextInt();

    //. IO routine
    char[][] spot = new char[n][m];
    char[][] plain = new char[n][m];

    for (int i = 0; i < n; i++) {
      spot[i] = fr.nextLine().toCharArray();
    }

    for (int i = 0; i < n; i++) {
      plain[i] = fr.nextLine().toCharArray();
    }

    // Brute force traversal
    int ans = 0;

    for (int i = 0; i < m; i++) {
      if (counts(spot, plain, i)) ans++;
    }

    pr.println(ans);
    pr.close();
  }

  static boolean counts(char[][] a, char[][] b, int col) {
    boolean[] vis = new boolean[26];

    for (int i = 0; i < a.length; i++) {
      vis[a[i][col] - 'A'] = true;
    }

    for (int i = 0; i < b.length; i++) {
      if (vis[b[i][col] - 'A']) return false; 
    }

    return true;
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
          br = new BufferedReader(new FileReader("cownomics.in")); 
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
