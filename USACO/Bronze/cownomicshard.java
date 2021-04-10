import java.io.*;
import java.util.*;

public class cownomicshard {

  static int[][] P, S;
  static int[] A = new int[64]; // will hold all subsets present for a 3-set of the spotty cows
  static int n, k;

  public static void main(String[] args) throws IOException{
    FastReader fr = new FastReader();
    PrintWriter pr = new PrintWriter(new FileWriter(new File("cownomics.out")));
    n = fr.nextInt();
    k = fr.nextInt();

    P = new int[n][k];
    S = new int[n][k];

    // IO routine that will store the values of the genome by: (A = 0, C = 1, G = 2, T = 3) -> Reason for the 0-index being that they will hold array places.

    for (int i = 0; i < n; i++) {
      String in = fr.nextLine();
      for (int j = 0; j < k; j++) {
        switch (in.charAt(j)) {
          case 'A': S[i][j] = 0; break;
          case 'C': S[i][j] = 1; break;
          case 'G': S[i][j] = 2; break;
          case 'T': S[i][j] = 3; break;
        }
      }
    }

    for (int i = 0; i < n; i++) {
      String in = fr.nextLine();
      for (int j = 0; j < k; j++) {
        switch (in.charAt(j)) {
          case 'A': P[i][j] = 0; break;
          case 'C': P[i][j] = 1; break;
          case 'G': P[i][j] = 2; break;
          case 'T': P[i][j] = 3; break;
        }
      }
    }

    int ans = 0;
    // Complete search for all possible 3-sets of cows
    for (int i = 0; i < k; i++) {
      for (int j = i+1; j < k; j++) {
        for (int l = j+1; l < k; l++) {
          if (testLocation(i, j, l)) ans++;
        }
      }
    }

    pr.println(ans);
    pr.close();
  }

  static boolean testLocation(int i, int j, int k) {
    // Set all subsets of the spotty cows to true
    for (int k2 = 0; k2 < n; k2++) {
      A[S[k2][i] * 16 + S[k2][j] * 4 + S[k2][k]] = 1;
    }

    // Check that the plain cows do not have the set
    boolean found = true;
    for (int l = 0; l < n; l++) {
      if (A[P[l][i] * 16 + P[l][j] * 4 + P[l][k]] == 1) found = false;
    }

    // reset the A-true sets before returning
    for (int l = 0; l < n; l++) {
      A[S[l][i] * 16 + S[l][j] * 4 + S[l][k]] = 0;
    }

    return found;
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
          br = new BufferedReader(new FileReader("cownomics.in")); 
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
