import java.util.*;

public class ORinMatrix {

	/// UNSOLVED

	static  int m, n;

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		m = scan.nextInt(); n = scan.nextInt();
		int[][] arr = new int[m][n];
		for (int i = 0; i < m; i++)
		{
			for (int j = 0; j < n; j++)
			{
				arr[i][j] = scan.nextInt();
			}
		}

		if (!isTrue(arr)) {
			System.out.println("NO");
			return;
		} 

		int[][] flipped = flip(arr);

		boolean isTrue = false;
		for (int[] row : flipped) {
			for (int l = 0; l < n; l++) {
				if (row[l] == 1) {
					isTrue = true;
					break;
				}
			}
		}

		if (isTrue) {
			System.out.println("YES");
			for (int[] row : flipped) {
				for (int num : row) {
					System.out.print(num + " ");
				}
				System.out.print("\n");
			}	
		} else {
			System.out.println("NO");
		}

		
	}


	static boolean isTrue(int[][] arr)
	{
		for (int i = 0; i < m; i++) {
			if (Arrays.asList(arr[i]).contains(0)) return true;
		}

		int zeroTally = 0;

		for (int i = 0; i < n; i++) {
			int zeroCount = 0;
			for (int j = 0; j < m; j++) {
				if (arr[j][i] == 0) {
					zeroCount++;
					zeroTally++;
				}
			}
			if (zeroCount == 0) return true;
		}

		if (zeroTally == m * n) {
			System.out.println("YES");
			for (int[] row : arr) {
				for (int num : row) {
					System.out.print(num + " ");
				}
				System.out.print("\n");
			}
			System.exit(0);
		}
		return false;
	}

	static int[][] flip(int[][] arr){
		int[][] cop = new int[m][n];
		for (int[] row : cop) {
			Arrays.fill(row, 1);
		}
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (arr[i][j] == 0) {
					Arrays.fill(cop[i], 0);
					cop = fillVert(cop, j);
				}
			}
		}
		return cop;
	}

	static int[][] fillVert(int[][] arr, int j) {
		for (int i = 0; i < m; i++) {
			arr[i][j] = 0;
		}
		return arr;
	}
}