import java.util.Scanner;

public class ShaassAndOskols {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int[] arr = new int[n];

		for (int i = 0; i < n; i++) arr[i] = scan.nextInt();

		int m = scan.nextInt();

		for (int k = 0; k < m; k++)
		{
			int x = scan.nextInt();
			int y = scan.nextInt();

			if (x == 1)
			{
				if (n != 1) {
					arr[x] += arr[x-1] - y;
					arr[x-1] = 0;					
				} else {
					arr[x-1] = 0;
				}

			} else if (x == n)
			{
				arr[x-2] += y-1;
				arr[x-1] = 0;
			} else {
				arr[x-2] += y-1;
				arr[x] += arr[x-1] - y;
				arr[x-1] = 0;
			}
		}

		for (int a : arr) System.out.println(a);
	}
}