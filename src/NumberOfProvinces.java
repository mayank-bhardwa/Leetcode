public class NumberOfProvinces {
    public static void main(String[] args) {
        int[][] isConnected = { { 1, 0, 0, 1 }, { 0, 1, 1, 0 }, { 0, 1, 1, 1 }, { 1, 0, 1, 1 } };
        System.out.println(findCircleNum(isConnected));
    }

    public static int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        int count = 0;

        boolean[] visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (visited[i])
                continue;

            count++;
            dfs(isConnected, i, visited);
        }

        return count;
    }

    private static void dfs(int[][] graph, int source, boolean[] visited) {
        visited[source] = true;
        for (int i = 0; i < visited.length; i++) {
            if (graph[source][i] == 1 && !visited[i])
                dfs(graph, i, visited);
        }
    }
}
