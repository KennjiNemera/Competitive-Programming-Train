import java.io.*;
import java.util.*;

public class XorSum {
    public static void main(String[] args) throws IOException {
        FastReader fr = new FastReader();
        PrintWriter pr = new PrintWriter(new OutputStreamWriter(System.out));
        int n = fr.nextInt();
        int q = fr.nextInt();

        long[] arr = new long[n];

        for (int i = 0; i < arr.length; i++) {
          int val = fr.nextInt();
          if (i == 0) {
            arr[0] = val;
          } else {
            arr[i] = val ^ arr[i-1];
          }
        }

        while (q-- > 0) {
          int a = fr.nextInt()-2;
          int b = fr.nextInt()-1;

          long ans = arr[b];

          if (a >= 0) {
            ans ^= arr[a];
          }

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

    void minimumquery(long[][] arr, long[] vals, int n) {

        for (int i = 0; i < arr.length; i++) {
            arr[i][0] = vals[i];
        }

        for (int i = 1; (1 << i) <= n; i++) {
            for (int j = 0; j + (1 << i) - 1 < n; j++) {
                arr[j][i] = Math.min(arr[j][i-1], arr[j + (1 << (i-1))][i-1]);
            }
        }
    }

    int solveExp2(int n) {
        return (int)Math.ceil(Math.log10(n*1.0)/Math.log10(2*1.0));
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
