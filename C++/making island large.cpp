#include <iostream>
#include <vector>
#include <unordered_map>
#include <unordered_set>
using namespace std;

class Solution
{
    int mark(vector<vector<int>> &grid, int i, int j, int marker)
    {
        int len = grid.size();
        if (i < 0 || j < 0 || i >= len || j >= len || grid[i][j] == 0 || grid[i][j] == marker)
            return 0;

        grid[i][j] = marker;

        return mark(grid, i - 1, j, marker) + mark(grid, i + 1, j, marker) + mark(grid, i, j - 1, marker) + mark(grid, i, j + 1, marker) + 1;
    }

    int calculate_area(vector<vector<int>> &grid, unordered_map<int, int> &island_area, int i, int j)
    {
        int area = 1, len = grid.size();
        unordered_set<int> marker;

        if (i > 0 && grid[i - 1][j] != 0)
        {
            area += island_area[grid[i - 1][j]];
            marker.emplace(grid[i - 1][j]);
        }

        if (i < len - 1 && grid[i + 1][j] != 0 && marker.find(grid[i + 1][j]) == marker.end())
        {
            area += island_area[grid[i + 1][j]];
            marker.emplace(grid[i + 1][j]);
        }

        if (j > 0 && grid[i][j - 1] != 0 && marker.find(grid[i][j - 1]) == marker.end())
        {
            area += island_area[grid[i][j - 1]];
            marker.emplace(grid[i][j - 1]);
        }

        if (j < len - 1 && grid[i][j + 1] != 0 && marker.find(grid[i][j + 1]) == marker.end())
        {
            area += island_area[grid[i][j + 1]];
            marker.emplace(grid[i][j + 1]);
        }
        return area;
    }

public:
    int largestIsland(vector<vector<int>> &grid)
    {
        int marker = 1, len = grid.size(), area = 0, mx_area = 0;
        unordered_map<int, int> island_area;
        for (int i = 0; i < len; i++)
        {
            for (int j = 0; j < len; j++)
            {
                if (grid[i][j] == 1)
                {
                    ++marker;
                    area = mark(grid, i, j, marker);
                    island_area[marker] = area;
                }
            }
        }

        mx_area = max(mx_area, area);
        for (int i = 0; i < len; i++)
        {
            for (int j = 0; j < len; j++)
            {
                if (grid[i][j] == 0)
                {
                    area = max(area, calculate_area(grid, island_area, i, j));
                }
            }
        }

        return area;
    }
};

int main()
{
    vector<vector<int>> grid = {{0, 1, 0, 1},
                                {1, 1, 0, 1},
                                {1, 1, 0, 0},
                                {1, 0, 1, 1}};
    Solution s;
    cout << s.largestIsland(grid) << endl;
    return 0;
}