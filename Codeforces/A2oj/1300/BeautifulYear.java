import java.util.*;

public class BeautifulYear {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt()+1;
		while (true) {
			if (isDistinct(n)) {
				System.out.println(n);
				return;
			}
			n++;
		}
	}

	static boolean isDistinct(int n)
	{
		Set<Integer> numSet = new HashSet<>();
		while (n > 0)
		{
			int mod = n % 10;
			n /= 10;

			if (!numSet.contains(mod))
			{
				numSet.add(mod);
			} else return false;
		}
		return true;
	}
}