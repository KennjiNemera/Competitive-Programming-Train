import java.io.*;
import java.util.*;

public class FootballKit_246B {
  public static void main(String[] args) throws IOException{
    FastReader fr = new FastReader();
    PrintWriter pr = new PrintWriter(new OutputStreamWriter(System.out));
    int n = fr.nextInt();

    Pair[] arr = new Pair[n];

    Map<Integer, Integer> home = new HashMap<>();

    for (int i = 0; i < arr.length; i++) {
      int a = fr.nextInt();
      int b = fr.nextInt();
      arr[i] = new Pair(a, b);

      home.putIfAbsent(a, 0);
      home.put(a, home.get(a) + 1);

      home.putIfAbsent(b, 0);
    }

    // brute force
    for (int i = 0; i < arr.length; i++) {
      arr[i].home += n - 1;
      int same = home.get(arr[i].y);
      arr[i].away += n - same - 1;
      arr[i].home += same;
    }

    for (int i = 0; i < arr.length; i++) {
      pr.println(arr[i].home + " " + arr[i].away);
    }

    pr.close();
  }

  static class Pair {
      int x, y;
      int home, away;
      public Pair(int x, int y) {
          this.x = x;
          this.y = y;
          home = 0;
          away = 0;
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
