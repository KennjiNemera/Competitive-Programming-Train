import java.io.*;
import java.util.*;

public class PCL {

  static boolean[][] vis;
  static int n;
  static char[][] arr;
  static ArrayList<pPCL> pcls;
  static int colourCount = 0;

  public static void main(String[] args) throws IOException{
    FastReader fr = new FastReader();
    PrintWriter pr = new PrintWriter(new FileWriter(new File("where.out")));
    n = fr.nextInt();
    arr = new char[n][n];
    vis = new boolean[n][n];

    // IO routine
    for (int i = 0; i < arr.length; i++) {
      String in = fr.nextLine();
      for (int j = 0; j < arr.length; j++) {
        arr[i][j] = in.charAt(j);
      }
    }

    pcls = new ArrayList<>();

    // bruce force all possible subgrids and check if it is valid
    for (int i = 0; i < n; i++) { // low x
      for (int j = 0; j < n; j++) { // low y
        for (int k = i; k < n; k++) { // high x
          for (int l = j; l < n; l++) { // high y
            if (check(i, k, j, l, arr)) {
              pcls.add(new pPCL(i, j, k, l));
            }
          }  
        }
      }
    }

    // verify PCL's
    int ret = 0;
    for (int i = 0; i < pcls.size(); i++) {
      if (maximalPCL(i)) ret++; 
    }

    pr.println(ret);
    pr.close();  
  }

  static boolean maximalPCL(int i) {
    for (int j = 0; j < pcls.size(); j++) {
      if (j != i && within(i, j)) {
        return false;
      }
    }
    return true;
  }

  static boolean within(int x, int y) {
    // testing if x is in y
    return pcls.get(x).x1 >= pcls.get(y).x1 
      && pcls.get(x).x2 <= pcls.get(y).x2
      && pcls.get(x).y1 >= pcls.get(y).y1
      && pcls.get(x).y2 <= pcls.get(y).y2;
  }

  static boolean check(int x1, int x2, int y1, int y2, char[][] c) {
    int[] freq = new int[26];
    colourCount = 0;
    for (int i = x1; i <= x2; i++) {
      for (int j = y1; j <= y2; j++) {
        vis[i][j] = false;
      }
    }
    for (int i = x1; i <= x2; i++) {
      for (int j = y1; j <= y2; j++) {
        if (!vis[i][j]) {
          char chr = c[i][j];
          if (freq[chr - 'A'] == 0) colourCount++;
          freq[chr - 'A']++; // increment the frequency array
          // perform dfs
          dfs(i, j, x1, y1, x2, y2, chr);
        }
      }
    }

    // check if meets PCL constraints
    if (colourCount != 2) return false;

    boolean foundOne = false, foundMany = false;
    for (int i = 0; i < 26; i++) {
      if (freq[i] == 1) foundOne = true;
      if (freq[i] > 1) foundMany = true;
    }
    return foundMany && foundOne;
  }

  static void dfs(int x, int y, int lx, int ly, int rx, int ry, char c) {
    vis[x][y] = true;
    if (x > lx && arr[x-1][y] == c && !vis[x-1][y]) {
      dfs(x-1, y, lx, ly, rx, ry, c);
    } 
    if (x < rx && arr[x+1][y] == c && !vis[x+1][y]) {
      dfs(x+1, y, lx, ly, rx, ry, c);
    } 
    if (y > ly && arr[x][y-1] == c && !vis[x][y-1]) {
      dfs(x, y - 1, lx, ly, rx, ry, c);
    } 
    if (y < ry && arr[x][y+1] == c && !vis[x][y+1]) {
      dfs(x, y+1, lx, ly, rx, ry, c);
    } 
  }


  static class pPCL {
    int x1, y1, x2, y2;
    public pPCL(int x1, int y1, int x2, int y2) {
      this.x1 = x1;
      this.y1 = y1;
      this.x2 = x2;
      this.y2 = y2;
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
          br = new BufferedReader(new FileReader("where.in")); 
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
