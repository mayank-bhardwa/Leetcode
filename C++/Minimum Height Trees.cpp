#include <iostream>
#include <vector>
#include <map>
using namespace std;
class Solution
{
    map<int, vector<int>> result;
    int dfs(int u, vector<vector<int>> &adjacency_list, vector<bool> isroot)
    {
        if (isroot[u])
            return 0;
        isroot[u] = true;
        int h = 1, t;
        for (int child : adjacency_list[u])
        {
            t = dfs(child, adjacency_list, isroot);
            h = max(h, t + 1);
        }
        cout << endl;
        isroot[u] = false;
        return h;
    }

public:
    vector<int> findMinHeightTrees(int n, vector<vector<int>> &edges)
    {
        vector<vector<int>> adjacency_list(n);
        for (vector<int> edge : edges)
        {
            adjacency_list[edge[0]].emplace_back(edge[1]);
            adjacency_list[edge[1]].emplace_back(edge[0]);
        }

        vector<bool> isroot(n, false);
        for (int i = 0; i < n; i++)
        {
            dfs(i, adjacency_list, isroot);
        }

        return {};
    }
};
int main()
{
    vector<vector<int>> edges = {{3, 0}, {3, 1}, {3, 2}, {3, 4}, {5, 4}};
    int n = 6;
    Solution sc;
    vector<int> minRoot = sc.findMinHeightTrees(n, edges);
    for (int i : minRoot)
        cout << i << " ";
    return 0;
}
