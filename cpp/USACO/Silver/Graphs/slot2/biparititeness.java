import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

public class biparititeness {

  static ArrayList<Edge> adj;
  static boolean[] vis;
  static int h, t, n;

  public static void main(String[] args) throws IOException{
    FastReader fr = new FastReader();
    PrintWriter pr = new PrintWriter(new OutputStreamWriter(System.out));
    n = fr.nextInt();

    adj = new ArrayList<>();

    for (int i = 0; i < n; i++) {
        adj.add(new Edge(i));
    }

    vis = new boolean[n];

    // build map

    for (int i = 0; i < n-1; i++) {
        int a = fr.nextInt() - 1;
        int b = fr.nextInt() - 1;

        adj.get(a).neighbours.add(adj.get(b));
        adj.get(b).neighbours.add(adj.get(a));
    }

    // perform standard dfs
    adj.get(0).c = 'H';
    dfs(0);

    long ans = 0;

    // Complete search over the array
    for (Edge e : adj) {
        int colour = e.c == 'H' ? 1 : 0;
        int sub = colour == 1 ? t : h;
        ans += Math.max(0, sub - e.neighbours.size());
    }

    pr.println(ans / 2);
    pr.close();
  }

  static void dfs(int n) {
    vis[n] = true;
    if (adj.get(n).c == 'H') h++; else t++;
    int colour = adj.get(n).c == 'H' ? 1 : 0;
    for (Edge edge : adj.get(n).neighbours) {
        if (!vis[edge.val]) {
            adj.get(edge.val).c = colour == 1 ? 'T' : 'H';
            dfs(edge.val);
        }
    }
  }

  static class Edge {
      char c;
      int val;
      ArrayList<Edge> neighbours;
      public Edge(int val) {
          this.val = val;
          neighbours = new ArrayList<>();
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
