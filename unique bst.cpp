/*
Given an integer n, return all the structurally unique BST's (binary search trees), 
which has exactly n nodes of unique values from 1 to n. Return the answer in any order
*/

#include <iostream>
#include <vector>
using namespace std;

struct TreeNode
{
    int val;
    TreeNode *left;
    TreeNode *right;
    TreeNode() : val(0), left(nullptr), right(nullptr) {}
    TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
    TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
};

class Solution
{
    TreeNode *insert(TreeNode *head, int data)
    {
        if (head == nullptr)
            return new TreeNode(data);
        else if (head->val > data)
            head->left = insert(head->left, data);
        else
            head->right = insert(head->right, data);
        return head;
    }

public:
    vector<TreeNode *> generateTrees(int n)
    {
        vector<TreeNode *> trees(n, nullptr);
        vector<int> catalan(n + 1);
        catalan[0] = catalan[1] = 0;
        for (int i = 2; i <= n; i++)
        {
            catalan[i] = 0;
            for (int j = 0; j < i; j++)
            {
                catalan[i] += catalan[j] * catalan[i - j - 1];
            }
        }
    }
};

void print(TreeNode *head)
{
    if (head == nullptr)
    {
        cout << 'null' << " ";
        return;
    }
    cout << head->val << " ";
    print(head->left);
    print(head->right);
}

int main(int argc, char const *argv[])
{
    int n = 3;
    Solution sol;
    vector<TreeNode *> trees = sol.generateTrees(3);
    for (auto i : trees)
    {
        print(i);
        cout << endl;
    }
    return 0;
}