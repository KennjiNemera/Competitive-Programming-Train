import java.util.*;

public class VanyaAndFenya {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int h = scan.nextInt();
		int total = 0;

		for (int i = 0; i < n; i++)
		{
			if (scan.nextInt() > h) total += 2;
			else total += 1;
		}

		System.out.println(total);
	}
}