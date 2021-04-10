import java.util.Scanner;

public class PetrBook {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int[] arr = new int[7];
		for (int i = 0; i < 7; i++) {
			arr[i] = scan.nextInt();
		}
		int curDay = 0;
		while (n > 0) {
			n -= arr[curDay];
			if (curDay == 6) {
				curDay = 0;
			} else curDay++;
		}
		System.out.println(curDay == 0 ? "7" : curDay);
	}
}