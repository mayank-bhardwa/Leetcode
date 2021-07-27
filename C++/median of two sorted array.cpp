#include <iostream>
#include <vector>
#define deb(x) cout << #x << " " << x << endl;
using namespace std;

double findMedianSortedArrays(vector<int> &nums1, vector<int> &nums2)
{
    if (nums1.size() > nums2.size())
        return findMedianSortedArrays(nums2, nums1);
    int s1 = nums1.size(), s2 = nums2.size();
    int low = 0, high = s1;
    int lx, rx, ly, ry;
    int pX, pY;
    while (low <= high)
    {
        pX = (low + high) / 2;
        pY = (s1 + s2 + 1) / 2 - pX;

        lx = pX > 0 ? nums1[pX - 1] : INT32_MIN;
        rx = pX != s1 ? nums1[pX] : INT32_MAX;

        ly = pY > 0 ? nums2[pY - 1] : INT32_MIN;
        ry = pY != s2 ? nums2[pY] : INT32_MAX;

        if (lx <= ry && ly <= rx)
        {
            if ((s1 + s2) % 2 == 0)
                return (max(lx, ly) + min(rx, ry)) / 2.0;
            else
                return max(lx, ly);
        }

        if (lx > ry)
            high = pX - 1;
        else
            low = pX + 1;
    }
    return -1;
}

int main()
{
    vector<int> nums1 = {100001}, nums2 = {100001};
    cout << findMedianSortedArrays(nums1, nums2);
    return 0;
}