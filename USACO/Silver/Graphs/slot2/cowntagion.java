import java.io.*;
import java.util.*;

public class cowntagion {

  static ArrayList<ArrayList<Integer>> adj = new ArrayList<>();  
  public static void main(String[] args) throws IOException{
    FastReader fr = new FastReader();
    PrintWriter pr = new PrintWriter(new OutputStreamWriter(System.out));
    int n = fr.nextInt();

    for (int i = 0; i < n; i++) {
        adj.add(new ArrayList<>());
    }

    for (int i = 0; i < n - 1; i++) {
        int a = fr.nextInt() - 1;
        int b = fr.nextInt() - 1;

        adj.get(a).add(b);
        adj.get(b).add(a);
    }

    // edge case 
    if (n == 1) {
        pr.println(0);
        pr.close();
        return;
    }

    pr.println(dfs(0, -1));
    pr.close();
  }

  static long dfs(int v, int p) {

    long total = 0;

    int cows = adj.get(v).size();

    if (p == -1) cows++;

    int curCows = 1;
    int days = 0;
    
    while (curCows < cows) {
        curCows *= 2;
        days++;
    }

    total += days;

    for (Integer child : adj.get(v)) {
        if (p == child) continue;
        total += dfs(child, v) + 1;
    }

    return total;
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
