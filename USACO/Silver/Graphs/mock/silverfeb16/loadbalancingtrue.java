import java.io.*;
import java.util.*;

public class loadbalancingtrue {
  public static void main(String[] args) throws IOException{
    FastReader fr = new FastReader();
    PrintWriter pr = new PrintWriter(new FileWriter(new File("balancing.out")));
    int n = fr.nextInt();
    Pair[] arr = new Pair[n];

    // read in
    for (int i = 0; i < arr.length; i++) {
      arr[i] = new Pair(fr.nextInt(), fr.nextInt());
    }

    Arrays.sort(arr); // sorted by their x
    
    int ret = n;

    for (int i = 0; i < arr.length; i++) {
      ArrayList<Pair> above = new ArrayList<>();
      ArrayList<Pair> below = new ArrayList<>();

      for (int j = 0; j < arr.length; j++) {
        if (arr[j].y <= arr[i].y) {
          below.add(arr[j]);
        } else above.add(arr[j]);
      }

      int belowIndex = 0;
      int aboveIndex = 0;

      while (belowIndex < below.size() || aboveIndex < above.size()) {
        int xBorder = Integer.MAX_VALUE;
        if (belowIndex < below.size()) {
          xBorder = Math.min(xBorder, below.get(belowIndex).x);
        } 
        if (aboveIndex < above.size()) {
          xBorder = Math.min(xBorder, above.get(aboveIndex).x);
        }

        // handle duplicates with the same x value
        while (belowIndex < below.size() && below.get(belowIndex).x == xBorder) {
          belowIndex++; // move past duplicate fences
        }

        while (aboveIndex < above.size() && above.get(aboveIndex).x == xBorder) {
          aboveIndex++;
        }

        // update ret with the pair of x and y
        ret = Math.min(ret, Math.max(Math.max(belowIndex, below.size() - belowIndex), Math.max(aboveIndex, above.size() - aboveIndex)));
      }
    }

    pr.println(ret);
    pr.close();
  }

  static class Pair implements Comparable<loadbalancingtrue.Pair> {
      int x, y;
      public Pair(int x, int y) {
          this.x = x;
          this.y = y;
      }

      @Override
      public int compareTo(Pair o) {
        return x - o.x;
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
