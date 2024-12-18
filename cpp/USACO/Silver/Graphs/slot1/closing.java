import java.io.*;
import java.util.*;

public class closing {

  static int n, m;
  static ArrayList<ArrayList<Integer>> arr;
  static Set<Integer> dist;
  static ArrayList<Boolean> vis;
  static int connected;
  static PrintWriter pr;

  public static void main(String[] args) throws IOException{
    FastReader fr = new FastReader();
    pr = new PrintWriter(new FileWriter(new File("closing.out")));
    int n = fr.nextInt();
    int m = fr.nextInt();

    arr = new ArrayList<>();
    vis = new ArrayList<>();
    dist = new HashSet();

    for (int i = 0; i < n; i++) {
        arr.add(new ArrayList<>());
        vis.add(false);
    }

    // IO routine, build the map
    for (int i = 0; i < m; i++) {
        int a = fr.nextInt() - 1;
        int b = fr.nextInt() - 1;
        dist.add(a);
        dist.add(b);

        // add to adj list
        arr.get(a).add(b);
        arr.get(b).add(a);
    }

    // Process removals
    processCC();
    for (int i = 0; i < n-1; i++) {
        int remove = fr.nextInt()-1;
        remove(remove);
        processCC();
    }

    pr.close();
}

    static void remove(int a) {
        for (Integer child : arr.get(a)) {
            arr.get(child).remove((Integer)a);
        }
        dist.remove(a);
    }

    static void processCC() {
        connected = 0;
        Collections.fill(vis, false);
        dfs(getFirst());
        if (connected == dist.size()) {
            pr.println("YES");
        } else {
            pr.println("NO");
        }
    }

    static int getFirst() {
        int i = 0;
        while (i < 3000) {
            if (dist.contains((Integer) i)) {
                return i;
            }
            i++;
        }
        return -1;
    }

    static void dfs(int i) {
        vis.set(i, true);
        connected++;
        for (Integer child : arr.get(i)) {
            if (!vis.get(child)) {
                dfs(child);
            }
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
          br = new BufferedReader(new FileReader("closing.in")); 
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
