import java.io.*;
import java.util.*;

public class stones {

  static long[][] tree;
  static int n, m;

  static void update(int x, int y, int val) {
    for (int i = x; i <= n; i += (i & -i)) {
      for (int j = y; j <= m; j += (j & -j)) {
        tree[i][j] += val;
      }
    }
  }

  static long sum(int x, int y) {
    long ans = 0;
    for (int i = x; i > 0; i -= (i & -i)) {
      for (int j = y; j > 0; j -= (j & -j)) {
        ans += tree[i][j];
      }
    }
    return ans;
  }

  public static void main(String[] args) throws IOException {
    FastReader fr = new FastReader();
    PrintWriter pr = new PrintWriter(new OutputStreamWriter(System.out));

    n = fr.nextInt();
    m = fr.nextInt();
    int q = fr.nextInt();

    tree = new long[n + 1][m + 1];

    for (int i = 1; i <= n; i++) {
      for (int j = 1; j <= m; j++) {
        update(i, j, fr.nextInt());
      }
    }

    while (q-- > 0) {
      int t = fr.nextInt();

      if (t == 0) {
        // build tower
        int a = fr.nextInt()+1, b = fr.nextInt()+1;
        long stones = fr.nextLong();

        long ans = 0;
        long prev = 0;

        for (int i = 0; (a + i <= n) || (a - i > 0) || (b + i <= m) || (b - i > 0); i++) {

          if (stones == 0) break;

          long curStones = sum(min(n, a+i), min(m, b+i))
                           - sum(a-i-1,min(b+i, m))
                           - sum(min(n, a+i), b-i-1)
                           + sum(a-i-1, b-i-1)
                           - prev;

          prev += curStones;

          curStones = Math.min(curStones, stones);

          stones -= curStones;

          ans += 2 * i * curStones;
        }

        if (stones == 0) {
          pr.println(ans);
        } else {
          pr.println(-1);
        }
      } else {
        // update cell
        int a = fr.nextInt() + 1, b = fr.nextInt() + 1;
        int c = fr.nextInt();

        int curval = (int) (sum(a, b) + sum(a - 1, b - 1) - sum(a - 1, b) - sum(a, b - 1));

        update(a, b, c - curval);
      }
    }

    pr.close();

  }

  static class Comp implements Comparator<Pair> {
    public int compare(Pair a, Pair b) {
      return Integer.compare(a.c, b.c);
    }
  }

  static int min(int x, int y) {
    return Math.min(x, y);
  }

  static int max(int x, int y) {
    return Math.max(x, y);
  }

  static class Pair {
    int x, y, c;

    public Pair(int x, int y, int c) {
      this.x = x;
      this.y = y;
      this.c = c;
    }
  }

  static int gcd(int a, int b) {
    if (b == 0)
      return a;
    return gcd(b, a % b);
  }

  static int toInt(String s) {
    return Integer.parseInt(s);
  }

  // MERGE SORT IMPLEMENTATION
  void sort(int[] arr, int l, int r) {
    if (l < r) {
      int m = l + (r - l) / 2;

      sort(arr, l, m);
      sort(arr, m + 1, r);

      // call merge
      merge(arr, l, m, r);
    }
  }

  void merge(int[] arr, int l, int m, int r) {
    // find sizes
    int len1 = m - l + 1;
    int len2 = r - m;

    int[] L = new int[len1];
    int[] R = new int[len2];

    // push to copies
    for (int i = 0; i < L.length; i++)
      L[i] = arr[l + i];
    for (int i = 0; i < R.length; i++) {
      R[i] = arr[m + 1 + i];
    }

    // fill in new array
    int i = 0, j = 0;
    int k = l;
    while (i < len1 && j < len2) {
      if (L[i] < R[i]) {
        arr[k] = L[i];
        i++;
      } else {
        arr[k] = R[i];
        j++;
      }
      k++;
    }

    // add remaining elements
    while (i < len1) {
      arr[k] = L[i];
      i++;
      k++;
    }

    while (j < len2) {
      arr[k] = R[j];
      j++;
      k++;
    }
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
