import java.util.*;

public class BuildingTeams {

	static int n, m;
	static ArrayList<ArrayList<Integer>> grid;
	static ArrayList<Integer> color;
	static ArrayList<Boolean> vis;

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		n = scan.nextInt();
		m = scan.nextInt();

		grid = new ArrayList<>();
		color = new ArrayList<>();
		vis = new ArrayList<>();

		for (int i = 0; i < n; i++) {
			grid.add(new ArrayList<>());
			vis.add(false);
			color.add(0);
		}

		for (int con = 0; con < m; con++) {
			int a = scan.nextInt();
			int b = scan.nextInt();

			grid.get(a-1).add(b);
			grid.get(b-1).add(a);
		}

		boolean result = colourAll();

		if (!result) {
			System.out.println("IMPOSSIBLE");
		} else {
			for (int child = 0; child < color.size(); child++) {
				System.out.print(color.get(child) + " ");
			}
		}
	}

	static boolean colourAll() {
		for (int i = 0; i < n; i++) {
			if (!vis.get(i)) {
				if (!dfs(i,1,-1)) return false;
			}
		}
		return true;
	}

	static boolean dfs(int node, int colour, int parent) {
		vis.set(node, true);
		color.set(node, colour);
		// System.out.println("PARENT: " + node);

		for (int child : grid.get(node)) {
			// System.out.println("CHILD: " + child );
			if (child == parent+1) continue;
			if (color.get(child-1) == 0) {
				if (!dfs(child-1, color.get(node)^3, node)) {
					return false;
				}
			} else if (color.get(child-1) == colour) {
				return false;
			}
		}
		return true;
	}


}