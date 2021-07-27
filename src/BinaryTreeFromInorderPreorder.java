import java.util.Hashtable;

public class BinaryTreeFromInorderPreorder {
    public static void main(String[] args) {
        int[] inorder = { 9, 3, 15, 20, 7 };
        int[] preorder = { 3, 9, 20, 15, 7 };
        TreeNode root = buildTree(preorder, inorder);
        TreeOperations.inorder(root);
    }

    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        Hashtable<Integer, Integer> in = new Hashtable<>();
        for (int i = 0; i < inorder.length; i++)
            in.put(inorder[i], i);

        return helper(preorder, in, 0, preorder.length - 1);
    }

    public static int preIndex = 0;

    public static TreeNode helper(int[] preorder, Hashtable<Integer, Integer> in, int start, int end) {
        if (start > end)
            return null;

        TreeNode head = new TreeNode(preorder[preIndex++]);

        if (end == start)
            return head;

        int inIndex = in.get(head.val);

        head.left = helper(preorder, in, start, inIndex - 1);
        head.right = helper(preorder, in, inIndex + 1, end);

        return head;
    }
}
