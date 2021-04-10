import java.util.*;

public class BlackSquare {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int[] arr = new int[4];

		for (int i = 0; i < 4; i++) arr[i] = scan.nextInt();

		scan.nextLine();

		String in = scan.nextLine();
		int total = 0;

		for (char c : in.toCharArray())
		{
			total += arr[Character.getNumericValue(c)-1];
		} 
		
		System.out.println(total);

	}
}