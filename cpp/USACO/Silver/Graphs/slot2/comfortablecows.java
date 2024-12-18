import java.io.*;
import java.util.*;

public class comfortablecows {

  static int[][] dir = {{1,0}, {-1,0}, {0,1}, {0,-1}};
  static boolean[][] vis = new boolean[3000][3000];
  static Queue<Pair> q;

  public static void main(String[] args) throws IOException{
    FastReader fr = new FastReader();
    PrintWriter pr = new PrintWriter(new OutputStreamWriter(System.out));
    int n = fr.nextInt();
    q = new LinkedList<>();
    int totalCows = 0;

    for (int i = 1; i <= n; i++) {
      Pair a = new Pair(fr.nextInt() + 1000, fr.nextInt() + 1000);
      q.offer(a);

      while (!q.isEmpty()) {
        Pair o = q.poll();
        if (vis[o.x][o.y]) continue;
        totalCows++;
        vis[o.x][o.y] = true;
        reevalutate(o.x, o.y);
        for (int[] move : dir) {
          int cx = o.x + move[0];
          int cy = o.y + move[1];

          reevalutate(cx, cy);
        }
      }

      pr.println(totalCows - i); // returns the number of cows that needs to be added
    }

    pr.close();
  }

  static void reevalutate(int x, int y) {
    if (!vis[x][y]) return;

    int num = 0;

    for (int i = 0; i < 4; i++) {
      if (vis[x + dir[i][0]][y + dir[i][1]]) num++;
    }

    if (num == 3) {
      for (int i = 0; i < dir.length; i++) {
        Pair add = new Pair(x + dir[i][0], y + dir[i][1]);
        if (!vis[add.x][add.y]) {
          q.offer(add);
        }
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
