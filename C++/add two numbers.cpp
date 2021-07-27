#include <iostream>
using namespace std;

struct ListNode
{
    int val;
    ListNode *next;
    ListNode() : val(0), next(nullptr) {}
    ListNode(int x) : val(x), next(nullptr) {}
    ListNode(int x, ListNode *next) : val(x), next(next) {}
};

ListNode *insert(ListNode *head, int data)
{
    ListNode *new_node = new ListNode(data);
    if (head == nullptr)
        return new_node;

    ListNode *temp = head;
    while (temp->next != nullptr)
        temp = temp->next;
    temp->next = new_node;

    return head;
}

ListNode *addTwoNumbers(ListNode *l1, ListNode *l2)
{
    int carry = 0, n;
    ListNode *result = nullptr;
    ListNode *end = nullptr;
    while (l1 != nullptr || l2 != nullptr || carry)
    {
        n = 0;
        if (l1 != nullptr)
        {
            n = l1->val;
            l1 = l1->next;
        }

        if (l2 != nullptr)
        {
            n += l2->val;
            l2 = l2->next;
        }

        if (carry)
        {
            n += carry;
        }

        carry = n / 10;

        if (result != nullptr)
        {
            end->next = new ListNode(n % 10);
            end = end->next;
        }
        else
        {
            result = new ListNode(n % 10);
            end = result;
        }
    }
    return result;
}

void print(ListNode *head)
{
    if (head == nullptr)
        return;

    print(head->next);
    cout << head->val << " ";
}

int main()
{
    ListNode *l1 = nullptr;
    l1 = insert(l1, 2);
    l1 = insert(l1, 4);
    l1 = insert(l1, 3);
    cout << "Number 1: ";
    print(l1);

    ListNode *l2 = nullptr;
    l2 = insert(l2, 5);
    l2 = insert(l2, 6);
    l2 = insert(l2, 4);
    cout << "\nNumber 2: ";
    print(l2);

    ListNode *result = addTwoNumbers(l1, l2);
    cout << "\nResults : ";
    print(result);
    return 0;
}