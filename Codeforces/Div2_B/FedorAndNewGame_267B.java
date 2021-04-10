import java.io.*;
import java.util.*;

public class FedorAndNewGame_267B {
  public static void main(String[] args) throws IOException{
    FastReader fr = new FastReader();
    PrintWriter pr = new PrintWriter(new OutputStreamWriter(System.out));
    int n = fr.nextInt();  
    int m = fr.nextInt();
    int k = fr.nextInt();

    int[] arr = new int[m];

    // IO Routine
    for (int i = 0; i < m; i++) {
        arr[i] = fr.nextInt();
    }

    int fedor = fr.nextInt();
    int total = 0;

    // Find the number of matching, true bits
    for (Integer i : arr) {
        int a = fedor ^ i;
        // System.out.println(a);
        int count = 0;
        while (a > 0) {
            // Test if the ith bit is set
            if ((a & 1) > 0) {
                count++;
            }
            a = a >> 1;
        }
        // System.out.println("C:" + count);
        if (count <= k) total++;
    }
    pr.println(total);
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
