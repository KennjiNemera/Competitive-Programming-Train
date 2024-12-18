import java.io.*;
import java.util.*;

public class countinghaybales {
  public static void main(String[] args) throws IOException{
    FastReader fr = new FastReader();
    PrintWriter pr = new PrintWriter(new FileWriter(new File("haybales.out")));
    int n = fr.nextInt();
    int q = fr.nextInt();
    int[] vals = new int[n];
    
    for (int i = 0; i < n; i++) {
      int a = toInt(fr.next());
      vals[i] = a;
    }

    Arrays.sort(vals);

    while (q-- > 0) {
      int a = fr.nextInt();
      int b = fr.nextInt();

      pr.println(binaryrangesearch(a, b, vals));
    }

    pr.close();
  }

  static int binaryrangesearch(int a, int b, int[] vals) {
    int left = -1, right = -1;
    int low = 0, high = vals.length-1;
    while (low <= high) {
      int mid = (low + high) / 2;
      if (vals[mid] < a) {
        left = mid;
        low = mid + 1;
      } else {
        high = mid - 1;
      }
    }
    low = 0; high = vals.length - 1;
    while (low <= high) {
      int mid = (low + high) / 2;
      if (vals[mid] <= b) {
        right = mid;
        low = mid + 1;
      } else high = mid - 1;
    }
    return right - left;
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
