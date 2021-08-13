#include <iostream>
#include <algorithm>
#include <unordered_map>
#include <vector>
using namespace std;

bool canReorderDoubled(vector<int> &arr)
{
    sort(arr.begin(), arr.end(), [](int a, int b)
         { return abs(a) < abs(b); });
    unordered_map<int, int> um;
    for(int i: arr)
        um[i]++;
    
    for(int i : arr){
        if(um[i]==0)
            continue;
        um[i]--;
        if(um[i*2]>0)
            um[i * 2]--;
        else
            return false;
    }

    return true;
}

int main()
{
    vector<int> arr = {1, 2, 1, -8, 8, -4, 4, -4, 2, -2};
    cout << canReorderDoubled(arr);
    return 0;
}