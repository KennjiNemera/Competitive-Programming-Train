import java.io.*;
import java.util.*;

public class socdist {
  public static void main(String[] args) throws IOException{
    FastReader fr = new FastReader();
    PrintWriter pr = new PrintWriter(new FileWriter(new File("socdist.out")));
    int n = fr.nextInt();
    int k = fr.nextInt();
    
    Pair[] arr = new Pair[k];

    for (int i = 0; i < arr.length; i++) {
      arr[i] = new Pair(fr.nextInt(), fr.nextInt());
    }

    Arrays.sort(arr);

    // perform binary search for the answer
    long low = 0;
    long high = Long.MAX_VALUE;
    long ans = 0;
    while (low <= high) {
      long mid = (low + high)/2;
      if (simulate(arr, mid, n)) { // store greatest valid answer
        low = mid + 1;
        ans = mid;
      } else {
        high = mid - 1;
      }
    }

    pr.println(ans);
    pr.close();
  }

  static boolean simulate(Pair[] arr, long k, long n) {
    int curLand = 0; 
    long count = 0, curPos = arr[0].x;
    while (count < n && curPos <= arr[arr.length-1].y) {
      if (curPos >= arr[curLand].x && curPos <= arr[curLand].y) { // handles case of us being in a valid range
        count++;
        curPos += k;
      } else {
        curLand++;
        if (curLand >= arr.length) break; // handles overflow
        if (curPos < arr[curLand].x) { // handles an increment that doesnt land on a new stick of grass
          curPos = arr[curLand].x;
        }
      }
    }
    return count >= n;
  }

  static class Pair implements Comparable<socdist.Pair> {
      long x, y;
      public Pair(long x, long y) {
          this.x = x;
          this.y = y;
      }

      @Override
      public int compareTo(Pair o) {
        return Long.compare(x, o.x);
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
          br = new BufferedReader(new FileReader("socdist.in")); 
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
