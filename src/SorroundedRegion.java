public class SorroundedRegion {
    public static void main(String[] args)

    {
        char[][] board = { { 'O', 'O' }, { 'O', 'O' } };// { { 'X', 'X', 'X', 'X' }, { 'X', 'O', 'O', 'X' }, { 'X', 'X',
                                                        // 'O', 'X' },{ 'X', 'O', 'X', 'X' } };
        solve(board);

        for (char[] row : board) {
            for (char i : row)
                System.out.printf("%c ", i);
            System.out.println();
        }
    }

    private static void solve(char[][] board) {
        int rows = board.length - 1;
        int cols = board[0].length - 1;

        for (int i = 0; i <= rows; i++) {
            if (board[i][0] == 'O')
                mark(board, i, 0);

            if (board[i][cols] == 'O')
                mark(board, i, cols);
        }

        for (int i = 0; i <= cols; i++) {
            if (board[0][i] == 'O')
                mark(board, 0, i);

            if (board[rows][i] == 'O')
                mark(board, rows, i);
        }

        for (int i = 0; i <= rows; i++)
            for (int j = 0; j <= cols; j++)
                if (board[i][j] == '-')
                    board[i][j] = 'O';
                else if (board[i][j] == 'O')
                    board[i][j] = 'X';
    }

    private static void mark(char[][] board, int i, int j) {
        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length || board[i][j] == 'X' || board[i][j] == '-')
            return;

        board[i][j] = '-';
        mark(board, i + 1, j);
        mark(board, i - 1, j);
        mark(board, i, j + 1);
        mark(board, i, j - 1);
    }
}
