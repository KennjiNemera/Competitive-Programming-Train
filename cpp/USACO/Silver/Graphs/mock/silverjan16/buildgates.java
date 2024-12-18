import java.io.*;
import java.util.*;

public class buildgates {

  static int curX = 1002, curY = 1002;
  static int[][] dir = {{1,0}, {0, 1}, {-1, 0}, {0, -1}};
  static boolean[][] vis = new boolean[2005][2005];
  public static void main(String[] args) throws IOException{
    FastReader fr = new FastReader();
    PrintWriter pr = new PrintWriter(new FileWriter(new File("gates.out")));
    int n = fr.nextInt();
    String in = fr.nextLine();
    vis[curX][curY] = true;
    for (int i = 0; i < n; i++) {
      char c = in.charAt(i);
      for (int j = 0; j < 2; j++) {
        switch (c) {
          case 'N': 
            curX -= 1;
            break;
          case 'E':
            curY += 1;
            break;
          case 'S':
            curX += 1;
            break;
          case 'W':
            curY -= 1;
            break;
        }  
        vis[curX][curY] = true;      
      }
    }

    // run a flood fill counting the components
    int count = 0;

    for (int i = 0; i < vis.length; i++) {
      for (int j = 0; j < vis[i].length; j++) {
        if (!vis[i][j]) {
          Queue<Pair> q = new LinkedList<>();
          q.offer(new Pair(i, j));
          count++;
          vis[i][j] = true;

          while (!q.isEmpty()) {
            Pair o = q.poll();

            vis[o.x][o.y] = true;

            for (int[] move : dir) {
              int cx = o.x + move[0];
              int cy = o.y + move[1];

              if (isvalid(cx, cy)) {
                if (!vis[cx][cy]) {
                  vis[cx][cy] = true;
                  q.offer(new Pair(cx,cy));
                }
              }
            }
          }
        }
      }
    }

    pr.println(count - 1);
    pr.close();
  }

  static boolean isvalid(int x, int y) {
    if (x < 0 || x >= 2005 || y < 0 || y >= 2005) return false;
    return true;
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
          br = new BufferedReader(new FileReader("gates.in")); 
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
