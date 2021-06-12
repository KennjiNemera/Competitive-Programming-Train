import java.io.*;
import java.util.*;

public class BerSUball {
  public static void main(String[] args) throws IOException{
    FastReader fr = new FastReader();
    PrintWriter pr = new PrintWriter(new OutputStreamWriter(System.out));
    int n = fr.nextInt();

    int[] boys = new int[n];

    for (int i = 0; i < boys.length; i++) {
      boys[i] = fr.nextInt();
    }

    int m = fr.nextInt();

    int[] girls = new int[m];

    for (int i = 0; i < girls.length; i++) {
      girls[i] = fr.nextInt();
    }

    Arrays.sort(boys);
    Arrays.sort(girls);

    // perform a two pointer
    int i = 0;
    int j = 0;

    int count = 0;

    while(i < n && j < m) {
      if (Math.abs(boys[i] - girls[j]) <= 1) {
        count++;
        i++;
        j++;
      } else if (boys[i] < girls[j]) {
        i++;
      } else j++;
    }

    pr.println(count);
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
