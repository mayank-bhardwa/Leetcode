#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

vector<vector<int>> dp;

int util(vector<int> &dishes, int i, int t)
{
    if (i >= dishes.size())
        return 0;

    if (dp[i][t] != -1)
        return dp[i][t];

    dp[i][t] = max(util(dishes, i + 1, t), util(dishes, i + 1, t + 1) + dishes[i] * t);
    return dp[i][t];
}

int maxSatisfaction(vector<int> &dishes)
{
    sort(dishes.begin(), dishes.end());
    dp.clear();
    dp.assign(dishes.size() + 1, vector<int>(dishes.size() + 1, -1));
    return util(dishes, 0, 1);
}

int main()
{
    vector<int> dishes = {34, -27, -49, -6, 65, 70, 72, -37, -57, 92, -72, 36, 6, -91, 18, 61, 77, -91, 5, 64, -16, 5, 20, -60, -94, -15, -23, -10, -61, 27, 89, 38, 46, 57, 33, 94, -79, 43, -67, -73, -39, 72, -52, 13, 65, -82, 26, 69, 67};
    cout << maxSatisfaction(dishes);
    return 0;
}