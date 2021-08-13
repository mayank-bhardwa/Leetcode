#include <iostream>
#include <vector>
using namespace std;

int findLengthOfShortestSubarray(vector<int> &arr)
{
    int len = arr.size();
    int f = 1, b = len - 2;

    while (f < len && arr[f] >= arr[f - 1])
        f++;

    if (f == len)
        return 0;

    f--;
    while (b >= 0 && arr[b] <= arr[b + 1])
        b--;
    b++;

    int res = min(b, len - f - 1);

    int i = 0, j = b;

    for (int i = 0; i <= f; i++)
    {
        if (arr[i] <= arr[j])
        {
            res = min(res, j - i - 1);
        }
        else if (j < len - 1)
            j++;
        else
            break;
    }

    return res;
}

int main()
{
    vector<int> arr = {5, 4, 3, 2, 1};
    cout << findLengthOfShortestSubarray(arr) << endl;
    return 0;
}