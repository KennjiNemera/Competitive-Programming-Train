import java.io.*;
import java.util.*;

public class socdist {
  public static void main(String[] args) throws IOException {
    FastReader fr = new FastReader();
    PrintWriter pr = new PrintWriter(new FileWriter(new File("socdist.out")));
    long n = fr.nextLong();
    int k = fr.nextInt();

    Pair[] arr = new Pair[k];

    // fill array with valid grass locations
    for (int i = 0; i < k; i++) {
      arr[i] = new Pair(fr.nextLong(), fr.nextLong());
    }

    Arrays.sort(arr, Comparator.comparingLong(o -> o.f));

    long low = 1;
    long high = (long) 1e18 + 1;

    while (low != high) {
      long mid = (low + high + 1) / 2;
      if (sim(arr, mid, n)) {
        low = mid;
      } else high = mid - 1;  
    }

    pr.println(low);
    pr.close();
  }

  static boolean sim(Pair[] arr, long d, long k) {
    long pos = arr[0].f; int ix = 0;
    for (int i = 1; i < k; i++) {
      if (pos + d > arr[ix].s) {
        while (arr[ix].f < pos + d && arr[ix].s < pos + d) {
          ix++;
          if (ix == arr.length) return false;
        }
        pos = Math.max(arr[ix].f, pos + d);
      } else {
        pos += d;
      }
    }
    return true;
  }

  static class Pair {
    long f,s;
    public Pair(long x, long y) {
      f = x;
      s = y;
    }
  }

  static class FastReader 
  { 
      BufferedReader br; 
      StringTokenizer st; 

      public FastReader() throws FileNotFoundException 
      { 
          br = new BufferedReader(new FileReader("socdist.in")); 
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