import java.util.LinkedList;
import java.util.Queue;

public class isBiparatite {
    public static void main(String[] args) {
        int[][] graph = { { 4 }, {}, { 4 }, { 4 }, { 0, 2, 3 } };
        System.out.println(checkBiparatite(graph));
    }

    private static boolean checkBiparatite(int[][] graph) {
        int[] color = new int[graph.length];

        for (int i = 0; i < graph.length; i++) {
            if (color[i] == 0) {
                if (!bfs(graph, color, i))
                    return false;
            }
        }

        return true;
    }

    private static boolean bfs(int[][] graph, int[] color, int u) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(u);
        color[u] = 1;
        int f;
        while (!q.isEmpty()) {
            f = q.poll();

            for (int i : graph[f]) {
                if (color[i] == 0) {
                    if (color[f] == 1)
                        color[i] = 2;
                    else
                        color[i] = 1;
                    q.offer(i);

                } else if (color[i] == color[f])
                    return false;
            }
        }

        return true;
    }
}
