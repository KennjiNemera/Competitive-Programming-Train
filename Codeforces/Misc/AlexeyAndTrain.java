import java.io.*;
import java.util.*;

public class AlexeyAndTrain {
  public static void main(String[] args) throws IOException{
    FastReader fr = new FastReader();
    PrintWriter pr = new PrintWriter(new OutputStreamWriter(System.out));
    int t = fr.nextInt();

    while (t-- > 0) {
      int n = fr.nextInt();
      int curtime = 0;
      Pair[] arr = new Pair[n];
      int[] extra = new int[n];

      for (int i = 0; i < n; i++) {
        arr[i] = new Pair(fr.nextInt(), fr.nextInt());
      }

      for (int i = 0; i < n; i++) {
        extra[i] = fr.nextInt();
      }

      // process each pair
      int pb = 0;

      for (int i = 0; i < extra.length; i++) {
        // add the arrival time
        int batch = 0;
        batch += arr[i].x - pb + extra[i];

        if (i == extra.length - 1 ) {
          curtime += batch;
          break;
        }

        // add the departure time
        double num = (arr[i].y-arr[i].x);
        batch += Math.ceil(num / 2.0);

        curtime += batch;

        // add for early edge case
        if (curtime < arr[i].y) {
          curtime += arr[i].y - curtime;
        }

        pb = arr[i].y;
      }

      pr.println(curtime);
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
