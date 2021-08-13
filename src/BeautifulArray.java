/*

*/

public class BeautifulArray {
    public static void main(String[] args) {
        int n = 5;
        int[] result = beautifulArray(n);
        for (int i : result)
            System.out.printf("%d ", i);
    }

    private static int[] beautifulArray(int n) {
        int[] result = new int[n];
        for (int i = 0; i < n; i++)
            result[i] = i + 1;
        return rearrange(result);
    }

    private static int[] rearrange(int[] arr) {
        if (arr.length <= 2)
            return arr;
        int r = (int) Math.ceil(arr.length / 2);
        int l = arr.length - r;

        int[] left = new int[l];
        int[] right = new int[r];

        for (int i = 0, j = 0; i < arr.length; i += 2, j++)
            left[j] = arr[i];

        for (int i = 1, j = 0; i < arr.length; i += 2, j++)
            right[j] = arr[i];

        left = rearrange(left);
        right = rearrange(right);
        int i = 0;
        for (int j : left)
            arr[i++] = j;
        for (int j : right)
            arr[i++] = j;

        return arr;
    }
}