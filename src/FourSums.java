import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FourSums {
    public static void main(String[] args) {
        int[] nums = { 1, 0, -1, 0, -2, 2 };
        int target = 0;
        System.out.println(fourSums(nums, target).toString());
    }

    private static List<List<Integer>> fourSums(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        int left, right, curr;
        for (int i = 0; i < nums.length - 3; i++)
            if (i == 0 || nums[i] != nums[i - 1])
                for (int j = i + 1; j < nums.length - 2; j++)
                    if (j == i + 1 || nums[j] != nums[j - 1]) {
                        left = j + 1;
                        right = nums.length - 1;
                        while (left < right) {
                            curr = nums[i] + nums[j] + nums[left] + nums[right];

                            if (curr == target) {
                                result.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));

                                while (left < right && nums[left] == nums[left + 1])
                                    left++;

                                while (left < right && nums[right] == nums[right - 1])
                                    right--;
                            }

                            if (curr > target)
                                right--;
                            else
                                left++;
                        }
                    }

        return result;
    }
}
