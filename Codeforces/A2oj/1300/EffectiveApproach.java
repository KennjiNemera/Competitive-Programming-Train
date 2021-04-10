import java.util.*;

public class EffectiveApproach {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		List<Integer> arr = new ArrayList<>();
		long vTotal = 0, pTotal = 0;

		for (int i = 0; i < n; ++i) arr.add(scan.nextInt());

		boolean isSorted = isSorted(arr);	
		int qNum = scan.nextInt();
		
		if (isSorted && n > 10000)  {
			for (int j = 0; j < qNum; j++)
			{
				int num = scan.nextInt();
				vTotal += num;
				pTotal += (n-(num-1));
			} 
		} else {
			for (int i = 0; i < qNum; ++i)
			{
				int num = scan.nextInt();
				int vSearch = vasyaSearch(arr, num);
				vTotal += vSearch;
				pTotal += (n-(vSearch-1));
			}	
		}

		
		System.out.println(vTotal + " " + pTotal);

	}

	static int vasyaSearch(List<Integer> arr, int num) {
		return arr.indexOf(num) + 1;
	}

	static boolean isSorted(List<Integer> arr) {
		return arr.get(0) < arr.get(1) && arr.get(1) < arr.get(2);
	}
}