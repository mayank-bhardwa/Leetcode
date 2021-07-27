#include <iostream>
#include <vector>
using namespace std;

int targetSum(vector<int> &nums, int target, int n)
{
    if (n == 0)
        return 0;
    else if (target == 0)
}

int main(int argc, char const *argv[])
{
    vector<int> nums = {1, 0, -1, 0, -2, 2};
    cout << targetSum(nums, 1, nums.size());
    return 0;
}