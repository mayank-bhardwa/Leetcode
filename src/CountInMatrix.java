/*
Given a m x n matrix grid which is sorted
in non-increasing order both row-wise and 
column-wise, return the number of negative 
numbers in grid.
*/
public class CountInMatrix {
    public static void main(String[] args) {
        int[][] matrix = { { 4, 3, 2, -1 }, { 3, 2, 1, -1 }, { 1, 1, -1, -2 }, { -1, -1, -2, -3 } };
        System.out.println(countNegatives(matrix));
    }

    private static int countNegatives(int[][] grid) {
        int count = 0;
        int row = grid.length;
        int col = grid[0].length;
        int r = row - 1;
        int c = 0;

        while (r >= 0 && c < col) {
            if (grid[r][c] < 0) {
                count += col - c;
                r--;
            } else {
                c++;
            }
        }

        return count;
    }
}