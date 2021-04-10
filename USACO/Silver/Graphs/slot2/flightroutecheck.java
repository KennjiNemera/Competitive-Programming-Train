import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

public class flightroutecheck {

  static ArrayList<City> arr = new ArrayList<>();
  static boolean[] vis = new boolean[100001];
  static int n, m;
  static PrintWriter pr = new PrintWriter(new OutputStreamWriter(System.out));
  public static void main(String[] args) throws IOException{
    FastReader fr = new FastReader();
    n = fr.nextInt();
    m = fr.nextInt();

    // init arr
    for (int i = 0; i < n; i++) {
      arr.add(new City());
    }

    // Process edges
    for (int i = 0; i < m; i++) {
      int a = fr.nextInt() - 1;
      int b = fr.nextInt() - 1;

      arr.get(a).out.add(b);
      arr.get(b).in.add(a);
    }

    dfs(0, 0);

    /// check for any not visited by 1
    for (int i = 0; i < n; i++) {
      if (!vis[i]) {
        pr.println("NO");
        pr.println(1 + " " + (i + 1));
        pr.close();
      }
    }

    Arrays.fill(vis, false);

    dfs(0, 1);

    for (int i = 0; i < n; i++) {
      if (!vis[i]) {
        pr.println("NO");
        pr.println((i + 1) + " " + 1);
        pr.close();
      }
    }

    pr.println("YES");
    pr.close();    
  }

  static void dfs(int a, int x) {
    vis[a] = true;
    ArrayList<Integer> children;

    if (x == 0) children = arr.get(a).out;
    else children = arr.get(a).in;

    for (Integer i : children) {
      if (!vis[i]) {
        dfs(i, x);
      }
    }
  }

  static class City {
      ArrayList<Integer> in, out;
      public City() {
          in = new ArrayList<>();
          out = new ArrayList<>();          
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
