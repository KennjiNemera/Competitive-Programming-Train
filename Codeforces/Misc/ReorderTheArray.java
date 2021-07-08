import java.io.*;
import java.util.*;

public class ReorderTheArray {
  public static void main(String[] args) throws IOException{
    FastReader fr = new FastReader();
    PrintWriter pr = new PrintWriter(new OutputStreamWriter(System.out));
    int n = fr.nextInt();

    int[] arr = new int[n];

    for (int i = 0; i < arr.length; i++) {
        arr[i] = fr.nextInt();
    }

    Arrays.sort(arr);

    ArrayList<Integer> offlimit = new ArrayList<>();

    int count = 0;
    int lo = -1;

    for (int i = 0; i < arr.length-1; i++) {
        int bn = binarysearch(arr[i], arr, lo);
        if (bn != -1) {
            offlimit.add(bn);
            lo = bn;
            count++;
        }
    }

    pr.println(count);
    pr.close();
  }

  static int binarysearch(int target, int[] arr, int i) {
    int lo = i + 1;
    int hi = arr.length - 1;
    int ans = -1;
    while (lo <= hi) {
        int mid = (lo + hi) / 2;
        if (arr[mid] > target) {
            hi = mid - 1;
            ans = mid;
        } else lo = mid + 1;
    }
    return ans;
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
