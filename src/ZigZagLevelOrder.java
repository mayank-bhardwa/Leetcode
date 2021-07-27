import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ZigZagLevelOrder {
    public static void main(String[] args) {
        int[] arr = { 3, 9, 20, Integer.MIN_VALUE, Integer.MIN_VALUE, 15, 7 };
        TreeNode root = TreeOperations.insert(arr);
        List<List<Integer>> result = zigzagLevelOrder(root);

        result.forEach((n) -> {
            n.forEach((i) -> System.out.printf("%d ", i));
            System.out.println();
        });
    }

    public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null)
            return result;

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        List<Integer> level = new ArrayList<>();
        boolean status = false;
        Integer size;
        TreeNode temp;
        while (!q.isEmpty()) {
            size = q.size();
            for (int i = 0; i < size; i++) {
                temp = q.poll();
                level.add(temp.val);
                if (temp.left != null)
                    q.offer(temp.left);
                if (temp.right != null)
                    q.offer(temp.right);
            }

            if (status)
                Collections.reverse(level);

            result.add(new ArrayList<>(level));
            level.clear();
            status = !status;
        }

        return result;
    }
}
