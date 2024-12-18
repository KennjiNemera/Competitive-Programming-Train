import java.util.*;

public class RoundTrip {

	static int n, m;
	static int sv, ev;
	static ArrayList<ArrayList<Integer>> g = new ArrayList<>();
	static ArrayList<Integer> par = new ArrayList<>();
	static ArrayList<Boolean> vis = new ArrayList<>();
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		n = scan.nextInt();
		m = scan.nextInt();

		for (int i = 0; i < n; i++) {
			g.add(new ArrayList<Integer>());
			vis.add(false);
			par.add(-1);
		}

		for (int road = 0; road < m; road++) {
			int a = scan.nextInt(), b = scan.nextInt();

			g.get(a-1).add(b);
			g.get(b-1).add(a);
		}
		
		boolean isCycle = visitAll();


		if (!isCycle) {
			System.out.println("IMPOSSIBLE");
			return;
		}
		
		int cv = ev;
		ArrayList<Integer> ans = new ArrayList<>();
		ans.add(ev);

		while(cv != sv) {
			ans.add(par.get(cv-1));
			cv = par.get(cv-1);
		}

		ans.add(ev);

		System.out.println(ans.size());

		for (int c : ans) {
			System.out.print(c + " ");
		}
	}

	// Handles all the connected components
	static boolean visitAll() {
		for (int i = 1; i <= n; i++) {
			if (!vis.get(i-1)) {
				if (dfs(i, -1)) {
					return true;
				}
			}
		}
		return false;
	}

	// Perform DFS on the vertices
	static boolean dfs(int n, int p) {
		vis.set(n-1, true);
		par.set(n-1, p);

		for (int v : g.get(n-1)) {

			if (v == p) continue;

			// Detected a cycle
			if (vis.get(v-1)) {
				sv = v;
				ev = n;
				return true;
			}

			// Continue recursive
			if (!vis.get(v-1)) {
				if (dfs(v, n)) return true;
			}
		}
		return false;
	}

}