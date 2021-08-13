import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

/*
Given an m x n matrix, return a new matrix answer where answer[row][col] is the rank of matrix[row][col].

The rank is an integer that represents how large an element is compared to other elements. It is calculated using the following rules:

The rank is an integer starting from 1.
If two elements p and q are in the same row or column, then:
If p < q then rank(p) < rank(q)
If p == q then rank(p) == rank(q)
If p > q then rank(p) > rank(q)
The rank should be as small as possible.
*/

public class RankTransformMatrix {
    public static void main(String[] args) {
        int[][] mat = { { -2, -35, -32, -5, -30, 33, -12 }, { 7, 2, -43, 4, -49, 14, 17 },
                { 4, 23, -6, -15, -24, -17, 6 }, { -47, 20, 39, -26, 9, -44, 39 }, { -50, -47, 44, 43, -22, 33, -36 },
                { -13, 34, 49, 24, 23, -2, -35 }, { -40, 43, -22, -19, -4, 23, -18 } };
        int[][] rankMatrix = matrixRankTransform(mat);
        for (int[] row : rankMatrix) {
            for (int cell : row)
                System.out.printf("%d ", cell);
            System.out.println();
        }
    }

    private static int[][] matrixRankTransform(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;

        TreeMap<Integer, List<Coor>> rank = new TreeMap<>();

        for (int i = 0; i < row; i++)
            for (int j = 0; j < col; j++) {
                rank.putIfAbsent(matrix[i][j], new ArrayList<>());
                rank.get(matrix[i][j]).add(new Coor(i, j));
            }

        int[] initP = new int[row + col];
        int[] rnk = new int[row + col];

        for (int i = 0; i < initP.length; i++) {
            initP[i] = i;
        }

        rank.forEach((key, value) -> {
            int[] p = initP.clone();
            int[] rank2 = rnk.clone();
            for (Coor c : value) {
                int rootI = find(p, c.col), rootJ = find(p, c.col + row);
                p[rootI] = rootJ;
                rank2[rootJ] = Math.max(rank2[rootI], rank2[rootJ]);
            }

            for (Coor cord : value) {
                int i = cord.row, j = cord.col;
                rnk[i] = rnk[j + row] = matrix[i][j] = rank2[find(p, i)] + 1;
            }
        });

        return matrix;
    }

    private static int find(int[] p, int x) {
        while (p[x] != x) {
            p[x] = p[p[x]];
            x = p[x];
        }
        return x;
    }
}

class Coor {
    int row, col;

    Coor(int j, int k) {
        this.row = j;
        this.col = k;
    }

    Coor() {
    }
}