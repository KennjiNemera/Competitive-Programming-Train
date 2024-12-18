import java.io.*;
import java.util.*;

public class planets {
  public static void main(String[] args) throws IOException {
    FastReader fr = new FastReader();
    PrintWriter pr = new PrintWriter(new OutputStreamWriter(System.out));
    int n = fr.nextInt();
    long k = fr.nextLong();

    long lcm = 1;

    int[] t = new int[n];

    for (int i = 0; i < n; i++) {

      int a = fr.nextInt();

      t[i] = a;

      lcm = lcm(lcm, a);
    }

    long pulserate = 0;
    int start = t[0];

    for (int i = 0; i < t.length; i++) {
      pulserate += lcm / t[i];
      if (i > 0)
        pulserate -= lcm / lcm(start, t[i]);
    }

    long years = (k / pulserate) * lcm;

    long simcycle = k % pulserate;

    PriorityQueue<Pair> pq = new PriorityQueue<>(new Comp());

    for (int i = 0; i < t.length; i++) {
      pq.add(new Pair(1, t[i]));
    }

    ArrayList<Long> dup = new ArrayList<>();

    while (simcycle > 0) {
      Pair a = pq.poll();
      Pair b = pq.peek();

      int x = (int) Math.ceil((b.x * b.y * 1.0) / (a.x * a.y * 1.0));

      // means that we are done
      if (x > simcycle + 1) {
        years += simcycle * a.y;
        a.x += simcycle;
        pq.offer(a);
        break;
      } else {
        if (!dup.contains(a.x*a.y)) {
          years += (x-1) * a.y;
          simcycle -= x;
          simcycle++;
        }        
        a.x += x;
        pq.offer(a);
        dup.add(a.x * a.y);
      }
    }


    long ans = 2020 + years;
    pr.println(ans);
    pr.close();

  }

  static class Comp implements Comparator<Pair> {
    public int compare(Pair a, Pair b) {
      return Long.compare(a.x*a.y, b.x*b.y);
    }
  }

  static long gcd(long a, long b) {
    if (a == 0)
      return b;
    return (gcd(b % a, a));
  }

  static long lcm(long a, long b) {
    return (a / gcd(a, b)) * b;
  }

  static class Pair {
    long x, y;

    public Pair(long x, long y) {
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
