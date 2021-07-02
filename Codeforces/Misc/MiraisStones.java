import java.io.*;
import java.util.*;

public class MiraisStones {
  public static void main(String[] args) throws IOException{
    FastReader fr = new FastReader();
    PrintWriter pr = new PrintWriter(new OutputStreamWriter(System.out));
    int n = fr.nextInt();

    long[] arr = new long[n + 1];
    long[] sortedarr = new long[n + 1];

    long total = 0;
    for (int i = 0; i < n; i++) {
      int a = fr.nextInt();

      total += a;

      arr[i+1] = total;

      sortedarr[i+1] = a;
    }

    Arrays.sort(sortedarr);

    for (int i = 2; i <= n; i++) {
      sortedarr[i] += sortedarr[i-1];
    }

    int t = fr.nextInt();

    while (t-- > 0) {
      int type = fr.nextInt();
      int l = fr.nextInt();
      int r = fr.nextInt();

      if (type == 1) {
          pr.println(arr[r]-arr[l-1]);
      } else {
          pr.println(sortedarr[r]-sortedarr[l-1]);
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
