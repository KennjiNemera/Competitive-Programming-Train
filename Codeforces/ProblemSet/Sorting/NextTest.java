import java.util.*;

public class NextTest {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = scan.nextInt();
		}

		Arrays.sort(arr);

		for (int 	i = 1; i < arr[0]; i++) {
			if (i < arr[0]) {
				System.out.println(i);
				return;
			}
		}

		for (int i = 0; i < n-1; i++) {
			if (arr[i] != arr[i+1]-1) {
				System.out.println(arr[i] + 1);
				return;
			}
		}

		System.out.println(arr[n-1] + 1);
	}
}