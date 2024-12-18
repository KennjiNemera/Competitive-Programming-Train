import java.util.*;
import java.io.*;

public class Towers {
  public static void main(String[] args) throws IOException{
    FastReader fr = new FastReader();
    int n = fr.nextInt();
    int[] arr = new int[n];
    int count = 0;
    while(n-- > 0) {
      int num = fr.nextInt();
      int search = binary(arr, count, num);
      if (search == -1) {
        arr[count] = num;
        count++;
      } else arr[search] = num; 
    }
    System.out.println(count);
  }

  static int binary(int[] arr, int R, int val) {
    R--;
    int ans = -1;
    int L = 0;
    while (L <= R) {
      int mid = L + ((R-L)/2);
      if (arr[mid] > val) {
        R = mid - 1;
        ans = mid;
      } else L = mid + 1;
    }
    return ans;
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
