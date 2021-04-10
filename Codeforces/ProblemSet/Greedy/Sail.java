import java.util.*;
import java.io.*;

public class Sail {

	static int ex, ey;

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int t = scan.nextInt();
		int sx = scan.nextInt();
		int sy = scan.nextInt();
		ex = scan.nextInt();
		ey = scan.nextInt();
		int dist = Math.abs(sx - ex) + Math.abs(sy - ey);

		scan.nextLine();
		char[] dir = scan.nextLine().toCharArray();

		for (int i = 0; i < t; i++) {

			switch(dir[i]) {
				case 'N':
					if (getDist(sx, sy + 1) < dist) {
						sy++;
					}
					break;
				case 'S': 
					if (getDist(sx, sy - 1) < dist) {
						sy--;
					}
					break;
				case 'E':
					if (getDist(sx+1, sy) < dist) {
						sx++;
					}
					break;
				case 'W':
					if (getDist(sx-1, sy) < dist) {
						sx--;
					}
					break;
			}

			dist = getDist(sx, sy);

			if (sx == ex && sy == ey) {
				System.out.println(i+1);
				return;
			}
		}

		System.out.println(-1);
	}

	static int getDist(int x, int y) {
		return Math.abs(x - ex) + Math.abs(y - ey);		
	}


}