#include <iostream>
#include <unordered_map>
using namespace std;

int lengthOfLongestSubstring(string s)
{
    if (s.length() < 1)
        return 0;
    unordered_map<char, int> id;
    id[s[0]] = 0;
    int mx = 0, start = 0, i = 1;
    for (i = 1; i < s.length(); i++)
    {
        if (id.find(s[i]) != id.end() && id[s[i]] >= start)
        {
            mx = max(mx, i - start);
            start = id[s[i]] + 1;
        }

        id[s[i]] = i;
    }

    return max(mx, i - start);
}

int main()
{
    string s = "abba";
    cout << lengthOfLongestSubstring(s);
    return 0;
}