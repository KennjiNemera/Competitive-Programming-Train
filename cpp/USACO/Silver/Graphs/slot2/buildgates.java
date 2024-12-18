import java.io.*;
import java.util.*;

public class buildgates {
  public static void main(String[] args) throws IOException{
    FastReader fr = new FastReader();
    PrintWriter pr = new PrintWriter(new FileWriter(new File("gates.out")));
    boolean[][] isFence = new boolean[2005][2005];
    int curX = 1002, curY = 1002;
    int n = fr.nextInt();
    String s = fr.nextLine();

    // populate the isFence array
    isFence[curX][curY] = true;

    for (char c : s.toCharArray()) {
      int dirX = 0, dirY = 0;
      switch (c) {
        case 'N': dirX = -1; break;
        case 'E': dirY = 1; break;
        case 'S': dirX = 1; break;
        case 'W': dirY = -1; break;
      }

      for (int i = 0; i < 2; i++) {
        curX += dirX;
        curY += dirY;
        isFence[curX][curY] = true;
      }
    }

    int ret = -1;
    int[][] dir = {{1,0}, {-1,0}, {0,1}, {0,-1}};
    // run flood fill over the fence
    for (int i = 0; i < isFence.length; i++) {
      for (int j = 0; j < isFence[i].length; j++) {
        if (isFence[i][j]) continue;
        
        Queue<Pair> q = new LinkedList<>();
        ret++; // we have a new component
        q.add(new Pair(i, j));

        isFence[i][j] = true;

        // run bfs over the q
        while (!q.isEmpty()) {
          Pair poll = q.poll();
          int cX = poll.x;
          int cY = poll.y;

          isFence[cX][cY] = true; // flood fills the array

          for (int[] d : dir) {
            int x = d[0] + cX;
            int y = d[1] + cY;
            // validate point
              // check if in bound and within the current rectangle
              if (x >= 0 && x < isFence.length && y >= 0 && y < isFence[x].length && !isFence[x][y]) {
                isFence[x][y] = true;
                q.offer(new Pair(x, y));
              }
          }
        }
      }
    }

    pr.println(ret);
    pr.close();  
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
