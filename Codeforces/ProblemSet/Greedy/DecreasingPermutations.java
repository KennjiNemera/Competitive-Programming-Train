import java.util.*;

public class DecreasingPermutations {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int k = scan.nextInt();
		for (int c = 0; c < k; c++) {
			System.out.print((n - c) + " ");
		}
		for (int i = 0; i < n - k; i++) {
			System.out.print((i + 1) + " ");
		}
	}
}