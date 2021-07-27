#include <iostream>
#include <unordered_map>
#include <vector>
using namespace std;

struct TreeNode
{
    int val;
    TreeNode *left, *right;
    TreeNode(int val)
    {
        this->val = val;
        this->left = nullptr;
        this->right = nullptr;
    }

    TreeNode(int val, TreeNode *left, TreeNode *right) : val(val), left(left), right(right) {}
};

int postIndex;

TreeNode *helper(vector<int> &postorder, unordered_map<int, int> &inIndex, int start, int end)
{
    if (start > end)
        return nullptr;

    TreeNode *head = new TreeNode(postorder[postIndex--]);

    if (start == end)
        return head;

    int curr = inIndex[head->val];

    head->right = helper(postorder, inIndex, curr + 1, end);
    head->left = helper(postorder, inIndex, start, curr - 1);

    return head;
}

TreeNode *buildTree(vector<int> &postorder, vector<int> &inorder)
{
    unordered_map<int, int> inIndex;
    for (int i = 0; i < inorder.size(); i++)
        inIndex[inorder[i]] = i;
    postIndex = postorder.size() - 1;
    return helper(postorder, inIndex, 0, postorder.size() - 1);
}

void preorder(TreeNode *root)
{
    if (root == nullptr)
        return;

    cout << root->val << " ";
    preorder(root->left);
    preorder(root->right);
}

int main(int argc, char const *argv[])
{
    vector<int> inorder = {9, 3, 15, 20, 7};
    vector<int> postorder = {9, 15, 7, 20, 3};
    TreeNode *root = buildTree(postorder, inorder);
    preorder(root);
    cout << endl;
    return 0;
}