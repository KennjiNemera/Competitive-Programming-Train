import java.util.*;
import java.io.*;

public class SumOfTwoValues {
  public static void main(String[] args) throws IOException {
    FastReader fr = new FastReader();
    int n = fr.nextInt();
    if (n==1) {
      System.out.println("IMPOSSIBLE");
      return;
    }
    int k = fr.nextInt();
    Pair[] arr = new Pair[n];
    for (int i = 0; i < arr.length; i++) {
      arr[i] = new Pair(fr.nextInt(), i + 1);
    }
    Arrays.sort(arr);
    int L = 0;
    int R = n - 1;
    while (arr[L].val + arr[R].val != k) {
      if (arr[L].val + arr[R].val < k) L++;
      else R--;
      if (L == R) {
        System.out.println("IMPOSSIBLE");
        return;
      }
    }
    System.out.println(arr[L].ind + " " + arr[R].ind);
  }

  static class Pair implements Comparable<SumOfTwoValues.Pair> {
    int val, ind;
    public Pair(int val, int ind) {
      this.val = val;
      this.ind = ind;
    } 
    @Override
    public int compareTo(Pair o) {
      return val - o.val;
    }
  }
  
  static class FastReader 
  { 
      BufferedReader br; 
      StringTokenizer st; 

      public FastReader()
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
