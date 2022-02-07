import java.io.*;
import java.util.*;

// barebones problem from SAPO 2021 Day 2

public class city_center {

	static Pair[] max1, max2;
	static int[] parent;
	static long ans;
	static ArrayList<ArrayList<Pair>> adj;

	public static void main(String[] args) throws IOException {

		FastIO fr = new FastIO();
		PrintWriter pr = new PrintWriter(new OutputStreamWriter(System.out));

		int n = fr.nextInt();

		max1 = new Pair[n]; 
		max2 = new Pair[n];
		
		parent = new int[n];
		adj = new ArrayList<>();

		for (int i = 0; i < n; i++) {
			adj.add(new ArrayList<>());
			max1[i] = new Pair(0, 0);
			max2[i] = new Pair(0, 0);
		}

		for (int i = 0; i < n - 1; i++) {
			int a = fr.nextInt();
			int b = fr.nextInt();
			int w = fr.nextInt();

			adj.get(a).add(new Pair(b, w));
			adj.get(b).add(new Pair(a, w));
			
//			maxchildren = Math.max(maxchildren, Math.max(adj.get(a).size(), adj.get(b).size()));
		}

		dfs(new Pair(0, 0), -1);

		ans = Integer.MAX_VALUE;

		parentsearch(0, 0);

		pr.println(ans);
		pr.close();
	}

	static void parentsearch(int v, int w) {

		if (parent[v] != -1) {
			if (max1[parent[v]].y == v) {
				// use the 2nd length
				if (max2[parent[v]].x + w > max1[v].x) {
					max2[v] = max1[v];
					max1[v] = new Pair(max2[parent[v]].x + w, parent[v]);
				} else if (max2[parent[v]].x + w > max2[v].x) {
					max2[v] = new Pair(max2[parent[v]].x + w, parent[v]);
				}
			} else {
				if (max1[parent[v]].x + w > max1[v].x) {
					max2[v] = max1[v];
					max1[v] = new Pair(max1[parent[v]].x + w, parent[v]);
				} else if (max1[parent[v]].x + w > max2[v].x) {
					max2[v] = new Pair(max1[parent[v]].x + w, parent[v]);
				}				
			}
		}
		
		ans = Math.min(ans, max1[v].x);

		for (Pair child : adj.get(v)) {
			if (child.x != parent[v])
				parentsearch(child.x, child.y);
		}
	}

	static void dfs(Pair v, int p) {

		parent[v.x] = p;

		for (Pair child : adj.get(v.x)) {
			if (child.x == p)
				continue;

			dfs(child, v.x);

			int x = child.x, y = child.y;

			if (max2[v.x].x < max1[x].x + y) {
				if (max1[v.x].x < max1[x].x + y) {
					// swap position
					max2[v.x] = max1[v.x];
					max1[v.x] = new Pair(max1[x].x + y, x);
				} else {
					max2[v.x] = new Pair(max1[x].x + y, x);
				}
			}
		}
	}

	static class Pair {
		int x, y;

		public Pair(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	static class FastIO extends PrintWriter {
		private InputStream stream;
		private byte[] buf = new byte[1<<16];
		private int curChar, numChars;

		// standard input
		public FastIO() { this(System.in,System.out); }
		
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
			if (numChars == -1) throw new InputMismatchException();
			if (curChar >= numChars) {
				curChar = 0;
				try {
					numChars = stream.read(buf);
				} catch (IOException e) {
					throw new InputMismatchException();
				}
				if (numChars == -1) return -1; // end of file
			}
			return buf[curChar++];
		}

		// to read in entire lines, replace c <= ' '
		// with a function that checks whether c is a line break
		public String next() {
			int c; do { c = nextByte(); } while (c <= ' ');
			StringBuilder res = new StringBuilder();
			do { res.appendCodePoint(c); c = nextByte(); } while (c > ' ');
			return res.toString();
		}
		public int nextInt() { // nextLong() would be implemented similarly
			int c; do { c = nextByte(); } while (c <= ' ');
			int sgn = 1; if (c == '-') { sgn = -1; c = nextByte(); }
			int res = 0;
			do {
				if (c < '0' || c > '9')
					throw new InputMismatchException();
				res = 10*res+c-'0';
				c = nextByte();
			} while (c > ' ');
			return res * sgn;
		}
		public double nextDouble() { return Double.parseDouble(next()); }
	}

	static class FastReader {
		BufferedReader br;
		StringTokenizer st;

		public FastReader() {
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

		double nextDouble() {
			return Double.parseDouble(next());
		}

		long nextLong() {
			return Long.parseLong(next());
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
