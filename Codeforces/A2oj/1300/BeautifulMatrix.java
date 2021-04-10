import java.util.*;

public class BeautifulMatrix {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int x = 0, y = 0;
		for (int i = 0; i < 5; i++)
		{
			String[] in = scan.nextLine().split(" ");
			for (int j = 0; j < 5; j++)
			{
				if (in[j].equals("1"))
				{
					x = i;
					y = j;
					System.out.println(Math.abs(x-2) + Math.abs(y-2));
					return;
				}
			}
		}
	}
}