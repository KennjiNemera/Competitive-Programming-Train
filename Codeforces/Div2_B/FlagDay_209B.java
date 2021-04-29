import java.io.*;
import java.util.*;

public class FlagDay_209B {
  public static void main(String[] args) throws IOException{
    FastReader fr = new FastReader();
    PrintWriter pr = new PrintWriter(new OutputStreamWriter(System.out));
    int n = fr.nextInt();
    int m = fr.nextInt();

    Integer[] arr = new Integer[n];

    for (int i = 0; i < m; i++) {
        int x = fr.nextInt();
        int y = fr.nextInt();
        int z = fr.nextInt();

        if (arr[x-1] != null) {
          switch(arr[x-1]) {
            case 1:
              arr[y-1] = 2;
              arr[z-1] = 3;
              break;
            case 2:
              arr[y-1] = 1;
              arr[z-1] = 3;
              break;
            case 3:
              arr[y-1] = 1;
              arr[z-1] = 2;
              break;
          }
        } else if (arr[y-1] != null) {
          switch(arr[y-1]) {
            case 1:
              arr[x-1] = 2;
              arr[z-1] = 3;
              break;
            case 2:
              arr[x-1] = 1;
              arr[z-1] = 3;
              break;
            case 3:
              arr[x-1] = 1;
              arr[z-1] = 2;
              break;
          }
        } else if (arr[z-1] != null) {
          switch(arr[z-1]) {
            case 1:
              arr[x-1] = 2;
              arr[y-1] = 3;
              break;
            case 2:
              arr[x-1] = 1;
              arr[y-1] = 3;
              break;
            case 3:
              arr[x-1] = 1;
              arr[y-1] = 2;
              break;
          }
        } else {
          arr[x-1] = 1;
          arr[y-1] = 2;
          arr[z-1] = 3; 
        }
    }

    for (Integer integer : arr) {
      pr.print(integer + " ");
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
