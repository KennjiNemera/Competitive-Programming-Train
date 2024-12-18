import java.io.*;
import java.util.*;

public class loadbalancing {
  public static void main(String[] args) throws IOException{
    FastReader fr = new FastReader();
    PrintWriter pr = new PrintWriter(new FileWriter(new File("balancing.out")));
    int n = fr.nextInt();
    ArrayList<Pair> arr = new ArrayList<>(); // store Pair objects that hold co-ordiantes for each cow

    // Read and Store Input 
    for (int i = 0; i < n; i++) {
      arr.add(new Pair(fr.nextInt(), fr.nextInt()));
    }

    // Sort the Objects by their x value
    Collections.sort(arr, new CompX());


    // run a sweep over the sorted x's
    int mid = n / 2;
    if (mid != 0) mid--;
    int x = arr.get(mid).x + 1; // set the vertical fence to the x value of the median object.
    
    // Sort the objects by their y values
    Collections.sort(arr, new CompY());

    // Run a sweep over the y elements
    mid = n / 2;
    if (mid != 0) mid--;
    int y = arr.get(mid).y + 1; // set the horizontal fence to the y value of the median

    // initialize array to store quadrant count
    int[] totals = new int[4];

    // For each object. Determine it's quadrant and increment relevant count
    for (Pair a : arr) {
      if (a.x < x && a.y < y) totals[3]++;
      else if (a.x > x && a.y < y) totals[0]++;
      else if (a.x < x && a.y > y) totals[2]++;
      else totals[1]++;
    }

    int ret = 0; // will store max quadrant value;

    // search for the maximum quadrant tally in the total's array.
    for (int i = 0; i < totals.length; i++) {
      ret = Math.max(ret, totals[i]);
    }

    pr.println(ret);
    pr.close();
  }

  static class CompX implements Comparator<loadbalancing.Pair> {
    @Override
    public int compare(Pair o, Pair p) {
      return Integer.compare(o.x, p.x);
    }
  }

  static class CompY implements Comparator<loadbalancing.Pair> {
    @Override
    public int compare(Pair o, Pair p) {
      return Integer.compare(o.y, p.y);
    }
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
