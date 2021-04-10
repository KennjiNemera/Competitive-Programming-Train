import java.io.*;
import java.util.*;

public class angry {
  public static void main(String[] args) throws IOException {
    FastReader fr = new FastReader();
    PrintWriter pr = new PrintWriter(new FileWriter(new File("angry.out")));
    int n = fr.nextInt();
    int k = fr.nextInt();
    int[] arr = new int[n];

    for (int i = 0; i < arr.length; i++) {
      arr[i] = fr.nextInt();
    }

    Arrays.sort(arr);

    int min = 0;
    int max = 10;
    while (min != max) {
      System.out.println(min);
      int mid = min + (max - min) / 2;
      int used = 0;
      int last = 0;
      while (last < n) {
        int cur = last + 1;
        used++;
        while (cur < n && arr[cur] - arr[last] <= 2 * mid) {
          cur++;
        }
        last = cur;
      }
      if (used <= k) {
        max = mid;
      } else min = mid + 1;
    }

    pr.println(min);
    pr.close();
  }

  static class FastReader 
  { 
      BufferedReader br; 
      StringTokenizer st; 

      public FastReader() throws FileNotFoundException 
      { 
          br = new BufferedReader(new FileReader("angry.in")); 
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
