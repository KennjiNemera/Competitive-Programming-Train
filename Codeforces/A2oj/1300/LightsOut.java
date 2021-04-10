import java.util.*;

public class LightsOut {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int[][] map = {{1,1,1}, {1,1,1}, {1,1,1}};
		int[][] flickMap = new int[3][3];

		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				flickMap[i][j] = scan.nextInt();
			}
		}

		for (int x = 0; x < 3; x++) {
			for (int y = 0; y < 3; y++) {
				if (!isOn(flickMap, x, y))
				{
					map[x][y] = 0;
				}
			}
		}

		for (int[] row : map)
		{
			for (int light : row)
			{
				System.out.print(light);
			}
			System.out.println();
		}




	}

	static boolean isOn(int[][] map, int i, int j)
	{
		int total = map[i][j];
		int[][] moves = {{-1,0}, {1,0}, {0,-1}, {0,1}};

		for (int[] move : moves)
		{
			int x = i + move[0];
			int y = j + move[1];
			if (x < 0 || x >= 3 || y < 0 || y >= 3) continue;
			total += map[x][y];
		}

		return total % 2 == 0;
	}
}