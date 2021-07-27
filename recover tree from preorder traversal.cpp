#include <iostream>
#include <queue>
#define deb(x) cout << #x << " " << x << endl;
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

void insert(TreeNode **root, int data, int h)
{
    if (root == NULL && h == 0)
    {
        (*root) = new TreeNode(data);
        cout << (*root)->val << " ";
        return;
    }
    else if (h > 1)
    {
        insert(&(*root)->left, data, h - 1);
        insert(&(*root)->right, data, h - 1);
    }
}

TreeNode *recoverFromPreorder(string traversal)
{
    TreeNode *root = NULL;
    int h = 0, i = 0;

    while (i < traversal.size())
    {
        if (traversal[i] == '-')
        {
            h++;
            i++;
        }
        else
        {
            int num = traversal[i] - '0';
            while (i + 1 < traversal.size() && traversal[i + 1] != '-')
            {
                i++;
                num = num * 10 + (traversal[i] - '0');
            }

            insert(&root, num, h);

            h = 0;
            i++;
        }
    }

    return root;
}

void inorder(TreeNode *root)
{
    if (root != NULL)
    {
        inorder(root->left);
        cout << root->val << " ";
        inorder(root->right);
    }
}

int main()
{
    string preorder = "5431-254--378--454-5--66385--7";
    int i = 0;
    TreeNode *root = recoverFromPreorder(preorder);
    inorder(root);
    return 0;
}