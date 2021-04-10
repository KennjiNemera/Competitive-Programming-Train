import java.io.*;
import java.util.*;

public class haybalestacking {
  public static void main(String[] args) throws IOException{
    FastReader fr = new FastReader();
    PrintWriter pr = new PrintWriter(new FileWriter(new File("stacking.out")));
    int n = fr.nextInt();
    int k = fr.nextInt();
    int[] dif = new int[n + 1];

    // this method uses the fact that we can compute the array by creating a difference between the endpoints of a range. if we know that we will inc from pos a to pos b then that means that the elements in this range will be affected using a prefix sum, denoted with a ++ at a and a -- at b + 1.

    // manipulating the endpoints is a O(1) operation that is more effienct than our solution based on incrementing each value in the range which with would be O(b - a)

    for (int i = 0; i < k; i++) {
        int a = fr.nextInt()-1;
        int b = fr.nextInt()-1;

        dif[a]++;
        dif[b+1]--;
    }

    // run over the array and build the output
    int[] data = new int[n];
    int val = 0;

    for (int i = 0; i < data.length; i++) {
        val += dif[i];
        data[i] = val;    
    }

    Arrays.sort(data);
    pr.println(data[n/2]);
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
          br = new BufferedReader(new FileReader("stacking.in")); 
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
