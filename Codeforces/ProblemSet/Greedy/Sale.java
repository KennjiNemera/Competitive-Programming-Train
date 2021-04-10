import java.util.*;

public class Sale {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int m = scan.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = scan.nextInt();
		}
		Arrays.sort(arr);
		int ans = 0;
		for (int i = 0; i < m; i++) {
			if (arr[i] >= 0) break;
			ans += arr[i]; 
		}
		System.out.println(-ans);
	}
}