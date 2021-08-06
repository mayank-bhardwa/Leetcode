import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CourseSchedule {
    public static void main(String[] args) {
        int[][] prereq = { { 1, 0 }, { 0, 3 }, { 0, 2 }, { 3, 2 }, { 2, 5 }, { 4, 5 }, { 5, 6 }, { 2, 4 } };
        int numCourses = 7;

        System.out.println(canFinish(numCourses, prereq));
    }

    private static boolean canFinish(int numCourses, int[][] prereq) {

        boolean[] visited = new boolean[numCourses];
        boolean[] root = new boolean[numCourses];

        HashMap<Integer, List<Integer>> lookup = new HashMap<>();

        for (int[] pair : prereq) {
            List<Integer> l = lookup.getOrDefault(pair[1], new ArrayList<>());
            l.add(pair[0]);
            lookup.put(pair[1], l);
        }

        for (int i = 0; i < numCourses; i++) {
            if (!visited[i]) {
                if (containCycle(i, lookup, visited, root))
                    return false;
            }
        }

        return true;
    }

    private static boolean containCycle(int i, HashMap<Integer, List<Integer>> lookup, boolean[] visited,
            boolean[] root) {
        if (root[i])
            return true;

        if (visited[i])
            return false;

        root[i] = true;
        visited[i] = true;

        List<Integer> temp = lookup.getOrDefault(i, new ArrayList<>());
        for (int j : temp) {
            if (containCycle(j, lookup, visited, root)) {
                return true;
            }
        }

        root[i] = false;

        return false;
    }
}