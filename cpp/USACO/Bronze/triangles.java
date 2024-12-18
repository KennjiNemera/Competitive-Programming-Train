import java.io.*;
import java.util.*;

public class triangles {
  public static void main(String[] args) throws IOException{
    FastReader fr = new FastReader();
    PrintWriter pr = new PrintWriter(new FileWriter(new File("triangles.out")));
    int n = fr.nextInt();
    Pair[] arr = new Pair[n];

    for (int i = 0; i < arr.length; i++) {
      arr[i] = new Pair(fr.nextInt(), fr.nextInt()); 
    }

    // complete search for greatest area
    double max = 0;

    for (int i = 0; i < arr.length - 2; i++) {
      for (int j = 0; j < arr.length - 1; j++) {
        for (int k = 0; k < arr.length; k++) {
          Pair[] set = {arr[i], arr[j], arr[k]};
          double val = Math.abs(validSet(set));
          if (val == -1) continue;
          max = Math.max(max, val);
        }
      }
    }

    pr.println((int) max * 2);
    pr.close();
  }

  static double validSet(Pair[] a) {
    boolean foundX = false;
    boolean foundY = false;
    int base = 0;
    int height = 0;

    for (int i = 0; i < 2; i++) {
      for (int j = i+1; j < 3; j++) {
        if (!foundX && parallelX(a[i], a[j])) {
          foundX = true;
          base = Math.abs(a[j].y - a[i].y);
        } else if (!foundY && paralleyY(a[i], a[j])) {
          foundY = true;
          height = Math.abs(a[j].x - a[i].x);
        }
        if (foundX && foundY) {
          return (0.5 * base) * height;
        }
      }
    }

    return -1;
  }

  static boolean parallelX(Pair a, Pair b) {
    return a.x == b.x;
  }

  static boolean paralleyY(Pair a, Pair b) {
    return a.y == b.y;
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
          br = new BufferedReader(new FileReader("triangles.in")); 
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
