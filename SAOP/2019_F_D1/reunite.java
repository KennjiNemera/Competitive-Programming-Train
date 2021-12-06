import java.io.*;
import java.util.*;

public class reuite {

  static ArrayList<ArrayList<Integer>> arr;
  static int n, a, b;
  static int[][] dp;

  public static void main(String[] args) throws IOException {
    FastReader fr = new FastReader();
    PrintWriter pr = new PrintWriter(new OutputStreamWriter(System.out));
    n = fr.nextInt();
    int m = fr.nextInt();
    a = fr.nextInt() - 1;
    b = fr.nextInt() - 1;

    arr = new ArrayList<>();
    dp = new int[n][2];

    for (int i = 0; i < n; i++) {
      arr.add(new ArrayList<>());
      Arrays.fill(dp[i], -1);
    }

    for (int i = 0; i < m; i++) {
      int x = fr.nextInt() - 1;
      int y = fr.nextInt() - 1;

      arr.get(x).add(y);
      arr.get(y).add(x);
    }

    bfs(a);
    bfs(b);

    // search for the min sol

    long ans = Integer.MAX_VALUE;
    int room = -1;

    for (int i = 0; i < n; i++) {
      if (dp[i][0] != -1 && dp[i][1] != -1) {
        int temp = Math.max(dp[i][0] -1, dp[i][1]-1);
        if (ans > temp) {
          ans = temp;
          room = i + 1;
        }
      }
    }

    pr.println(room);
    pr.close();
  }

  static class Comp implements Comparator<Pair> {
    public int compare(Pair a, Pair b) {
      if (a.y == b.y) {
        return Integer.compare(a.x, b.x);
      } else {
        return Integer.compare(a.y, b.y);
      }
    }
  }

  static void bfs(int target) {
      Queue<Integer> pq = new LinkedList<Integer>(); 
      if (target == a) {
        dp[target][0] = 1;
      } else {
        dp[target][1] = 1;
      }
      
      pq.offer(target);

      while (!pq.isEmpty()) {
        Integer p = pq.poll();
        
        for (Integer edge : arr.get(p)) {
          if (target == a) {
            if (dp[edge][0] == -1) {
              dp[edge][0] = dp[p][0] + 1;
              pq.offer(edge);
            }
          } else {
            if (dp[edge][1] == -1) {
              dp[edge][1] = dp[p][1] + 1;
              pq.offer(edge);
            }
          }

        }
      }
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

  void minimumquery(long[][] arr, long[] vals, int n) {

    for (int i = 0; i < arr.length; i++) {
      arr[i][0] = vals[i];
    }

    for (int i = 1; (1 << i) <= n; i++) {
      for (int j = 0; j + (1 << i) - 1 < n; j++) {
        arr[j][i] = Math.min(arr[j][i - 1], arr[j + (1 << (i - 1))][i - 1]);
      }
    }
  }

  int solveExp2(int n) {
    return (int) Math.ceil(Math.log10(n * 1.0) / Math.log10(2 * 1.0));
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
