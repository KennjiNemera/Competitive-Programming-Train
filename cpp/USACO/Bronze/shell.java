import java.io.*;
import java.util.*;

public class shell {
  public static void main(String[] args) throws IOException{
    FastReader fr = new FastReader();
    PrintWriter pr = new PrintWriter(new FileWriter(new File("shell.out")));
    int n = fr.nextInt();
    // Placement setup routine
    int[] freq = new int[3];
    int[] shells = new int[n];

    for (int i = 1; i <= n; i++) {
      shells[i-1] = i;
    }

    for (int j = 0; j < n; j++) {
      int a = fr.nextInt(), b = fr.nextInt(), c = fr.nextInt();
      int temp = shells[a-1];
      shells[a-1] = shells[b-1];
      shells[b-1] = temp;  
      freq[shells[c-1]-1]++;
    }

    System.out.println(Arrays.toString(freq));

    int max = 0;
    for (int i = 0; i < freq.length; i++) {
      max = Math.max(freq[i], max);
    }

    pr.println(max);
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
          br = new BufferedReader(new FileReader("shell.in")); 
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
