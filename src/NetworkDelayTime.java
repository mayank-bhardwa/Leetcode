import java.util.ArrayList;
import java.util.PriorityQueue;

public class NetworkDelayTime {
    public static void main(String[] args) {
        int[][] times = { { 1, 2, 1 }, { 2, 3, 7 }, { 1, 3, 4 }, { 2, 1, 2 } };
        int n = 4;
        int k = 1;
        int res = networkDelayTime(times, n, k);
        System.out.println(res);
    }

    private static int networkDelayTime(int[][] times, int n, int k) {
        ArrayList<ArrayList<int[]>> adjList = new ArrayList<>();
        for (int i = 0; i <= n; i++)
            adjList.add(new ArrayList<>());
        for (int[] i : times) {
            int[] arr = { i[1], i[2] };
            adjList.get(i[0]).add(arr);
        }

        return bfs(adjList, k, n);
    }

    private static int bfs(ArrayList<ArrayList<int[]>> adjList, int k, int n) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((ob1, ob2) -> {
            return ob1[1] - ob2[1];
        });

        boolean[] visited = new boolean[n + 1];
        int[] arr = { k, 0 };
        pq.add(arr);
        int[] distance = new int[n + 1];
        for (int i = 1; i <= n; i++)
            distance[i] = Integer.MAX_VALUE;
        distance[k] = 0;
        while (!pq.isEmpty()) {
            int[] p = pq.poll();
            if (visited[p[0]])
                continue;
            visited[p[0]] = true;
            for (int[] i : adjList.get(p[0])) {
                if (!visited[i[0]] && distance[i[0]] > i[1] + p[1]) {
                    i[1] += p[1];
                    pq.offer(i);
                    distance[i[0]] = i[1];
                }
            }
        }

        int res = -1;
        for (int i = 1; i < n + 1; i++)
            res = Integer.max(res, distance[i]);
        return res == Integer.MAX_VALUE ? -1 : res;
    }
}
