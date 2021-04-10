import java.util.*;

public class StonesOnTheSurds {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		scan.nextLine();
		StringBuilder sb = new StringBuilder(scan.nextLine());
		int total = 0;

		for (int i = 0; i < sb.length()-1; i++)
		{
			if (sb.charAt(i) == sb.charAt(i+1))
			{
				sb.deleteCharAt(i);
				i--;
				total++;
			}
		}

		System.out.println(total);
	}
}