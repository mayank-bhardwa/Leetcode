#include <iostream>
#include <vector>
using namespace std;

int threeSumClosest(vector<int> &nums, int target, int i = 0, int left = 3)
{
    if (left == 0)
        return 0;

    if (nums.size() - i - 1 > left)
    {
        int x = threeSumClosest(nums, target, i + 1, left);
        int y = threeSumClosest(nums, target, i + 1, left - 1) + nums[i];

        if (abs(target - x) < abs(target - y))
            return x;
        else
            return y;
    }
    else
    {
        return threeSumClosest(nums, target, i + 1, left - 1) + nums[i];
    }
}

int main(int argc, char const *argv[])
{
    vector<int> nums = {1, 1, 1, 0};
    int target = 100;
    cout << threeSumClosest(nums, target);
    return 0;
}