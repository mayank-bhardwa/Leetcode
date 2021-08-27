#include <iostream>
using namespace std;

template <typename tp>
struct Node
{
    tp val;
    int height;
    Node *left, *right;
    Node() {}
    Node(tp val)
    {
        this->val = val;
        this->height = 1;
        this->left = this->right = nullptr;
    }
};

template <typename __tp>
class AVL
{
private:
    Node<__tp> *root = nullptr;
    Node<__tp> *insert(Node<__tp> *root, __tp data);
    void preorder(Node<__tp> *root);
    int getBalance(Node<__tp> *root);
    int height(Node<__tp> *root);
    Node<__tp> *rotateLeft(Node<__tp> *root);
    Node<__tp> *rotateRight(Node<__tp> *root);

public:
    void insert(__tp data)
    {
        root = insert(root, data);
    }

    void preorder()
    {
        preorder(root);
        cout << "\n";
    }
};

int_fast32_t main()
{
    int n;
    int val;
    cin >> n;
    AVL<int> tree;
    while (n--)
    {
        cin >> val;
        tree.insert(val);
    }

    tree.preorder();

    return 0;
}

template <typename __tp>
void AVL<__tp>::preorder(Node<__tp> *root)
{
    if (root == nullptr)
        return;

    cout << root->val << " ";
    preorder(root->left);
    preorder(root->right);
}

template <typename __tp>
int AVL<__tp>::height(Node<__tp> *root)
{
    if (root == nullptr)
        return 0;
    return root->height;
}

template <typename __tp>
int AVL<__tp>::getBalance(Node<__tp> *root)
{
    if (root == nullptr)
        return 0;

    return height(root->left) - height(root->right);
}

template <typename __tp>
Node<__tp> *AVL<__tp>::rotateLeft(Node<__tp> *root)
{
    Node<__tp> *right = root->right;
    Node<__tp> *rl = right->left;
    right->left = root;
    root->right = rl;
    root->height = 1 + max(height(root->left), height(root->right));
    right->height = 1 + max(height(right->left), height(root->right));
    return right;
}

template <typename __tp>
Node<__tp> *AVL<__tp>::rotateRight(Node<__tp> *root)
{
    Node<__tp> *left = root->left;
    Node<__tp> *lr = left->right;
    left->right = root;
    root->left = lr;
    root->height = 1 + max(height(root->left), height(root->right));
    left->height = 1 + max(height(left->left), height(left->right));
    return left;
}

template <typename __tp>
Node<__tp> *AVL<__tp>::insert(Node<__tp> *root, __tp val)
{
    if (root == nullptr)
        return new Node<__tp>(val);
    if (root->val > val)
        root->left = insert(root->left, val);
    else if (root->val < val)
        root->right = insert(root->right, val);
    else
        return root;

    root->height = 1 + max(height(root->left), height(root->right));

    int balance = getBalance(root);

    if (balance > 1) // more elements on left side
    {
        if (val < root->left->val)
            return rotateRight(root);
        else
        {
            root->left = rotateLeft(root->left);
            return rotateRight(root->left);
        }
    }
    else if (balance < -1) // more elements on right side
    {
        if (val < root->right->val)
        {
            root->right = rotateRight(root->right);
            return rotateLeft(root);
        }
        else
            return rotateLeft(root);
    }

    return root;
}