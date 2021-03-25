package x.godk.leetcode.simple;

/**
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 * <p>
 * 如果不存在公共前缀，返回空字符串 ""。
 * <p>
 * 示例 1:
 * <p>
 * 输入: ["flower","flow","flight"]
 * 输出: "fl"
 * 示例 2:
 * <p>
 * 输入: ["dog","racecar","car"]
 * 输出: ""
 * 解释: 输入不存在公共前缀。
 * 说明:
 * <p>
 * 所有输入只包含小写字母 a-z 。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-common-prefix
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author wt
 * @program practice
 * @create 2020-10-12  13:42
 */
public class LongestCommonPrefix {


    public static void main(String[] args) {
        String[] arr = new String[]{"aa", "aa"};
        String solution = solution(arr);
        System.out.println(solution.equals("aa"));

    }


    private static String solution(String[] arr) {
        StringBuilder sb = new StringBuilder();
        Character common = null;
        int index = 0;
        int i = 0;
        if (arr.length == 1) {
            return arr[0];
        }
        while (arr.length > 0) {
            if (i >= arr.length) {
                sb.append(common);
                break;
            }
            if (arr[i].length() <= index) {
                break;
            }
            char c = arr[i].charAt(index);
            if (common == null) {
                common = c;
            } else if (c != common) {
                break;
            }
            if (i == arr.length - 1) {
                sb.append(c);
                i = 0;
                index++;
                common = null;
            } else {
                i++;
            }

        }


        return sb.length() > 0 ? sb.toString() : "";
    }

    private static String solution2(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        String prefix = strs[0];
        int count = strs.length;
        for (int i = 1; i < count; i++) {
            prefix = longestCommonPrefix(prefix, strs[i]);
            if (prefix.length() == 0) {
                break;
            }
        }
        return prefix;
    }


    public static String longestCommonPrefix(String str1, String str2) {
        int length = Math.min(str1.length(), str2.length());
        int index = 0;
        while (index < length && str1.charAt(index) == str2.charAt(index)) {
            index++;
        }
        return str1.substring(0, index);
    }


    /**
     * 功能描述: <br>
     * 〈〉
     *
     * @param strs
     * @return java.lang.String
     * @author weitao
     * @date 2021/1/11 16:45
     */
    private static String solution3(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        int length = strs[0].length();
        int count = strs.length;
        for (int i = 0; i < length; i++) {
            char c = strs[0].charAt(i);
            for (int j = 1; j < count; j++) {
                if (i == strs[j].length() || strs[j].charAt(i) != c) {
                    return strs[0].substring(0, i);
                }
            }
        }
        return strs[0];
    }

}
