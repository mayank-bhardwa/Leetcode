/*
Given an m x n integers matrix, return the length of the longest increasing path in matrix.

From each cell, you can either move in four directions: left, right, up, or down. You may 
not move diagonally or move outside the boundary (i.e., wrap-around is not allowed)
*/

#include <iostream>
#include <vector>
using namespace std;

int helper(vector<vector<int>> &matrix, int i, int j, int prevValue)
{
    if (i < 0 || j < 0 || i >= matrix.size() || j >= matrix[0].size() || matrix[i][j] < prevValue)
        return 0;

    return helper(matrix, i + 1, j, matrix[i][j]) + helper(matrix, i - 1, j, matrix[i][j]) + helper(matrix, i, j + 1, matrix[i][j]) + helper(matrix, i, j - 1, matrix[i][j]) + 1;
}

int longestIncreasingPath(vector<vector<int>> &matrix)
{
    return helper(matrix, 0, 0, -1);
}
int main()
{
    vector<vector<int>> matrix = {{9, 9, 4}, {6, 6, 8}, {2, 1, 1}};
    cout << longestIncreasingPath(matrix) << endl;
    return 0;
}