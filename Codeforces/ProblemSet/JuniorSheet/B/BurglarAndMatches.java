import java.util.*;

public class BurglarAndMatches {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt(), m = scan.nextInt();
		int[][] arr = new int[m][2];
		int total = 0;
		Set<String> set = new HashSet<>();
		for (int i = 0; i < m; i++)
		{
			arr[i][0] = scan.nextInt();
			arr[i][1] = scan.nextInt();
		}

		int curMax = 0;
		while (n > 0) {
			int max = 0;
			for (int j = 0; j < arr.length; j++) {
				if (max < arr[j][1] && !set.contains(j+","+arr[j][1])) {
					max = arr[j][1];
					curMax = j;
				}
			}
			if (max == 0) break;
			// System.out.println(max + " " + curMax + " " + total + " " + n);
			if (n - arr[curMax][0] <= 0) {
				total += arr[curMax][1] * Math.min(n, arr[curMax][0]);
				n = 0;
			} else {
				total += arr[curMax][1] * Math.min(n, arr[curMax][0]);
				n -= arr[curMax][0];
			}
			set.add(curMax + "," + max);
			if (m == 1) break;
		}

		System.out.println(total);
	}
}