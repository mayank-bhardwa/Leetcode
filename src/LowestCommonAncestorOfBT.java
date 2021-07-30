public class LowestCommonAncestorOfBT {
    public static void main(String[] args) {
        int[] arr = { 3, 5, 1, 6, 2, 0, 8, Integer.MIN_VALUE, Integer.MIN_VALUE, 7, 4 };
        TreeNode root = TreeOperations.insert(arr);
        TreeNode p = root.left;
        TreeNode q = p.right.right;
        TreeNode lowest = lowestCommonAncestor(root, p, q);
        System.out.println(lowest.val);
    }

    private static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q)
            return root;

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        if (left != null && right != null)
            return root;
        else if (left != null)
            return left;
        else
            return right;
    }
}