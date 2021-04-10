import java.util.Scanner;

public class TriangularNumber {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();

		double sr = Math.sqrt(8 * n + 1);
		if (sr ==  Math.floor(sr)) {
			System.out.println("YES");
		} else System.out.println("NO");
	}
}