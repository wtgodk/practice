package x.godk.leetcode.middle;

import java.util.Arrays;

/**
 * 给定一个包括 n 个整数的数组 nums 和 一个目标值 target。找出 nums 中的三个整数，使得它们的和与 target 最接近。返回这三个数的和。假定每组输入只存在唯一答案。
 * <p>
 * <p>
 * 示例：
 * <p>
 * 输入：nums = [-1,2,1,-4], target = 1
 * 输出：2
 * 解释：与 target 最接近的和是 2 (-1 + 2 + 1 = 2) 。
 *  
 * <p>
 * 提示：
 * <p>
 * 3 <= nums.length <= 10^3
 * -10^3 <= nums[i] <= 10^3
 * -10^4 <= target <= 10^4
 *
 * @author wt
 * @program practice
 * @create 2020-12-02  09:32
 */
public class ThreeSumClosest {


    public static void main(String[] args) {
        int[] nums = {-55, -24, -18, -11, -7, -3, 4, 5, 6, 9, 11, 23, 33};
        int target = 0;
        int i = solution1(nums, target);

        System.out.println(i);
    }


    public static int solution1(int[] nums, int target) {
        Arrays.sort(nums);
        int val = 0;
        //  三数之和 + -target 越接近0
        //双指针
        for (int i = 0; i < nums.length - 1; i++) {
            int flag = nums[i];
            int left = i + 1;
            int right = nums.length - 1;
            if (i == 0) {
                val = -target + flag + nums[left] + nums[right];
            }
            while (left < right) {

                int tmp = -target + flag + nums[left] + nums[right];
                if (tmp == 0) {
                    return target;
                } else if (tmp > 0) {
                    right--;
                } else {
                    left++;
                }
//                 if(val >0 && tmp >0 && tmp>val){
//                     return val+target;
//                 }
                int abs = Math.abs(tmp);
                int valAbs = Math.abs(val);
                if (abs < valAbs) {
                    val = tmp;
                }


            }

        }
        return val + target;

    }


}
