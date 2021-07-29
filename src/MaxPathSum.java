public class MaxPathSum {
    public static void main(String[] args) {
        int[] arr = {-3};//{ -10, 9, 20, Integer.MIN_VALUE, Integer.MIN_VALUE, 15, 7 };
        TreeNode root = TreeOperations.insert(arr);
        System.out.println(maxPathSum(root));
    }

    public static Integer mx = -10000;

    public static int maxPathSum(TreeNode root) {
        helper(root);
        return mx;
    }

    public static int helper(TreeNode root) {
        if (root == null)
            return -10000;
        int res = root.val;
        int l = helper(root.left);
        int r = helper(root.right);

        res = max(res, l, r);

        return res;
    }

    private static int max(int val, int left, int right) {
        int p1 = Integer.max(left, right);
        int p2 = Integer.max(val, p1 + val);
        int p3 = Integer.max(p2, left + right + val);
        mx = Integer.max(mx, p3);
        return p2;
    }
}