import java.util.ArrayList;
import java.util.Hashtable;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class CourseSchedule {
    public static void main(String[] args) {
        int[][] prereq = { { 1, 4 }, { 2, 4 }, { 3, 1 }, { 3, 2 } };
        int numCourses = 5;

        System.out.println(canFinish(numCourses, prereq));
    }

    private static boolean canFinish(int numCourses, int[][] prereq) {
        Hashtable<Integer, List<Integer>> adj = new Hashtable<>();
        for (int i = 0; i < prereq.length; i++) {
            if (adj.containsKey(prereq[i][0]))
                adj.get(prereq[i][0]).add(prereq[i][1]);
            else {
                adj.put(prereq[i][0], new ArrayList<>());
                adj.get(prereq[i][0]).add(prereq[i][1]);
            }
        }

        Queue<Integer> q = new LinkedList<>();

        for (int i = 0; i < numCourses; i++) {
            if (adj.containsKey(i)) {
                boolean[] visited = new boolean[numCourses];

                q.clear();
                q.offer(i);
                while (!q.isEmpty()) {
                    int t = q.poll();
                    visited[t] = true;
                    if (adj.containsKey(t))
                        for (int k : adj.get(t)) {
                            if (visited[k])
                                return false;
                            q.offer(k);
                        }
                }
            }
        }

        return true;
    }
}
