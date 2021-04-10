import java.io.*;
import java.util.*;

public class B {
  public static void main(String[] args) throws IOException{
    FastReader fr = new FastReader();
    PrintWriter pr = new PrintWriter(new OutputStreamWriter(System.out));
    int t = fr.nextInt();

    while (t-- > 0) {
      int n = fr.nextInt();
      char[][] arr = new char[n][n];
      List<Pair> points = new ArrayList<>();
      for (int i = 0; i < n; i++) {
        char[] temp = fr.nextLine().toCharArray();
        for (int j = 0; j < temp.length; j++) {
            if (temp[j] == '*') {
              points.add(new Pair(i, j));
            }
        }
        arr[i] = temp;
      }

      int ax = points.get(0).x;
      int ay = points.get(0).y;
      int bx = points.get(1).x;
      int by = points.get(1).y;

      // check for any equality
      if (ax == bx || ay == by) {
        if (ax == bx) {
          if (ax == n-1) {
            arr[0][ay] = '*';
            arr[0][by] = '*';
          } else {
            arr[n-1][ay] = '*';
            arr[n-1][by] = '*';            
          }
        } else {
          if (ay == n-1) {
            arr[ax][0] = '*';
            arr[bx][0] = '*';
          } else {
            arr[ax][n-1] = '*';
            arr[bx][n-1] = '*';            
          }   
        }
      } else {
        arr[ax][by] = '*';
        arr[bx][ay] = '*';
      }

      // print out the array
      for (char[] a : arr) {
        for (char b : a) {
          pr.print(b);
        }
        pr.print("\n");
      }
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
