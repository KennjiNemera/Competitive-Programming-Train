import java.io.*;
import java.util.*;

public class PolandBallAndForest {

  static ArrayList<ArrayList<Integer>> list = new ArrayList<>();
  static boolean[] vis;
  static int n;

  public static void main(String[] args) throws IOException{
    FastReader fr = new FastReader();
    PrintWriter pr = new PrintWriter(new OutputStreamWriter(System.out));
    n = fr.nextInt();
    vis = new boolean[n];

    for (int i = 0; i < n; i++) {
      list.add(new ArrayList<>());
    }

    // IO routine
    for (int i = 0; i < n; i++) {
      int a = fr.nextInt()-1;

      list.get(i).add(a);
      list.get(a).add(i);
    }

    // process cc
    int count = 0;
    for (int i = 0; i < n; i++) {
      if (!vis[i]) {
        count++;
        dfs(i, -1);
      }
    }

    pr.println(count);
    pr.close();
  }

  static void dfs(int n, int p) {
    vis[n] = true;
    for (Integer a : list.get(n)) {
      if (a == p) continue;
      dfs(a, n);
    }
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
