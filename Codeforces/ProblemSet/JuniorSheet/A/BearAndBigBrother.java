import java.util.*;

public class BearAndBigBrother {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int a = scan.nextInt(), b = scan.nextInt();
		int years = 0;

		while (a <= b)
		{
			years++;
			a *= 3;
			b *= 2;
		}

		System.out.println(years);
	}
}