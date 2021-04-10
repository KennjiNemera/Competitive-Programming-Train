import java.util.*;

public class SumOfDigits {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String n = scan.nextLine();
		long moves = 0;

		while (n.length() >= 2) {
			long sum = 0;
			for (int i = 0; i < n.length(); i++) {
				sum += Integer.parseInt(n.charAt(i) + "");
			}
			n = String.valueOf(sum);
			moves++;
		}

		System.out.println(moves);
	}
}