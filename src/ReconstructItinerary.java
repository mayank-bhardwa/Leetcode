import java.util.*;

public class ReconstructItinerary {
    public static void main(String[] args) {
        List<List<String>> tickets = new ArrayList<>();
        tickets.add(Arrays.asList("JFK", "SFO"));
        tickets.add(Arrays.asList("JFK", "ATL"));
        // tickets.add(Arrays.asList("SFO", "ATL"));
        tickets.add(Arrays.asList("ATL", "JFK"));
        // tickets.add(Arrays.asList("ATL", "SFO"));
        List<String> iterOder = findItinerary(tickets);
        System.out.println(iterOder.toString());
    }

    public static List<String> findItinerary(List<List<String>> tickets) {
        List<String> iterOrder = new ArrayList<>();
        HashMap<String, PriorityQueue<String>> graph = new HashMap<>();
        for (List<String> i : tickets) {
            graph.putIfAbsent(i.get(0), new PriorityQueue<>());
            graph.get(i.get(0)).add(i.get(1));
        }

        dfs(graph, "JFK", iterOrder);

        Collections.reverse(iterOrder);

        return iterOrder;
    }

    private static void dfs(HashMap<String, PriorityQueue<String>> graph, String source, List<String> res) {
        if (graph.containsKey(source)) {
            PriorityQueue<String> path = graph.get(source);
            while (!path.isEmpty()) {
                dfs(graph, path.poll(), res);
            }
        }
        res.add(source);
    }
}