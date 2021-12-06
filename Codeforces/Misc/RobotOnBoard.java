import java.io.*;
import java.util.*;

public class RobotOnBoard {
    public static void main(String[] args) throws IOException {
        FastReader fr = new FastReader();
        PrintWriter pr = new PrintWriter(new OutputStreamWriter(System.out));
        int t = fr.nextInt();

        while (t-- > 0) {
          int n = fr.nextInt();
          int m = fr.nextInt();

          String s = fr.nextLine();

          int minX = 0, minY = 0;
          int maxX = 0, maxY = 0;

          int cx = 0;
          int cy = 0;

          int temp;

          boolean possible = true;
          for (int i = 0; i < s.length() && possible; i++) {
            switch (s.charAt(i)) {
              case 'L':
                  cy--;
                  temp = minY;
                  minY = Math.min(minY, cy);
                  if (maxY + Math.abs(minY) >= m) {
                    minY = temp;
                    possible = false;
                    break;
                  }
                break;
              case 'R':
                  cy++;
                  temp = maxY;
                  maxY = Math.max(maxY, cy);      
                  if (maxY + Math.abs(minY) >= m) {
                    maxY = temp;
                    possible = false;
                    break;
                  }        
                break;
              case 'D':
                  cx++;
                  temp = maxX;
                  maxX = Math.max(maxX, cx);
                  if (Math.abs(minX) + maxX >= n) {
                    maxX = temp;
                    possible = false;
                    break;
                  }
                break;
              case 'U':
                  cx--;
                  temp = minX;
                  minX = Math.min(minX, cx); 
                  if (Math.abs(minX) + maxX >= n) {
                    minX = temp;
                    possible = false;
                    cx++;
                    break;
                  }
                break;
              default:
                break;
            }
          }
          pr.println((Math.abs(minX) + 1) + " " + (Math.abs(minY) + 1));
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
