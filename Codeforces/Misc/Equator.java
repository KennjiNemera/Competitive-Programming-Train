import java.io.*;
import java.util.*;

public class Equator {
  public static void main(String[] args) throws IOException {
    FastReader fr = new FastReader();
    PrintWriter pr = new PrintWriter(new OutputStreamWriter(System.out));
    int n = fr.nextInt();

    int[] arr = new int[n];

    arr[0] = fr.nextInt();

    for (int i = 1; i < arr.length; i++) {
      arr[i] = fr.nextInt() + arr[i - 1];
    }

    pr.println(binarysearch((int) (arr[n - 1] + 1) / 2, arr));

    pr.close();
  }

  static int binarysearch(int a, int[] arr) {
    int lo = 0;
    int hi = arr.length - 1;
    int ans = -1;
    while (lo <= hi) {
      int mid = (lo + hi) / 2;
      if (arr[mid] >= a) {
        hi = mid - 1;
        ans = mid;
      } else
        lo = mid + 1;
    }

    return ans + 1;
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
