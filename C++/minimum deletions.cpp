#include <iostream>
#include <unordered_set>
using namespace std;
int minDeletions(string s)
{
    int freq[26] = {0};
    for (char i : s)
        freq[i - 'a']++;

    unordered_set<int> isPresent;
    int res = 0;
    for (int i : freq)
    {
        if (i == 0)
            continue;
        if (isPresent.find(i) == isPresent.end())
            isPresent.insert(i);
        else
        {
            int m = i;
            while (isPresent.find(m) != isPresent.end() && m != 0)
            {
                res++;
                m--;
            }
            if (m != 0)
                isPresent.insert(m);
        }
    }

    return res;
}
int main()
{
    string s = "aaabbbcc";
    cout << minDeletions(s);
    return 0;
}