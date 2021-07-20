import java.io.*;
import java.util.*;

public class C {
    public static void main(String[] args) throws IOException {
        FastReader fr = new FastReader();
        PrintWriter pr = new PrintWriter(new OutputStreamWriter(System.out));
        int t = fr.nextInt();

        while (t-- > 0) {
          int n = fr.nextInt();
          int[] me = new int[n];
          int[] friend = new int[n];

          for (int i = 0; i < friend.length; i++) {
            me[i] = fr.nextInt();
          }

          for (int i = 0; i < friend.length; i++) {
            friend[i] = fr.nextInt();
          }

          Arrays.sort(me);
          Arrays.sort(friend);

          for (int i = 1; i < friend.length; i++) {
            me[i] += me[i-1];
            friend[i] += friend[i-1]; 
          }

          pr.println(binarySearch(me,friend));
        }

        pr.close();
    }

    static int binarySearch(int[] me, int[] friend) {
      int lo = me.length;
      int hi = 1000000;
      int ans = 0;
      int n = me.length;
      while (lo <= hi) {
        int mid = (lo + hi) / 2;
        int req = mid - (int)Math.floor(mid/4);
        int additional = mid - n;
        int total = Math.max(0,req - additional);
        int a = me[n-1] + 100 * additional;
        if (n-total-1 >= 0) a -= me[n-total-1];
        int b = friend[n-1];
        if (req < n) b -= friend[n-req-1];
        if (a >= b) {
          ans = mid - n;
          hi = mid - 1; 
        } else {
          lo = mid + 1;
        }
      }

      return ans;
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
