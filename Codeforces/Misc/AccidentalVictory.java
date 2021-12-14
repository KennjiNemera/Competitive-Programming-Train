import java.io.*;
import java.util.*;

public class AccidentalVictory {
    public static void main(String[] args) throws IOException {
        FastReader fr = new FastReader();
        PrintWriter pr = new PrintWriter(new OutputStreamWriter(System.out));
        int t = fr.nextInt();

        while (t-- > 0) {
          int n = fr.nextInt();

          TreeMap<Long, Long> map = new TreeMap<>();
          long[] arr = new long[n];

          long total = 0;

          for (int i = 0; i < n; i++) {
            long a = fr.nextInt();
            arr[i] = a;
            total += a;
            map.putIfAbsent(a, 0L);
            map.put(a, map.get(a) + 1);
          }

          // check each possible token value and check if the preceding sum is greater than the max.

          long maxk = map.lastKey();
          int valid = 0;

          Long floor = map.lowerKey(maxk);
          total -= (long) (maxk * map.get(maxk));
          long min = maxk;
          valid += map.get(maxk); 

          while (floor != null) {
            if (total >= map.higherKey(floor)) {
              // value is valid
              min = floor;
              long floorInt = map.get(floor);
              total -= floor * floorInt;
              valid += floorInt;
              floor = map.lowerKey(floor);
            } else break;
          }

          StringBuilder sb = new StringBuilder();

          for (int i = 0; i < n; i++) {
            if (arr[i] >= min) {
              sb.append((i+1) + " ");
            }
          }

          pr.println(valid);
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
        while(i < len1 && j < len2) {
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
            i++;k++;
        }

        while (j < len2) {
            arr[k] = R[j];
            j++; k++;
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