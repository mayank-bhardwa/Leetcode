#include <iostream>
#include <vector>
#include <unordered_map>
using namespace std;

int helper(vector<int> &nums, int target, int n, vector<unordered_map<int, int>> &dp)
{
    if (dp[n].find(target) != dp[n].end())
        return dp[n][target];

    if (n == 0)
    {
        return dp[n][target] = (target - nums[0] == 0) + (target + nums[0] == 0);
    }

    return dp[n][target] = helper(nums, target - nums[n], n - 1, dp) + helper(nums, target + nums[n], n - 1, dp);
}

int findTargetSumWays(vector<int> &nums, int target)
{
    vector<unordered_map<int, int>> dp(nums.size() + 1);
    return helper(nums, target, nums.size() - 1, dp);
}

int main(int argc, char const *argv[])
{
    vector<int> nums = {1, 1, 1, 1, 1};
    int target = 3;
    cout << findTargetSumWays(nums, target);
    return 0;
}