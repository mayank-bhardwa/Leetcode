import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Pair {
    TreeNode n;
    Integer i;

    Pair(TreeNode t, Integer i) {
        this.n = t;
        this.i = i;
    }
}

public class LevelOrder {
    public static void main(String[] args) {
        int[] arr = { -9, -3, 2, Integer.MIN_VALUE, 4, 4, 0, Integer.MIN_VALUE, Integer.MIN_VALUE, -6,
                Integer.MIN_VALUE, -5 };
        TreeNode root = TreeOperations.insert(arr);
        TreeOperations.preorder(root);
        System.out.println();
        List<List<Integer>> result = levelOrder(root);
        // for (List<Integer> i : result) {
        // for (Integer j : i)
        // System.out.printf("%d ", j);
        // System.out.println();
        // }

        result.forEach((n) -> {
            n.forEach((i) -> System.out.printf("%d ", i));
            System.out.println();
        });
    }

    public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null)
            return result;

        Queue<TreeNode> q = new LinkedList<>();

        q.offer(root);
        q.offer(null);

        TreeNode temp = null;
        List<Integer> level = new ArrayList<>();

        while (!q.isEmpty()) {
            temp = q.poll();
            if (temp == null) {
                result.add(new ArrayList<>(level));
                level.clear();
                if (!q.isEmpty())
                    q.offer(null);
            } else {
                level.add(temp.val);
                if (temp.left != null)
                    q.offer(temp.left);
                if (temp.right != null)
                    q.offer(temp.right);
            }
        }

        return result;
    }
}
