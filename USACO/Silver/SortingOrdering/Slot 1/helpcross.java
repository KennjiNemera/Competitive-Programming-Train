import java.util.*;
import java.io.*;

public class helpcross {
  public static void main(String[] args) throws IOException{
    FastReader fr = new FastReader();
    PrintWriter pr = new PrintWriter(new FileWriter(new File("helpcross.out")));
    int c = fr.nextInt();
    int n = fr.nextInt();
    int[] chickens = new int[c];

    // IO routine
    for (int i = 0; i < c; i++) {
      chickens[i] = fr.nextInt();
    }

    Arrays.sort(chickens);

    Pair[] cows = new Pair[n];

    for (int i = 0; i < cows.length; i++) {
      cows[i] = new Pair(fr.nextInt(), fr.nextInt());
    }

    Arrays.sort(cows);

    for (Pair pair : cows) {
      System.out.println(pair.x + " " + pair.y);
    }

    // Process
    int total = 0;
    for (int i = 0; i < cows.length; i++) {
      for (int j = 0; j < chickens.length; j++) {
        if (chickens[j] != -1 && chickens[j] >= cows[i].x && chickens[j] <= cows[i].y) {
          chickens[j] = -1;
          total++;
          break;
        }
      }
    }

    pr.println(total);
    pr.close();
  }

  static class Pair implements Comparable<helpcross.Pair> {
      int x, y;
      public Pair (int x, int y) {
          this.x = x;
          this.y = y;
      }
      @Override
      public int compareTo(Pair o) {
        if (y - x == o.y - o.x) {
          return Integer.compare(x, o.x);
        } else {
          return Integer.compare(y - x, o.y - o.x );
        }
      }
  }

  static class FastReader 
    { 
        BufferedReader br; 
        StringTokenizer st; 
  
        public FastReader() throws FileNotFoundException 
        { 
            br = new BufferedReader(new FileReader(new File("helpcross.in"))); 
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
