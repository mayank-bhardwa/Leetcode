public class LongestIncreasingPath {
    public static void main(String[] args) {
        int[][] matrix = { { 9, 9, 4 }, { 6, 6, 8 }, { 2, 1, 1 } };
        System.out.println(longestIncreasingPath(matrix));
    }

    public static int longestIncreasingPath(int[][] matrix) {
        int res = 0;
        dp = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                res = Integer.max(res, Helper(matrix, i, j));
            }
        }
        return res;
    }

    private static int[] Xmove = { 1, -1, 0, 0 };
    private static int[] Ymove = { 0, 0, 1, -1 };
    private static int[][] dp;

    private static int Helper(int[][] matrix, int i, int j) {
        if (dp[i][j] != 0)
            return dp[i][j];
        int m = matrix.length, n = matrix[0].length;
        int res = 1;
        int x, y;
        for (int k = 0; k < 4; k++) {
            x = i + Xmove[k];
            y = j + Ymove[k];
            if (!isValidMove(m, n, x, y))
                continue;
            if (matrix[i][j] < matrix[x][y]) {
                res = Integer.max(res, 1 + Helper(matrix, x, y));
            }
        }
        return dp[i][j] = res;
    }

    private static boolean isValidMove(int m, int n, int i, int j) {
        if (i < 0 || j < 0 || i >= m || j >= n)
            return false;
        return true;
    }
}
