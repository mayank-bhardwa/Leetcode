import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BottomUpLevelOrder {
    public static void main(String[] args) {
        int[] arr = { 3, 9, 20, Integer.MIN_VALUE, Integer.MIN_VALUE, 15, 7 };
        TreeNode root = TreeOperations.insert(arr);
        List<List<Integer>> result = levelOrderBottom(root);

        result.forEach((n) -> {
            n.forEach((i) -> System.out.printf("%d ", i));
            System.out.println();
        });
    }

    private static List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null)
            return result;
        Queue<TreeNode> q = new LinkedList<>();
        List<Integer> level = new ArrayList<>();
        TreeNode temp;
        int size;

        q.offer(root);
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

            result.add(new ArrayList<>(level));
            level.clear();
        }

        Collections.reverse(result);

        return result;
    }
}
