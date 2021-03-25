package x.godk.leetcode.difficult;

/**
 *
 * 给你一个只包含 '(' 和 ')' 的字符串，找出最长有效（格式正确且连续）括号子串的长度。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：s = "(()"
 * 输出：2
 * 解释：最长有效括号子串是 "()"
 * 示例 2：
 *
 * 输入：s = ")()())"
 * 输出：4
 * 解释：最长有效括号子串是 "()()"
 * 示例 3：
 *
 * 输入：s = ""
 * 输出：0
 *  
 *
 * 提示：
 *
 * 0 <= s.length <= 3 * 104
 * s[i] 为 '(' 或 ')'
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-valid-parentheses
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author wt
 * @program practice
 * @create 2021-03-03  14:20
 */
public class LongestValidParentheses {


    public static void main(String[] args) {
        int solution = solution2(")()())");
        System.out.println(solution);
    }


    public static int solution(String str){
        if(str==null || str.length()==1){
            return 0;
        }
        int left= 0;
        int right= left+1;
        int result = 0;
        while(left < str.length()){
            int leftParentheses = 0;
            if(str.charAt(left)==')'){
                left++;
                right =left+1;
                continue;
            }
            leftParentheses++;
            while(right<str.length()){
                char c = str.charAt(right);
                if(leftParentheses==0){
                    //当前是一个合法串
                    result = Math.max(result,right-left);
                }else if(leftParentheses<0){
                    break;
                }
                if(c == '('){
                    leftParentheses++;
                }else{
                    leftParentheses--;
                }
                right++;

            }
            if(leftParentheses==0){
                result = Math.max(result,right-left);
            }

            left++;
            right=left+1;

        }

return result;
    }

    /**
     * 功能描述: <br>
     * 〈〉 FIXME  动态规划  这玩意儿 是真的看不太懂
     * @param s
     * @return int
     * @author weitao
     * @date 2021/3/3 15:32
     */
    public static int solution2(String s) {
        int[] dp = new int[s.length()];
        int maxLength = 0;
        for (int i = 1; i < dp.length; i++) {
            if (s.charAt(i) == ')') {
                if (s.charAt(i - 1) == '(') {
                    // ...()
                    dp[i] = 2 + (i - 2 >= 0 ? dp[i - 2] : 0);
                } else if (s.charAt(i - 1) == ')') {
                    // ...))
                    if (dp[i - 1] > 0) {
                        // ...(...))
                        if (i - dp[i - 1] - 1 >= 0 && s.charAt(i - dp[i - 1] - 1) == '(') {
                            // ...((...))
                            dp[i] = 2 + dp[i - 1] + (i - dp[i - 1] - 1 - 1 >= 0 ? dp[i - dp[i - 1] - 1 - 1] : 0);
                        }
                    }
                }
            }
            maxLength = Math.max(maxLength, dp[i]);
        }
        return maxLength;
    }

}
