package x.godk.leetcode.middle;

import java.util.Arrays;

/**
 *
 * 实现获取 下一个排列 的函数，算法需要将给定数字序列重新排列成字典序中下一个更大的排列。
 *
 * 如果不存在下一个更大的排列，则将数字重新排列成最小的排列（即升序排列）。
 *
 * 必须 原地 修改，只允许使用额外常数空间。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：nums = [1,2,3]
 * 输出：[1,3,2]
 * 示例 2：
 *
 * 输入：nums = [3,2,1]
 * 输出：[1,2,3]
 * 示例 3：
 *
 * 输入：nums = [1,1,5]
 * 输出：[1,5,1]
 * 示例 4：
 *
 * 输入：nums = [1]
 * 输出：[1]
 *  
 *
 * 提示：
 *
 * 1 <= nums.length <= 100
 * 0 <= nums[i] <= 100
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/next-permutation
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author wt
 * @program practice
 * @create 2021-03-03  10:52
 */
public class NextPermutation {

    public static void main(String[] args) {
        solution3(new int[]{1,2});


    }
    public static int[]  solution1(int[] array){
        if(array ==null ||  array.length<=1){
            return array;
        }
        int pre = array.length-1;
        for(int i=array.length-2;i>=0 ;i--){
            int val = array[i];
            if(val>=array[pre]){
                pre--;
            }else{
                int index = i+1;
                int tmp =index;
                while(index < array.length-1 ){
                    if(array[tmp] > array[++index] && array[index] > val){
                        tmp= index;
                    }
                }

               int tmpVal= array[tmp];
                array[tmp]=  val;
                array[i]=  tmpVal;
                Arrays.sort(array,i+1,array.length);
                return array;
            }
        }
        Arrays.sort(array);
return array;
    }

    /**
     * 功能描述: <br>
     * 〈〉 官解模仿
     * @param nums
     * @return void
     * @author weitao
     * @date 2021/3/3 13:56
     */
    public static void solution3(int[] nums){
        if(nums ==null ||  nums.length<=1){
            return ;
        }
       int i = nums.length-2; //从倒数第二个开始往后比较，如果前一个比后一个大那么继续比较知道 当前值小于后一个值
        while(i>=0 && nums[i] >= nums[i+1]){
            i--;
        }
        if(i>=0){
            // 此时找到i所在值 小于i=1的值，那么 从后往前找到第一个比 i大的值， 因为 i+1->length 是一个倒序数组，所以找到从后往前第一个比i位置大的
            int j = nums.length-1;
            while(i<j && nums[i]>=nums[j]){
                j--;
            }
            swap(nums,i,j);
        }
        // 反转 i+1->length  倒序数组
        reverse(nums,i+1);
        System.out.println(Arrays.toString(nums));
    }



    public static void solution2(int[] nums) {
        int i = nums.length - 2;
        // 找到前一个比后移 小的位置， 从该位置处理数组， 在此位置之前都是 后一个比前一个大，是一个倒叙数组
        while (i >= 0 && nums[i] >= nums[i + 1]) {
            i--;
        }
        if (i >= 0) {
            int j = nums.length - 1;
            // 从后往前找第一个比当前数大的位置，因为是倒序数组所以 第一个是最小的
            while (j >= 0 && nums[i] >= nums[j]) {
                j--;
            }
            // 交换两位置， 交换后 i+1 -> nums.length 仍为一个倒叙数组
            swap(nums, i, j);
        }
        // i+1 -> nums.length  转换为正序，如果 i<0 说明该数组 本身就是倒叙数组，直接从0开始反转数组
        reverse(nums, i + 1);
    }

    public static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    /**
     * 〈〉  倒序链表 转换为正序
     */
    public static void reverse(int[] nums, int start) {
        int left = start, right = nums.length - 1;
        while (left < right) {
            swap(nums, left, right);
            left++;
            right--;
        }
    }
}
