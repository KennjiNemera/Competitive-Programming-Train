import java.io.*;
import java.util.*;

public class pyramid {

	static int[][] arr;
	static ArrayList<ArrayList<Integer>> adj;
	static int ind = 0;
	static int[] nodepos;
	static long[] fenwick;
	static int n;

	static long sum(int k) {
		long sum = 0;

		while (k >= 1) {
			sum += fenwick[k];
			k -= k & -k;
		}

		return sum;
	}

	static void add(int k, long x) {
		while (k <= n) {
			fenwick[k] += x;
			k += k & -k;
		}
	}

	static void dfs(int cur, int par) {
		nodepos[cur] = ind;
		arr[ind][0] = cur;
		arr[ind][1] = 1;
		ind++;
		for (Integer child : adj.get(cur)) {
			if (child == par)
				continue;
			dfs(child, cur);
			arr[nodepos[cur]][1] += arr[nodepos[child]][1];
		}
	}

	public static void main(String[] args) throws IOException {
		FastIO fr = new FastIO();
		PrintWriter pr = new PrintWriter(new OutputStreamWriter(System.out));

		int q;

		n = fr.nextInt();
		q = fr.nextInt();

		arr = new int[n][3];
		nodepos = new int[n];
		adj = new ArrayList<>();

		for (int i = 0; i < n; i++) {
			adj.add(new ArrayList<>());
		}

		for (int i = 1; i < n; i++) {
			int par = fr.nextInt();

			adj.get(par).add(i);
			adj.get(i).add(par);
		}

		// run a dfs
		dfs(0, -1);

		fenwick = new long[n + 1];

		for (int i = 0; i < n; i++) {
			int sum = fr.nextInt();
			int pos = nodepos[i];
			arr[pos][2] = sum;

			add(pos + 1, sum);
		}

		// for (int i = 0; i < n; i++) {
		// pr.println(arr[i][0] + " " + arr[i][1] + " " + arr[i][2]);
		// }

		// for (int i = 0; i <= n; i++) {
		// pr.print(fenwick[i] + " ");
		// }

		while (q-- > 0) {
			char c;

			c = fr.next().charAt(0);

			if (c == 'C') {

				// so it's you!
				int a;
				long b;
				a = fr.nextInt();
				b = fr.nextLong();

				long curVal = arr[nodepos[a]][2];
				long change = b - curVal; // get's the change from old to new

				arr[nodepos[a]][2] = (int)b;

				add(nodepos[a] + 1, change); //  our fenwick array is 1-indexed
			} else {
				int node = fr.nextInt();

				int pos = nodepos[node];

				long rightsum = sum(pos + arr[pos][1]) - sum(pos);
				pr.println(rightsum);
			}
		}

		pr.close();

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

		public long nextLong() {
			long c;
			do {
				c = nextByte();
			} while (c <= ' ');
			long sgn = 1;
			if (c == '-') {
				sgn = -1;
				c = nextByte();
			}
			long res = 0;
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
