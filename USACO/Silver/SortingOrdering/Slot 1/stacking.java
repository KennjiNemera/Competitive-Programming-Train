import java.util.*;
import java.io.*;

public class stacking {
  public static void main(String[] args) throws IOException{
    FastReader fr = new FastReader();
    PrintWriter pr = new PrintWriter(new FileWriter(new File("stacking.out")));
    int n = fr.nextInt();
    int k = fr.nextInt();
    int[] arr = new int[n];

    while (k-- > 0) {
      int L = fr.nextInt()-1;
      int R = fr.nextInt()-1;
      for (int i = L; i <= R; i++) {
        arr[i] += 1;
      }
    }

    Arrays.sort(arr);
    int mid = ((n-1) / 2);
    pr.println(arr[mid]);
    pr.close();
  }

  static class FastReader 
  { 
      BufferedReader br; 
      StringTokenizer st; 

      public FastReader() throws FileNotFoundException 
      { 
          br = new BufferedReader(new FileReader("stacking.in")); 
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
