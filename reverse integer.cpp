#include <iostream>
#define deb(x) cout<<#x<<" "<<x<<endl;
using namespace std;

int reverse(int n)
{
	long k = 0;
	while (n)
	{
		k = k * 10 + (n % 10);
		n /= 10;
	}

	if(k > INT32_MAX or k < INT32_MIN)
		return 0;
	
	return (int)k;
}

int main(int argc, char const *argv[])
{
	int t;
	cin >> t;
	while (t--)
	{
		int n;
		cin >> n;
		cout << reverse(n) << endl;
	}
	return 0;
}