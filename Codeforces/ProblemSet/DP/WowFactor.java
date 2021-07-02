import java.io.*;
import java.util.*;

public class WowFactor {
  public static void main(String[] args) throws IOException{
    FastReader fr = new FastReader();
    PrintWriter pr = new PrintWriter(new OutputStreamWriter(System.out));
    String s = fr.nextLine();

    long[] arr = new long[s.length()];

    // build the revelant w sum
    for (int i = 1; i < arr.length; i++) {
      if (s.charAt(i) == 'o') {
        arr[i] = arr[i-1];
      } else {
        if (s.charAt(i-1)=='v') {
          arr[i] = arr[i-1] + 1;
        } else arr[i] = arr[i-1];
      }
    }

    // for every o that acts as an anchor point we know that we can pair all the w's to the left of it to all the w's on the right of it.
    long sum = 0;
    for (int i = 2; i < arr.length; i++) {   
      if (s.charAt(i)=='o') {
        sum += Math.max(0,arr[i-1]) * Math.max((arr[s.length()-1]-arr[i-1]),0);
      }
    }

    pr.println(String.valueOf(sum));
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
