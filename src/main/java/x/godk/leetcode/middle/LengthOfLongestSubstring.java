package x.godk.leetcode.middle;

import java.util.*;

/**
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 * <p>
 * 示例 1:
 * <p>
 * 输入: "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * 示例 2:
 * <p>
 * 输入: "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * 示例 3:
 * <p>
 * 输入: "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-substring-without-repeating-characters
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author wt
 * @program practice
 * @create 2020-07-09  11:56
 */
public class LengthOfLongestSubstring {


    public static void main(String[] args) {
        //   String str = "abbcdefghijklmnopqrstbuvwxyz";
        //  String str = "cdefghijklmnopqrstuvwxyz";
        String str = "abba";
        //String[] split = str.split("a");
        int length1 = str.length();
        int length = lengthOfLongestSubstring4(str);
        System.out.println(length);


    }

    /**
     * 很慢
     *
     * @param str
     * @return
     */
    static int lengthOfLongestSubstring(String str) {
        if (str.length() == 1) {
            return 1;
        }
        int length = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.length() - i <= length) {
                return length;
            }
            StringBuilder sb = new StringBuilder(str.charAt(i) + "");
            for (int j = i + 1; j < str.length(); j++) {
                String s = str.charAt(j) + "";
                if (sb.toString().contains(s)) {
                    if (length < sb.length()) {
                        length = sb.length();
                    }
                    break;
                }
                sb.append(str.charAt(j) + "");
                if (j == str.length() - 1) {
                    if (length < sb.length()) {
                        length = sb.length();
                    }
                }
            }
        }
        return length;
    }

    /**
     * @param str
     * @return
     */
    static int lengthOfLongestSubstring2(String str) {
        if (str.length() == 1) {
            return 1;
        }
        int length = 0;
        int index = 1;
        LinkedList<Character> list = new LinkedList<>();
        for (int i = 0; i < str.length(); i++) {
            if (str.length() - i <= length) {
                return length;
            }
            if (i == 0) {
                list.add(str.charAt(i));
            }
            for (int j = index; j < str.length(); j++) {
                char s = str.charAt(j);
                if (list.contains(s)) {
                    if (length < list.size()) {
                        length = list.size();
                    }
                    index = j;
                    list.removeFirst();
                    break;
                }
                list.add(str.charAt(j));
                if (j == str.length() - 1) {
                    if (length < list.size()) {
                        length = list.size();
                    }
                }
            }
        }
        return length;
    }


    static int lengthOfLongestSubstring3(String str) {
        if (str.length() == 1) {
            return 1;
        }
        int length = 0;
        Set<Character> set = new HashSet<>();
        int startIndex = -1;
        for (int i = 0; i < str.length(); i++) {
            if (i > 0) {
                set.remove(str.charAt(i - 1));
            }
            while (startIndex + 1 < str.length() && !set.contains(str.charAt(startIndex + 1))) {
                set.add(str.charAt(startIndex + 1));
                startIndex++;
            }
            length = Math.max(length, startIndex - i + 1);
        }
        return length;
    }

    /**
     * 滑动窗口
     *
     * @param s
     * @return
     */
    public static int lengthOfLongestSubstring4(String s) {
        if (s.length() == 0 || s.length() == 1) {
            return s.length();
        }

        int leftIndex = 0;
        int maxLength = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            Character c = s.charAt(i);
            if (map.containsKey(c)) {
                //指针从有重复字母的位置向右移动一位移动
                leftIndex = Math.max(leftIndex, map.get(c) + 1);
            }
            map.put(c, i);
            maxLength = Math.max(maxLength, i - leftIndex + 1);

        }
        return maxLength;
    }

}
