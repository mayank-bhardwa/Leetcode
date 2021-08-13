/*
Given a positive integer n, return the number 
of the integers in the range [0, n] whose binary 
representations do not contain consecutive ones.
*/

#include <iostream>
#include <bitset>
#include <math.h>
#include <queue>
using namespace std;


int findIntegers(int c, int n)
{
    bitset<32> bits(0);
    
    if (c > n)
        return 0;

    if (c & 1)
        return findIntegers(c << 1, n) + 1;
    else
        return findIntegers(c << 1, n) + findIntegers((c << 1) | 1, n) + 1;
}

int main()
{
    int n = 5;
    cout << findIntegers(1, n) + 1 << endl;
    return 0;
}