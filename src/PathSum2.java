import java.util.List;
import java.util.ArrayList;

public class PathSum2 {
    public static void main(String[] args) {
        int[] arr = { 5, 4, 8, 11, Integer.MIN_VALUE, 13, 4, 7, 2, Integer.MIN_VALUE, Integer.MIN_VALUE, 5, 1 };
        TreeNode root = TreeOperations.insert(arr);
        Integer targetSum = 22;

        List<List<Integer>> result = pathSum(root, targetSum);

        result.forEach((n) -> {
            n.forEach((i) -> System.out.printf("%d ", i));
            System.out.println();
        });
    }

    private static List<List<Integer>> result = new ArrayList<>();

    public static List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        helper(root, targetSum, new ArrayList<>());
        return result;
    }

    private static void helper(TreeNode root, int targetSum, List<Integer> arrayList) {
        if (root == null) {
            return;
        }

        arrayList.add(root.val);

        if (root.left == null && root.right == null && targetSum == root.val) {
            result.add(new ArrayList<>(arrayList));
            arrayList.remove(arrayList.size() - 1);
            return;
        }

        helper(root.left, targetSum - root.val, arrayList);
        helper(root.right, targetSum - root.val, arrayList);

        arrayList.remove(arrayList.size() - 1);
    }
}