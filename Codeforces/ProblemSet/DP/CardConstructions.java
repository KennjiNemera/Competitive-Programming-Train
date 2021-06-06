import java.io.*;
import java.util.*;

public class CardConstructions {
  public static void main(String[] args) throws IOException {
    FastReader fr = new FastReader();
    PrintWriter pr = new PrintWriter(new OutputStreamWriter(System.out));
    int t = fr.nextInt();
    int[] dp = new int[100001];

    while (t-- > 0) {
      int n = fr.nextInt();
      int count = 0;
      while (n > 0) {
        int temp = binarysearch(n);
        if (temp != n) count++; else break;
        n = temp;
      }
      pr.println(count);
    }

    pr.close();
  }

  static int binarysearch(int n) {
    int lo = 0;
    int hi = 100000;
    int ans = 0;
    while (lo <= hi) {
      int mid = (lo + hi) / 2;
      double res = mid * ((3.0*mid/2.0) + (1.0/2.0));
      if (res <= n) {
        ans = mid;
        lo = mid + 1;
      } else
        hi = mid - 1;
    }

    return n - (int)(ans * ((3.0*ans/2.0) + (1.0/2.0)));
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

  static class FastReader {
    BufferedReader br;
    StringTokenizer st;

    public FastReader() throws FileNotFoundException {
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
