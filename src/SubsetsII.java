import java.util.ArrayList;
import java.util.List;

public class SubsetsII {
    public static void main(String[] args) {
        int[] nums = { 1, 2, 2 };
        List<List<Integer>> result = subsetWithDup(nums);
        System.out.println(result.toString());
    }

    private static List<List<Integer>> subsetWithDup(int[] nums) {
        result = new ArrayList<>();

        helper(nums, 0, new ArrayList<>());

        return result;
    }

    private static List<List<Integer>> result;

    private static void helper(int[] nums, int index, List<Integer> res) {
        result.add(new ArrayList<>(res));
        if (nums.length == index)
            return;

        for (int i = index; i < nums.length; i++) {
            if (i != index && nums[i] == nums[i - 1])
                continue;

            res.add(nums[i]);
            helper(nums, i + 1, res);
            res.remove(res.size() - 1);
        }

    }
}
