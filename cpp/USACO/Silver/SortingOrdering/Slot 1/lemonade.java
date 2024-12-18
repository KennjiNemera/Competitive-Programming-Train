import java.util.*;
import java.io.*;

public class lemonade {
  public static void main(String[] args) throws IOException {
    FastReader fr = new FastReader();
    PrintWriter pr = new PrintWriter(new FileWriter(new File("lemonade.out")));
    int n = fr.nextInt();
    Integer[] arr = new Integer[n];

    for (int i = 0; i < arr.length; i++) {
      arr[i] = fr.nextInt();
    }

    Arrays.sort(arr, Collections.reverseOrder());
    pr.println(binary(arr));
    pr.close();
  }  

  static int binary(Integer[] arr) {
    int ans = 0;
    int L = 0;
    int R = arr.length - 1;
    while (L <= R) {
      int mid = L + ((R-L)/2);
      if (arr[mid] >= mid) {
        ans = mid + 1;
        L = mid + 1;
      } else R = mid - 1;
    }
    return ans;
  }

  static class FastReader 
  { 
      BufferedReader br; 
      StringTokenizer st; 

      public FastReader() throws FileNotFoundException 
      { 
          br = new BufferedReader(new FileReader("lemonade.in")); 
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
