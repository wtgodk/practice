package x.godk.leetcode.middle;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。
 * <p>
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 *
 * @author wt
 * @program practice
 * @create 2021-01-06  09:50
 */
public class LetterCombinations {

    public static Map<Integer, String> param = new HashMap<>();

    static {

        param.put(2, "abc");
        param.put(3, "def");
        param.put(4, "ghi");
        param.put(5, "jkl");
        param.put(6, "mno");
        param.put(7, "pqrs");
        param.put(8, "tuv");
        param.put(9, "wxyz");

    }

    public static void main(String[] args) {
        List<String> strings = solution1("23456789");
        System.out.println(strings);
    }

    /**
     * 首先使用哈希表存储每个数字对应的所有可能的字母，然后进行回溯操作。
     * <p>
     * 回溯过程中维护一个字符串，表示已有的字母排列（如果未遍历完电话号码的所有数字，则已有的字母排列是不完整的）。该字符串初始为空。每次取电话号码的一位数字，从哈希表中获得该数字对应
     * 的所有可能的字母，
     * 并将其中的一个字母插入到已有的字母排列后面，然后继续处理电话号码的后一位数字，直到处理完电话号码中的所有数字，即得到一个完整的字母排列。然后进行回退操作，遍历其余的字母排列。
     * <p>
     * 回溯算法用于寻找所有的可行解，如果发现一个解不可行，则会舍弃不可行的解。在这道题中，由于每个数字对应的每个字母都可能进入字母组合，因此不存在不可行的解，直接穷举所有的解即可。
     * <p>
     * 作者：LeetCode-Solution
     * 链接：https://leetcode-cn.com/problems/letter-combinations-of-a-phone-number/solution/dian-hua-hao-ma-de-zi-mu-zu-he-by-leetcode-solutio/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    public static List<String> solution1(String digits) {
        List<String> values = new ArrayList<>();
        combinations(digits, values, 0, new StringBuilder());
        return values;
    }

    //FIXME 这东西看不太懂     sb.deleteCharAt(index);  这个递归 没搞太明白
    public static void combinations(String digits, List<String> values, int index, StringBuilder sb) {
        char[] chars = digits.toCharArray();
        if (index == chars.length) {
            values.add(sb.toString());
            return;
        }
        Character c = chars[index];
        String str = param.get(Integer.parseInt(String.valueOf(c)));
        for (int i = 0; i < str.length(); i++) {
            sb.append(str.charAt(i));
            combinations(digits, values, index + 1, sb);
            sb.deleteCharAt(index);
            System.out.println();
        }
    }


}
