import java.util.*;
import java.io.*;

public class reststops {
  public static void main(String[] args) throws IOException{
    FastReader fr = new FastReader();
    PrintWriter pr = new PrintWriter(new FileWriter(new File("reststops.out"))); 
    int l = fr.nextInt();
    int n = fr.nextInt();
    int fj = fr.nextInt();
    int b = fr.nextInt();

    ArrayList<Pair> arr = new ArrayList<>();

    for (int i = 0; i < n; i++) {
      arr.add(new Pair(fr.nextInt(), fr.nextInt()));
    }

    Collections.sort(arr, new comp());

    // for (Pair pair : arr) {
    //   System.out.println(pair.x + " " + pair.y);
    // }

    long lastStop = 0;
    long ans = 0;
    for (Pair pair : arr) {
      // System.out.println(lastStop);
      if (pair.x <= lastStop || pair.x >= l) continue;
      long dist = pair.x - lastStop;
      long timeSpare = (dist) * (fj - b);
      ans += (timeSpare * pair.y);
      lastStop = pair.x;
    }

    pr.println(ans);
    pr.close();
  }

  static class Pair{
      int x, y;
      public Pair (int x, int y) {
          this.x = x;
          this.y = y;
      }
  }

  static class comp implements Comparator<reststops.Pair> {
    public int compare(Pair a, Pair b) {
      if (b.y == a.y) {
          return Integer.compare(b.x, a.x);        
      } else {
          return Integer.compare(b.y, a.y);
      }
    }
  }

  static class FastReader 
    { 
        BufferedReader br; 
        StringTokenizer st; 
  
        public FastReader() throws FileNotFoundException 
        { 
            br = new BufferedReader(new FileReader(new File("reststops.in"))); 
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
