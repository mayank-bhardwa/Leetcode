import java.util.*;

public class RedundantDirectedConnection {
    public static void main(String[] args) {
        int[][] edges = { { 2, 1 }, { 3, 1 }, { 4, 2 }, { 1, 4 } };
        int[] res = findRedundantDirectedConnection(edges);
        System.out.println(res[0] + " " + res[1]);
    }

    public static int[] findRedundantDirectedConnection(int[][] edges) {
        int n = edges.length;
        HashMap<Integer, PriorityQueue<Pair<Integer, Integer>>> graph = new HashMap<>();
        for (int i = 0; i < n; i++) {
            graph.putIfAbsent(edges[i][0], new PriorityQueue<>(new comparator()));
            graph.get(edges[i][0]).add(new Pair<>(i, edges[i][1]));
        }

        return null;
    }
}

class comparator implements Comparator<Pair<Integer, Integer>> {
    @Override
    public int compare(Pair<Integer, Integer> o1, Pair<Integer, Integer> o2) {
        return o1.first - o2.first;
    }
}
