public class SerializeDeserializeBT {
    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, Integer.MIN_VALUE, Integer.MIN_VALUE, 4, 5 };
        TreeNode root = TreeOperations.insert(arr);
        String serial = serialize(root);
        System.out.println(serial);

        TreeNode root1 = deserialize(serial);
        TreeOperations.preorder(root1);
    }

    private static String serialize(TreeNode root) {
        if (root == null)
            return "X";
        StringBuilder s = new StringBuilder(); // Faster

        String left = serialize(root.left);
        String right = serialize(root.right);

        return s.append(root.val).append(",").append(left).append(",").append(right).toString();
    }

    private static TreeNode deserialize(String serial) {
        String[] q = serial.split(",");
        pos = 0;
        return helper(q);
    }

    private static int pos = 0;

    private static TreeNode helper(String[] q) {
        String value = q[pos++];
        if (value.equals("X"))
            return null;

        TreeNode root = new TreeNode(Integer.valueOf(value));

        root.left = helper(q);
        root.right = helper(q);

        return root;
    }
}