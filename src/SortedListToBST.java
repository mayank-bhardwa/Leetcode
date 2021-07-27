public class SortedListToBST {
    public static void main(String[] args) {
        int[] arr = { -10, -3, 0, 5, 9 };
        ListNode head = new ListNode(arr[0]);
        ListNode temp = head;
        for (int i = 1; i < arr.length; i++) {
            temp.next = new ListNode(arr[i]);
            temp = temp.next;
        }
        TreeNode root = sortedListToBST(head);
        TreeOperations.preorder(root);
    }

    public static TreeNode sortedListToBST(ListNode head) {
        if (head == null)
            return null;

        ListNode head1 = split(head);

        TreeNode root = new TreeNode(head1.val);

        if (head1 != head)
            root.left = sortedListToBST(head);

        head1 = head1.next;
        root.right = sortedListToBST(head1);

        return root;
    }

    public static ListNode split(ListNode head) {
        ListNode slow = head, fast = head.next, prev = null;
        while (fast != null) {
            fast = fast.next;
            if (fast != null) {
                fast = fast.next;
                prev = slow;
                slow = slow.next;
            }
        }

        if (prev != null)
            prev.next = null;

        return slow;
    }
}
