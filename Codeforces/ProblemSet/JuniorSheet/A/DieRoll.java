import java.util.*;

public class DieRoll {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int m = scan.nextInt();

		int max = Math.max(n,m);
		int req = 6-max+1;
		int denom = 6;

		if (max == 1) {
			System.out.println("1/1");
			return;
		} 

		for (int i = req; req > 0; i--)
		{
			if (denom % i == 0 && req % i == 0)
			{
				denom /= i;
				req /= i;
				break;
			}
		}

		System.out.println(req + "/" + denom);

	}
}