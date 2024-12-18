import java.io.*;
import java.util.*;

public class blocks {
  public static void main(String[] args) throws IOException{
    FastReader fr = new FastReader();
    PrintWriter pr = new PrintWriter(new FileWriter(new File("blocks.out")));
    int n = fr.nextInt();
    int[][] arr = new int[n][26];

    for (int i = 0; i < arr.length; i++) {
      String[] in = fr.nextLine().split(" ");
      arr[i] = getFreq(in[0], in[1]);
    }

    // compare each array
    for (int i = 0; i < n-1; i++) {
      arr[i+1] = max(arr[i], arr[i+1]);
    }

    // Print the final arr
    for (Integer i : arr[n-1]) {
      pr.println(i);
    }

    pr.close();
  }

  static int[] max(int[] a, int[] b) {
    for (int i = 0; i < b.length; i++) {
      a[i] += b[i];
    }
    return a;
  }

  static int[] getFreq(String a, String b) {
    a = a.toUpperCase();
    b = b.toUpperCase();
    int[] wA = new int[26];
    int[] wB = new int[26];

    for (int i = 0; i < a.length(); i++) {
      wA[a.charAt(i) - 'A']++;
    }

    for (int i = 0; i < b.length(); i++) {
      wB[b.charAt(i) - 'A']++;
    }

    for (int i = 0; i < wB.length; i++) {
      wA[i] = Math.max(wA[i], wB[i]);
    }

    return wA;
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
          br = new BufferedReader(new FileReader("blocks.in")); 
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
