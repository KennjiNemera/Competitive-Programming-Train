import java.util.*;

public class Jzzhu {

	static class Pair {
		int pos;
		int need;

		public Pair(int pos, int need)
		{
			this.pos = pos;
			this.need = need;
		}
	}
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int m = scan.nextInt();

		Queue<Pair> q = new LinkedList<>();

		for (int i = 0; i < n; i++) q.offer(new Pair(i+1, scan.nextInt()));

		while (q.size() != 1)
		{
			Pair polled = q.poll();

			polled.need -= m;

			if (polled.need > 0) q.offer(polled);
		}

		System.out.println(q.peek().pos);
	}
}