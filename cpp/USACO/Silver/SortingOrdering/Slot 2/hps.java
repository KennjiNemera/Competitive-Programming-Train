import java.io.*;
import java.util.*;

public class hps {
  public static void main(String[] args) throws IOException{
    FastReader fr = new FastReader();
    PrintWriter pr = new PrintWriter(new FileWriter(new File("hps.out")));
    int n = fr.nextInt();

    int[] l = new int[n];
    int[] reverse = new int[n];

    for (int i = 0; i < n; i++) {
      String s = fr.nextLine();
      if (s.equals("P")) l[i] = 1;
      else if (s.equals("H")) l[i] = 2;
      reverse[n - i - 1] = l[i]; 
    }

    int[][] matchPrefix = getMatch(l);
    int[][] matchSuffix = getMatch(reverse);

    // find the maximum yield
    int ret = 0;
    for (int a = 0; a <= n; a++) {
      for (int i = 0; i < 3; i++) {
        for (int j = 0; j < 3; j++) {
          ret = Math.max(ret, matchPrefix[i][a] + matchSuffix[j][n-a]);
        }
      }
    }

    pr.println(ret);
    pr.close();
  }

  static int[][] getMatch(int[] arr) {
    int[][] match = new int[3][arr.length + 1];
    // prefix sum generation of each move
    for (int i = 0; i < arr.length; i++) {
      for (int j = 0; j < 3; j++) {
        match[j][i+1] += match[j][i];
      }
      match[arr[i]][i+1]++;
    }
    return match;
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
          br = new BufferedReader(new FileReader("hps.in")); 
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
