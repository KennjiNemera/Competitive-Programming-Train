import java.util.*;

public class SuperCentral {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int[][] arr = new int[n][2];
		int total = 0;

		for (int i = 0; i < n; i++)
		{
			arr[i][0] = scan.nextInt();
			arr[i][1] = scan.nextInt();
		}

		int ordCount = 0;

		for (int j = 0; j < n; j++)
		{
			boolean[] state = {false, false, false, false};
			int x = arr[j][0];
			int y = arr[j][1];

			for (int k = 0; k < n; k++)
			{
				int tempX = arr[k][0];
				int tempY = arr[k][1];

				isPerpendicular(state, x, y, tempX, tempY);
			}

			boolean found = false;

			for (int ind = 0; ind < 4; ind++)
			{
				if (state[ind] == false) {
					found = true;
					break;
				}
			}

			if (!found) total++;
		}

		System.out.println(total);
	}

	static void isPerpendicular(boolean[] state, int x, int y, int tempX, int tempY)
	{
		if (x == tempX && y < tempY) {
			state[0] = true;
			return;
		}
		if (x == tempX && y > tempY) {
			state[1] = true;
			return;
		}
		if (y == tempY && x < tempX) {
			state[2] = true;
			return;
		}
		if (y == tempY && x > tempX) {
			state[3] = true;
			return;
		}
	}
}