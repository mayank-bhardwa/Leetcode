#include <iostream>
#include <algorithm>
#include <vector>
#include <queue>
using namespace std;

class Solution
{
public:
    int scheduleCourse(vector<vector<int>> &courses)
    {
        sort(courses.begin(), courses.end(), [](auto a, auto b) { return a[1] < b[1]; });

        priority_queue<int> pq; // for getting the course with maximum completion time
        int totalTime = 0;
        for (vector<int> course : courses)
        {
            if (totalTime + course[0] <= course[1])
            {
                totalTime += course[0];
                pq.push(course[0]);
            }
            else if (!pq.empty() && pq.top() > course[0])
            {
                totalTime += course[0] - pq.top();
                pq.pop();
                pq.push(course[0]);
            }
        }

        return pq.size();
    }
};

int main()
{
    vector<vector<int>> courses = {{7, 17}, {3, 12}, {10, 20}, {9, 10}, {5, 20}, {10, 19}, {4, 18}};
    // correct 4
    Solution sc;
    cout << sc.scheduleCourse(courses) << endl;
    return 0;
}