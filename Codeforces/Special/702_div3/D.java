import java.io.*;
import java.util.*;

public class D {

  public static void main(String[] args) throws IOException{
    FastReader fr = new FastReader();
    PrintWriter pr = new PrintWriter(new OutputStreamWriter(System.out));
    int t = fr.nextInt();

    while (t-- > 0) {
      int n = fr.nextInt();
      int[] arr = new int[n];
      int[] posarr = new int[n];

      Arrays.fill(posarr, -1);

      int max = 0;
      
      for (int i = 0; i < arr.length; i++) {
        arr[i] = fr.nextInt();
        if (arr[i] > arr[max]) {
          max = i;
        }
      }

      // call a recursive funtion that works on the array
      push(arr, posarr, max, -1);

      for (int i : posarr) {
        pr.print(i + " ");
      }
      pr.print("\n");
    }

    pr.close();
  }

  static void push(int[] arr, int[] pos, int val, int parent) {
    pos[val] = parent + 1;

    // find the left max, find the right max
    int max = -1;
    for (int i = val - 1; i >= 0; i--) {
      if (pos[i] != -1) {
        break;
      }
      if (max == -1) max = i;
      if (arr[i] > arr[max]) {
        max = i;
      }
    }

    if (max != -1) {
      push(arr, pos, max, pos[val]);
    }

    // search on the right
    max = -1;
    for (int i = val + 1; i < arr.length; i++) {
      if (pos[i] != -1) break;
      if (max == -1) max = i;
      if (arr[i] > arr[max]) {
        max = i;
      }
    }

    if (max != -1) {
      push(arr, pos, max, pos[val]);
    }
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
