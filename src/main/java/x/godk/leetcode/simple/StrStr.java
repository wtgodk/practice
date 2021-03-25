package x.godk.leetcode.simple;

/**
 *
 * 实现 strStr() 函数。
 *
 * 给定一个 haystack 字符串和一个 needle 字符串，在 haystack 字符串中找出 needle 字符串出现的第一个位置 (从0开始)。如果不存在，则返回  -1。
 *
 * 示例 1:
 *
 * 输入: haystack = "hello", needle = "ll"
 * 输出: 2
 * 示例 2:
 *
 * 输入: haystack = "aaaaa", needle = "bba"
 * 输出: -1
 * 说明:
 *
 * 当 needle 是空字符串时，我们应当返回什么值呢？这是一个在面试中很好的问题。
 *
 * 对于本题而言，当 needle 是空字符串时我们应当返回 0 。这与C语言的 strstr() 以及 Java的 indexOf() 定义相符。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/implement-strstr
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author wt
 * @program practice
 * @create 2021-02-25  13:45
 */
public class StrStr {


    public static void main(String[] args) {


        int solution = solution2( "hel12loll","ll");
        System.out.println(solution);

    }

    public static int solution2(String haystack,String needle){
        if( "".equals(needle)|| needle==null){
            return 0;
        }
        for(int i=0;i<=haystack.length()-needle.length();i++){
            String substring = haystack.substring(i, i+ needle.length());
            if(substring.equals(needle)){
                return i;
            }
        }
        return -1;

    }

    public static int solution(String haystack,String needle){
        int first = -1;
        int pos = 0;
        if( "".equals(needle)|| needle==null){
            return 0;
        }
        for( int i=0;i<haystack.length();i++){
            char c = haystack.charAt(i);
            if(c == needle.charAt(pos)){
                if(pos == 0){
                    first = i;
                }
                if(pos == needle.length()-1){
                    return first;
                }
                pos++;
            }else{
                if(pos>0 ){
                    i = first;
                }
                    pos = 0;
                    first = -1;
            }
        }
        return -1;

    }
}
