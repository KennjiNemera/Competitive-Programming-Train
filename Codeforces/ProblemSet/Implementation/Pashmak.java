import java.util.*;

public class Pashmak {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int x1 = scan.nextInt();
		int y1 = scan.nextInt();
		int x2 = scan.nextInt();
		int y2 = scan.nextInt();

		if (x1 == x2) {
			System.out.println((Math.abs(y1-y2)+x1) + " " + y1 + " " + (Math.abs(y1-y2)+x2) + " " + y2);
		} else if (y1 == y2) {
			System.out.println(x1 + " " + (Math.abs(x1-x2) + y1) + " " + x2 + " " + (Math.abs(x1-x2) + y2));
		} else if (Math.abs(x1-x2) == Math.abs(y2 - y1)) {
			System.out.println(x1 + " " + y2 + " " +  x2 + " " + y1);
		} else {
			System.out.println(-1);
		}
	}
}