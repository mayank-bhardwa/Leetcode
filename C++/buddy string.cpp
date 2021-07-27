#include <iostream>
using namespace std;

bool buddyString(string g, string t)
{
	int c = 0;
	int arr[2] = {0};
	if (g.size() != t.size())return false;
	if(g==t)
	{
		int visited[26] = {0};
		for(auto i: g)
		{
			if(visited[i-'a'])return true;
			visited[i-'a'] = 1;
		}
		return false;
	}
	for (int i = 0; i < g.size(); i++)
	{
		if (g[i] != t[i])
		{
			c++;
			if (c > 2)return false;
			arr[c - 1] = i;
		}
	}

	if (g[arr[1]] == t[arr[0]] && g[arr[0]] == t[arr[1]])return true;
	else return false;
}

int main(int argc, char const *argv[])
{
	cout << buddyString("bac", "bac");
	return 0;
}