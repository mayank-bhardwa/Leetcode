/*
    Minimum Adjacent swaps required to make string pallindrome
*/

#include <iostream>
using namespace std;

bool isPossible(string s)
{
    int freq[26] = {0};
    int odd = 0;
    for (char i : s)
    {
        freq[i - 'c']++;
    }
    for (int i : freq)
        if (i % 2)
            odd++;
    if (odd > 1)
        return false;
    return true;
}

int AdjacentSwaps(string s)
{
    cout << isPossible(s);
    return 0;
}

int main()
{
    string s = "macmadm";
    cout << AdjacentSwaps(s);
    return 0;
}