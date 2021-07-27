#include <iostream>
#include <vector>
#include <algorithm>
#include <unordered_map>
using namespace std;

vector<vector<int>> fourSum(vector<int> &nums, int target)
{
    sort(nums.begin(), nums.end());

    unordered_map<int, vector<pair<int, int>>> twoSum;
    for (int i = 0; i < nums.size() - 1; i++)
    {
        if(nums[i]==nums[i+1])
            continue;
        for (int j = i + 1; j < nums.size(); j++)
            twoSum[nums[i] + nums[j]].push_back({i, j});

    }
    vector<vector<int>> result;

    for (int i = 0; i < nums.size() - 3; i++)
    {
        if (nums[i] == nums[i + 1])
            continue;
        for (int j = i + 1; nums.size() - 2; j++)
        {
            if (nums[j] == nums[j + 1])
                continue;
            int t = target - (nums[i] + nums[j]);
            if (twoSum.find(t) != twoSum.end())
            {
                for (pair<int, int> k : twoSum[t])
                {
                    if (k.first != i && k.first != j && k.second != i && k.second != j)
                        result.push_back({i, j, k.first, k.second});
                }
            }
        }
    }
    return result;
}

int main()
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    vector<int> nums = {1, 0, -1, 0, -2, 2};
    int target = 0;
    vector<vector<int>> result = fourSum(nums, target);

    for (vector<int> i : result)
    {
        for (int j : i)
            cout << j << " ";
        cout << endl;
    }
    return 0;
}