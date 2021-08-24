import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LargeIsland {
    public static void main(String[] args) {
        int[][] grid = { { 1, 0 }, { 0, 1 } };
        int area = largestIsland(grid);
        System.out.println(area);
    }

    private static int largestIsland(int[][] grid) {
        List<Set<Pair<Integer,Integer>>> islands = new ArrayList<>();

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid.length; j++) {
                if(grid[i][j] == 1)
                { 
                    if(islands.isEmpty())
                    {
                        Set<Pair<Integer, Integer>> s = new HashSet<>();
                        s.add(new Pair<>(i, j));

                        islands.add(s);
                    }
                    else 
                    {
                        
                    }
                }
            }
        }
        return 0;
    }
}
