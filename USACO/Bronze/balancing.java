import java.io.*;
import java.util.*;

public class balancing {

  static int[] xpos, ypos;
  public static void main(String[] args) throws IOException{
    FastReader fr = new FastReader();
    PrintWriter pr = new PrintWriter(new FileWriter(new File("balancing.out")));
    int n = fr.nextInt();
    int b = fr.nextInt();

    xpos = new int[n];
    ypos = new int[n];

    for (int i = 0; i < n; i++) {
      xpos[i] = fr.nextInt();
      ypos[i] = fr.nextInt();
    }

    int min = n;

    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        int xCo = xpos[i]+1;
        int yCo = ypos[j]+1;
        int max = countMax(xCo, yCo);
        min = Math.min(min, max);
      }
    }

    pr.println(min);
    pr.close();
  }

  static int countMax(int x, int y) {
    int[] freq = new int[4];
    for (int i = 0; i < xpos.length; i++) {
      if (xpos[i] > x && ypos[i] > y) freq[0]++;
      else if (xpos[i] < x && ypos[i] > y) freq[1]++;
      else if (xpos[i] < x && ypos[i] < y) freq[2]++;
      else freq[3]++;
    }

    int max = -1;
    for (int i = 0; i < freq.length; i++) {
      max = Math.max(max, freq[i]);
    }
    return max;
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
          br = new BufferedReader(new FileReader("balancing.in")); 
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
