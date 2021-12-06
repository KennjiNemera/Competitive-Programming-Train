import java.util.*;
import java.io.*;

public class satisfy {

	static int[][] moves = {{1,0}, {-1,0}, {0,1}, {0,-1}};
	static int[][] grid;
	static int n, m;
	
	public static void main(String[] args) {
		
		FastReader fr = new FastReader();
		PrintWriter pr = new PrintWriter(new OutputStreamWriter(System.out));
		
		n = fr.nextInt();
		m = fr.nextInt();
		int v = fr.nextInt();
		
		grid = new int[n][m];
		int inf = (int) Math.pow(10, 9);
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				int val = fr.nextInt();
				grid[i][j] = val;
			}
		}
		
		ArrayList<Pair> arr = new ArrayList<>();
		boolean[][] vis = new boolean[n][m];
		
		Queue<Tuple> q = new LinkedList<>();
		q.offer(new Tuple(0,0,0));
		
		vis[0][0] = true;
		
		while (!q.isEmpty()) {
			Tuple p = q.poll();
			int x = p.x;
			int y = p.y;
			long dist = p.dist;

			if (grid[x][y] > 0) {
				arr.add(new Pair(grid[x][y], (int)dist));
			}
			
			for (int[] move : moves) {
				int cx = x + move[0];
				int cy = y + move[1];
				
				if (isValid(cx, cy)) {
					if (grid[cx][cy] != -1 && !vis[cx][cy]) {
						vis[cx][cy] = true;
						q.offer(new Tuple(cx, cy, dist + 1));
					}
				}
			}
		}
		
		if (grid[0][0] != 0) {
			pr.println(0);
		} else {
			long ans = 0;
			while (v > 0) {
				// find the most efficient point given that we have some value remaining
				double max = 0.0;
				long points = 0;
				long disttemp = inf;
				for (Pair p : arr) {
					long fact = Math.min(p.x, v);
					
					if (v >= p.x) fact = (int) Math.min(v, p.x*Math.ceil(v*1.0/p.x*1.0));
					
					long den = p.y * (int)Math.ceil((fact * 1.0) / (p.x * 1.0));
					double score = (fact*1.0) / (den*1.0);
					
					if (score >= max) {
						if (score == max) {
							if (p.y * 2 > disttemp) continue;
						}
						disttemp = p.y * 2;
						max = score;
						points = p.x;
					}
				}
				v-=points;
				ans += disttemp;
			}
			pr.println(ans);
		}
		pr.close();
	}
	
	static boolean isValid(int x, int y) {
		if (x < 0 || x >= n || y < 0 || y >= m) {
			return false;
		}
		return true;
	}
	
	static class Pair {
		int x, y;
		
		public Pair(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	static class Tuple {
		int x, y;
		long dist;
		
		public Tuple (int x, int y, long dist) {
			this.x = x;
			this.y = y;
			this.dist = dist;
		}
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
