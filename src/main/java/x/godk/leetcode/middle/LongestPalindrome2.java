package x.godk.leetcode.middle;

/**
 * 判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 121
 * 输出: true
 * 示例 2:
 * <p>
 * 输入: -121
 * 输出: false
 * 解释: 从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。
 * 示例 3:
 * <p>
 * 输入: 10
 * 输出: false
 * 解释: 从右向左读, 为 01 。因此它不是一个回文数。
 * 进阶:
 * <p>
 * 你能不将整数转为字符串来解决这个问题吗？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/palindrome-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author wt
 * @program practice
 * @create 2020-08-19  14:57
 */
public class LongestPalindrome2 {


    public static void main(String[] args) {

        boolean solution = solution2(10);
        System.out.println(solution);
    }


    static boolean solution(long number) {
        // 数学方法 将 数字倒过来看是不是相等
        long tmp = number;
        // 是否为负数
        if (number < 0) {
            return false;
        }
        long newNumber = 0;
        while (number > 0) {
            long currNum = number % 10;
            newNumber = newNumber * 10 + currNum;
            number = number / 10;
        }
        return tmp == newNumber;
    }


    static boolean solution2(long number) {
        long tmp = number;
        if (number < 0) {
            return false;
        }
        if (number < 10) {
            return true;
        }
        long newNumber = 0;
        while (number > 0) {
            long tmpNumber = number % 10;
            if (newNumber == 0 && tmpNumber == 0) {
                return false;
            }
            newNumber = newNumber * 10 + tmpNumber;
            number = number / 10;
            if (newNumber >= number) {
                break;
            }
        }
        if (newNumber > number) {
            newNumber = newNumber / 10;
        }
        return newNumber == number;

    }

}
