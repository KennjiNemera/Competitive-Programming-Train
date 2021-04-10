import java.io.*;
import java.util.*;

public class bcount {

  static int[][] arr;

  public static void main(String[] args) throws IOException{
    FastReader fr = new FastReader();
    PrintWriter pr = new PrintWriter(new FileWriter(new File("bcount.out")));
    int n = fr.nextInt(); int q = fr.nextInt();
    arr = new int[3][n];

    // compute the prefix sum
    for (int i = 0; i < n; i++) {
      int a = toInt(fr.nextLine());
      arr[a-1][i] = 1;
      for (int j = 0; j < 3; j++) {
        if (i > 0) {
          arr[j][i] += arr[j][i-1];          
        }
      }
    }

    for (int i = 0; i < q; i++) {
      int a = fr.nextInt()-1;
      int b = fr.nextInt()-1;
      for (int j = 0; j < 3; j++) {
        int value = 0;
        if (a == 0) {
          value = arr[j][b]; 
        } else {
          value = arr[j][b] - arr[j][a-1];
        }
        if (j == 2) {
          pr.print(value);
        } else pr.print(value + " ");
      }
      pr.println();
    }

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
          br = new BufferedReader(new FileReader("bcount.in")); 
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
