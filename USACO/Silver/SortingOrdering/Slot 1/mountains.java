import java.util.*;
import java.io.*;

public class mountains {
  public static void main(String[] args) throws IOException{
    FastReader fr = new FastReader();
    PrintWriter pr = new PrintWriter(new FileWriter(new File("mountains.out"))); 
    int n = fr.nextInt();
    Pair[] arr = new Pair[n];

    // IO routine
    for (int i = 0; i < arr.length; i++) {
        int x = fr.nextInt();
        int y = fr.nextInt();
        arr[i] = new Pair(x - y, x + y);
    }

    Arrays.sort(arr);

    // Process 
    long total = 1;
    long curEnd = arr[0].y;
    for (int i = 1; i < arr.length; i++) {
        while (i < n - 1  && arr[i].y <= curEnd) i++;
        if (arr[i].y > curEnd) total++;
        System.out.println(arr[i].x + " " + arr[i].y);
        curEnd = arr[i].y;
    }

    pr.println(total);
    pr.close();
  }

  static class Pair implements Comparable<mountains.Pair> {
      long x, y;
      public Pair (long x, long y) {
          this.x = x;
          this.y = y;
      }
      @Override
      public int compareTo(Pair o) {
          if (x == o.x) {
              return Long.compare(o.y, y);
          } else {
              return Long.compare(x, o.x);
          }
      }
  }

  static class FastReader 
    { 
        BufferedReader br; 
        StringTokenizer st; 
  
        public FastReader() throws FileNotFoundException 
        { 
            br = new BufferedReader(new FileReader(new File("mountains.in"))); 
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
