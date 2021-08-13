import java.util.HashMap;

/*
Given an array of positive integers nums, remove 
the smallest subarray (possibly empty) such that 
the sum of the remaining elements is divisible by 
p. It is not allowed to remove the whole array.

(Total - Deleted)%P ==0 means 
Total%P == Deleted%P
*/
public class MakeSumDivisibleByP {
    public static void main(String[] args) {
        int[] nums = { 3, 1, 4, 2 };
        int p = 6;
        System.out.println(minSubarray(nums, p));
    }

    private static int minSubarray(int[] nums, int p) {
        int len = nums.length;
        int result = len;
        int total = 0;
        for (int i : nums)
            total = (total + i) % p;

        if (total == 0)
            return 0;

        HashMap<Integer, Integer> prefix = new HashMap<>();
        int target = 0;
        int curr = 0;
        prefix.put(0, -1);
        for (int i = 0; i < len; i++) {
            curr = (curr + nums[i]) % p;
            target = (curr - total + p);

            if (prefix.containsKey(target)) {
                result = Math.min(result, i - prefix.get(target));
            }

            prefix.put(curr, i);
        }
        if (result >= len)
            return -1;
        return result;
    }
}
