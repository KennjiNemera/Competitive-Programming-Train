import java.io.*;
import java.util.*;

public class CorruptedArray {
  public static void main(String[] args) throws IOException {
    FastReader fr = new FastReader();
    PrintWriter pr = new PrintWriter(new OutputStreamWriter(System.out));
    int t = fr.nextInt();

    while (t-- > 0) {
      int n = fr.nextInt();

      Long max1 = 0L;
      Long max2 = 0L;

      ArrayList<Long> arr = new ArrayList<>();

      long total = 0;

      for (int i = 0; i < n + 2; i++) {
        long a = fr.nextInt();

        total += a;

        // change maxes
        if (max1 < a) {
          max2 = max1;
          max1 = a;
        } else {
          if (max2 < a) {
            max2 = a;
          }
        }
        arr.add((long)a);
      }

      // casework max
      // long max = arr.get(arr.size() - 1);
      total -= max1;
      Long dif = (total - max1);

      StringBuilder sb = new StringBuilder();

      arr.remove(max1);

      if (arr.contains(dif)) {
        arr.remove(dif);
        // pr.println("MAX1 TRACK: " + dif);
        for (int i = 0; i < n; i++) {
          long val = arr.get(i);
          sb.append(val + " ");
        }
      } else {
        // case 2nd max
        arr.remove(max2);
        total -= max2;
        if (total == max2) { 
          // pr.println("MAX2 TRACK: " + total);
          for (int i = 0; i < n; i++) {
            long val = arr.get(i);
            sb.append(val + " ");
          }
        } else {
          sb.append("-1");
        }
      }

      pr.println(sb.toString().trim());
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
