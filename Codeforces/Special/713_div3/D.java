import java.io.*;
import java.util.*;

public class D {
  public static void main(String[] args) throws IOException{
    FastReader fr = new FastReader();
    PrintWriter pr = new PrintWriter(new OutputStreamWriter(System.out));
    int t = fr.nextInt();

    while (t-- > 0) {
      int n = fr.nextInt();
      int[] arr = new int[n + 2];
      Set<Integer> totals = new HashSet<>();
      int total = 0;
      for (int i = 0; i < n + 2; i++) {
        arr[i] = fr.nextInt();
      }

        Arrays.sort(arr);

      for (int i = 0; i < arr.length; i++) {
        total += arr[i];
        totals.add(total);
      }

      // find the two values
      int a = -1;
      int b = -1;
      StringBuilder sb = new StringBuilder();
      for (int i = 0; i < n - 1 && sb.length() == 0; i++) {
        if (totals.contains(arr[i] + arr[n+1])) {
          // print elements
          for (int j = 0; j < n + 1; j++) {
            if (j != i) {
              sb.append(arr[j] + " ");
            }
          }
        }
      }

      if (sb.length() != 0) {
        pr.println(sb.toString().substring(0, sb.length()));
      } else {
        pr.println("-1");
      }
    }

    pr.close();
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
