public class TreeOperations {
    private static int pos = 0;

    public static TreeNode insert(int arr[]) {
        pos = 0;
        return insertHelper(arr);
    }

    private static TreeNode insertHelper(int[] arr) {
        if (pos >= arr.length)
            return null;
        int val = arr[pos++];

        if (val == Integer.MIN_VALUE)
            return null;

        TreeNode root = new TreeNode(val);
        root.left = insertHelper(arr);
        root.right = insertHelper(arr);
        return root;
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
