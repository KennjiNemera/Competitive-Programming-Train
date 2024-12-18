import java.util.*;

public class Building {

	static ArrayList<ArrayList<Integer>> grid;
	static ArrayList<Boolean> vis;
	static ArrayList<Integer> lead;
	static int cc = 0;
	static int n, m;

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		n = scan.nextInt();
		m = scan.nextInt();

		grid = new ArrayList<>();
		vis = new ArrayList<>();
		lead = new ArrayList<>();

		for (int j = 0; j < n; j++) {
			grid.add(new ArrayList<Integer>());
			vis.add(false);
		}

		for (int i = 0; i < m; i++) {
			int u, v;
			u = scan.nextInt();
			v = scan.nextInt();

			grid.get(u-1).add(v);
			grid.get(v-1).add(u);
		}

		process_cc();

		System.out.println(cc - 1);

		if (cc > 1) {
			int u = lead.get(0);
			int v;
			for (int i = 1; i < cc; i++) {
				v = lead.get(i);
				System.out.println(u + " " + v);
				u = v;
			}
		}

	}

	static void process_cc() {
		for (int i = 0; i < n; i++) {
			if (!vis.get(i)) {
				cc++;
				lead.add(i+1);
				dfs(i);
			}
		}
	}

	static void dfs(int u) {
		vis.set(u, true);
		for (int v : grid.get(u)) {
			if(!vis.get(v-1))	{
				dfs(v-1);
			}
		}
	}
}
