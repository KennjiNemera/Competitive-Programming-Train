import java.util.*;

public class Coins {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int[] arr = new int[3];

		for (int i = 0; i < 3; i++)
		{
			String s = scan.nextLine();
			if (s.charAt(1) == '>') {
				switch (s.charAt(0))
				{
					case 'A': arr[0]++;
						break;
					case 'B': arr[1]++;
						break;
					case 'C': arr[2]++;
						break;
				}
			} else {
				switch (s.charAt(2))
				{
					case 'A': arr[0]++;
						break;
					case 'B': arr[1]++;
						break;
					case 'C': arr[2]++;
						break;
				}
			}
		}

		String out = "";

		Set<Integer> set = new HashSet<>();
		for (int i = 0; i < 3; i++) {
			if (!set.contains(arr[i])) {
				set.add(arr[i]);
			} else {
				System.out.println("Impossible");
				return;
			}
		}

		for (int i = 0; i < 3; i++)
		{
			for (int j = 0; j < 3; j++) {
				if (arr[j] == i) {
					switch (j) {
						case 0: out += "A";
							break;
						case 1: out += "B";
							break;
						case 2: out += "C";
							break;
					}
					break;
				}
			}
		}

		System.out.println(out);



	}
}