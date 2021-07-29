import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class RightSideView {
    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 4 };//{ 1, 2, 3, Integer.MIN_VALUE, 5, Integer.MIN_VALUE, 4 };
        TreeNode root = TreeOperations.insert(arr);
        List<Integer> res = rightSideView(root);
        res.forEach((n) -> System.out.printf("%d ", n));
        System.out.println();
    }

    private static List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();

        Queue<TreeNode> q = new LinkedList<>();
        TreeNode temp;
        q.offer(root);
        int size;
        while (!q.isEmpty())
        {
            size = q.size();
            for(int i=0;i<size;i++)
            {
                temp = q.poll();
                if(i == size -1)result.add(temp.val);

                if(temp.left != null)q.add(temp.left);
                if(temp.right != null)q.add(temp.right);
            }
        }

        return result;
    }
}
