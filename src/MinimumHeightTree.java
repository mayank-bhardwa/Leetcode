import java.util.*;

public class MinimumHeightTree {
    public static void main(String[] args) {
        int[][] edges = { { 3, 0 }, { 3, 1 }, { 3, 2 }, { 3, 4 }, { 5, 4 } };
        int n = 6;
        List<Integer> result = findMinHeightTrees(n, edges);
        result.forEach((i) -> {
            System.out.printf("%d ", i);
        });
        System.out.println();
    }

    public static List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if (n == 1)
            return Arrays.asList(0);
        int[] outDegree = new int[n];
        List<Integer>[] adjacencyList = new List[n];
        for (int i = 0; i < n; i++)
            adjacencyList[i] = new ArrayList<>();
        for (int[] i : edges) {
            adjacencyList[i[0]].add(i[1]);
            adjacencyList[i[1]].add(i[0]);
            outDegree[i[0]]++;
            outDegree[i[1]]++;
        }

        Queue<Integer> q = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            if (outDegree[i] == 1)
                q.offer(i);
        }

        int s, f;
        while (n > 2) {
            s = q.size();
            n -= s;
            while (s-- > 0) {
                f = q.poll();
                outDegree[f]--;

                for (int i : adjacencyList[f]) {
                    outDegree[i]--;
                    if (outDegree[i] == 1) {
                        q.offer(i);
                    }
                }
            }
        }

        return new ArrayList<>(q);
    }
}
