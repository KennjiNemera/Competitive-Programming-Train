import java.io.*;
import java.util.*;

public class buildingroads {

  static ArrayList<ArrayList<Integer>> map = new ArrayList<>();
  static ArrayList<Boolean> vis = new ArrayList<>();
  static ArrayList<Integer> lead = new ArrayList<>();
  static int n, m, cc;
  
  public static void main(String[] args) throws IOException{
    FastReader fr = new FastReader();
    PrintWriter pr = new PrintWriter(new OutputStreamWriter(System.out));
    n = fr.nextInt();
    m = fr.nextInt();

    for (int i = 0; i < n; i++) {
      map.add(new ArrayList<>());
      vis.add(false);
    }

    for (int i = 0; i < m; i++) {
      int a = fr.nextInt();
      int b = fr.nextInt();
      map.get(a-1).add(b);
      map.get(b-1).add(a);
    }

    for (int i = 0; i < n; i++) {
      if (!vis.get(i)) {
        cc++;
        lead.add(i + 1);
        dfs(i);
      }
    }

    System.out.println(cc-1);

    // we want to print the connections between all component leads
    if (cc > 1) {
      int u = lead.get(0);
      int v;
      for (int i = 1; i < cc; i++) {
        v = lead.get(i);
        pr.println(u + " " + v);
        u = v;
      }
    }

    pr.close();


  }

  static void dfs(int i) {
    vis.set(i, true);
    for (Integer val : map.get(i)) {
        if (!vis.get(val-1)) {
          dfs(val-1);
        }
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
