public class MakingLargeIsland {
    public static void main(String[] args) {
        char[][] grid = { { '0', '1', '0', '1', '1' }, { '1', '1', '0', '1', '1' }, { '1', '1', '0', '0', '0' },
                { '1', '0', '1', '1', '1' } };
        System.out.println(numIslands(grid));
    }

    private static int numIslands(char[][] grid) {
        int counter = 0;
        int n = grid.length, m = grid[0].length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == '1') {
                    counter++;
                    mark(grid, i, j);
                }
            }
        }
        return counter;
    }

    private static void mark(char[][] grid, int i, int j) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[i].length || grid[i][j] == '0')
            return;

        grid[i][j] = '0';

        if (i > 0)
            mark(grid, i - 1, j);
        if (i < grid.length)
            mark(grid, i + 1, j);
        if (j < grid[i].length)
            mark(grid, i, j + 1);
        if (j > 0)
            mark(grid, i, j - 1);
    }
}