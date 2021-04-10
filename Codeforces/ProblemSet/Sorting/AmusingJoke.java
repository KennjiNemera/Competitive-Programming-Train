import java.util.*;

public class AmusingJoke {

	static String target;

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String s = scan.nextLine();
		String n = scan.nextLine();
		String ans = scan.nextLine();
		target = s + n;

		String a = bubbleSort(target);
		String b = bubbleSort(ans);

		if (a.equals(b)) {
			System.out.println("YES");
		} else {
			System.out.println("NO");
		}
	}

	static String bubbleSort(String s) {
		char[] charArr = s.toCharArray();
		for (int i = 0; i < charArr.length; i++) {
			for (int j = i+1; j < charArr.length; j++) {
				if (charArr[i] > charArr[j]) {
					char c = charArr[i];
					charArr[i] = charArr[j];
					charArr[j] = (char) c;
				}
			}
		}
		return Arrays.toString(charArr);
	}

}