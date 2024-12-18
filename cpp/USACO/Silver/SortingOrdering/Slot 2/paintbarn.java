import java.io.*;
import java.util.*;

public class paintbarn {
  public static void main(String[] args) throws IOException{
    FastReader fr = new FastReader();
    PrintWriter pr = new PrintWriter(new FileWriter(new File("paintbarn.out")));
    int[][] arr = new int[1001][1001];
    int n = fr.nextInt();
    int k = fr.nextInt();

    while (n-- > 0) {
      int a = fr.nextInt();
      int b = fr.nextInt();
      int c = fr.nextInt();
      int d = fr.nextInt();
      
      arr[a][b]++;
      arr[a][d]--;
      arr[c][d]++;
      arr[c][b]--;
    }

    // perform a 2d prefix sum over the array
    int ret = 0;
    for (int i = 0; i < 1000; i++) {
      for (int j = 0; j < 1000; j++) {
        if (i != 0) arr[i][j] += arr[i-1][j];
        if (j != 0) arr[i][j] += arr[i][j-1];
        if (i != 0 && j != 0) arr[i][j] -= arr[i-1][j-1];
        if (arr[i][j] == k) ret++;
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
          br = new BufferedReader(new FileReader("paintbarn.in")); 
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
