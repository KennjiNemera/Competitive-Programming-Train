import java.io.*;
import java.util.*;

public class B {
  public static void main(String[] args) throws IOException {
    FastReader fr = new FastReader();
    PrintWriter pr = new PrintWriter(new OutputStreamWriter(System.out));
    int t = fr.nextInt();

    while (t-- > 0) {
      int h = fr.nextInt();
      int w = fr.nextInt();

      int[][] arr = new int[h][w];

      if (w == 1) {
        for (int i = 0; i < arr.length; i+=2) {
          arr[i][0] = 1;
        }
      } else {
        int cx = 0, cy = 0;
        int turns = 0;

        while (turns < 4) {
          arr[cx][cy] = 1;

          switch (turns) {
            case 0:
              cy += 2;
              if (cy >= w) {
                cx += 2;
                cy = w - 1;
                turns = 1;
              }
              break;
            case 1:
              cx += 2;
              if (cx >= h) {
                cx = h - 1;
                cy -= 2;
                turns = 2;
              }
              break;
            case 2:
              cy -= 2;
              if (cy < 0) {
                cx -= 2;
                cy = 0;
                if (cx == 1) {
                  turns = 4;
                } else turns = 3;
              }
              break;
            case 3:
              cx -= 2;
              if (cx == 1) {
                turns = 4;
              } else if (cx < 0) {
                cx = 0;
                cy -= 2;
                turns = 4;
              }
              break;
          }
        }        
      }

      for (int i = 0; i < h; i++) {
        for (int j = 0; j < w; j++) {
          pr.print(arr[i][j]);
        }
        pr.print("\n");
      }

      pr.println();
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
