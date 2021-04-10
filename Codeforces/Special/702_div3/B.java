import java.io.*;
import java.util.*;

public class B {
  public static void main(String[] args) throws IOException{
    FastReader fr = new FastReader();
    PrintWriter pr = new PrintWriter(new OutputStreamWriter(System.out));
    int t = fr.nextInt();

    while (t-- > 0) {
      int n = fr.nextInt();
      int[] div = new int[3];
      int max = 0;

      for (int i = 0; i < n; i++) {
        int next = fr.nextInt();
        div[next % 3]++;
        if (div[max] < div[next % 3]) {
          max = next % 3;
        }
      }

      // System.out.println("Round: " + t);
      // System.out.println(n);

      // count moves to make them =
      int count = 0;

      while (!isEqual(div)) {
        count++;
        switch (max) {
          case 2:
            div[2]--;
            div[0]++;
            break;
          default:
            div[max]--;
            div[max + 1]++;
        }
        max = findMax(div);
        // System.out.println(Arrays.toString(div));
      }

      pr.println(count);
    }

    pr.close();
  }

  static int findMax(int[] div) {
    int max = 0;
    for (int i = 0; i < div.length; i++) {
      if (div[max] < div[i]) {
        max = i;
      }
    }
    return max;
  }

  static boolean isEqual(int[] arr) {
    int val = arr[0];
    for (int i = 0; i < arr.length; i++) {
      if (arr[i] != val) return false;
    }
    return true;
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
