import java.util.*;

public class NewPassword {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int k = scan.nextInt();
		Set<Character> set = new HashSet<>();
		String out = "";
		char c = 'a';
		int distCount = 0;

		for (int i = 0; i < n; i++)
		{	
			if (distCount < k)
			{
				out += c;
				set.add(c);
				c++;
				distCount++;
			} else {
				for (char usedC : set)
				{
					if (out.charAt(out.length()-1) != usedC)
					{
						out += usedC;
						break;
					}
				}
			}
		}

		System.out.println(out);

	}
}