public class Compliment {
    public static void main(String[] args) {
        int num = 6;
        System.out.println(compliment(num));
    }

    private static int compliment(int num) {
        int res = 0;
        int i = 0;
        while (num > 0) {
            if (num % 2 == 0)
                res += 1 << i;

            i++;
            num >>= 1;
        }

        return res;
        // if (num == 1)
        // return 0;
        // StringBuilder res = new StringBuilder();
        // int len = (int) Math.ceil(Math.log(num) / Math.log(2));
        // for (int i = 0; i < len; i++) {
        // if ((num & 1 << i) == 0)
        // res.append('1');
        // else
        // res.append('0');
        // }

        // System.out.println(res);

        // return Integer.parseInt(res.reverse().toString(), 2);
    }
}
