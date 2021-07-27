public class SameTree {
    public static void main(String[] args) {
        int[] arr1 = { 10, 5, 15 }, arr2 = { 10, 5, -1, -1, 15 };
        TreeNode root1 = TreeOperations.insert(arr1);
        TreeNode root2 = TreeOperations.insert(arr2);

        TreeOperations.inorder(root1);
        System.out.println();
        TreeOperations.inorder(root2);
        System.out.println();
        System.out.println(isSameTree(root1, root2));
    }

    public static boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null)
            return true;

        if (p != null && q != null && p.val == q.val)
            return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);

        return false;
    }
}