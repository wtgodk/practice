package x.godk.leetcode.middle;

import java.util.HashMap;
import java.util.Map;

/**
 * 请你来实现一个 atoi 函数，使其能将字符串转换成整数。
 * <p>
 * 首先，该函数会根据需要丢弃无用的开头空格字符，直到寻找到第一个非空格的字符为止。接下来的转化规则如下：
 * <p>
 * 如果第一个非空字符为正或者负号时，则将该符号与之后面尽可能多的连续数字字符组合起来，形成一个有符号整数。
 * 假如第一个非空字符是数字，则直接将其与之后连续的数字字符组合起来，形成一个整数。
 * 该字符串在有效的整数部分之后也可能会存在多余的字符，那么这些字符可以被忽略，它们对函数不应该造成影响。
 * 注意：假如该字符串中的第一个非空格字符不是一个有效整数字符、字符串为空或字符串仅包含空白字符时，则你的函数不需要进行转换，即无法进行有效转换。
 * <p>
 * 在任何情况下，若函数不能进行有效的转换时，请返回 0 。
 * <p>
 * 提示：
 * <p>
 * 本题中的空白字符只包括空格字符 ' ' 。
 * 假设我们的环境只能存储 32 位大小的有符号整数，那么其数值范围为 [−231,  231 − 1]。如果数值超过这个范围，请返回  INT_MAX (231 − 1) 或 INT_MIN (−231) 。
 *  
 * <p>
 * 示例 1:
 * <p>
 * 输入: "42"
 * 输出: 42
 * 示例 2:
 * <p>
 * 输入: "   -42"
 * 输出: -42
 * 解释: 第一个非空白字符为 '-', 它是一个负号。
 *      我们尽可能将负号与后面所有连续出现的数字组合起来，最后得到 -42 。
 * 示例 3:
 * <p>
 * 输入: "4193 with words"
 * 输出: 4193
 * 解释: 转换截止于数字 '3' ，因为它的下一个字符不为数字。
 * 示例 4:
 * <p>
 * 输入: "words and 987"
 * 输出: 0
 * 解释: 第一个非空字符是 'w', 但它不是数字或正、负号。
 * 因此无法执行有效的转换。
 * 示例 5:
 * <p>
 * 输入: "-91283472332"
 * 输出: -2147483648
 * 解释: 数字 "-91283472332" 超过 32 位有符号整数范围。
 *      因此返回 INT_MIN (−231) 。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/string-to-integer-atoi
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author wt
 * @program practice
 * @create 2020-08-19  10:11
 */
public class Atoi {


    final int START = 0;
    final int SIGNED = 1;
    final int IN_NUM = 2;
    final int END = 3;
    public int sign = 1;
    public long ans = 0;
    int state = START;
    Map<Integer, Integer[]> map;

    public Atoi() {
        map = new HashMap<>();
        map.put(START, new Integer[]{START, SIGNED, IN_NUM, END});
        map.put(SIGNED, new Integer[]{END, END, IN_NUM, END});
        map.put(IN_NUM, new Integer[]{END, END, IN_NUM, END});
        map.put(END, new Integer[]{END, END, END, END});
    }

    public static void main(String[] args) {
        String str = "+1";
        int solution = solution2(str);
        System.out.println(solution);
        int x = 2147483640;
        int j = 8;
        int total = x + j;
        System.out.println(total);
    }

    static int solution(String str) {
        String trim = str.trim();
        char[] chars = trim.toCharArray();
        int num = 0;
        boolean negative = false;
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            if (i == 0) {
                if (c != '+' && c != '-' && (c < '0' || c > '9')) {
                    return 0;
                } else if (c == '-') {
                    negative = true;
                    continue;
                } else if (c == '+') {
                    continue;
                }

            }
            if (c < '0' || c > '9') {
                break;
            }
            int i1 = c - '0';
            if ((num * 10 + i1) / 10 != num) {
                return negative ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            }
            num = num * 10 + i1;
        }
        return negative ? -num : num;

    }

    /**
     * 字符串处理的题目往往涉及复杂的流程以及条件情况，如果直接上手写程序，一不小心就会写出极其臃肿的代码。
     * <p>
     * 因此，为了有条理地分析每个输入字符的处理方法，我们可以使用自动机这个概念：
     * <p>
     * 我们的程序在每个时刻有一个状态 s，每次从序列中输入一个字符 c，并根据字符 c 转移到下一个状态 s'。这样，我们只需要建立一个覆盖所有情况的从 s 与 c 映射到 s' 的表格即可解决题目中的问题。
     * <p>
     * start
     * end
     *
     * @param str
     * @return
     */

    static int solution2(String str) {
        Atoi automaton = new Atoi();
        char[] c = str.toCharArray();
        for (char ch : c) {
            automaton.get(ch);
        }
        return automaton.sign * ((int) automaton.ans);
    }

    public int get_col(char c) {
        if (c == ' ') return 0;
        if (c == '+' || c == '-') return 1;
        if (c >= '0' && c <= '9') return 2;
        return 3;
    }

    public void get(char c) {
        state = map.get(state)[get_col(c)];
        if (state == IN_NUM) {
            ans = ans * 10 + c - '0';
            if (sign == 1) {
                ans = Math.min(ans, Integer.MAX_VALUE);
            } else {
                // -(long)Integer.MIN_VALUE，这个操作有点东西，不然越界
                ans = Math.min(ans, -(long) Integer.MIN_VALUE);
            }
        } else if (state == SIGNED) {
            sign = c == '+' ? 1 : -1;
        }

    }


}
