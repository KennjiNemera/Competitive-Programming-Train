import java.io.*;
import java.util.*;

public class mootube {

  static int n, q;
  static ArrayList<ArrayList<Pair>> arr;
  static Set<Integer> vis;
  static int curTotal;

  public static void main(String[] args) throws IOException{
    FastReader fr = new FastReader();
    PrintWriter pr = new PrintWriter(new FileWriter(new File("mootube.out")));
    n = fr.nextInt();
    q = fr.nextInt();
    vis = new HashSet();
    arr = new ArrayList<>();

    for (int i = 0; i < n; i++) {
      arr.add(new ArrayList<>());
    }

    // IO routine to build the map
    for (int i = 0; i < n-1; i++) {
      int a = fr.nextInt()-1;
      int b = fr.nextInt()-1;
      int r = fr.nextInt();

      // append adj list
      arr.get(a).add(new Pair(b, r));
      arr.get(b).add(new Pair(a, r));
    }

    // Query routine
    for (int i = 0; i < q ; i++) {
      int k = fr.nextInt();
      int v = fr.nextInt()-1;
      vis.clear();
      curTotal = 0;
      dfs(v, k, 1000000000);
      pr.println(curTotal);
    }

    pr.close();
  }

  static void dfs(int n, int k, int min) {
    vis.add(n);
    for (Pair child : arr.get(n)) {
      if (Math.min(child.rel, min) >= k && !vis.contains(child.vid)) {
        curTotal++;
        dfs(child.vid, k, Math.min(child.rel, min));
      }
    }
  }

  static class Pair {
      int vid, rel;
      public Pair(int x, int y) {
          vid = x;
          rel = y;
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
