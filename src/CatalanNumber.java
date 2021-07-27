public class CatalanNumber {
    public static void main(String[] args) {
        for (int i = 1; i <= 10; i++) {
            System.out.println(catalan(i));
        }
    }

    private static int catalan(int n) {
        int[] catln = new int[n + 1];
        catln[0] = catln[1] = 1;

        for (int i = 2; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                catln[i] += catln[j] * catln[i - j - 1];
            }
        }
        return catln[n];
    }
}
