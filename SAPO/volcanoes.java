import java.io.*;
import java.util.*;

public class volcanoes {

	static int[] tree;
	static long[] dif;
	static int len, n;

	public static void main(String[] args) {
		FastIO fr = new FastIO();
		PrintWriter pr = new PrintWriter(new OutputStreamWriter(System.out));

		n = fr.nextInt();
		int a = fr.nextInt(), b = fr.nextInt();

		Event[] events = new Event[a];
		View[] queries = new View[b];

		for (int i = 0; i < events.length; i++) {
			events[i] = new Event(fr.nextInt(), fr.nextInt(), fr.next().charAt(0), fr.nextInt());
		}

		for (int i = 0; i < queries.length; i++) {
			queries[i] = new View(fr.nextInt(), fr.nextInt(), fr.nextInt());
		}

		Arrays.sort(events, (x, y) -> x.year - y.year);
		Arrays.sort(queries, (x, y) -> x.year - y.year);

		// pre-process the segment tree
		len = (int) Math.pow(2, Math.ceil(Math.log10(n) / Math.log10(2)));

		tree = new int[2 * len];

		for (int i = 0; i < n; i++) {
			update(500, i);
		}

		// pre-process the range update segment tree
		dif = new long[n + 1];

		for (int i = 1; i <= n; i++) {
			fenwickupdate(500, i);
		}

		// process events chronologically
		int e = 0;
		int v = 0;

		while (e < a && v < b) {
			if (events[e].year < queries[v].year) {
				if (events[e].type == 'D') {
					int ind = events[e].pos+1;
					int curDist = fenwicksum(ind) - fenwicksum(ind - 1);
					int net = events[e].val - curDist;

					fenwickupdate(net, ind);
				} else {
					update(events[e].val, events[e].pos+1);
				}
				e++;
			} else {
				int ind = queries[v].pos+1;
				int dist = queries[v].dist;

				int cursum = fenwicksum(ind);

				int lo = lowerbound(cursum - dist);
				int hi = upperbound(cursum + dist);
				
				if (lo == hi) pr.println(0);
				else pr.println(Math.max(query(lo, ind - 1), query(ind + 1, hi)));
				
				v++;
			}
		}
		
		while (e < a) {
			if (events[e].type == 'D') {
				int ind = events[e].pos+1;
				int curDist = fenwicksum(ind) - fenwicksum(ind - 1);
				int net = events[e].val - curDist;

				fenwickupdate(net, ind);
			} else {
				update(events[e].val, events[e].pos+1);
			}
			e++;
		} 
		
		while (v < b) {
			int ind = queries[v].pos+1;
			int dist = queries[v].dist;

			int cursum = fenwicksum(ind);

			int lo = lowerbound(cursum - dist);
			int hi = upperbound(cursum + dist);
			
			if (lo == hi) pr.println(0);
			else pr.println(Math.max(query(lo, ind - 1), query(ind + 1, hi)));

			
			v++;
		}
		
		pr.close();		
	}

	static int lowerbound(int target) {
		int lo = 1;
		int hi = n;
		int ans = -1;

		while (lo <= hi) {
			int mid = (lo + hi) / 2;
			if (fenwicksum(mid) >= target) {
				ans = mid;
				hi = mid - 1;
			} else
				lo = mid + 1;
		}

		return ans;
	}

	static int upperbound(int target) {
		int lo = 1;
		int hi = n;
		int ans = -1;

		while (lo <= hi) {
			int mid = (lo + hi) / 2;
			if (fenwicksum(mid) <= target) {
				ans = mid;
				lo = mid + 1;
			} else
				hi = mid - 1;
		}

		return ans;
	}

	static void fenwickupdate(int v, int pos) {
		for ( ; pos <= n; pos += (pos & -pos)) {
			dif[pos] += v;
		}
	}

	static int fenwicksum(int pos) {
		int sum = 0;
		while (pos >= 1) {
			sum += dif[pos];
			pos -= (pos & -pos);
		}
		return sum;
	}

	static void update(int v, int pos) {
		pos += len;
		tree[pos] = v;
		pos /= 2;
		while (pos >= 1) {
			tree[pos] = Math.max(tree[2 * pos], tree[pos * 2 + 1]);
			pos /= 2;
		}
	}

	static int query(int a, int b) {
		int s = 0;
		a += len;
		b += len;

		// propagate to the top
		while (a <= b) {
			if (a % 2 == 1)
				s = Math.max(s, tree[a++]);
			if (b % 2 == 0)
				s = Math.max(s, tree[b--]);
			a /= 2;
			b /= 2;
		}

		return s;
	}

	static class View {
		int year, pos, dist;

		public View(int year, int pos, int dist) {
			this.year = year;
			this.pos = pos;
			this.dist = dist;
		}
	}

	static class Event {
		int year, pos, val;
		char type;

		public Event(int year, int pos, char type, int val) {
			this.year = year;
			this.pos = pos;
			this.val = val;
			this.type = type;
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
