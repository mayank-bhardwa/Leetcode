#include <iostream>
#include <vector>
#include <algorithm>
#define deb(x) cout << #x << " " << x << endl;
using namespace std;

struct coor
{
    int x, y;
    friend bool operator==(coor, coor);
};

bool operator==(coor a, coor b)
{
    if (a.x == b.x && a.y == b.y)
        return true;
    return false;
}

int explore(vector<vector<int>> &grid, coor curr, int c)
{
    if (curr.x < 0 || curr.x >= grid.size() || curr.y < 0 || curr.y >= grid[0].size() || grid[curr.x][curr.y] == -1)
        return 0;

    if (grid[curr.x][curr.y] == 2)
        return c == -1 ? 1 : 0;

    grid[curr.x][curr.y] = -1;

    int result = explore(grid, {curr.x + 1, curr.y}, c - 1) + explore(grid, {curr.x + -1, curr.y}, c - 1) + explore(grid, {curr.x, curr.y + 1}, c - 1) + explore(grid, {curr.x, curr.y - 1}, c - 1);

    grid[curr.x][curr.y] = 0;
    return result;
}

int uniquePaths(vector<vector<int>> &grid)
{
    int row = grid.size();
    int col = grid[0].size();
    int c = 0;
    coor start;
    for (int i = 0; i < row; i++)
    {
        for (int j = 0; j < col; j++)
        {
            if (grid[i][j] == 0)
                c++;
            if (grid[i][j] == 1)
                start = {i, j};
        }
    }
    return explore(grid, start, c);
}

int main()
{
    vector<vector<int>> grid = {{1, 0, 0, 0}, {0, 0, 0, 0}, {0, 0, 2, -1}};
    cout << uniquePaths(grid);
    return 0;
}
