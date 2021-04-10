import java.util.*;

public class FoxDots {

	static boolean[][] vis;
	static char[][] arr;
	static int[][] moves = {{-1,0}, {1,0}, {0,1}, {0,-1}};

	static class Pair {
		static int x, y;
		static char c;

		public Pair (int x, int y, char c) {
			this.x = x;
			this.y = y;
			this.c = c;
		}
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int m = scan.nextInt();

		arr = new char[n][m];
		vis = new boolean[n][m];
		Stack<Pair> stk = new Stack<>();
		Set<Character> set = new HashSet<>();
		scan.nextLine();

		// ADD all new letters
		for (int k = 0; k < n; k++) {
			arr[k] = scan.nextLine().toCharArray();
		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (!vis[i][j]) {
					stk.push(new Pair(i, j, arr[i][j]));
					Pair polled = stk.pop();
					printArr(vis);
					vis[polled.x][polled.y] = true;
					dfs(polled, polled);
				}
			}
		}
	}

	private static boolean dfs(Pair p, Pair n) {
		if (!isValid(n.x, n.y)) return false;
		System.out.println("parent: " + p.x + " " + p.y);
		System.out.println("current: " + n.x + " " + n.y);
		for (int[] move : moves) {
			System.out.println(n.x + " " + n.y + " " + (n.x+move[0]) + " " +  (n.y+move[1]));
			if (!isValid(n.x+move[0], n.y+move[1])) {
				System.out.println("invalid");
				continue;
			}
			System.out.println(arr[n.x+move[0]][n.y+move[1]] + " " + n.c);
			if (arr[n.x+move[0]][n.y+move[1]] != n.c) {
				System.out.println("wrong color");
				continue;
			}
			if (n.x+move[0] == p.x && n.y+move[1] == p.y) {
				System.out.println("Same as parent");
				continue;
			}
			vis[n.x][n.y] = true;
			if (vis[n.x+move[0]][n.y+move[1]] && p.x != n.x+move[0] || p.y != n.y+move[1]) {
				System.out.println("Yes");
				printArr(vis);
				System.exit(0);
			}
			System.out.println(n.x + " " + n.y + " " + (n.x+move[0]) + " " +  (n.y+move[1]));
			dfs(n, new Pair(n.x+move[0], n.y+move[1], arr[n.x+move[0]][n.y+move[1]]));
		}
		return false;
	}

	private static boolean isValid(int x, int y) {
		if (x < 0 || x >= arr.length || y < 0 || y >= arr[0].length) {
			return false;
		}
		return true;
	}

	private static void printArr(boolean[][] arr) {
		for (boolean[] row : arr) {
			System.out.println(Arrays.toString(row));
		}
		System.out.println(".");
	}
}