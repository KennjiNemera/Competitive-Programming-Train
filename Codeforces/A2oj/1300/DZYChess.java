import java.util.*;

public class DZYChess {

	static class Pair {
		int x;
		int y;
		char c;

		public Pair(int x, int y, char c) {
			this.x = x;
			this.y = y;
			this.c = c;
		}
	}

	static int n, m;
	static boolean[][] vis;
	static char[][] arr;
	static int[][] moves = {{0,1}, {0,-1}, {1,0}, {-1,0}};

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		n = scan.nextInt();
		m = scan.nextInt();
		arr = new char[n][m];
		vis = new boolean[n][m];
		scan.nextLine();

		for (int i = 0; i < n; i++) {
			arr[i] = scan.nextLine().toCharArray();
		}

		for (int j = 0; j < n; j++) {
			for (int k = 0; k < m; k++) {
				if (arr[j][k] != '-') {
					if ((j + k)  % 2 == 0) arr[j][k] = 'B';
					else arr[j][k] = 'W';
				}
			}
		}

		printBoard();
	}

	static void printBoard() {
		for (char[] row : arr) {
			for (char c : row) {
				System.out.print(c+"");
			}
			System.out.print("\n");
		}
	}
}