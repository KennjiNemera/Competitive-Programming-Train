import java.util.Scanner;

public class Parallelepiped {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int a = scan.nextInt();
		int b = scan.nextInt();
		int c = scan.nextInt();
		int ia = (int) Math.sqrt(a * b / c);
		int ib = (int) Math.sqrt(b * c / a);
		int ic = (int) Math.sqrt(a * c / b);
		System.out.println(4 * (ia + ib + ic));
	}
}