import java.util.*;
import java.io.*;

public class FactoryMachines {

  public static void main(String[] args) throws IOException {
    FastReader fr = new FastReader();
    int n = fr.nextInt();
    int t = fr.nextInt();
    int[] arr = new int[n];
    for (int i = 0; i < n; i++) {
      arr[i] = fr.nextInt();
    }
    Arrays.sort(arr);
    System.out.println(binary(arr, t));
  }

  static long binary(int[] arr, int t) {
    long ans = -1;
    long L = 0, R = (long) 1e18;
    while (L <= R) { 
      long mid = L + ((R-L) / 2); 
      long sum = 0;
      for (int i = 0; i < arr.length; i++) {
        sum += (mid / arr[i]);
        if (sum >= t) break; // deal with the overflow
      }
      if (sum >= t) { // number of products is greater 
        ans = mid;
        R = mid - 1;
      } else L = mid + 1;
    }
    return ans;
  }

  static class FastReader 
  { 
      BufferedReader br; 
      StringTokenizer st; 

      public FastReader()
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
