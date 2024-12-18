import java.util.*;
import java.io.*;

public class paintbarn {
  public static void main(String[] args) throws IOException {
    FastReader fr = new FastReader();
    PrintWriter pr = new PrintWriter(new FileWriter(new File("paintbarn.out")));
    int n = fr.nextInt();
    int k = fr.nextInt();
    int A = 0;
    int[][] arr = new int[1001][1001];

    // Function prepares rectangles
    for (int i = 0; i < n; i++) {
      int a = fr.nextInt()+1;
      int b = fr.nextInt()+1;
      int c = fr.nextInt()+1;
      int d = fr.nextInt()+1;

      arr[a][b]++;
      arr[c][d]++;
      arr[a][d]--;
      arr[c][b]--;
    }

    // 2d Prefix sum generation
    for (int i = 1; i < 1001; i++) {
      for (int j = 1; j < 1001; j++) {
        arr[i][j] += arr[i-1][j] + arr[i][j-1] - arr[i-1][j-1];
        if (arr[i][j] == k) A++;
      }
    }

    pr.println(A);
    pr.close();
  }
  
  static class FastReader 
  { 
      BufferedReader br; 
      StringTokenizer st; 

      public FastReader() throws FileNotFoundException 
      { 
          br = new BufferedReader(new FileReader("paintbarn.in")); 
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
