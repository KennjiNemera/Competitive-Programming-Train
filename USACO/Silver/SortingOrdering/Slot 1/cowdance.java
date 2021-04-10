import java.io.*;
import java.util.*;

public class cowdance {
  public static void main(String[] args) throws IOException{
    FastReader fr = new FastReader();
    PrintWriter pr = new PrintWriter(new FileWriter(new File("cowdance.out")));
    int n = fr.nextInt();
    int tMax = fr.nextInt();
    int[] arr = new int[n];

    for (int i = 0; i < arr.length; i++) {
      arr[i] = fr.nextInt();
    }

    System.out.println(Arrays.toString(arr));

    int low = 1;
    int high = n;
    int lastMid = -1;

    while (low != high) {
      int mid = (low + high) / 2;
      if (mid == lastMid) break;
      if (sim(arr, mid, tMax)) {
        high = mid;
      } else {
        low = mid + 1;
      }
    }

    pr.println(low);
    pr.close();
  }

  static boolean sim(int[] arr, int k, int max) {
    int time = 0;
    PriorityQueue<Integer> pq = new PriorityQueue<>(); // will hold the cows 

    // because we know how large the arr can be, we use a for loop
    for (int i = 0; i < arr.length; i++) {
      if (pq.size() == k) {
        time = pq.poll();
      }
      if (time + arr[i] > max) {
        return false;
      }
      pq.add(time + arr[i]);
    }
    return true;
  }

  static class FastReader 
  { 
      BufferedReader br; 
      StringTokenizer st; 

      public FastReader() throws FileNotFoundException 
      { 
          br = new BufferedReader(new FileReader("cowdance.in")); 
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
