package x.godk.leetcode.simple;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 * <p>
 * 有效字符串需满足：
 * <p>
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 注意空字符串可被认为是有效字符串。
 * <p>
 * 示例 1:
 * <p>
 * 输入: "()"
 * 输出: true
 * 示例 2:
 * <p>
 * 输入: "()[]{}"
 * 输出: true
 * 示例 3:
 * <p>
 * 输入: "(]"
 * 输出: false
 * 示例 4:
 * <p>
 * 输入: "([)]"
 * 输出: false
 * 示例 5:
 * <p>
 * 输入: "{[]}"
 * 输出: true
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/valid-parentheses
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author wt
 * @program practice
 * @create 2021-01-08  13:14
 */
public class IsValid {

    public static void main(String[] args) {

        boolean solution = solution("(as[da[]({}s)]zx)");
        System.out.println(solution);

    }


    public static boolean solution(String str) {
        Map<Character, Character> param = new HashMap<>();
        param.put(']', '[');
        param.put('}', '{');
        param.put(')', '(');
        Stack<Character> stack = new Stack<>();

        char[] chars = str.toCharArray();

        for (char c : chars) {
            if (c == '[' || c == '{' || c == '(') {
                stack.push(c);
            } else if (param.get(c) != null) {


                if (stack.size() == 0 || !stack.pop().equals(param.get(c))) {
                    return false;
                }
            }
        }
        return stack.size() == 0;
    }

}
