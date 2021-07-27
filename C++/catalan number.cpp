#include <iostream>
#include <vector>
using namespace std;

int catalan(int n)
{
    if (n <= 1)
        return 1;

    int res = 0;
    for (int i = 0; i < n; i++)
    {
        res += catalan(i) * catalan(n - i - 1);
    }
    return res;
    // vector<int> catalan_num(n + 1, 0);
    // catalan_num[0] = catalan_num[1] = 1;

    // // int res = 0;
    // for (int i = 2; i <= n; i++)
    // {
    //     catalan_num[i] = 0;
    //     for (int j = 0; j < i; j++)
    //     {
    //         catalan_num[i] += catalan_num[j] * catalan_num[i - j - 1];
    //     }
    // }

    // return catalan_num[n];
}

int main()
{
    int n = 3;
    cout << catalan(n);
    return 0;
}