import java.io.*;
import java.util.*;

public class lightson {

  static int[][] arr, dir = {{1,0}, {-1,0}, {0,1}, {0,-1}};
  static int n, m, count;
  static boolean[][] vis;
  static Map<String, List<String>> map;

  public static void main(String[] args) throws IOException{
    FastReader fr = new FastReader();
    PrintWriter pr = new PrintWriter(new FileWriter(new File("lightson.out")));
    n = fr.nextInt(); m = fr.nextInt();

    arr = new int[n][n];
    vis = new boolean[n][n];
    map = new HashMap<>();

    // read in connections
    for (int i = 0; i < m; i++) {
      int a = fr.nextInt()-1, b = fr.nextInt()-1, c = fr.nextInt()-1, d = fr.nextInt()-1;
      String first = a + " " + b, last = c + " " + d;
      map.putIfAbsent(first, new ArrayList<>());
      map.putIfAbsent(last, new ArrayList<>());
      map.get(first).add(last);
    }

    // Perform a floodfill starting from 0,0
    count = 1;
    arr[0][0] = 1;
    dfs(0, 0);

    // perform a dfs on all the new additions
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        if (arr[i][j] == 1 && !vis[i][j]) {
          // System.out.println(i + " " + j + " :");
          boolean valid = false; // need to validate if it has a neighnour that is on and visited.
          for (int[] move : dir) {
            if (valid) break;
            int cx = i + move[0];
            int cy = j + move[1];
            if (!isValid(cx, cy)) continue;
            if (arr[cx][cy] == 1 && vis[cx][cy]) valid = true;
          }
          // System.out.println(valid);
          if (valid) {
            dfs(i, j);
            i = 0;
            j = 0;
          }
        }
      }
    }

    // for (int[] row : arr) {
    //   System.out.println(Arrays.toString(row));
    // }

    pr.println(count);
    pr.close();
  }

  static boolean isValid(int x, int y) {
    if (x < 0 || x >= n || y < 0 || y >= n) return false;
    return true;

  }

  static void dfs(int x, int y) {
    // Validate 
    if (x < 0 || x >= n || y < 0 || y >= n) return;
    if (arr[x][y] != 1) return;
    
    vis[x][y] = true;

    // set all connections to true -> inc count if any false
    for (String is : map.get(x + " " + y)) {
      String[] split = is.split(" ");
      int a = toInt(split[0]);
      int b = toInt(split[1]);

      // System.out.println(a + " " + b);

      if (arr[a][b] != 1) {
        count++;
        arr[a][b] = 1;
      }
    }

    // Run the standard floodfill
    for (int[] is : dir) {
      int cx = x + is[0];
      int cy = y + is[1];

      if (isValid(cx, cy) && arr[cx][cy] == 1 && !vis[cx][cy]) dfs(cx, cy);
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

  static int toInt(char c) {
    return Integer.parseInt(c + "");
  }

  static class FastReader 
  { 
      BufferedReader br; 
      StringTokenizer st; 

      public FastReader() throws FileNotFoundException 
      { 
          br = new BufferedReader(new FileReader("lightson.in")); 
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
