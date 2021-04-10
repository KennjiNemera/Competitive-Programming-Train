import java.io.*;
import java.util.*;

public class moocast {

  static boolean[] vis;
  static int count = 0;
  static Cow[] arr;
  public static void main(String[] args) throws IOException{
    FastReader fr = new FastReader();
    PrintWriter pr = new PrintWriter(new FileWriter(new File("moocast.out")));
    int n = fr.nextInt();
    arr = new Cow[n];
    vis = new boolean[n];

    for (int i = 0; i < arr.length; i++) {
      arr[i] = new Cow(fr.nextInt(), fr.nextInt(), fr.nextInt(), i);
    }

    // traverse through all possible cow pairs to run a dfs
    int max = 0;

    for (int i = 0; i < arr.length; i++) {
      Arrays.fill(vis, false);
      count = 0;
      dfs(i);
      max = Math.max(max, count);
    }

    pr.println(max);
    pr.close();
  }

  static void dfs(int node) {
    vis[node] = true;
    count++;
    for (Cow a : arr) {
      if (a.i == node) continue;
      if (vis[a.i]) continue;
      
      // check if in distance
      double dist = Math.pow(Math.abs(arr[node].x - a.x), 2) + Math.pow(Math.abs(arr[node].y - a.y), 2);
      dist = Math.sqrt(dist);

      // System.out.println(arr[node].p + " " + dist);

      if (Math.ceil(dist) <= arr[node].p) {
        // System.out.println("yes");
        dfs(a.i);
      }
    }
  }

  static class Cow {
      int x, y, p, i;
      public Cow(int x, int y, int p, int i) {
          this.x = x;
          this.y = y;
          this.p = p;
          this.i = i;
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
          br = new BufferedReader(new FileReader("moocast.in")); 
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
