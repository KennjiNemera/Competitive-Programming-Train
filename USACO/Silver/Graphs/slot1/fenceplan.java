import java.io.*;
import java.util.*;

public class fenceplan {

  static ArrayList<Pair> arr;
  static boolean[] vis;
  static int n, m, minPerim = Integer.MAX_VALUE;
  static int lX, lY, hX, hY;

  public static void main(String[] args) throws IOException{
    FastReader fr = new FastReader();
    PrintWriter pr = new PrintWriter(new FileWriter(new File("fenceplan.out")));
    n = fr.nextInt();
    m = fr.nextInt();

    arr = new ArrayList<>();
    vis = new boolean[n];

    // add the cows to the list
    for (int i = 0; i < n; i++) {
      arr.add(new Pair(fr.nextInt(), fr.nextInt(), i));
    }

    // build map 
    for (int i = 0; i < m; i++) {
      int a = fr.nextInt();
      int b = fr.nextInt();
      arr.get(a-1).neighbours.add(arr.get(b-1));
      arr.get(b-1).neighbours.add(arr.get(a-1));
    }

    // for (Pair o : arr) {
    //   System.out.println(o.index + " lead ");
    //   for (Pair a : o.neighbours) {
    //     System.out.println(a.index + " ");
    //   }
    // }

    // process the components
    for (int i = 0; i < n; i++) {
      if (!vis[i]) {
        lX = arr.get(i).x; lY = arr.get(i).y; hX = lX; hY = lY;
        dfs(arr.get(i));
        // check to see if we have found a smaller fence
        int perm = 2 * (Math.abs(hX - lX) + Math.abs(hY - lY));
        minPerim = Math.min(minPerim, perm);
      }
    }

    pr.println(minPerim);
    pr.close();

  }

  static void dfs(Pair o) {
    vis[o.index] = true;
    for (Pair pair : o.neighbours) {
      if (!vis[pair.index]) {
        lX = Math.min(lX, pair.x);
        lY = Math.min(lY, pair.y);
        hX = Math.max(hX, pair.x);
        hY = Math.max(hY, pair.y);    
        dfs(pair);
      }
    }
  }

  static class Pair {
    int x, y, index;
    ArrayList<Pair> neighbours;
    public Pair(int x, int y, int index) {
      this.x = x;
      this.y = y;
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
          br = new BufferedReader(new FileReader("fenceplan.in")); 
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
