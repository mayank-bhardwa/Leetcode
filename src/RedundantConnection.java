public class RedundantConnection {
    public static void main(String[] args) {
        int[][] edges = { { 1, 2 }, { 2, 3 }, { 3, 4 }, { 1, 4 }, { 1, 5 } };
        int[] edge = findRedundantConnection(edges);
        System.out.println(edge[0] + " " + edge[1]);
    }

    private static int[] parent;

    public static int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        parent = new int[n + 1];
        for (int i = 0; i <= n; i++)
            parent[i] = i;

        for (int[] edge : edges) {
            if (find(edge[0]) == find(edge[1]))
                return edge;

            union(edge[0], edge[1]);
        }

        int[] res = { -1, -1 };
        return res;
    }

    private static int find(int u) {
        while (parent[u] != u)
            u = parent[u];

        return u;
    }

    private static void union(int u, int v) {
        u = find(u);
        v = find(v);

        parent[u] = v;
    }
}
