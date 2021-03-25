package x.godk.leetcode.difficult;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 给定两个大小为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。
 * <p>
 * 请你找出这两个正序数组的中位数，并且要求算法的时间复杂度为 O(log(m + n))。
 * <p>
 * 你可以假设 nums1 和 nums2 不会同时为空。
 * <p>
 *  正则表达式
 * <p>
 * 示例 1:
 * <p>
 * nums1 = [1, 3]
 * nums2 = [2]
 * <p>
 * 则中位数是 2.0
 * 示例 2:
 * <p>
 * nums1 = [1, 2]
 * nums2 = [3, 4]
 * <p>
 * 则中位数是 (2 + 3)/2 = 2.5
 *
 * @author wt
 * @program practice
 * @create 2020-07-10  09:56
 */
public class FindMedianSortedArrays {


    public static void main(String[] args) {
        int[] nums1 = {4, 5};
        int[] nums2 = {1, 2, 3};
        double v = solution1(nums1, nums2);
        System.out.println(v);
        //TODO  难 搞不定

    }


    static double solution1(int[] nums1, int[] nums2) {
        List<Integer> list = new ArrayList<>();
        int num1Len = nums1 != null ? nums1.length : -1;
        int num2Len = nums2 != null ? nums2.length : -1;
        int length = Math.max(num1Len, num2Len);
        for (int i = 0; i < length; i++) {
            Integer val1 = null;
            Integer val2 = null;
            if (i < num1Len) {
                val1 = nums1[i];
            }
            if (i < num2Len) {
                val2 = nums2[i];
            }
            if (val1 != null && val2 != null) {
                int tmp;
                if (val1 > val2) {
                    tmp = val1;
                    val1 = val2;
                    val2 = tmp;
                }
            }
            if (val1 != null) {
                if (list.size() > 0) {
                    Integer integer = list.get(list.size() - 1);
                    if (val1 > integer) {
                        list.add(val1);
                    } else {
                        list.add(list.size() - 1, val1);
                    }
                } else {
                    list.add(val1);
                }

            }
            if (val2 != null) {
                list.add(val2);
                if (list.size() > 0) {
                    Integer integer = list.get(list.size() - 1);
                    if (val2 > integer) {
                        list.add(val2);
                    } else {
                        list.add(list.size() - 1, val2);
                    }
                } else {
                    list.add(val2);
                }
            }
        }
        int size = list.size();
        int val = size / 2;
        Collections.sort(list);
        if (size % 2 == 0) {

            return Double.parseDouble(chufa(list.get(val) + list.get(val - 1), 2));
        } else {
            return list.get(val);
        }

    }

    //定义方法
    public static String chufa(Integer a, Integer b) {
        //“0.00000000”确定精度
        DecimalFormat dF = new DecimalFormat("0.00000000");
        return dF.format((float) a / b);
    }
}
