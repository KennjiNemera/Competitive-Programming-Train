import java.io.*;
import java.util.*;

public class ShortestPaths2 {
  public static void main(String[] args) throws IOException {
    FastReader fr = new FastReader();
    PrintWriter pr = new PrintWriter(new OutputStreamWriter(System.out));

    long inf =(long) Math.pow(10, 15);

    int n = fr.nextInt();
    int m = fr.nextInt();
    int q = fr.nextInt();

    long[][] adj = new long[n][n];

    for (int i = 0; i < n; i++) {
      for (int j = i + 1; j < n; j++) {
        adj[i][j] = inf;
        adj[j][i] = inf;
      }
    }
 
    for (int i = 0; i < m; i++) {
      int a = fr.nextInt()-1;
      int b = fr.nextInt()-1;
      int w = fr.nextInt();
 
      adj[a][b] = adj[b][a] = Math.min(w, adj[a][b]);
    }

    // O(n^3)

    for (int k = 0; k < n; k++) {
      for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
          long temp = adj[i][k] + adj[k][j];
          adj[i][j] = Math.min(adj[i][j], temp);
          // if (adj[i][k] != inf && adj[k][j] != inf && adj[i][j] > temp) {
          //   adj[i][j] = temp;
          // }
        }
      }
    }

    for (int i = 0; i < q; i++) {
      int a = fr.nextInt() - 1;
      int b = fr.nextInt() - 1;
      long ans = adj[a][b];
      if (ans == inf)
        pr.println(-1);
      else
        pr.println(ans);
    }

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
