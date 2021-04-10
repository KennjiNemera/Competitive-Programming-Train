import java.util.*;

public class EvenOdds {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		long n = scan.nextLong();
		long k = scan.nextLong();
		long curInt = 2 * k - 1;
		k -= ((n + 1) / 2);
		if (k <= 0) {
			System.out.println(curInt);
			return;
		}
		if (curInt > n) curInt = 2;
		curInt = curInt * k;
		System.out.println(curInt);
	}
}