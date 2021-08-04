#include <iostream>
#include <vector>
#include <set>
#include <map>
using namespace std;

class Solution
{
    void mark(vector<vector<int>> &grid, int i, int j)
    {
        if (i < 0 || i >= grid.size() || j < 0 || j >= grid.size() || grid[i][j] == 0 || grid[i][j] == 2)
            return;
        grid[i][j] = 2;
        mark(grid, i - 1, j);
        mark(grid, i + 1, j);
        mark(grid, i, j + 1);
        mark(grid, i, j - 1);
    }

public:
    int countIsland(vector<vector<int>> &grid)
    {
        int counter = 0;
        for (int i = 0; i < grid.size(); i++)
        {
            for (int j = 0; j < grid.size(); j++)
            {
                if (grid[i][j] == 1)
                {
                    counter++;
                    mark(grid, i, j);
                }
            }
        }
        return counter;
    }
};

int main()
{
    vector<vector<int>> grid = {{0, 1, 0, 1, 1},
                                {1, 1, 0, 1, 1},
                                {1, 1, 0, 0, 0},
                                {1, 0, 1, 1, 1}};
    Solution s;
    cout << s.countIsland(grid) << endl;
    return 0;
}