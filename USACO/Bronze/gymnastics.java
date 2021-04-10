import java.io.*;
import java.util.*;

public class gymnastics {
  public static void main(String[] args) throws IOException{
    FastReader fr = new FastReader();
    PrintWriter pr = new PrintWriter(new FileWriter(new File("gymnastics.out")));
    int k = fr.nextInt();
    int n = fr.nextInt();
    int[][] arr = new int[k][n];

    // IO routine
    for (int i = 0; i < k; i++) {
      String[] in = fr.nextLine().split(" ");
      for (int j = 0; j < n; j++) {
        arr[i][j] = toInt(in[j]);
      }
    }

    int total = 0;
    for (int i = 0; i < n-1; i++) {
      int a = arr[0][i];
      for (int j = i+1; j < n; j++) {
        int b = arr[0][j];
        if (isConsistant(arr, a, b)) {
          total++;
        } 
      }
    }
    pr.println(total);
    pr.close();
  }

  static boolean isConsistant(int[][] arr, int a, int b) {
    int countA = 0;
    int countB = 0;
    for (int i = 0; i < arr.length; i++) {
      for (int j = 0; j < arr[0].length; j++) {
        if (arr[i][j] == a) break;
        if (arr[i][j] == b) return false;
      }
    }
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
          br = new BufferedReader(new FileReader("gymnastics.in")); 
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
