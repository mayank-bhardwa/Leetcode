public class RecoverBST {
    public static void main(String[] args) {
        TreeNode head = null;
        int[] arr = { 3, 1, 4, -1, -1, 2 };
        head = TreeOperations.insert(arr);
        TreeOperations.inorder(head);
        System.out.println();
        recoverTree(head);
        TreeOperations.inorder(head);
    }

    private static void recoverTree(TreeNode head) {
        helper(head);
        int val = first.val;
        first.val = second.val;
        second.val = val;
    }

    static TreeNode first = null, second = null, prev = null;

    private static void helper(TreeNode head) {
        if (head == null)
            return;

        helper(head.left);

        if (prev != null && prev.val > head.val) {
            if (first == null) {
                first = prev;
            }
            second = head;
        }
        prev = head;

        helper(head.right);
    }
}