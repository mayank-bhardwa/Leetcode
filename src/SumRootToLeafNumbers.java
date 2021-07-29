public class SumRootToLeafNumbers {
    public static void main(String[] args) {
        int[] arr = { 4, 9, 0, 5, 1 };
        TreeNode root = TreeOperations.insert(arr);
        System.out.println(sumNumbers(root));
    }

    private static int sumNumbers(TreeNode root) {
        res = 0;
        helper(root, 0);
        return res;
    }

    private static void helper(TreeNode root, int num) {
        int temp = num * 10 + root.val;

        if (root.left == null && root.right == null) {
            res += temp;
            return;
        }

        if (root.left != null)
            helper(root.left, temp);
        if (root.right != null)
            helper(root.right, temp);
    }

    private static int res;
}