import java.util.*;

public class Equilibrium {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();

		int x = 0, y = 0, z = 0;

		for (int i = 0; i < n; ++i)
		{
			x += scan.nextInt();
			y += scan.nextInt();
			z += scan.nextInt();
		}

		if (x == 0 && y == 0 && z == 0) System.out.println("YES");
		else System.out.println("NO");
	}
}