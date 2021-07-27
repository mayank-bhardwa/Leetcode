public class TreeOperations {
    public static TreeNode insert(int arr[]) {
        TreeNode head = null;
        head = insert(head, arr, 0);
        return head;
    }

    private static TreeNode insert(TreeNode head, int[] arr, int i) {
        if (arr[i] == Integer.MIN_VALUE)
            return null;
        head = new TreeNode(arr[i]);
        int l = 2 * i + 1, r = 2 * i + 2;
        if (l < arr.length)
            head.left = insert(head.left, arr, l);

        if (r < arr.length)
            head.right = insert(head.right, arr, r);
        return head;
    }

    public static void preorder(TreeNode head) {
        if (head == null)
            return;

        System.out.printf("%d ", head.val);
        preorder(head.left);
        preorder(head.right);
    }

    public static void inorder(TreeNode head) {
        if (head == null)
            return;

        inorder(head.left);
        System.out.printf("%d ", head.val);
        inorder(head.right);
    }

    public static void postorder(TreeNode head) {
        if (head == null)
            return;
        postorder(head.left);
        postorder(head.right);
        System.out.printf("%d ", head.val);
    }
}
