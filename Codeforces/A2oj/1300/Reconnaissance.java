import java.util.Scanner;

public class Reconnaissance {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int min = Integer.MAX_VALUE;
		int[] soldiers = new int[n];
		for (int k = 0; k < n; k++) {
			soldiers[k] = scan.nextInt();
		}
		int man = 0;
		int woman = 0;
		for (int i = 0; i < n-1; i++) {
			int a = soldiers[i];
			if (i == 0 && Math.abs(a - soldiers[n-1]) < min) {
				min = Math.abs(a - soldiers[n-1]);
				man = i+1;
				woman = n;	
			} 
			if (i != 0 && Math.abs(a - soldiers[i-1]) < min) {
				min = Math.abs(a - soldiers[i-1]);
				man = i+1;
				woman = i;
			} 
			if (i != 0 && Math.abs(a - soldiers[i+1]) < min) {
				min = Math.abs(a - soldiers[i+1]);
				man = i+1;
				woman = i + 2;
			}
		}
		System.out.println(man + " " + woman);
	}
}