import java.util.*;

public class Dima {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt() + 1;

		int total = 0, answer = 0;

		for (int i = 0; i < n-1; i++) total += scan.nextInt();

		for (int j = 1; j <= 5; j++)
		{
			if ((total + j) % (n) != 1) answer += 1;
		}

		System.out.println(answer);
	}
}