import java.io.*;
import java.util.*;

public class WebOfLies {
    static int count = 0;
    static long[] arr;

    public static void main(String[] args) throws IOException {
        FastIO fr = new FastIO();
        PrintWriter pr = new PrintWriter(new OutputStreamWriter(System.out));
        int n = fr.nextInt();
        int m = fr.nextInt();

        arr = new long[n];

        for (int i = 0; i < m; i++) {
            append(fr.nextInt()-1, fr.nextInt()-1);
        }

        int q = fr.nextInt();

        while (q-- > 0) {
          int t = fr.nextInt();
          if (t == 1) {
            int a = fr.nextInt()-1, b = fr.nextInt()-1;
            append(a, b);
          } else if (t == 2) {
            int a = fr.nextInt()-1;
            int b = fr.nextInt()-1;

            int min = Math.min(a, b);
            arr[min]--;
            if (arr[min] == 0) count--;
          } else {
            pr.println(n-count);
          }
        }

        pr.close();
    }

    // static boolean isVulnerable(int a) {
    //     Object[] children = adj.get(a).toArray();
    //     Integer val = null;
    //     for (Object child : children) {
    //         if (!vis[(int)child]) {
    //             val = (int)child;
    //             break;
    //         } 
    //     }
    //     return val == null || val < a;
    // }

    static void append(int a, int b) {
        int min = Math.min(a, b);
        if (arr[min] == 0) count++;
        arr[min]++;
    }    

    // static void dfs(int v, int p) {

    //   if (vis[v]) return;

    //   // prove vulnerability
    //   if (p != -1) {

    //     ArrayList<Integer> temp = new ArrayList<>();
        
    //     // for (Integer val : propmand) {
    //     //     if (adj.get(v).contains(val)) {
    //     //         adj.get(v).remove(val);
    //     //         temp.add(val);
    //     //     }
    //     // }

    //     boolean notvulnerable = isVulnerable(v);

    //     // 
    //     // for (Integer val : temp) {
    //     //     adj.get(v).add(val);
    //     // }

    //     if (notvulnerable) return;    
    //   }

    //   count++; // i believe that the issue has something to do with this count and where it is placed.
    //   vis[v] = true;

    //   for (Integer child : adj.get(v)) {
    //     if (child == p) continue;
    //     dfs(child, v);
    //   }

    // }

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

    static class FastIO extends PrintWriter {
		private InputStream stream;
		private byte[] buf = new byte[1 << 16];
		private int curChar, numChars;

		// standard input
		public FastIO() {
			this(System.in, System.out);
		}

		public FastIO(InputStream i, OutputStream o) {
			super(o);
			stream = i;
		}

		// file input
		public FastIO(String i, String o) throws IOException {
			super(new FileWriter(o));
			stream = new FileInputStream(i);
		}

		// throws InputMismatchException() if previously detected end of file
		private int nextByte() {
			if (numChars == -1)
				throw new InputMismatchException();
			if (curChar >= numChars) {
				curChar = 0;
				try {
					numChars = stream.read(buf);
				} catch (IOException e) {
					throw new InputMismatchException();
				}
				if (numChars == -1)
					return -1; // end of file
			}
			return buf[curChar++];
		}

		// to read in entire lines, replace c <= ' '
		// with a function that checks whether c is a line break
		public String next() {
			int c;
			do {
				c = nextByte();
			} while (c <= ' ');
			StringBuilder res = new StringBuilder();
			do {
				res.appendCodePoint(c);
				c = nextByte();
			} while (c > ' ');
			return res.toString();
		}

		public int nextInt() { // nextLong() would be implemented similarly
			int c;
			do {
				c = nextByte();
			} while (c <= ' ');
			int sgn = 1;
			if (c == '-') {
				sgn = -1;
				c = nextByte();
			}
			int res = 0;
			do {
				if (c < '0' || c > '9')
					throw new InputMismatchException();
				res = 10 * res + c - '0';
				c = nextByte();
			} while (c > ' ');
			return res * sgn;
		}

		public double nextDouble() {
			return Double.parseDouble(next());
		}
	}
}
