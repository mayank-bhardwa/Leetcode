#include <iostream>
#include <vector>
#define deb(x, y) cout << #x << " " << x << " " << #y << " " << y << endl;
using namespace std;

string longestPalindrome(string s)
{
    string rev = string(s.rbegin(), s.rend());
    int n = s.length();
    vector<vector<int>> dp(n + 1, vector<int>(n + 1));
    pair<int, int> sb;
    int res = 0;
    for (int i = 0; i <= n; i++)
    {
        for (int j = 0; j <= n; j++)
        {
            if (i == 0 || j == 0)
                dp[i][j] = 0;
            else if (s[i - 1] == rev[j - 1])
            {
                dp[i][j] = dp[i - 1][j - 1] + 1;
                if (res < dp[i][j])
                {
                    res = dp[i][j];
                    sb = {i, i + res - 1};
                }
            }
            else
                dp[i][j] = 0;
        }
    }

    for (auto i : dp)
    {
        for (int j : i)
            cout << j << " ";
        cout << endl;
    }
    cout << res;
    return s.substr(min(sb.first, sb.second), abs(sb.second - sb.first));
}

int main(int argc, char const *argv[])
{
    string s = "aacabdkacaa";
    cout << longestPalindrome(s);
    return 0;
}