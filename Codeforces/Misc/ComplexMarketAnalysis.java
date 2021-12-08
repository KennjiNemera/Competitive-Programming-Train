import java.io.*;
import java.util.*;

public class ComplexMarketAnalysis {
  public static void main(String[] args) throws IOException {
    FastReader fr = new FastReader();
    PrintWriter pr = new PrintWriter(new OutputStreamWriter(System.out));

    int t = fr.nextInt();

    boolean[] comp = new boolean[1000005];

    // sieve
    for (int i = 2; i < comp.length; i++) {
      if (comp[i])
        continue;
      for (int j = i + i; j < comp.length; j += i) {
        comp[j] = true;
      }
    }

    while (t-- > 0) {
      int n = fr.nextInt();
      int e = fr.nextInt();

      int[] arr = new int[n + 1];

      for (int i = 1; i <= n; i++) {
        int a = fr.nextInt();
        arr[i] = a;
      }

      long total = 0;
      boolean[] chained = new boolean[n + 1];
      ArrayList<Integer> ones = new ArrayList<>();
      int currentOnes = 0;

      for (int i = 1; i <= n; i++) {
        // reset structures
        ones.clear();
        currentOnes = 0;
        // pr.println("Start: " + i);
        // loop through sequence
        for (int j = i; j <= n; j += e) {
          if ((arr[j] != 1 && comp[arr[j]]) || chained[j]) {
            break;
          }
          chained[j] = true;
          if (arr[j] == 1) {
            // pr.println("is one: " + j);
            currentOnes++;
          } else {
            // pr.println("end of group: " + j + " : cur : " + currentOnes);
            ones.add(currentOnes);
            currentOnes = 0;
          }
        }

        if (ones.size() == 0) continue;
        ones.add(currentOnes);

        for (int j = 0; j < ones.size(); j++) {
          total += ones.get(j);
          if (j > 0 && j < ones.size() - 1) {
            total += ones.get(j);
          }
          if (j < ones.size() - 1) {
            total += (long)(ones.get(j)) * (long)(ones.get(j + 1));
          }
        }
      }

      pr.println(total);

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
