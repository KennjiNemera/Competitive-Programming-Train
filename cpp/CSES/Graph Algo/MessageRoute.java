import java.util.*;

public class MessageRoute {

	static ArrayList<ArrayList<Integer>> grid;
	static ArrayList<Boolean> vis;
	static ArrayList<Integer> par;
	static int count = 0;
	static int n, m;

	public static void main(String[] args) {
		long startTime = System.nanoTime();
		Scanner scan = new Scanner(System.in);
		n = scan.nextInt();
		m = scan.nextInt();

		grid = new ArrayList<>();
		vis = new ArrayList<>();
		par = new ArrayList<>();

		for (int i = 0; i < n; i++) {
			grid.add(new ArrayList<Integer>());
			vis.add(false);
		}

		for (int j = 0; j <= n; j++) {
			par.add(-1);
		}

		for (int j = 0; j < m; j++) {
			int u = scan.nextInt(), v = scan.nextInt();

			grid.get(u - 1).add(v);
			grid.get(v - 1).add(u);
		}

		bfs();
		
		if (par.get(n-1) == -1) {
			System.out.println("IMPOSSIBLE");
			return;
		}

		par.set(0, -1);
		int candidate = n;
		Stack<Integer> stk = new Stack<>();
		while (candidate != -1) {
			stk.push(candidate);
			candidate = par.get(candidate-1);
		}

		System.out.println(stk.size());

		while (!stk.isEmpty()) {
			System.out.print(stk.pop() + " ");
		}

		long endTime   = System.nanoTime();
		long totalTime = (endTime - startTime) / 1000;
		System.out.println(totalTime);
	}

	static void bfs() {
		Queue<Integer> q = new LinkedList<>();
		q.offer(1);
		while (!q.isEmpty()) {
			int curNode = q.poll();
			for (int i : grid.get(curNode-1)) {
				if (i == n) {
					vis.set(i-1, true);
					par.set(i-1, curNode);
					return;
				}
				if (!vis.get(i-1)) {
					q.offer(i);
					vis.set(i-1, true);
					par.set(i-1, curNode);
				}
			}
		}
	}
}