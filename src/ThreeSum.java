import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
    public static void main(String[] args) {
        int[] nums = { -1, 0, 1, 2, -1, -4 };
        List<List<Integer>> result = threeSum(nums);
        System.out.println(result.toString());
    }

    private static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        int target, j, k;
        for (int i = 0; i < nums.length - 2; i++) {
            if (i == 0 || nums[i] != nums[i - 1]) {
                j = i + 1;
                k = nums.length - 1;
                while (j < k) {
                    target = nums[i] + nums[j] + nums[k];
                    if (target == 0) {
                        result.add(Arrays.asList(nums[i], nums[j], nums[k]));

                        while (j < k && nums[k] == nums[k - 1])
                            k--;
                        while (j < k && nums[j] == nums[j + 1])
                            j++;
                    }

                    if (target > 0) {
                        k--;
                    } else {
                        j++;
                    }
                }
            }
        }

        return result;
    }
}