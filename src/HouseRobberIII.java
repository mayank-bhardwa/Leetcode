//  Wrong Solution

public class HouseRobberIII {
    public static void main(String[] args) {
        int[] arr = { 3, 4, 5, 1, 3, Integer.MIN_VALUE, 1 };
        TreeNode root = TreeOperations.insert(arr);
        System.out.println(rob(root));

    }

    private static int rob(TreeNode root) {
        return helper(root, false);
    }

    private static int helper(TreeNode root, Boolean status) {
        if (root == null)
            return 0;
        int case1 = 0;
        if (status == false) {
            case1 = helper(root.left, true) + helper(root.right, true) + root.val;
        }
        int case2 = helper(root.left, false) + helper(root.right, false);

        return Integer.max(case1, case2);
    }
}