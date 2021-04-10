import java.util.*;

public class PoliceRecruits {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int total = 0;
		int numCops = 0;

		for (int i = 0; i < n; i++)
		{
			int num = scan.nextInt();
			switch (num)
			{
				case -1:
					if (numCops == 0) total++;
					else numCops--;
					break;
				default:
					numCops += num;
					break;
			}
		}
		System.out.println(total);
	}
}