import java.util.*;

public class QueueAtSchool {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int t = scan.nextInt();
		scan.nextLine();
		char[] q = scan.nextLine().toCharArray();

		for (int time = 0; time < t; time++)
		{
			for (int i = 0; i < n-1; i++)
			{
				if (q[i] == 'B' && q[i+1] == 'G')
				{
					q[i] = 'G';
					q[i+1] = 'B';
					i++;
				}
			}	
		}

		for (char c : q)
		{
			System.out.print(c);
		}
	}
}