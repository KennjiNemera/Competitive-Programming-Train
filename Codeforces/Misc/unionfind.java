import java.io.*;
import java.util.*;

public class unionfind {

  static int[] link, size;
    public static void main(String[] args) throws IOException {
        FastIO fr = new FastIO();
        PrintWriter pr = new PrintWriter(new OutputStreamWriter(System.out));

        int n = fr.nextInt();
        int q = fr.nextInt();

        link = new int[n+1];
        size = new int[n+1];

        for (int i = 1; i < n; i++) {
          link[i] = i;
          size[i] = 1;
        }

        while (q-- > 0) {
          String c = fr.next();
          int a = fr.nextInt();
          int b = fr.nextInt();

          if (c.equals("F")) {
            boolean same = find(a) == find(b);
            String out = same ? "True" : "False";
            pr.println(out);
          } else {
            union(a, b);
          }
        }

        pr.close();
    }

    static int find(int x) {
      while (x != link[x]) x = link[x];
      return x;
    }

    static void union(int a, int b) {
      int ap = find(a);
      int bp = find(b);
      if (size[ap] < size[bp]) {
        int temp = bp;
        bp = ap;
        ap = temp;
      }
      size[ap] += size[bp];
      link[bp] = ap;
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
