#include <iostream>
#include <vector>
#include <algorithm>
#include <unordered_map>
using namespace std;

vector<vector<string>> groupAnagrams(vector<string> &strs)
{
    unordered_map<string, int> um;
    vector<vector<string>> groups;
    int len = strs.size();
    for (int i = 0; i < len; i++)
    {
        string cpy = strs[i];
        sort(cpy.begin(), cpy.end());

        if (um.find(cpy) != um.end())
        {
            groups[um[cpy]].emplace_back(strs[i]);
        }
        else
        {
            vector<string> new_group = {strs[i]};
            int i = groups.size();
            groups.emplace_back(new_group);
            um[cpy] = i;
        }
    }

    return groups;
}

int main()
{
    vector<string> strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
    vector<vector<string>> groups = groupAnagrams(strs);
    for (auto group : groups)
    {
        for (auto word : group)
            cout << word << " ";
        cout << endl;
    }
    return 0;
}