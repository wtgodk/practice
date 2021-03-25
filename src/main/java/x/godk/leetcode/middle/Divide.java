package x.godk.leetcode.middle;

import lombok.val;

/**
 *
 * 给定两个整数，被除数 dividend 和除数 divisor。将两数相除，要求不使用乘法、除法和 mod 运算符。
 *
 * 返回被除数 dividend 除以除数 divisor 得到的商。
 *
 * 整数除法的结果应当截去（truncate）其小数部分，例如：truncate(8.345) = 8 以及 truncate(-2.7335) = -2
 *
 *  
 *
 * 示例 1:
 *
 * 输入: dividend = 10, divisor = 3
 * 输出: 3
 * 解释: 10/3 = truncate(3.33333..) = truncate(3) = 3
 * 示例 2:
 *
 * 输入: dividend = 7, divisor = -3
 * 输出: -2
 * 解释: 7/-3 = truncate(-2.33333..) = -2
 *  
 *
 * 提示：
 *
 * 被除数和除数均为 32 位有符号整数。
 * 除数不为 0。
 * 假设我们的环境只能存储 32 位有符号整数，其数值范围是 [−231,  231 − 1]。本题中，如果除法结果溢出，则返回 231 − 1。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/divide-two-integers
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author wt
 * @program practice
 * @create 2021-02-25  14:46
 */
public class Divide {


    public static void main(String[] args) {

       int val =  ~-20;
//TODO  这题 递归  、边界限制 知识点很多
        int divide = divide(-2147483648, -1);

        System.out.println(divide);
    }

    public static int divide(int dividend, int divisor) {
        // 负数比正数多一位，所以把传入的数 按照负数算 就不会出现越界
        int pos =-1;
        int sign = 0; //正数
        if((dividend > 0 && divisor< 0) || (dividend <0 && divisor>0)){
            sign=1;// 负数
        }
        // 都转为 负数
        if(dividend>0){
            dividend = opposite(dividend);
        }
        if(divisor>0){
            divisor = opposite(divisor);
        }
        if(dividend > divisor){
            // 都转为负数， 应该 被除数的 绝对值更大， 真正值更小，此时结束递归，被除数已经无法被减去除数了
            return 0;
        }
        int tmpDividend = dividend;
        int tmpDivisor = divisor;

        dividend -=divisor;
        while(dividend <=divisor){
            // 除数膨胀
            divisor +=divisor;
            pos =pos + pos;
            dividend-=divisor;
        }
        int result = pos + opposite(divide(tmpDividend-divisor,tmpDivisor));
        if(result==Integer.MIN_VALUE){
            if(sign==0){
                return Integer.MAX_VALUE;
            }else{
                return result;
            }
        }else{
            return sign==0 ? -result:result;
        }
    }
    public static int opposite(int x) {
        return ~x + 1;
    }

}
