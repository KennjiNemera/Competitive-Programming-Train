import java.io.*;
import java.util.*;

public class Ticks {
    public static void main(String[] args) throws IOException {
        FastReader fr = new FastReader();
        PrintWriter pr = new PrintWriter(new OutputStreamWriter(System.out));
        int t = fr.nextInt();

        while (t-- > 0) {

          int n = fr.nextInt();
          int m = fr.nextInt();
          int k = fr.nextInt();

          String[] arr = new String[n];

          for (int i = 0; i < n; i++) {
            arr[i] = fr.nextLine();
          }

          // find the longest tick that can be made for some root at [i][j];

          int[][] best = new int[n][m];

          for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
              if (arr[i].charAt(j) == '*') {

                // run a while to find the longest valid tick
                int d = 0;

                while (true) {

                  if (i - d < 0) break;

                  if (j - d < 0 || j + d >= m) break;

                  if (arr[i-d].charAt(j-d) != '*' || arr[i-d].charAt(j+d) != '*') {
                    break;
                  }

                  d++;
                }

                best[i][j] = d - 1;
              } 
            }
          }

          // for (int[] row : best) {
          //   pr.println(Arrays.toString(row));
          // }

          // for each painted cell, find a potential root

          boolean valid = true;

          for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
              
              if (arr[i].charAt(j) == '*') {

                boolean left = true;
                boolean right = true;

                int d = 0;

                // find a potential root either to the left or right of the current cell.

                boolean pos = true;

                while (pos) {

                  if (i + d >= n) {
                    pos = false;
                    break;
                  }

                  // the culprit

                  // check right
                  if (j + d < m) {

                    if (arr[i+d].charAt(j+d) == '.') {
                      right = false;
                    }

                    if (best[i+d][j+d] >= d && best[i+d][j+d] >= k && right) {
                      break;
                    }
                  }

                  // check left
                  if (j - d >= 0) {

                    if (arr[i+d].charAt(j-d) == '.') {
                      left = false;
                    }

                    if (best[i+d][j-d] >= d && best[i+d][j-d] >= k && left) {
                      break;
                    }
                  
                  }

                  d++;
                }

                // pr.println(i + " : " + j + " = " + pos);
                valid &= pos;
              } 
            }
          }

          if (valid) {
            pr.println("YES");
          } else pr.println("NO");

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
        if (b == 0) return a;
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
