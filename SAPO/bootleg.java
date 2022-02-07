import java.io.*;
import java.util.*;

public class bootleg {
	
	static int[][] sparse;
	static int[] arr;

	public static void main(String[] args) {
		FastIO fr = new FastIO();
		PrintWriter pr = new PrintWriter(new OutputStreamWriter(System.out));
		
		int n = fr.nextInt();
		int q = fr.nextInt();
		int b = fr.nextInt();
		
		// store the heights for the sake of retrieving the left and rightbound
		sparse = new int[n + 2][20];
		
		arr = new int[n + 2];
		
		for (int i = 1; i <= n; i++) {
			arr[i] = fr.nextInt();
			sparse[i][0] = arr[i];
		}
			
		for (int i = 1; (1 << i) <= n; i++) {
			for (int j = 1; j + (1 << (i-1)) <= n; j++) {
				int sender = j + (1 << (i-1));
				sparse[j][i] = Math.min(sparse[j][i-1], sparse[sender][i-1]); 
			}
		}
		
		int z = 0;
		
		// handle the online queries
		while (q-- > 0) {
			int x = fr.nextInt();
			int y = fr.nextInt();
			
			int left = Math.max(1,((x - 1 + b * z) % n) + 1);
			int right = Math.min(n,((y - 1 + b * z) % n) + 1);
			
			Pair p = getMin(left, right);
			z = Math.abs(p.x);
			
			if (p.x == -1) {
				pr.println(-1);
			} else {
				pr.println(p.x + " " + p.y);
			}
		}
		
		pr.close();
	}
	
	static Pair getMin(int a, int b) {
		// we just need to check for single value ranges.
		for (int i = (b - a); i >= 1; i--) {
			int w = (int) Math.ceil(Math.log10(i+1) / Math.log10(2));
			for (int j = b - i; j >= a; j--) {
				
				int l = arr[j-1];
				int r = arr[j + i + 1];
				
				int send = (j + i + 1) - (1 << (w-1));
				int min = Math.min(sparse[j][w-1], sparse[send][w-1]);
				
				if (min > l && min > r) {
					return new Pair(j, j + i);
				}
			}
		}
		
		for (int i = b; i >= a; i--) {
			int l = arr[i-1];
			int r = arr[i + 1];
			
			if (arr[i] > l && arr[i] > r) {
				return new Pair(i, i);
			}
		}
		
		return new Pair(-1,-1);
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

}
