import java.util.*;
import java.io.*;

public class StuckInARut {
  public static void main(String[] args) throws IOException{
    FastReader fr = new FastReader();
    PrintWriter pr = new PrintWriter(new OutputStreamWriter(System.out));
    int n = fr.nextInt();
    // We need to sort the cows into a list of North and East cows
    ArrayList<Integer> northCows = new ArrayList<>();
    ArrayList<Integer> eastCows = new ArrayList<>();
    int[] xs = new int[n];
    int[] ys = new int[n];

    // Read in cow info
    for (int i = 0; i < n; i++) {
      if (fr.next().charAt(0) == 'E') {
        eastCows.add(i);
      } else northCows.add(i);
      xs[i] = fr.nextInt();
      ys[i] = fr.nextInt();
    }

    // Sort arraylists for iteration
    northCows.sort(Comparator.comparingInt(j -> xs[j]));
    eastCows.sort(Comparator.comparingInt(j -> ys[j]));

    // Array creating for status tracting
    boolean[] isStopped = new boolean[n];
    int[] amtStopped = new int[n];

    // Process each cow...
    for (int i : eastCows) {
      for (int k : northCows) {
        if (!isStopped[i] && !isStopped[k] && xs[i] < xs[k] && ys[k] < ys[i]) {
          // Handles the case of north reaching intersection first
          if (xs[k] - xs[i] > ys[i] - ys[k]) {
            isStopped[i] = true;
            amtStopped[k] += 1 + amtStopped[i];
          } 
          // Handles case of east reaching intersection first
          else if (xs[k] - xs[i] < ys[i] - ys[k]) {
            isStopped[k] = true;
            amtStopped[i] += 1 + amtStopped[k];
          }
        }
      }
    }
    for (int i : amtStopped) {
      pr.println(i);
    }
    pr.close();
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
