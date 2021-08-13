#include <iostream>
#include <vector>
#include <queue>
using namespace std;

class MedianFinder
{
    priority_queue<int> left;                             // Max Queue
    priority_queue<int, vector<int>, greater<int>> right; // Min Queue
    int sizeLeft, sizeRight;

public:
    /** initialize your data structure here. */
    MedianFinder()
    {
        this->sizeLeft = 0;
        this->sizeRight = 0;
    }

    void addNum(int num)
    {
        if (sizeLeft - sizeRight == 0)
        {
            if (sizeLeft == 0 || right.top() >= num)
                left.push(num);
            else
            {
                int rt = right.top();
                left.push(right.top());
                right.pop();
                right.push(num);
            }

            sizeLeft++;
        }
        else
        {
            int lt = left.top();
            if (lt <= num)
                right.push(num);
            else
            {
                right.push(lt);
                left.pop();
                left.push(num);
            }

            sizeRight++;
        }
    }

    double findMedian()
    {
        if (sizeLeft == sizeRight)
            return (left.top() + right.top()) / 2.0;
        return left.top();
    }
};

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder* obj = new MedianFinder();
 * obj->addNum(num);
 * double param_2 = obj->findMedian();
 */

int main()
{
    MedianFinder *obj = new MedianFinder();
    obj->addNum(6);
    obj->addNum(10);
    obj->addNum(2);
    cout << obj->findMedian() << endl;
    obj->addNum(6);
    obj->addNum(5);
    obj->addNum(0);
    obj->addNum(6);
    cout << obj->findMedian() << endl;
    obj->addNum(3);
    obj->addNum(1);
    obj->addNum(0);
    obj->addNum(0);
    cout << obj->findMedian() << endl;
    return 0;
}