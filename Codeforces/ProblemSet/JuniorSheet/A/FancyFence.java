import java.util.Scanner;
import java.util.Scanner;


public class FancyFence {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		for (int i = 0; i < n; i++)
		{
			int a = scan.nextInt();
			if (360 % (180-a) == 0) System.out.println("YES");
			else System.out.println("NO");
		}
	}
}
