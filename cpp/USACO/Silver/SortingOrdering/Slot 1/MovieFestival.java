import java.util.*;
import java.io.*;
import java.lang.reflect.Array;

public class MovieFestival {
  public static void main(String[] args) throws IOException {
    FastReader fr = new FastReader();    
    int n = fr.nextInt();
    Pair[] arr = new Pair[n];
    for (int i = 0; i < arr.length; i++) {
      arr[i] = new Pair(fr.nextInt(), fr.nextInt());
    }
    Arrays.sort(arr);
    int count = 0;
    int curEndtime = -1;
    for (int i = 0; i < arr.length; i++) {
      if (arr[i].x >= curEndtime) {
        count++;
        curEndtime = arr[i].y;
      }
    }
    System.out.println(count);
  }

  static class Pair implements Comparable<MovieFestival.Pair> {
    int x, y;
    public Pair(int x, int y) {
      this.x = x;
      this.y = y;
    }
    @Override
    public int compareTo(Pair o) {
      return y - o.y;
    }
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
