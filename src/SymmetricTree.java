public class SymmetricTree {
    public static void main(String[] args) {
        int[] arr = { 1, 2, 2, 3, 4, 4, 3 };
        TreeNode root = TreeOperations.insert(arr);
        TreeOperations.inorder(root);
        System.out.printf("\n%b \n", isSymmetric(root));
    }

    public static boolean isSymmetric(TreeNode root) {
        if (root == null || (root.left == null && root.right == null))
            return true;

        return helper(root.left, root.right);
    }

    private static boolean helper(TreeNode p, TreeNode q) {
        if (p == null && q == null)
            return true;

        if (p != null && q != null && p.val == q.val)
            return helper(p.left, q.right) && helper(p.right, q.left);

        return false;
    }
}
