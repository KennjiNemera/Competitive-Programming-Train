import java.util.*;
import java.io.*;

public class div7 {
  public static void main(String[] args) throws IOException {
    FastReader fr = new FastReader();
    PrintWriter pr = new PrintWriter(new FileWriter(new File("div7.out")));
    int n = fr.nextInt();
    int[] arr = new int[n];

    int total = 0;
    for (int i = 0; i < arr.length; i++) {
      total += fr.nextInt();
      arr[i] = total;
    }

    // perform complete search for the largest set
    int max = 0;
    for (int i = 0; i < n-1; i++) {
      for (int j = n - 1; j >= i + 1; j--) {
        if (j - i < max) break;
        if ((arr[j] - arr[i]) % 7 == 0) {
          max = Math.max(max, j - i);
        }
      }      
    }

    pr.println(max);
    pr.close();
  }

  static class FastReader 
  { 
      BufferedReader br; 
      StringTokenizer st; 

      public FastReader() throws FileNotFoundException 
      { 
          br = new BufferedReader(new FileReader("div7.in")); 
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
