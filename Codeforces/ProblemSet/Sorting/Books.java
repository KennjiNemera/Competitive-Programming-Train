import java.io.*;
import java.util.*;

public class Books {
  public static void main(String[] args) throws IOException {
    FastReader fr = new FastReader();
    int n = fr.nextInt();
    int t = fr.nextInt();
    long[] arr = new long[n];
    arr[0] = fr.nextInt();

    for (int i = 1; i < arr.length; i++) {
      arr[i] = fr.nextInt();
    }

    int count = 0;
    int sum = 0;
    int k = 0;

    for (int i = 0; i < arr.length; i++) {
      sum += arr[i];
      if (sum <= t) {
        count++;
      } else {
        sum -= arr[k];
        k++;
      }
    }

    System.out.println(count);
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