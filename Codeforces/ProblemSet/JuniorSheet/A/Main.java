import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		while (true){
			int n = scan.nextInt();
			if (n == 0) break;
			int sqrt = (int) Math.sqrt(n);
			if (sqrt * sqrt == n) System.out.println("yes");
			else System.out.println("no");
		}
	}
}