package x.godk.leetcode.middle;

import java.util.Arrays;

/**
 *
 * 给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
 *
 * 如果数组中不存在目标值 target，返回 [-1, -1]。
 *
 * 进阶：
 *
 * 你可以设计并实现时间复杂度为 O(log n) 的算法解决此问题吗？
 *  
 *
 * 示例 1：
 *
 * 输入：nums = [5,7,7,8,8,10], target = 8
 * 输出：[3,4]
 * 示例 2：
 *
 * 输入：nums = [5,7,7,8,8,10], target = 6
 * 输出：[-1,-1]
 * 示例 3：
 *
 * 输入：nums = [], target = 0
 * 输出：[-1,-1]
 *  
 *
 * 提示：
 *
 * 0 <= nums.length <= 105
 * -109 <= nums[i] <= 109
 * nums 是一个非递减数组
 * -109 <= target <= 109
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-first-and-last-position-of-element-in-sorted-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author wt
 * @program practice
 * @create 2021-03-04  13:53
 */
public class SearchRange {


    public static void main(String[] args) {

        int[] ints = solution2(new int[]{5,7,7,8,8,10,11}, 8);
      // int[] ints = solution2(new int[]{1,2,2}, 2);
        System.out.println(Arrays.toString(ints));
    }

    public static int[] solution1(int[] nums,int target){
        if(nums==null ||nums.length==0){
            return new int[]{-1,-1};
        }
        if(nums.length == 1){
            return nums[0] == target ? new int[]{0,0}:new int[]{-1,-1};
        }
            int mid =nums.length/2;
            int left = mid;
             // 左边界
            while( left>=0 && nums[left] >= target  ){
                left--;
            }
            while(left>=0 && left < nums.length && nums[left] < target){
                left++;
            }
            if(left<0 && nums[0] == target){
                left =0;
            }
        int right = mid;
            //右边界
            while(right>left  && nums[right] > target){
                right--;
            }
            while(right>=0 && right < nums.length && nums[right] <= target){
                right++;
            }
            int l = -1;
            int r = -1;
            if(left >=0 && right <= nums.length && left < right){
                if(nums[left] == target){
                    l = left;
                    r = left;
                }
                if(nums[right-1] == target){
                       r = right-1;
                }
            }
        return new int[]{l,r};
    }

    public static int[] solution2(int[] nums, int target) {
        int len = nums.length;
        if (len == 0) {
            return new int[]{-1, -1};
        }

        int firstPosition = findFirstPosition(nums, target);
        if (firstPosition == -1) {
            return new int[]{-1, -1};
        }

        int lastPosition = findLastPosition(nums, target,firstPosition);
        return new int[]{firstPosition, lastPosition};
    }

    private static int findFirstPosition(int[] nums, int target) {
        int left  = 0;
        int right = nums.length-1;
        //left == right时 退出循环，此时已经排除所有结果内容，如果存在target 那么此时 left == right 且 为最小的 索引值
        while(left < right){
            // 中间值获取，   字符串长度 （right - left ）   字符串长度的中间值+ left 值   mid的索引值
            int mid = left + (right - left)/2;
            if(nums[mid] > target){
                // 中间值比 目标值大，由于 数组为升序数组，那么说明 目标值在 mid的左侧 ，此时 right指针移动到 mid左侧
                right = mid -1;
            }else if(nums[mid] < target){
                // 中间值 小于 目标值 ， 由于数组为升序数组，那么说明目标值在mid的右侧, 此时left指针移动到mid右侧
                left = mid +1;
            }else{
                // nums[mid] == target 此时说明 由于数组为升序数组 那么说明目标值在的索引 <=right
                right = mid;
            }
        }
            // 需要判断最后的left索引处值是否为 目标值，因为可能 left移动到 0位置 rigth 移动到0位置，但是并没有查询出结果，那么返回-1
        return nums[left] == target ? left: -1;
    }


    private static int findLastPosition(int[] nums, int target,int left) {
            int right = nums.length-1;
            // 由于 上一步已经找到最左侧的索引，所以可以减小 数组搜索范围 left->right
        // 如果 left == right  此时退出循环，
        while(left< right){
            // 此处 right-left +1 是用来向上取整，  由于该方法用于寻找最右侧的目标值，所以最终left == right时为 left 移动到最右位置，即最后一个符合目标值的索引处
            //  如果结果数组为偶数位  刚刚好出现  left  = right -1  且 nums[left] == nums[right] 此时由于指针不在移动将会导致死循环，所以直接选择中间值向上取整
        int mid = left + (right-left+1)/2;
                if(nums[mid] > target){
                    // 符合条件的内容在 mid 的 左侧 此时移动right指针到mid的左侧
                    right = mid-1;
                }else if(nums[mid] < target){
                    // 符合条件的内容在 mid的右侧
                    left = mid+1;
                }else{
                    // 符合条件的内容在 mid或 mid右侧，将 最左侧指针移动到mid
                    left = mid;
                }
        }
            return left;
    }

}
