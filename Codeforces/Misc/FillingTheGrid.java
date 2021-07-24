import java.io.*;
import java.util.*;

public class FillingTheGrid {
  public static void main(String[] args) throws IOException {
    FastReader fr = new FastReader();
    PrintWriter pr = new PrintWriter(new OutputStreamWriter(System.out));
    int n = fr.nextInt(), m = fr.nextInt();

    long mod = 1000000007;

    String[] row = fr.nextLine().split(" ");
    String[] col = fr.nextLine().split(" ");
    long ans= 1;

    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        if (toInt(row[i]) == j && toInt(col[j]) > i || toInt(col[j]) == i && toInt(row[i]) > j) {
          pr.println(0);
          pr.close();
          return;
        } else if (toInt(col[j]) < i && toInt(row[i]) < j) {
          ans *= 2;
          ans = ans % mod;
        }
      }
    }

    // pr.println(count)

    pr.println(ans);
    pr.close();
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
