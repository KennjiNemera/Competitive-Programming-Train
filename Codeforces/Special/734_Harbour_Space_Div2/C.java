import java.io.*;
import java.util.*;

public class C {
  public static void main(String[] args) throws IOException {
    FastReader fr = new FastReader();
    PrintWriter pr = new PrintWriter(new OutputStreamWriter(System.out));
    int t = fr.nextInt();

    while (t-- > 0) {
      String s = fr.nextLine();

      // implementation

      int i = teamone(s);
      int j = teamtwo(s);

      pr.println(Math.min(teamone(s), teamtwo(s)));
    }

    pr.close();
  }

  static int teamone(String s) {
        int a = 0;
        int b = 0;

        for (int i = 0; i < s.length(); i++) {
          if (i % 2 == 0) {
            if (s.charAt(i) == '?') {
              a += 1;
            } else {
              a += toInt(s.charAt(i) + "");
            }

          } else {
            if (s.charAt(i) != '?') {
              b += toInt(s.charAt(i) + "");
            }
            
          }

          if (i % 2 == 0 && 5 - (i/2) + b < a) {
            return i + 1;
          } else if (i % 2 == 1 && 4 - (i/2) + b < a) {
            return i + 1;
          }
        }

        return 10;
      }

  static int teamtwo(String s) {
    int a = 0;
    int b = 0;

    for (int i = 0; i < s.length(); i++) {
      if (i % 2 != 0) {
        if (s.charAt(i) == '?') {
          b += 1;
        } else {
          b += toInt(s.charAt(i) + "");
        }

      } else {
        if (s.charAt(i) != '?') {
          a += toInt(s.charAt(i) + "");
        }
      }

      if (i % 2 == 1 && 4 - (i/2) + a < b) {
        return i + 1;
      } else if (i % 2 == 0 && 4 - (i/2) + a < b) {
        return i + 1;
      }
    }

    return 10;
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
