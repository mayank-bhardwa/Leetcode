import java.util.*;

public class EvaluateDivision {
    public static void main(String[] args) {
        List<List<String>> equations = new ArrayList<>();
        equations.add(Arrays.asList("x1", "x2"));
        equations.add(Arrays.asList("x2", "x3"));
        equations.add(Arrays.asList("x3", "x4"));
        equations.add(Arrays.asList("x4", "x5"));

        double[] values = { 3.0, 4.0, 5.0, 6.0 };

        List<List<String>> queries = new ArrayList<>();
        queries.add(Arrays.asList("x1", "x5"));
        queries.add(Arrays.asList("x5", "x2"));
        queries.add(Arrays.asList("x2", "x4"));
        queries.add(Arrays.asList("x2", "x2"));
        queries.add(Arrays.asList("x2", "x9"));
        queries.add(Arrays.asList("x9", "x9"));

        double[] result = calcEquation(equations, values, queries);
        for (double d : result)
            System.out.print(d + " ");
    }
// [360.00000,0.00833,20.00000,1.00000,-1.00000,-1.00000]
    public static double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        double[] result = new double[queries.size()];

        HashMap<String, HashMap<String, Double>> graph = new HashMap<>();
        for (int i = 0; i < values.length; i++) {
            String from = equations.get(i).get(0);
            String to = equations.get(i).get(1);
            graph.putIfAbsent(from, new HashMap<>());
            graph.putIfAbsent(to, new HashMap<>());

            graph.get(from).put(to, values[i]);
            graph.get(to).put(from, 1 / values[i]);
        }

        int i = 0;
        for (List<String> query : queries) {
            String from = query.get(0);
            String to = query.get(1);
            result[i++] = dfs(graph, from, to, new HashSet<>());
        }

        return result;
    }

    private static double dfs(HashMap<String, HashMap<String, Double>> graph, String from, String to,
            HashSet<String> visited) {
        HashMap<String, Double> childs = graph.getOrDefault(from, null);
        if (childs == null)
            return -1;

        if (childs.containsKey(to))
            return childs.get(to);

        visited.add(from);

        for (String key : childs.keySet()) {
            if (visited.contains(key))
                continue;
            double res = dfs(graph, key, to, visited) * childs.get(key);
            if (res >= 0)
                return res;
        }
        visited.remove(from);
        return -1;
    }
}