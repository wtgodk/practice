package x.godk.leetcode.simple;

/**
 * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
 *
 * 你可以假设数组中无重复元素。
 *
 * 示例 1:
 *
 * 输入: [1,3,5,6], 5
 * 输出: 2
 * 示例 2:
 *
 * 输入: [1,3,5,6], 2
 * 输出: 1
 * 示例 3:
 *
 * 输入: [1,3,5,6], 7
 * 输出: 4
 * 示例 4:
 *
 * 输入: [1,3,5,6], 0
 * 输出: 0
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/search-insert-position
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author wt
 * @program practice
 * @create 2021-03-04  16:47
 */
public class SearchInsert {

    public static void main(String[] args) {
        int solution = solution2(new int[]{1, 3}, 2);
        System.out.println(solution);

    }

    public static int solution(int[] nums ,int target){
        if(nums==null || nums.length==0){
            return 0;
        }
        for( int i=0;i<nums.length;i++){
          int val =   nums[i];
          if(val == target){
              return i;
          }else  if(val > target){
              return i;
          }
        }
        return nums.length;
    }

    /**
     * 功能描述: <br>
     * 〈〉  二分法
     * @param nums
     * @param target
     * @return int
     * @author weitao
     * @date 2021/3/4 16:57
     */
    public static int solution2(int[] nums ,int target){
        int left =0;
        int right  = nums.length;
        while (left < right){
          int mid = left + (right-left)/2;
          if(nums[mid] > target){
              // 中间值大于目标值，此时结果在mid左侧
              right = mid;
          }
          if(nums[mid] < target){
              // 中间值小于 目标值 ，此时结果在目标值右侧
              left = mid +1;
          }
          if(nums[mid] == target){
              return mid;
          }
        }


        return left;


    }
}
