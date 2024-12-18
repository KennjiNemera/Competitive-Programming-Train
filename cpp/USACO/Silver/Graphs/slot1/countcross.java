import java.io.*;
import java.util.*;

public class countcross {

  static Pair[] cows;
  static int[][] field; // init at MAX + 2 to account for the extra edges added for the fence
  static int[][] marked;
  static int n, r, k;
  static int a, b, c, d;
  static int[] dx = {-1, 0, 1, 0};
  static int[] dy = {0, 1, 0, -1};

  public static void main(String[] args) throws IOException{
    FastReader fr = new FastReader();
    PrintWriter pr = new PrintWriter(new FileWriter(new File("countcross.out")));
    n = fr.nextInt(); r = fr.nextInt(); k = fr.nextInt();

    marked = new int[n+2][n+2];
    field = new int[n+2][n+2];
    
    // I/O Routine on roads appending on cells to illustrate the walls surrounding a field
    for (int i = 0; i < r; i++) {
      a = fr.nextInt(); b = fr.nextInt(); c = fr.nextInt(); d = fr.nextInt();
      if (a == c) {
        if (b < d) {
          field[a][b] += 2; field[c][d] += 8;
        } else {
          field[a][b] += 8; field[c][d] += 2;
        }
      } else {
        if (a < c) {
          field[a][b] += 4; field[c][d] += 1;
        } else {
          field[a][b] += 1; field[c][d] += 4;
        }
      }
    }

    // Mark all of the edges as checked since the cows cant escape haha
    for (int i = 1; i <= n; i++) {
      marked[0][i] = 1;
      marked[i][0] = 1;
      marked[n+1][i] = 1;
      marked[i][n+1] = 1;
    }

    // Time to gather the cows, I suppose.
    cows = new Pair[k];
    for (int i = 0; i < k; i++) {
      cows[i] = new Pair(fr.nextInt(), fr.nextInt());
    }

    // Process the components the best way that I know: flood fill da ting
    int roomno = 0;
    for (int i = 1; i <= n; i++) {
      for (int j = 1; j <= n; j++) {
        if (marked[i][j] == 0) {
          floodfill(i, j, ++roomno);
        }
      }
    }

    // for each pair of cows check that they are in the same room or else inc answer
    int ans = 0;
    for (int i = 0; i < k; i++) {
      for (int j = i+1; j < k; j++) {
        // System.out.println(marked[cows[i].x][cows[i].y] + " " + marked[cows[j].x][cows[j].y] );
        if (marked[cows[i].x][cows[i].y] != marked[cows[j].x][cows[j].y]) {
          ans++;
        }
      }
    }

    for (int[] a : marked) {
      System.out.println(Arrays.toString(a));
    }

    pr.println(ans);
    pr.close();
  }

  static void floodfill(int i, int j, int room) {
    marked[i][j] = room;
    for (int k = 0; k < 4; k++) {
      int nr = i + dx[k];
      int ny = j + dy[k];

      if (marked[nr][ny] == 0 && ((field[i][j] & (1 << k)) == 0)) {
        floodfill(nr, ny, room);
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
          br = new BufferedReader(new FileReader("countcross.in")); 
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
