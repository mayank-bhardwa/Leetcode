public class ValidateBinarySearchTree {
    public static void main(String[] args) {
        TreeNode root = null;

        int[] arr = { 2, 2, 2 };

        root = TreeOperations.insert(arr);

        // TreeOperations.preorder(root);

        if (isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE))
            System.out.println("Valid");
        else
            System.out.println("Invalid");
    }

    private static boolean isValidBST(TreeNode root, Long min, Long max) {
        if (root == null)
            return true;

        if (root.val <= min || root.val >= max)
            return false;

        return isValidBST(root.left, min, (long) root.val) && isValidBST(root.right, (long) root.val, max);
    }
}
