import java.util.*;
import java.io.*;

public class convention {
  public static void main(String[] args) throws IOException {
    FastReader fr = new FastReader();
    PrintWriter pr = new PrintWriter(new FileWriter(new File("convention.out")));
    int n = fr.nextInt();
    int m = fr.nextInt();
    int c = fr.nextInt();
    int[] arr = new int[n];

    for (int i = 0; i < arr.length; i++) {
      arr[i] = fr.nextInt();
    }

    Arrays.sort(arr);

    int lastmiddle = -1;
    int low = 0;
    int high = arr[n-1];
    while (low <= high) {
      int mid = (low + high) / 2;
      if (mid == lastmiddle) break;
      boolean bool = sim(arr, mid, m, c);
      if (bool) {
        high = mid;
      } else {
        low = mid;
      }
      lastmiddle = mid;
    }

    if (sim(arr, high, m, c)) {
      pr.println(high);
    } else pr.println(low);

    pr.close();
  }

  static boolean sim(int[] arr, int t, int m, int c) {
    int furlow = arr[0];
    int count = 0;
    for (int j = 0; j < arr.length; j++) {
      if (arr[j] - furlow > t || count == c) {
        count = 0;
        furlow = arr[j];
        m--;
      }
      count++;
    }
    m--;
    if (m < 0) return false;
    return true;
  }

  static class FastReader 
  { 
      BufferedReader br; 
      StringTokenizer st; 

      public FastReader() throws FileNotFoundException 
      { 
          br = new BufferedReader(new FileReader("convention.in")); 
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
