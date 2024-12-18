import java.io.*;
import java.util.*;

public class mooyo {
  
  static int[][] map;
  static int n, k, count = 0;
  static boolean[][] vis;
  static ArrayList<Comp> greater;
  static int[][] dir = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

  public static void main(String[] args) throws IOException{
    FastReader fr = new FastReader();
    PrintWriter pr = new PrintWriter(new FileWriter(new File("mooyomooyo.out")));
    
    n = fr.nextInt();
    k = fr.nextInt();

    map = new int[n][10];
    vis = new boolean[n][10];

    // IO routine
    for (int i = 0; i < n; i++) {
      String in = fr.nextLine();
        for (int j = 0; j < 10; j++) {
          map[i][j] = toInt(in.charAt(j) + "");
        }
    }

    greater = new ArrayList<>();

    do {      
      // fill the greater components with 0
      for (Comp a : greater) {
        fill(a.x, a.y, map[a.x][a.y]);
      }

      // might be space to improve time by trimming which columns we perform gravity on

      greater.clear();

      // perform gravity on the smaller components
      gravity();

      // perform a complete search on all non zero elements and build the components
      vis = new boolean[n][10];

      for (int i = 0; i < n; i++) {
        for (int j = 0; j < 10; j++) {
          if (!vis[i][j] && map[i][j] != 0) {
            count = 0;
            floodfill(i, j, map[i][j]);
            // assign to queue if count >= k
            if (count >= k) {
              greater.add(new Comp(i, j));
            }
          }
        }
      }
    } while (!greater.isEmpty());

    // print out the array
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < 10; j++) {
        pr.print(map[i][j]);
      }
      pr.println();
    }

    pr.close();
  }

  static void floodfill(int x, int y, int val) {
    if (!isValid(x, y)) return;
    if (vis[x][y]) return;
    
    count++;
    vis[x][y] = true;

    for (int[] is : dir) {
      int cx = x + is[0];
      int cy = y + is[1];

      if (isValid(cx, cy)) {
        if (map[cx][cy] == val) {
          floodfill(cx, cy, val);
        }
      }
    }
  }

  static void gravity() {

    int lowest = -1;

    for (int i = 0; i < 10; i++) {
      // find the lowest 0;
      for (int j = n - 1; j >= 0; j--) {
        if (map[j][i] == 0) {
          lowest = j;
          break;
        }
      }
      for (int j = lowest; j >= 0 && lowest != -1; j--) {
        if (map[j][i] != 0) {
          map[lowest][i] = map[j][i];
          map[j][i] = 0;
          lowest--;
        }
      }
    }
  }

  static class Comp {
      int x, y;
      public Comp(int x, int y) {
          this.x = x;
          this.y = y;
      }
  }

  static void fill(int x, int y, int val) {
    if (!isValid(x, y)) return;

    map[x][y] = 0;

    for (int[] is : dir) {
      int cx = x + is[0];
      int cy = y + is[1];

      if (isValid(cx, cy)) {
        if (map[cx][cy] == val) {
          fill(cx, cy, val);
        }
      }
    }
  }

  static boolean isValid(int x, int y) {
    if (x < 0 || x >= n || y < 0 || y >= 10) return false;
    return true;
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
          br = new BufferedReader(new FileReader("mooyomooyo.in")); 
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
