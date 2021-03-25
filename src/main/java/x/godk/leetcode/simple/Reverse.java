package x.godk.leetcode.simple;


import java.util.Stack;

/**
 * 给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 123
 * 输出: 321
 *  示例 2:
 * <p>
 * 输入: -123
 * 输出: -321
 * 示例 3:
 * <p>
 * 输入: 120
 * 输出: 21
 * 注意:
 * <p>
 * 假设我们的环境只能存储得下 32 位的有符号整数，则其数值范围为 [−231,  231 − 1]。请根据这个假设，如果反转后整数溢出那么就返回 0。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reverse-integer
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author wt
 * @program practice
 * @create 2020-08-17  11:06
 */
public class Reverse {


    public static void main(String[] args) {
        int reverse = solution3(1563847412);
        System.out.println(reverse);
    }


    static long solution(long num) {
        Stack<Integer> stack = new Stack<>();
        String str = num + "";
        String symbol = "";
        for (char c : str.toCharArray()) {
            try {
                int i = Integer.parseInt(c + "");
                stack.push(i);
            } catch (Exception e) {
                symbol = c + "";
            }


        }
        StringBuilder sb = new StringBuilder();
        while (!stack.empty()) {
            Integer pop = stack.pop();
            sb.append(pop);
        }
        String reverse = symbol + sb.toString();
        long l = Long.parseLong(reverse);
        long l1 = 1L << 32;
        return l >= -(1L << 31) && l <= (1L << 31) - 1 ? l : 0;
    }


    static long solution2(long num) {
        StringBuilder sb = new StringBuilder();
        String str = num + "";
        String symbol = "";
        for (int i = str.length() - 1; i >= 0; i--) {
            try {
                char c = str.charAt(i);
                sb.append(Integer.parseInt(c + ""));
            } catch (Exception e) {
                symbol = str.charAt(i) + "";
            }
        }
        long l = Long.parseLong(symbol + sb.toString());
        return l >= -(1L << 31) && l <= (1L << 31) - 1 ? l : 0;
    }

    public static int solution3(int x) {
        int ans = 0;
        while (x != 0) {
            if ((ans * 10) / 10 != ans) {
                // 大于 指定值判断
                ans = 0;
                break;
            }
            ans = ans * 10 + x % 10;
            x = x / 10;
        }
        return ans;
    }

}
