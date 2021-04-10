import java.io.*;
import java.util.*;

public class danceshow {
  public static void main(String[] args) throws IOException{
    FastReader fr = new FastReader();
    PrintWriter pr = new PrintWriter(new FileWriter(new File("cowdance.out")));
    int n = fr.nextInt();
    int t = fr.nextInt();
    int[] arr = new int[n];

    for (int i = 0; i < arr.length; i++) {
      arr[i] = fr.nextInt();
    }

    int low = 1;
    int high = n;
    int lastMid = -1;

    while (low != high) {
      int mid = (low + high) / 2;
      if (mid == lastMid) break;
      if (valid(arr, mid, t)) {
        high = mid;
      } else low = mid + 1;
    }

    pr.println(low);
    pr.close();
  }

  static boolean valid(int[] arr, int size, int t) {
    PriorityQueue<Integer> pq = new PriorityQueue<>();
    int lasttime = 0;

    // System.out.println("Size: " + size);

    for (int i = 0; i < arr.length; i++) {
      if (pq.size() >= size) lasttime = pq.poll();

      if (lasttime + arr[i] > t) {
        return false;
      }

      pq.add(lasttime + arr[i]);
    }

    return true;
  }

  public static boolean possible(int[] l, int k, int t) {
		int lastTime = 0;
		PriorityQueue<Integer> q = new PriorityQueue<Integer>();
		for(int i = 0; i < l.length; i++) {
			if(q.size() == k) {
				lastTime = q.poll();
			}
			if(lastTime + l[i] > t) {
				return false;
			}
			q.add(lastTime + l[i]);
		}
		return true;
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
