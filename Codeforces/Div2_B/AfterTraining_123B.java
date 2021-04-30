import java.io.*;
import java.util.*;

public class AfterTraining_123B {
  public static void main(String[] args) throws IOException{
    FastReader fr = new FastReader();
    PrintWriter pr = new PrintWriter(new OutputStreamWriter(System.out));
    int n = fr.nextInt();
    int m = fr.nextInt();
    ArrayList<Integer> arr = new ArrayList<>();

    int mid = ((m + 1) / 2);
    int left = mid - 1;
    int right = mid + 1;

    arr.add(mid);

    if (m % 2 == 0) {
        arr.add(mid + 1);
        right++;
    }
    
    while (left > 0 || right <= m) {
        if (left > 0) {
            arr.add(left);
        }

        left--;

        if (right <= m) {
            arr.add(right);
        }

        right++;
    }

    // print out sequence for all balls
    int count = 0;
    int cur = 0;

    while (count < n) {
        pr.println(arr.get(cur));
        cur++;
        count++;
        if (cur == m) cur = 0;
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
