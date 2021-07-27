#include <iostream>
#include <stack>
using namespace std;

struct TreeNode
{
    int val;
    TreeNode *left;
    TreeNode *right;
    TreeNode(int val) : val(val), left(nullptr), right(nullptr) {}
};

TreeNode *util(TreeNode *root, TreeNode *l, TreeNode *h)
{
    if (root->val >= l->val && root->val <= h->val)
        return root;

    if (root->val > l->val)
        return util(root->left, l, h);
    else
        return util(root->right, l, h);
}

TreeNode *lowestCommonAncestor(TreeNode *root, TreeNode *p, TreeNode *q)
{
    if (p->val < q->val)
        return util(root, p, q);

    return util(root, q, p);
}

TreeNode *insert(TreeNode *root, int val)
{
    if (root == nullptr)
        return new TreeNode(val);

    if (root->val > val)
        root->left = insert(root->left, val);
    else if (root->val < val)
        root->right = insert(root->right, val);
    return root;
}

TreeNode *find(TreeNode *root, int val)
{
    if (root->val == val)
        return root;
    else if (root->val > val)
        return find(root->left, val);
    else
        return find(root->right, val);
}

int main()
{
    TreeNode *root = nullptr;
    int val[] = {3, 1, 4, 2};
    for (int i : val)
        root = insert(root, i);
    TreeNode *p = find(root, 2); //2
    TreeNode *q = find(root, 3); //8
    TreeNode *result = lowestCommonAncestor(root, p, q);
    cout << result->val;
    return 0;
}