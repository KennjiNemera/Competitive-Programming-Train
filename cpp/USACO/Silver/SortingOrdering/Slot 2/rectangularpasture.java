import java.io.*;
import java.util.*;

public class rectangularpasture {

  static int[][] psum;

  static int getSum(int x1, int y1, int x2, int y2) {
    return psum[x2+1][y2+1] - psum[x2+1][y1] - psum[x1][y2+1] + psum[x1][y1];
  }
  public static void main(String[] args) throws IOException{
    FastReader fr = new FastReader();
    PrintWriter pr = new PrintWriter(new OutputStreamWriter(System.out));
    int n = fr.nextInt();

    Pair[] arr = new Pair[n];

    for (int i = 0; i < arr.length; i++) {
      arr[i] = new Pair(fr.nextInt(), fr.nextInt());
    }

    Arrays.sort(arr, (a, b) -> a.x - b.x);

    for (int i = 0; i < arr.length; i++) {
      arr[i].x = i + 1;
    }

    Arrays.sort(arr, (a, b) -> a.y - b.y);

    for (int i = 0; i < arr.length; i++) {
      arr[i].y = i + 1;
    }

    psum = new int[n+1][n+1];

    for (int i = 0; i < n; i++) {
      psum[arr[i].x][arr[i].y] = 1;
    }

    // generate 2d prefix sum
    for (int i = 1; i < psum.length; i++) {
      for (int j = 1; j < psum.length; j++) {
        psum[i][j] = psum[i][j] + psum[i-1][j] + psum[i][j-1] - psum[i-1][j-1]; 
      }
    }

    long ans = n;

    for (int i = 0; i < n; i++) {
      for (int j = i + 1; j < n; j++) {
        int x1 = Math.min(arr[i].x, arr[j].x) - 1;
        int x2 = Math.max(arr[i].x, arr[j].x) - 1;

        ans += getSum(0, i, x1, j) * getSum(x2, i, n - 1, j);
      }
    }

    pr.println(ans+1);
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
