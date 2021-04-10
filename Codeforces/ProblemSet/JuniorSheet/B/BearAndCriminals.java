import java.util.Scanner;

public class BearAndCriminals {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int a = scan.nextInt()-1;
		int[] cities = new int[n];
		int total = 0;

		for (int i = 0; i < n; i++)
		{
			cities[i] = scan.nextInt();
		}

		int j = 1;
		if (cities[a] == 1) {
			total++;
		}
		while (true)
		{
			if (a-j < 0 && a+j >= n) {
				System.out.println(total);
				return;
			} else if (a-j < 0 && cities[a+j] == 0 || a+j >= n && cities[a-j] == 0); 
				else if (a-j < 0 && cities[a+j] == 1 || a+j >= n && cities[a-j] == 1) total += 1;
				else if (cities[a-j] == 1 && cities[a+j] == 1) total += 2;
			j++;
		}
	}
}