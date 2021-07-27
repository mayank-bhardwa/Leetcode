import java.util.Hashtable;

public class BinaryTreeFromPostorder {
    public static void main(String[] args) {
        int[] inorder = { 9, 3, 15, 20, 7 };
        int[] postorder = { 9, 15, 7, 20, 3 };
        TreeNode head = buildTree(postorder, inorder);
        TreeOperations.preorder(head);
        System.out.println();
    }

    public static TreeNode buildTree(int[] postorder, int[] inorder) {
        inIndex.clear();
        for (int i = 0; i < inorder.length; i++)
            inIndex.put(inorder[i], i);

        postIndex = postorder.length - 1;

        return helper(postorder, 0, inorder.length - 1);
    }

    private static int postIndex;
    private static Hashtable<Integer, Integer> inIndex = new Hashtable<>();

    private static TreeNode helper(int[] postorder, int start, int end) {
        if (start > end)
            return null;
        TreeNode head = new TreeNode(postorder[postIndex--]);

        if (start == end)
            return head;

        int curr = inIndex.get(head.val);

        head.right = helper(postorder, curr + 1, end);
        head.left = helper(postorder, start, curr - 1);

        return head;
    }
}
