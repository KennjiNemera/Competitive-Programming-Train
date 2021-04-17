import java.io.*;
import java.util.*;

public class PetyaAndStaircase_212B {
  public static void main(String[] args) throws IOException{
    FastReader fr = new FastReader();
    PrintWriter pr = new PrintWriter(new OutputStreamWriter(System.out));
    int n = fr.nextInt();
    int m = fr.nextInt();

    ArrayList<Integer> arr = new ArrayList<>();

    for (int i = 0; i < m; i++) {
      arr.add(fr.nextInt());
    }

    Collections.sort(arr);

    if (arr.contains(1) || arr.contains(n)) {
      pr.println("NO");
      pr.close();
      return;
    }

    for (int i = 0; i < m - 2; i++) {
      if (arr.get(i) == arr.get(i+1) - 1 && arr.get(i) == arr.get(i+2) - 2) {
        pr.println("NO");
        pr.close();
        return;
      }
    }

    pr.println("YES");
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
