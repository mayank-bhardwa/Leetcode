public class BalancedBST {
    public static void main(String[] args) {
        int[] arr = { 1, 2, 2, 3, 3, Integer.MIN_VALUE, Integer.MIN_VALUE, 4, 4 };
        TreeNode root = TreeOperations.insert(arr);
        System.out.println(isBalanced(root));
    }

    public static boolean isBalanced(TreeNode root) {
        height(root);
        return status;
    }
    
    private static boolean status = true;

    private static int height(TreeNode root) {
        if (root == null)
            return 0;

        int left = height(root.left) + 1;
        int right = height(root.right) + 1;

        if (Math.abs(left - right) > 1)
        {
            status = false;
            return 0;
        }
        
        return Math.max(left, right);
    }
}
