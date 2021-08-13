import java.util.HashMap;

/*
Given a string s, partition s such that every substring of the partition is a palindrome.
Return the minimum cuts needed for a palindrome partitioning of s.
*/

public class PallindromicSubstringII {
    public static void main(String[] args) {
        String s = "ltsqjodzeriqdtyewsrpfscozbyrpidadvsmlylqrviuqiynbscgmhulkvdzdicgdwvquigoepiwxjlydogpxdahyfhdnljshgjeprsvgctgnfgqtnfsqizonirdtcvblehcwbzedsmrxtjsipkyxk";
        System.out.println(minCut(s));
    }

    private static int minCut(String s) {
        dp = new HashMap<>();
        return minCutHelper(s, 0, s.length() - 1);
    }

    private static HashMap<String, Integer> dp;

    private static int minCutHelper(String s, int i, int j) {
        if (dp.containsKey(Key(i, j)))
            return dp.get(Key(i, j));
        if (i == j || isPallindrome(s, i, j)) {
            dp.put(Key(i, j), 0);
            return 0;
        }

        int res = j - i + 1;
        int l, r;
        for (int k = i; k < j; k++) {
            l = minCutHelper(s, i, k);
            dp.put(Key(i, k), l);
            r = minCutHelper(s, k + 1, j);
            dp.put(Key(k + 1, j), r);
            res = Math.min(l + r + 1, res);
        }

        dp.put(Key(i, j), res);
        return res;
    }

    private static String Key(int i, int j) {
        return i + "" + j;
    }

    private static boolean isPallindrome(String s, int i, int j) {
        while (i < j) {
            if (s.charAt(i) != s.charAt(j))
                return false;
            i++;
            j--;
        }
        return true;
    }
}