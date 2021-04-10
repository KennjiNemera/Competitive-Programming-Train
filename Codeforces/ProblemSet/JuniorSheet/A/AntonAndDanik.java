import java.util.Scanner;

public class AntonAndDanik {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		scan.nextLine();
		char[] arr = scan.nextLine().toCharArray();
		int ant = 0, dan = 0;

		for (char c : arr){
			if (c == 'A') ant++;
			else if (c == 'D') dan++;
		}

		if (ant == dan) System.out.println("Friendship");
		else if (ant > dan) System.out.println("Anton");
		else System.out.println("Danik");
	}
}