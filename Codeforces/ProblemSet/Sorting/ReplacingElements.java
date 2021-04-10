import java.util.*;

public class ReplacingElements {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int t = scan.nextInt();
		//
		while (t-- > 0) {
			int a = scan.nextInt();
			int d = scan.nextInt();
			int[] arr = new int[a];

			for (int k = 0; k < a; k++) {
				arr[k] = scan.nextInt();
			}

			boolean greater = false;
			boolean isTrue = false;

			for (int i = 0; i < arr.length-1; i++) {
				for (int j = i+1; j < arr.length; j++) {
					if (arr[j] + arr[i] <= d) {
						System.out.println("Yes");
						isTrue = true;
						break;
					}
					if (arr[i] > d || arr[j] > d) greater = true;
				}
			}

			if (!isTrue && !greater) System.out.println("No");
		}
	}
}