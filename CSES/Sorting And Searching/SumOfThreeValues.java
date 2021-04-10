import java.util.*;
import java.io.*;

public class SumOfThreeValues {
  public static void main(String[] args) throws IOException {
    FastReader fr = new FastReader();
    int n = fr.nextInt();
    int x = fr.nextInt();

    Pair[] arr = new Pair[n];

    for (int i = 0; i < arr.length; i++) {
      arr[i] = new Pair(fr.nextInt(), i+1);
    }

    Arrays.sort(arr);

    for (int i = 0; i < arr.length; i++) {
      int l = 0;
      int r = n - 1;
      while (l != r) {
        int sum = x - arr[i].val;
        if (l != i && r != i && arr[l].val + arr[r].val == sum) {
          System.out.println(arr[l].ind + " " + arr[r].ind + " " + arr[i].ind);
          return;
        }
        if (arr[l].val + arr[r].val < sum) {
          l++;
        } else r--;
      }
    }
    System.out.println("IMPOSSIBLE");
  }

  static class Pair implements Comparable<SumOfThreeValues.Pair> {
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
