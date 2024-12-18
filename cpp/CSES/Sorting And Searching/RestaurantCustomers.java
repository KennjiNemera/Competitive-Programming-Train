import java.util.*;
import java.io.*;

public class RestaurantCustomers {
  public static void main(String[] args) {
    FastReader fr = new FastReader();
    int n = fr.nextInt();
    int[][] arr = new int[n][2];
    ArrayList<Pair> cust = new ArrayList<>();
    for (int i = 0; i < arr.length; i++) {
      arr[i][0] = fr.nextInt();
      arr[i][1] = fr.nextInt();
    }
    for (int i = 0; i < arr.length; i++) {
      cust.add(new Pair(arr[i][0], 'x'));
      cust.add(new Pair(arr[i][1], 'y'));
    }
    Collections.sort(cust, (a, b) -> a.x - b.x);
    int ans = 0;
    int count = 0;
    for (Pair pair : cust) {
      if (pair.c == 'x') {
        count++;
      } else {
        count--;
      }
      ans = Math.max(ans, count);
    }
    System.out.println(ans);
  } 

  static class Pair implements Comparable<RestaurantCustomers.Pair> {
    int x; char c;
    public Pair (int x, char c) {
      this.x = x;
      this.c = c;
    }
    @Override
    public int compareTo(Pair o) {
      return x - o.x;
    }
  }

  static class FastReader {
    BufferedReader br;
    StringTokenizer st;

    public FastReader() {
      br = new BufferedReader(new InputStreamReader(System.in));
    }

    String next() {
      while (st == null || !st.hasMoreElements()) {
        try {
          st = new StringTokenizer(br.readLine());
        } catch (IOException e) {
          e.printStackTrace();
        }
      }
      return st.nextToken();
    }

    int nextInt() {
      return Integer.parseInt(next());
    }

    long nextLong() {
      return Long.parseLong(next());
    }

    double nextDouble() {
      return Double.parseDouble(next());
    }

    String nextLine() {
      String str = "";
      try {
        str = br.readLine();
      } catch (IOException e) {
        e.printStackTrace();
      }
      return str;
    }
  }
}
