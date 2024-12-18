import java.util.*;
import java.io.*;

public class MaxSubArraySum {
  public static void main(String[] args) throws IOException {
    FastReader fr = new FastReader();
    int n = fr.nextInt();
    long[] arr = new long[n];
    long sum = 0;
    long minpsum = 0;
    long max = Integer.MIN_VALUE;
    for (int i = 0; i < arr.length; i++) {
      sum += fr.nextLong();
      max = Math.max(max, sum - minpsum);
      minpsum = Math.min(minpsum, sum);
    }
    System.out.println(max);
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
