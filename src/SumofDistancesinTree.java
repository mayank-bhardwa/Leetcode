import java.util.ArrayList;

public class SumfDistancesinTree {
	public static void main(String[] args) {
		int n = 6;
		int[][] edges ={{0, 1}, {0, 2}, {2, 3}, {2, 4}, {2, 5}};
		int[] res = sumOfDistancesInTree(n, edges);
		for (int i : res)System.out.printf("%d ", i);
	}

	private static int[] sumOfDistancesInTree(int n, int[][] edges) {
		int[] res = new int[n];
		ArrayList<Integer>[] graph = new ArrayList[n];
		for (int i = 0; i < n; i++)graph[i] = new ArrayList<>();
		for (int[] edge : edges) {
			graph[edge[0]].add(edge[1]);
			graph[edge[1]].add(edge[0]);
		}

		int dp[][] = new int[n][n];

		for (int i = 0; i < n; i++) {
			res[i] = dfs(i, graph, new boolean[n], 0);
		}

		return res;
	}

	private static int dp[][];

	private static int dfs(int u, ArrayList<Integer>[] graph, boolean[] visited, int depth) {
		visited[u] = true;
		int res = depth;
		for (int v : graph[u]) {
			if (!visited[v]) {
				res += dfs(v, graph, visited, depth + 1);
			}
		}

		return res;
	}
}