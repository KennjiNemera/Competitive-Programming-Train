import java.io.*;
import java.util.*;

public class mootube {

  static ArrayList<Node> list = new ArrayList<>();
  static int n, q, count;

  public static void main(String[] args) throws IOException{
    FastReader fr = new FastReader();
    PrintWriter pr = new PrintWriter(new FileWriter(new File("mootube.out")));
    n = fr.nextInt(); q = fr.nextInt();

    for (int i = 0; i < n; i++) {
      list.add(new Node(i));
    }

    // IO routine 
    for (int i = 0; i < n - 1; i++) {
      int a = fr.nextInt() - 1;
      int b = fr.nextInt() - 1;
      int r = fr.nextInt();

      list.get(a).children.add(new Edge(b, r));
      list.get(b).children.add(new Edge(a, r));
    }

    // Perform DFS on each queury
    while (q-- > 0) {
      int k = fr.nextInt();
      int n = fr.nextInt()-1;

      count = 0;

      dfs(n, -1, k);

      pr.println(count);
    }

    pr.close();
  }

  static void dfs(int n, int p, int r) {
    for (Edge e : list.get(n).children) {
        if (e.y == p) continue;
        if (e.r >= r) {
          count++;
          dfs(e.y, n, r);
        }
    }
  }

  static class Node {
      int x;
      ArrayList<Edge> children;
      public Node(int x) {
          this.x = x;
          children = new ArrayList<>();
      }
  }

  static class Edge {
    int y, r;
    public Edge(int y, int r) {
      this.y = y;
      this.r = r;
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
          br = new BufferedReader(new FileReader("mootube.in")); 
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
