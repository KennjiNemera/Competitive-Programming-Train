import java.util.*;


// THIS SOLUTION DOESNT WORK, I DONT KNOW AHT DATA STRUCTURE TO USE THAT ALLOWS TO GET PAST THE WHOLE OBJECT WITH DIFFERENT ADDRESSES ISSUE`
public class Monster {

	static int n, m;
	static int[][] g;
	static ArrayList<Pair> monster;
	static Map<int[], int[]> par_m;
	static Pair si, se;
	static int[][] moves = {{-1,0},{1,0},{0,1},{0,-1}};

	public static boolean isValid(int x, int y, int time) {
		if (x < 0 || x >= n || y < 0 || y >= m) return false;
		if (g[x][y] <= time) return false;
		return true;
	}

	public static boolean isEscape(int x, int y, int time) {
		if (!isValid(x, y, time)) return false;
		if (x == 0 || y == 0 || x == n-1 || y == m - 1) return true;
		return false;
	}

	public static void preprocess_lava() {
		Queue<DeepPair> q = new LinkedList();
		for (Pair m : monster) {
			System.out.print("Monster: ");
			printPair(m);
			q.offer(new DeepPair(m, 0));
		}
		while (!q.isEmpty()) {
			int cx = q.peek().p.x;
			int cy = q.peek().p.y;
			int time = q.peek().time;
			time++;
			q.poll();
			for (int[] move : moves) {
				int tx = cx + move[0];
				int ty = cy + move[1];
				if (isValid(tx, ty, time)) {
					g[tx][ty] = time;
					System.out.println(tx + " " + ty);
					System.out.println("TIME: " + time);
					q.offer(new DeepPair(new Pair(tx, ty), time));
				}
			}
		}
	}

	public static boolean BFS_escape() {
		Queue<DeepPair> q = new LinkedList();
		q.offer(new DeepPair(si, 0));
		par_m.put(new int[] {si.x, si.y}, new int[] {-1,-1});
		printPair(si);
		printSet(par_m.get(new int[] {si.x, si.y}));
		while (!q.isEmpty()) {
			int cx = q.peek().p.x;
			int cy = q.peek().p.y;
			int time = q.peek().time;
			time++;
			q.poll();
			System.out.println("TIME: " + time);
			for (int[] move : moves) {
				int tx = cx + move[0];
				int ty = cy + move[1];
				Pair t = new Pair(tx, ty);
				
				if (isEscape(tx, ty, time)) {
					se = t;
					par_m.put(new int[] {tx, ty}, new int[] {cx, cy});
					return true;
				}
				if (isValid(tx, ty, time)) {
					par_m.put(new int[] {tx, ty}, new int[] {cx, cy});
					printSet(par_m.get(t));
					g[tx][ty] = time;
					q.offer(new DeepPair(t, time));
				}
			}
		}
		return false;
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		n = scan.nextInt();
		m = scan.nextInt();
		scan.nextLine();

		g = new int[n][m];
		par_m = new HashMap();
		monster = new ArrayList<>();

		for (int i = 0; i < n; i++) {
			Arrays.fill(g[i], Integer.MAX_VALUE);
		}

		for (int i = 0; i < n; i++) {
			String line = scan.nextLine();
			for (int j = 0; j < m; j++) {
				char c = line.charAt(j);
				switch (c) {
					case '#':
						g[i][j] = 0;
						break;
					case 'M':
						g[i][j] = 0;
						monster.add(new Pair(i, j));
						break;
					case 'A':
						g[i][j] = 0;
						si = new Pair(i, j);
						printPair(si);
						break;
					case '.':
						g[i][j] = Integer.MAX_VALUE;
						break;
				}
			}
		}
		// Edge case -> Checks if we are already at a boundary square
		if (si.y == 0 || si.x == 0 || si.x == n-1 || si.y == m-1) {
			System.out.println("YES");
			System.out.println(0);
			return;
		}

		preprocess_lava();

		printArr();

		if (!BFS_escape()) {
			System.out.println("NO");
			printArr();
			return;
		}

		printArr();

		System.out.println("YES");

		int[] tmp = new int[] {se.x, se.y};
		int[] tmp1 = par_m.get(se);
		int[] end = new int[] {-1,-1};
		ArrayList<Character> ans = new ArrayList<>();

		while (tmp1 != end) {

			System.out.println("We got in");

			System.out.println(tmp1[0] + " " + tmp1[1]);
			System.out.println(tmp[0] + " " + tmp[1]);

			if ((tmp[0] - tmp1[0]) == 1 && (tmp[1] - tmp1[1]) == 0) {
				ans.add('R');
			} else if ((tmp[0] - tmp1[0]) == -1 && (tmp[1] - tmp1[1]) == 0) {
				ans.add('L');
			} else if ((tmp[0] - tmp1[0]) == 0 && (tmp[1] - tmp1[1]) == 1) {
				ans.add('D');
			} else if ((tmp[0] - tmp1[0]) == 0 && (tmp[1] - tmp1[1]) == -1) {
				ans.add('U');
			}

			tmp = par_m.get(tmp);
			tmp1 = par_m.get(tmp);
		}

		Collections.reverse(ans);

		for (char c : ans) {
			System.out.print(c);
		}
	}

	static void printArr() {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				System.out.print(g[i][j] + " ");
			}
			System.out.println("");
		}
	}

	static void printPair(Pair p) {
		System.out.println("x: " + p.x + " " + "y: " + p.y);
	}

	static void printSet(int[] p) {
		System.out.println("SET: x: " + p[0] + " " + "y: " + p[1]);
	}

}

class Pair {
	public int x, y;
	public Pair(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

class DeepPair {
	public Pair p;
	public int time;

	public DeepPair(Pair p, int time) {
		this.p = p;
		this.time = time;
	}
}