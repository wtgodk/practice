package x.godk.leetcode.middle;

/**
 * 罗马数字包含以下七种字符： I， V， X， L，C，D 和 M。
 * <p>
 * 字符          数值
 * I             1
 * V             5
 * X             10
 * L             50
 * C             100
 * D             500
 * M             1000
 * 例如， 罗马数字 2 写做 II ，即为两个并列的 1。12 写做 XII ，即为 X + II 。 27 写做  XXVII, 即为 XX + V + II 。
 * <p>
 * 通常情况下，罗马数字中小的数字在大的数字的右边。但也存在特例，例如 4 不写做 IIII，而是 IV。数字 1 在数字 5 的左边，所表示的数等于大数 5 减小数 1 得到的数值 4 。同样地，数字 9 表示为 IX。这个特殊的规则只适用于以下六种情况：
 * <p>
 * I 可以放在 V (5) 和 X (10) 的左边，来表示 4 和 9。
 * X 可以放在 L (50) 和 C (100) 的左边，来表示 40 和 90。 
 * C 可以放在 D (500) 和 M (1000) 的左边，来表示 400 和 900。
 * 给定一个整数，将其转为罗马数字。输入确保在 1 到 3999 的范围内。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 3
 * 输出: "III"
 * 示例 2:
 * <p>
 * 输入: 4
 * 输出: "IV"
 * 示例 3:
 * <p>
 * 输入: 9
 * 输出: "IX"
 * 示例 4:
 * <p>
 * 输入: 58
 * 输出: "LVIII"
 * 解释: L = 50, V = 5, III = 3.
 * 示例 5:
 * <p>
 * 输入: 1994
 * 输出: "MCMXCIV"
 * 解释: M = 1000, CM = 900, XC = 90, IV = 4.
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/integer-to-roman
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author wt
 * @program practice
 * @create 2020-10-12  10:41
 */
public class IntToRoman {

    private static final char I = 'I';
    private static final char V = 'V';
    private static final char X = 'X';
    private static final char L = 'L';
    private static final char C = 'C';
    private static final char D = 'D';
    private static final char M = 'M';


    public static void main(String[] args) {
        String result = "MCMXCIV";
        String solution = solution2(1994);
        System.out.println(result.equals(solution));
    }


    private static String solution(int num) {
        StringBuilder sb = new StringBuilder();
        int tmp = num;
        // 千
        int m = tmp / 1000;
        if (m > 0) {
            for (int i = 0; i < m; i++) {
                sb.append(M);
            }
        }
        tmp = tmp % 1000;
        int cm = tmp / 900;
        if (cm == 1) {
            sb.append(C).append(M);
            tmp = tmp % 900;
        }
        int d = tmp / 500;
        tmp = tmp % 500;
        if (d > 0) {
            for (int i = 0; i < d; i++) {
                sb.append(D);
            }
        }
        int dc = tmp / 400;
        if (dc == 1) {
            sb.append(C).append(D);
            tmp = tmp % 400;
        }


        int c = tmp / 100;
        tmp = tmp % 100;
        if (c > 0) {
            for (int i = 0; i < c; i++) {
                sb.append(C);
            }
        }
        int xc = tmp / 90;
        if (xc == 1) {
            sb.append(X).append(C);
            tmp = tmp % 90;
        }

        int l = tmp / 50;
        tmp = tmp % 50;
        if (l > 0) {
            for (int i = 0; i < l; i++) {
                sb.append(L);
            }
        }
        int xl = tmp / 40;
        if (xl == 1) {
            sb.append(X).append(L);
            tmp = tmp % 40;
        }

        int x = tmp / 10;
        tmp = tmp % 10;
        if (x > 0) {
            for (int i = 0; i < x; i++) {
                sb.append(X);
            }
        }
        int ix = tmp / 9;
        if (ix == 1) {
            sb.append(I).append(X);
            tmp = tmp % 9;
        }

        int v = tmp / 5;
        tmp = tmp % 5;
        if (v > 0) {
            for (int i = 0; i < v; i++) {
                sb.append(V);
            }
        }
        int iv = tmp / 4;
        if (iv == 1) {
            sb.append(I).append(V);
            tmp = tmp % 4;
        }

        for (int i = 0; i < tmp; i++) {
            sb.append(I);
        }
        return sb.toString();
    }

    /**
     * 贪心算法
     *
     * @param num
     * @return
     */
    private static String solution2(int num) {
        int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] symbols = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        StringBuilder sb = new StringBuilder();
        // Loop through each symbol, stopping if num becomes 0.
        for (int i = 0; i < values.length && num >= 0; i++) {
            while (values[i] <= num) {
                sb.append(symbols[i]);
                num -= values[i];
            }

        }
        return sb.toString();

    }
}
