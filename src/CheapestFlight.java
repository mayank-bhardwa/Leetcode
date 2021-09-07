import java.util.ArrayList;
import java.util.HashMap;
import java.util.PriorityQueue;

public class CheapestFlight {
    public static void main(String[] args) {
        int n = 5, src = 0, dst = 2, k = 2;
        int[][] flights = { { 0, 1, 5 }, { 1, 2, 5 }, { 0, 3, 2 }, { 3, 1, 2 }, { 1, 4, 1 }, { 4, 2, 1 } };
        System.out.println(findCheapestPrice(n, flights, src, dst, k));
    }

    public static int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        HashMap<Integer, ArrayList<int[]>> graph = new HashMap<>();
        for (int[] i : flights) {
            int[] temp = { i[1], i[2] };

            if (!graph.containsKey(i[0]))
                graph.put(i[0], new ArrayList<>());

            graph.get(i[0]).add(temp);
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((ob1, ob2) -> {
            return ob1[1] - ob2[1];
        });

        int[] temp = { src, 0, 0 };
        pq.offer(temp);
        int[] distance = new int[n + 1];
        for (int i = 0; i <= n; i++)
            distance[i] = Integer.MAX_VALUE;
        distance[src] = 0;

        while (!pq.isEmpty()) {
            temp = pq.poll();

            if (temp[2] > k + 1)
                continue;

            if (temp[0] == dst)
                return temp[1];

            if (graph.containsKey(temp[0]))
                for (int[] i : graph.get(temp[0])) {
                    int[] temp1 = { i[0], temp[1] + i[1], temp[2] + 1 };
                    pq.offer(temp1);
                    distance[i[0]] = temp1[1];
                }
        }

        return -1;
    }
}
