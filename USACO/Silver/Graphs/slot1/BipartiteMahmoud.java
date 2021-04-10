import java.io.*;
import java.util.*;

public class BipartiteMahmoud {

  static ArrayList<Node> map;
  static boolean[] vis;
  static int n;
  static long l, r;

  public static void main(String[] args) throws IOException{
    FastReader fr = new FastReader();
    PrintWriter pr = new PrintWriter(new OutputStreamWriter(System.out));

    n = fr.nextInt();

    map = new ArrayList<>();
    vis = new boolean[n];

    for (int i = 0; i < n; i++) {
      map.add(new Node(i));
    }

    // build map
    for (int i = 0; i < n - 1; i++) {
      int a = fr.nextInt() - 1;
      int b = fr.nextInt() - 1;
      map.get(a).neighbours.add(map.get(b));
      map.get(b).neighbours.add(map.get(a));
    }

    // process cc
    for (int i = 0; i < n; i++) {
      if (!vis[i]) {
        dfs(i, 1);
      }
    }

    // append possible edges
    /* 
      the maximum number of edges that can be added is (l * r) - (n-1)
      becauce the max number of edges that can exist is l * r but n-1 edges already exist so the difference is the answer
    */
    long ans = (l * r) - (n - 1);

    pr.println(ans);
    pr.close();
  }

  static void dfs(int x, int c) {
    vis[x] = true;
    map.get(x).color = c;
    if (c == 1) l++;
    else r++;
    int t = c == 1 ? 2 : 1;
    for (Node node : map.get(x).neighbours) {
      if (node.color == c) continue;
      if (!vis[node.index]) {
        dfs(node.index, t);
      }
    }
  }

  static class Node {
    int index, color;
    ArrayList<Node> neighbours;
    public Node (int index) {
      this.index = index;
      neighbours = new ArrayList<>();
    }
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
