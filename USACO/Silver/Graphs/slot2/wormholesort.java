import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

public class wormholesort {

  static ArrayList<Edge> arr;
  static int n, m;
  static int[] loc, components;

  public static void main(String[] args) throws IOException{
    FastReader fr = new FastReader();
    PrintWriter pr = new PrintWriter(new FileWriter(new File("wormsort.out")));
    n = fr.nextInt(); m = fr.nextInt();
    loc = new int[n];
    components = new int[n];

    arr = new ArrayList<>();

    for (int i = 0; i < n; i++) {
      loc[i] = fr.nextInt();
      arr.add(new Edge(i));
    }

    for (int i = 0; i < m; i++) {
      int a = fr.nextInt()-1, b = fr.nextInt()-1, w = fr.nextInt();

      arr.get(a).neigh.add(new Join(b, w));
      arr.get(b).neigh.add(new Join(a, w)); 
    }

    long low = 0;
    long high = (long)1e9;
    long ans = -1;

    while (low <= high) {
      long mid = (low + high) / 2;
      if (isValid(mid)) {
        low = mid + 1;
        ans = mid;
      } else high = mid - 1;
    }

    if (ans >= 1e9) {
      pr.println(-1);
    } else {
      pr.println(ans);
    }

    pr.close();
  }

  static boolean isValid(long n) {
    Arrays.fill(components, -1);
    int numcc = 0;
    for (int i = 0; i < components.length; i++) {
      if (components[i] < 0) {
        dfs(i, numcc++, n);
      }
    }

    // perform the check
    for (int i = 0; i < components.length; i++) {
      if (components[i] != components[loc[i] - 1]) return false;
    }

    return true;
  }

  static void dfs(int node, int label, long min) {
    if (components[node] == label) return; // already visited
    components[node] = label;

    for (Join j : arr.get(node).neigh) {
      if (min <= j.w) {
        dfs(j.x, label, min);
      }
    }
  }

  static class Edge{
      int val;
      ArrayList<Join> neigh;
      public Edge(int val) {
          this.val = val;
          neigh = new ArrayList<>();
      }
  }

  static class Join {
    int x, w;
    public Join(int x, int w) {
      this.x = x;
      this.w = w;
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
          br = new BufferedReader(new FileReader("wormsort.in")); 
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
