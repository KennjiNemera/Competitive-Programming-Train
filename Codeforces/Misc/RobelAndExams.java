import java.io.*;
import java.util.*;

public class RobelAndExams {
  public static void main(String[] args) throws IOException{
    FastReader fr = new FastReader();
    PrintWriter pr = new PrintWriter(new OutputStreamWriter(System.out));
    int n = fr.nextInt(), r = fr.nextInt(), avg = fr.nextInt();

    Pair[] arr = new Pair[n];

    double total = 0.0;

    for (int i = 0; i < arr.length; i++) {
        int a = fr.nextInt();
        int b = fr.nextInt();

        total += (a + 0.0);

        arr[i] = new Pair(a,b);
    }

    Arrays.sort(arr, new Comp());

    double def = total / (n + 0.0);
    long rem = Math.round(Math.max((((avg + 0.0) - def) * n),0));

    int curI = 0;
    long ans = 0;

    while (rem > 0) {
        if (arr[curI].x == r) {
            curI++;
        }
        long write = Math.min(rem, r - arr[curI].x);
        arr[curI].x += write;
        ans += (write * arr[curI].y);
        rem -= write;
    }

    pr.println(ans);
    pr.close();
  }

  static class Pair {
      int x, y;
      public Pair(int x, int y) {
          this.x = x;
          this.y = y;
      }
  }

  static class Comp implements Comparator<Pair> {
    public int compare(Pair a, Pair b) {
        return a.y - b.y;
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
