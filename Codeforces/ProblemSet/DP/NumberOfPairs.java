import java.io.*;
import java.util.*;

public class NumberOfPairs {

  static long[] arr;
  public static void main(String[] args) throws IOException{
    FastReader fr = new FastReader();
    PrintWriter pr = new PrintWriter(new OutputStreamWriter(System.out));
    int t = fr.nextInt();

    while (t-- > 0) {
      int n = fr.nextInt(), l = fr.nextInt(), r = fr.nextInt();

      arr = new long[n+1];

      for (int i = 0; i < n; i++) {
        arr[i] = fr.nextInt();
      }

      arr[n] = 1000000001;

      Arrays.sort(arr);
      // pr.println(Arrays.toString(arr));

      long total = 0;

      int low = n, high = n;
      for (int i = 0; i < arr.length; i++) {
        long a = arr[i];
        while (low > 0 && (arr[low - 1] + a) >= l) low--;
        while (high > 0 && (arr[high - 1] + a) > r) high--;
        total += high - low;
        if (arr[low] <= a && a < arr[high]) total--;
      }

      total /= 2;

      pr.println(total);
    }

    pr.close();
  }

  static int binarysearch(int i,int r) {
    int lo = i + 1;
    int hi = arr.length - 1;
    int ans = -1;

    while (lo <= hi) {
      int mid = (lo + hi) / 2;
      if (arr[mid] <= r) {
        lo = mid + 1;
        ans = mid;
      } else {
        hi = mid - 1;
      }
    }

    // return the length of the subsequence
    return ans == -1 ? i : ans;  
  }

  static class Pair {
      int x, y;
      public Pair(int x, int y) {
          this.x = x;
          this.y = y;
      }
  }

  static int toInt(String s) {
    return Integer.parseInt(s);
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
