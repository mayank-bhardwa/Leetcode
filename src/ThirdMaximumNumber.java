import java.util.TreeSet;

public class ThirdMaximumNumber {
    public static void main(String[] args) {
        int[] nums = { 1, 2, 3 };
        System.out.println(thirdMax(nums));
    }

    private static int thirdMax(int[] nums) {
        TreeSet<Integer> num = new TreeSet<>();
        for (int i = 0; i < nums.length; i++)
            num.add(nums[i]);

        if (num.size() < 3)
            num.pollLast();

        num.pollLast();
        num.pollLast();
        return num.pollLast();
    }
}
