import java.io.*;
import java.util.*;

public class perimeter {

  static int area, perim, curArea, curPerim;  
  static boolean[][] vis;
  public static void main(String[] args) throws IOException{
    FastReader fr = new FastReader();
    PrintWriter pr = new PrintWriter(new FileWriter(new File("perimeter.out")));
    int n = fr.nextInt();
    char[][] arr = new char[n][n];
    vis = new boolean[n][n];

    for (boolean[] cs : vis) {
        Arrays.fill(cs, false);
    }

    // I/O routine
    for (int i = 0; i < n; i++) {
        String in = fr.nextLine();
        for (int j = 0; j < n; j++) {
            arr[i][j] = in.charAt(j);
        }
    }

    // Loop through
    int area = 0;
    int perim = 0;

    for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
            if (arr[i][j] == '#' && !vis[i][j]) {
                curArea = 0;
                curPerim = 0;
                process_blob(arr, i, j);
                if (curArea >= area) {
                    if (curArea == area && curPerim < perim) {
                         perim = curPerim;
                    } else {
                        area = curArea;
                        perim = curPerim;
                    }
                }
            }
        }
    }

    pr.print(area + " " + perim);
    pr.close();
    
  }

  // Algo

  /* 
    for this to work we need to do the following:
        check that the coords are in bounds 
        update perimeter
        check that we are still in the ice cream blob
        
        update the current block so we dont visit it again
  */

  static void process_blob(char[][] arr, int x, int y) {
    if (x < 0 || x >= arr.length || y < 0 || y >= arr.length) {
        curPerim++;
        return;
    }
    if (arr[x][y] == '.' && !vis[x][y]) {
        curPerim++;
        return;
    } else if (vis[x][y]) {
        return;
    }

    vis[x][y] = true;
    arr[x][y] = '.';
    curArea++;

    process_blob(arr, x+1, y);
    process_blob(arr, x-1, y);
    process_blob(arr, x, y+1);
    process_blob(arr, x, y-1);
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
          br = new BufferedReader(new FileReader("perimeter.in")); 
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
