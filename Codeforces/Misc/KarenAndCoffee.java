import java.io.*;
import java.util.*;

public class KarenAndCoffee {
  public static void main(String[] args) throws IOException{
    FastReader fr = new FastReader();
    PrintWriter pr = new PrintWriter(new OutputStreamWriter(System.out));
    int n = fr.nextInt();
    int k = fr.nextInt();
    int q = fr.nextInt();

    int[] arr = new int[200000];

    for (int i = 0; i < n; i++) {
        int a = fr.nextInt()-1, b = fr.nextInt();
        arr[a] += 1;
        if (b != arr.length) {
            arr[b] += -1;
        }
    }

    // build the prefix

    int cur = 0;

    for (int i = 0; i < arr.length; i++) {
        cur += arr[i];
        arr[i] = 0;
        if (cur >= k) {
            arr[i] = i == 0 ? 1 : 1 + arr[i-1];
        } else arr[i] = i == 0 ? 0 : arr[i-1];
    }

    // pr.println(Arrays.toString(arr));

    for (int i = 0; i < q; i++) {
        int a = fr.nextInt()-1, b = fr.nextInt()-1;
        
        int tot = arr[b];

        tot -= a == 0 ? 0 : arr[a - 1];

        pr.println(tot);
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
