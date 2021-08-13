#include <iostream>
#include <vector>
#include <unordered_map>
using namespace std;

bool dfs(unordered_map<int, vector<int>> &, int u, vector<bool> &, vector<bool> &, vector<int> &);
vector<int> findOrder(int, vector<vector<int>> &);
signed main()
{
    vector<vector<int>> prerequisites = {{0, 1}, {1, 0}}; //{{1, 0}, {2, 0}, {3, 1}, {3, 2}};
    int numCourses = 2;
    //4;
    vector<int> result = findOrder(numCourses, prerequisites);
    for (int i : result)
        cout << i << " ";
    return 0;
}

vector<int> findOrder(int numCourses, vector<vector<int>> &prerequisites)
{
    vector<bool> visited(numCourses, false);
    vector<bool> root(numCourses, false);
    vector<int> result;
    unordered_map<int, vector<int>> path;
    for (vector<int> row : prerequisites)
        path[row[0]].emplace_back(row[1]);

    for (int i = 0; i < numCourses; i++)
    {
        if (!visited[i])
        {
            if (dfs(path, i, visited, root, result))
                return {};
        }
    }
    return result;
}

bool dfs(unordered_map<int, vector<int>> &path, int u, vector<bool> &visited, vector<bool> &root, vector<int> &result)
{
    if (root[u])
        return true;
    if (visited[u])
        return false;
    visited[u] = true;
    root[u] = true;

    for (int i : path[u])
    {
        if (dfs(path, i, visited, root, result))
            return true;
    }
    result.emplace_back(u);
    root[u] = false;
    return false;
}