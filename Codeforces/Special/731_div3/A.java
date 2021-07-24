import java.io.*;
import java.util.*;

public class A {

  // b2f188d2132fbda240758559dc39b7e87795eb828c9da882ec08d60d50b3a344
  public static void main(String[] args) throws IOException{
    FastReader fr = new FastReader();
    PrintWriter pr = new PrintWriter(new OutputStreamWriter(System.out));
    int t = fr.nextInt();

    while (t-- > 0) {
      Pair[] arr = new Pair[3];

      for (int i = 0; i < arr.length; i++) {
        arr[i] = new Pair(fr.nextInt(), fr.nextInt());
      }

      // ok there are 2 cases to this.
      // 1. If the either on the same x or y and F is on the path, then we add 3
      int x = Math.abs(arr[0].x - arr[1].x);
      int y = Math.abs(arr[0].y-arr[1].y);
      int init_dist = x + y;

      if (x == 0 && arr[2].x==arr[0].x && inrange(arr, 1)|| y == 0 && arr[2].y==arr[0].y && inrange(arr, 0)) {
        init_dist += 2;
      } 

      pr.println(init_dist);
    }

    pr.close();
  }

  static boolean inrange(Pair[] arr, int type) {
    if (type == 1) {
      return arr[2].y > Math.min(arr[0].y, arr[1].y) && arr[2].y < Math.max(arr[0].y, arr[1].y);
    } else {
      return arr[2].x > Math.min(arr[0].x, arr[1].x) && arr[2].x < Math.max(arr[0].x, arr[1].x);
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
