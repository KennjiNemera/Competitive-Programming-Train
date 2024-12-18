import java.io.*;
import java.util.*;

public class countinghaybales {
  public static void main(String[] args) throws IOException{
    FastReader fr = new FastReader();
    PrintWriter pr = new PrintWriter(new FileWriter(new File("haybales.out")));
    int n = fr.nextInt();
    int q = fr.nextInt();
    int[] arr = new int[n];

    for (int i = 0; i < arr.length; i++) {
      arr[i] = fr.nextInt();
    }

    Arrays.sort(arr);

    while (q-- > 0) {
      int a = fr.nextInt();
      int b = fr.nextInt();

      int dist = search(arr, a, b);

      pr.println(dist);
    }

    pr.close();
  }

  // routine binary search for edge bales on the indices
  static int search(int[] arr, int a, int b) {

    // search for a
    int low = 0;
    int high = arr.length - 1;
    int aPos = -1;
    while (low <= high) {
      int mid = (low + high) / 2;
      if (arr[mid] >= a) {
        aPos = mid;
        high = mid - 1;
      } else low = mid + 1;
    }

    if (aPos == -1) return 0;

    low = 0;
    high = arr.length-1;
    int bPos = -1;
    while (low <= high) {
      int mid = (low + high) / 2;
      if (arr[mid] <= b) {
        bPos = mid;
        low = mid + 1;
      } else high = mid - 1;
    }

    if (bPos == -1) return 0;

    return bPos - aPos + 1;
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
          br = new BufferedReader(new FileReader("haybales.in")); 
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
