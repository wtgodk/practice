package x.godk.leetcode.middle;

/**
 * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
 * <p>
 * 示例 1：
 * <p>
 * 输入: "babad"
 * 输出: "bab"
 * 注意: "aba" 也是一个有效答案。
 * 示例 2：
 * <p>
 * 输入: "cbbd"
 * 输出: "bb"
 *
 * @author wt
 * @program practice
 * @create 2020-07-10  13:31
 */
public class LongestPalindrome {

    public static void main(String[] args) {
        String val = "a";
        String s = solution2(val);
        System.out.println(s);
    }

    static String solution1(String s) {
        int length = s.length();
        Boolean[][] boo = new Boolean[s.length()][s.length()];
        String val = "";
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                int m = i + j;
                if (m >= length) {
                    break;
                }
                if (i == 0) {
                    // 此时  j= m 所以永远为 ture
                    boo[j][m] = true;
                } else if (i == 1) {
                    // 此时  j 永远等于 j+1 比较两个相邻的 字符是否相同 如果相同则肯定为回文子串
                    boo[j][m] = s.charAt(j) == s.charAt(m);
                } else {
                    // 此时 i>1 需要比较 自己本身以及其 上一级是否是回文子串，如果不是那么他肯定不是 ,如果上一级是且 j m 坐标位置字符也相同，那么 boo[j,m] 也为回文子串
                    boo[j][m] = s.charAt(j) == s.charAt(m) && boo[j + 1][m - 1];
                }
                // 获取最长的回文子串，要从后往前获取  当0->i的长度大于目前已有的最大串时，进行判断是否符合条件,如果符合那么 回文子串 替换
                if (boo[j][m] && i + 1 > val.length()) {
                    val = s.substring(j, m + 1);
                }

            }

        }
        return val;

    }

    /**
     * 解决方法2
     *
     * @param s
     * @return
     */
    static String solution2(String s) {
        if (s == null || s.length() < 1) {
            return "";
        }
        String result = "";
        for (int i = 0; i < s.length(); i++) {
            // 以每一个节点进行左右推移运算，每个节点都计算出一个最长的回文串，取最长的哪一个
            // 两种情况 1： 回文串长度为 奇数，此时存在一个 中心字符
            //          2： 回文串长度为 偶数，此时存在两个中心字符

            //1、假设回文串长度为奇数 ,以 i作为中心字符进行左右扩展
            int jilen = extend(s, i, i);
            int oulen = extend(s, i, i + 1);
            //比较哪个更长
            int length = Math.max(jilen, oulen);
            if (length > result.length()) {
                int start = i - (length - 1) / 2;
                int end = i + length / 2;
                result = s.substring(start, end + 1);

            }


        }


        return result;


    }

    private static int extend(String s, int i, int j) {
        int left = i, right = j;
        while (i >= 0 && j < s.length() && s.charAt(i) == s.charAt(j)) {
            //左右移动坐标
            i--;
            j++;
        }
        //返回回文串长度
        return j - i - 1;


    }


}
