#include <iostream>
#include <vector>
using namespace std;

struct ListNode
{
    int val;
    ListNode *next;
    ListNode() : val(0), next(nullptr) {}
    ListNode(int x) : val(x), next(nullptr) {}
    ListNode(int x, ListNode *next) : val(x), next(next) {}
};

ListNode *reverseKGroup(ListNode *head, int k)
{
    if (head == nullptr)
        return nullptr;

    ListNode *curr = head;
    ListNode *prev = nullptr;
    ListNode *next = nullptr;

    int count = 0;
    while (curr != nullptr && count < k)
    {
        curr = curr->next;
        count++;
    }
    if (count != k)
        return head;

    count = 0;
    curr = head;
    while (curr != nullptr && count < k)
    {
        next = curr->next;
        curr->next = prev;
        prev = curr;
        curr = next;
        count++;
    }

    if (next != nullptr)
        head->next = reverseKGroup(next, k);

    return prev;
}

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

void print(ListNode *head)
{
    while (head != nullptr)
    {
        cout << head->val << " ";
        head = head->next;
    }
}

int main()
{
    ListNode *head = nullptr;
    int k = 3;
    for (int i = 1; i <= 5; i++)
        head = insert(head, i);

    cout << "Before Reverse: ";
    print(head);

    head = reverseKGroup(head, k);
    cout << "\nAfter Reverse: ";
    print(head);

    return 0;
}