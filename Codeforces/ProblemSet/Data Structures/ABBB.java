import java.util.*;
import java.lang.*;

public class ABBB {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		scan.nextLine();
		for (int i = 0; i < n; i++)
		{
			String s = scan.nextLine();
			System.out.println(solve(s));
		}

	}



	static int solve(String s)
	{
		Stack<Character> stk = new Stack<>();
		for (char c : s.toCharArray())
		{
			if (!stk.empty() && c == 'B') stk.pop();
			else stk.push(c);
		}
		return stk.size();
	}
}