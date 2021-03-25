package x.godk.leetcode.middle;

import java.util.ArrayList;
import java.util.List;

/**
 * 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
 * 示例：
 * 输入：n = 3
 * 输出：[
 * "((()))",
 * "(()())",
 * "(())()",
 * "()(())",
 * "()()()"
 * ]
 *
 * @author wt
 * @program practice
 * @create 2021-01-11  17:02
 */
public class GenerateParenthesis {
    public static void main(String[] args) {
        int n = 3;
        List<String> solution = solution2(3);
        System.out.println(solution);
    }

    public static List<String> solution(int n) {
        List<String> result = new ArrayList<>(n * 2);
        if (n <= 0) {
            return result;
        }
        generateP2(new StringBuilder(), n, n, result);


        return result;
    }

    public static void generateP(String param, int left, int right, List<String> result) {

        if (left == 0 && right == 0) {
            result.add(param);
            return;
        } else if (left == right) {
            // 左右括号相同下一个智能左括号
            generateP(param + "(", left - 1, right, result);
        } else {
            // 左括号右括号都可以
            if (left > 0) {
                generateP(param + "(", left - 1, right, result);
            }
            generateP(param + ")", left, right - 1, result);

        }


    }

    public static void generateP2(StringBuilder param, int left, int right, List<String> result) {

        if (left == 0 && right == 0) {
            result.add(param.toString());
            return;
        } else if (left == right) {
            // 左右括号相同下一个智能左括号
            generateP2(param.append("(") , left - 1, right, result);
        } else {
            // 左括号右括号都可以
            if (left > 0) {
                generateP2(param.append( "("), left - 1, right, result);
                param.deleteCharAt(param.length()-1);
            }
            generateP2(param.append(  ")"), left, right - 1, result);
            param.deleteCharAt(param.length()-1);
        }


    }





    public static List<String> generatP3(int n,ArrayList[] cache) {
        if (cache[n] != null) {
            return cache[n];
        }
        ArrayList<String> ans = new ArrayList<String>();
        if (n == 0) {
            ans.add("");
        } else {
            for (int c = 0; c < n; ++c) {
                for (String left: generatP3(c,cache)) {
                    for (String right: generatP3(n - 1 - c,cache)) {
                        ans.add("(" + left + ")" + right);
                    }
                }
            }
        }
        cache[n] = ans;
        return ans;
    }

    public static List<String> solution2(int n) {
        ArrayList[] cache = new ArrayList[100];
        return generatP3(n,cache);
    }

}