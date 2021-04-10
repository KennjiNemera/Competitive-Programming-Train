import java.io.*;
import java.util.*;

public class rental {
  public static void main(String[] args) throws IOException{
    FastReader fr = new FastReader();
    PrintWriter pr = new PrintWriter(new FileWriter(new File("rental.out")));
    int n = fr.nextInt();
    int b = fr.nextInt();
    int c = fr.nextInt();

    Integer[] cows = new Integer[n];

    for (int i = 0; i < cows.length; i++) {
      cows[i] = fr.nextInt();
    }

    Arrays.sort(cows, Collections.reverseOrder());

    Pair[] shops = new Pair[b];

    for (int i = 0; i < shops.length; i++) {
      shops[i] = new Pair(fr.nextInt(), fr.nextInt());
    }

    Arrays.sort(shops);

    // create buyer list
    long[] buy = new long[n + 1];

    int index = 0;
    
    for (int i = 0; i < n; i++) {
      buy[i + 1] = buy[i];
      while (index < b && cows[i] > 0) {
        int use = Math.min(cows[i], shops[index].x);
        buy[i+1] += use * (long)shops[index].y;
        shops[index].x -= use;
        cows[i] -= use;
        if (shops[index].x == 0) index++;
      }
    }

    Integer[] neighbours = new Integer[c];

    for (int i = 0; i < neighbours.length; i++) {
      neighbours[i] = fr.nextInt();
    }

    Arrays.sort(neighbours, Collections.reverseOrder());

    int a = n - 1;
    int r = 0;
    long maxSum = 0;

    while (a >= 0 && r < c) {
      maxSum += neighbours[r];
      buy[a] += maxSum;
      a--;
      r++;
    }

    long max = 0;

    for (int j = 0; j < n; j++) {
      max = Math.max(max, buy[j]);
    }

    pr.println(max);
    pr.close();
  }

  static class Pair implements Comparable<rental.Pair> {
      int x, y;
      public Pair(int x, int y) {
          this.x = x;
          this.y = y;
      }
      @Override
      public int compareTo(Pair o) {
        return o.y - y;
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
          br = new BufferedReader(new FileReader("rental.in")); 
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
