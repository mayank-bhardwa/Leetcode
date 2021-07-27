import java.util.ArrayList;
import java.util.List;

public class UniqueBinarySearchTree2 {
    public static void main(String[] args) {
        int n = 3;
        List<TreeNode> trees = generateTrees(n);

        for (TreeNode i : trees) {
            TreeOperations.preorder(i);
            System.out.println();
        }
    }

    public static List<TreeNode> generateTrees(int n) {
        return generate(1, n);
    }

    private static List<TreeNode> generate(int start, int end) {
        List<TreeNode> trees = new ArrayList<>();
        if (start > end) {
            trees.add(null);
            return trees;
        } else if (start == end) {
            trees.add(new TreeNode(start));
            return trees;
        } else if (end - start == 1) {
            trees.add(new TreeNode(start, null, new TreeNode(end)));
            trees.add(new TreeNode(end, new TreeNode(start), null));
            return trees;
        } else {
            for (int i = start; i <= end; i++) {
                List<TreeNode> leftSubtree = generate(start, i - 1);
                List<TreeNode> rightSubtree = generate(i + 1, end);

                for (TreeNode left : leftSubtree)
                    for (TreeNode right : rightSubtree) {
                        TreeNode root = new TreeNode(i, left, right);
                        trees.add(root);
                    }
            }
        }

        for (int i = start; i <= end; i++) {

        }

        return trees;
    }
}