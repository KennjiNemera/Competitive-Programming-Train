import java.util.Scanner;

public class NewYear {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int k = scan.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = 5 * (i+1);
		}
		int L = 0;
		int R = n-1;
		int cutOff = 240 - k;
		while (L <= R) {
			int mid = L + ((R-L) / 2);
			int sum = 0;
			int copMid = mid + 1;
			while (copMid > 0) {
				sum += 5 * copMid;
				copMid--;
			}
			// System.out.println(sum + " " + L + " " + R + " mid: " + mid + " cutoff: " + cutOff);
			if (L == R && sum <= cutOff) {
				System.out.println(mid + 1);
				return;		
			} else if (sum <= cutOff && sum + arr[mid+1] > cutOff) {
				System.out.println(mid + 1);
				return;
			} 
			if (sum > cutOff) {
				R = mid - 1;
			} else {
				L = mid + 1;
			}
		}
		System.out.println(0);
	}
}