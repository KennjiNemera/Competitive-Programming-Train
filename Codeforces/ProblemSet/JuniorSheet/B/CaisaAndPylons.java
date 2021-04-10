import java.util.*;

public class CaisaAndPylons {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int energy = 0;
		int first = scan.nextInt();
		int cost = first;

		for (int i = 0; i < n-1; i++)
		{
			int next = scan.nextInt();
			energy += first - next;
			if (energy < 0) {
				cost += Math.abs(energy);
				energy = 0; 
			} 
			first = next;
		}

		System.out.println(cost);


	}
}