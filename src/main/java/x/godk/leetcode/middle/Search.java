package x.godk.leetcode.middle;

/**
 *
 * 整数数组 nums 按升序排列，数组中的值 互不相同 。
 *
 * 在传递给函数之前，nums 在预先未知的某个下标 k（0 <= k < nums.length）上进行了 旋转，使数组变为 [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]]（下标 从 0 开始 计数）。例如， [0,1,2,4,5,6,7] 在下标 3 处经旋转后可能变为 [4,5,6,7,0,1,2] 。
 *
 * 给你 旋转后 的数组 nums 和一个整数 target ，如果 nums 中存在这个目标值 target ，则返回它的索引，否则返回 -1 。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：nums = [4,5,6,7,0,1,2], target = 0
 * 输出：4
 * 示例 2：
 *
 * 输入：nums = [4,5,6,7,0,1,2], target = 3
 * 输出：-1
 * 示例 3：
 *
 * 输入：nums = [1], target = 0
 * 输出：-1
 *  
 *
 * 提示：
 *
 * 1 <= nums.length <= 5000
 * -10^4 <= nums[i] <= 10^4
 * nums 中的每个值都 独一无二
 * nums 肯定会在某个点上旋转
 * -10^4 <= target <= 10^4
 *  
 *
 * 进阶：你可以设计一个时间复杂度为 O(log n) 的解决方案吗？
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/search-in-rotated-sorted-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author wt
 * @program practice
 * @create 2021-03-04  10:29
 */
public class Search {


    public static void main(String[] args) {

     //   nums = [4,5,6,7,0,1,2], target = 0
        int i = solution2(new int[]{2,3,1}, 3);
        System.out.println(i);

    }

    public static int solution1(int[] nums,int target){
        int i = 0;
        int start =nums[0];
        if(start ==target){
            return 0;
        }
        while(i<nums.length-1){
           int val =  nums[i];
           if(val == target){
               return i;
           }
           int next = nums[i+1];
           if(target==next){
               return i+1;
           }
           if(val > next){
               // 临界点   大->小 ， 如果 target > val 那么 不可能再有结果
               if(target > val){
                   return -1;
               }
               if(start < target){
                   return -1;
               }
           }
           i++;
        }
        return -1;
    }



    /**
     * 功能描述: <br>
     * 〈〉 官解  二分法
     * @param nums
     * @param target
     * @return int
     * @author weitao
     * @date 2021/3/4 11:20
     */
    public static int solution2(int[] nums,int target){
        int length = nums.length;
        if(length ==1){
            return nums[0] ==target? 0:-1;
        }
        if(length == 0){
            return -1;

        }
        int left = 0; int right = length-1;
        while(left<= right){
            int mid = (right +left)/2;
            if(nums[mid] ==   target){
                return mid;
            }
            // 首先判断 那一边是完全的 升序数组 ,最左侧的肯定大于 右侧升序数组的最大值，所以如果大于中间值，那么说明 left-> mid 不是升序数组 ， mid+1 -> right 为升序数组
            if(nums[left] > nums[mid]){
                if(target > nums[mid] && target < nums[left]){
                    // 大于中间值 小于 最左边第一个 或者 小于等于 最右边的值，那么 说明target 属于 mid->right  , 左指针移动到中间位置后一位。
                    left = mid +1;
                }else{
                    // 小于中间值，此时说明
                    right = mid -1;
                }
            }else{
                // left -> mid 为升序数组
                if(target < nums[mid] && target >= nums[left] ){
                    right = mid-1;
                }else{
                    left = mid +1;
                }
            }
        }
    return -1;

    }


}
