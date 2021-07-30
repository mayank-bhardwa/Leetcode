import java.util.LinkedList;
import java.util.Queue;

public class SerializeDeserializeBT {
    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, Integer.MIN_VALUE, Integer.MIN_VALUE, 4, 5 };
        TreeNode root = TreeOperations.insert(arr);
        String serial = serialize(root);
        System.out.println(serial);

        TreeNode root1 = deserialize(serial);
        TreeOperations.preorder(root1);
    }

    private static TreeNode deserialize(String serial) {
        String[] values = serial.substring(1).split(",");
        int[] arr = new int[values.length];
        for (int i = 0; i < values.length; i++) {
            if (values[i] != "null")
                arr[i] = Integer.parseInt(values[i]);
            else
                arr[i] = Integer.MIN_VALUE;
            System.out.println(arr[i]);
        }
        return null;
    }

    private static TreeNode insert(TreeNode head, String[] arr, int i) {
        if (arr[i] == "null")
            return null;
        head = new TreeNode(Integer.parseInt(arr[i]));

        int l = 2 * i + 1, r = 2 * i + 2;
        if (l < arr.length)
            head.left = insert(head.left, arr, l);

        if (r < arr.length)
            head.right = insert(head.right, arr, r);
        return head;
    }

    private static String serialize(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        if (root == null)
            return "null";

        int size;
        q.offer(root);
        TreeNode temp;
        String result = "";
        boolean all;
        while (!q.isEmpty()) {
            size = q.size();
            all = true;
            for (int i = 0; i < size; i++) {
                temp = q.poll();
                if (temp == null) {
                    result += ",null";
                    q.offer(null);
                    q.offer(null);
                } else {
                    result += "," + temp.val;
                    all = false;
                    if (temp.left != null)
                        q.offer(temp.left);
                    else
                        q.offer(null);
                    if (temp.right != null)
                        q.offer(temp.right);
                    else
                        q.offer(null);
                }
            }
            if (all)
                break;
        }

        return result;
    }
}
