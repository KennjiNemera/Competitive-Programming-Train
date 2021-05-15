import java.io.*;
import java.util.*;

public class RobotSequence {
  public static void main(String[] args) throws IOException{
    FastReader fr = new FastReader();
    PrintWriter pr = new PrintWriter(new OutputStreamWriter(System.out));
    int n = fr.nextInt();
    Pair[] arr = new Pair[n];
    int x = 0;
    int y = 0;
    String s = fr.nextLine();

    for (int i = 0; i < n; i++) {
      char c = s.charAt(i);
      switch (c) {
        case 'U': y++; break;
        case 'R': x++; break;
        case 'L': x--; break;
        case 'D': y--; break;
      }
      arr[i] = new Pair(x, y);
    }

    // Here is the idea -> find all combinations

    int count = 0;
    
    for (int i = 0; i < arr.length; i++) {
      if (arr[i].x == 0 && arr[i].y == 0) {
        count++;
      }
      for (int j = i + 1; j < arr.length; j++) {
        if((arr[i].x - arr[j].x) == 0 && (arr[i].y - arr[j].y) == 0) {
          count++;
        }
      }
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
