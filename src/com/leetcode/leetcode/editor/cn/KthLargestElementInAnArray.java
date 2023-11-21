//给定整数数组 nums 和整数 k，请返回数组中第 k 个最大的元素。 
//
// 请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。 
//
// 你必须设计并实现时间复杂度为 O(n) 的算法解决此问题。 
//
// 
//
// 示例 1: 
//
// 
//输入: [3,2,1,5,6,4], k = 2
//输出: 5
// 
//
// 示例 2: 
//
// 
//输入: [3,2,3,1,2,4,5,5,6], k = 4
//输出: 4 
//
// 
//
// 提示： 
//
// 
// 1 <= k <= nums.length <= 10⁵ 
// -10⁴ <= nums[i] <= 10⁴ 
// 
//
// Related Topics 数组 分治 快速选择 排序 堆（优先队列） 👍 2346 👎 0


package com.leetcode.leetcode.editor.cn;

public class KthLargestElementInAnArray{
    public static void main(String[] args) {
       Solution solution = new KthLargestElementInAnArray().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
        // 随机选择算法，时间复杂度O(n)
        public static int findKthLargest(int[] nums, int k) {
            return randomizedSelect(nums, nums.length - k);
        }

        // 如果arr排序的话，在i位置的数字是什么
        public static int randomizedSelect(int[] arr, int i) {
            int ans = 0;
            // 0 ~ n-1开始
            // l    r
            for (int l = 0, r = arr.length - 1; l <= r;) {
                // 随机这一下，常数时间比较大
                // 但只有这一下随机，才能在概率上把时间复杂度收敛到O(n)
                partition(arr, l, r, arr[l + (int) (Math.random() * (r - l + 1))]);
                // 因为左右两侧只需要走一侧
                // 所以不需要临时变量记录全局的first、last
                // 直接用即可
                if (i < first) {
                    r = first - 1;
                } else if (i > last) {
                    l = last + 1;
                } else {
                    ans = arr[i];
                    break;
                }
            }
            return ans;
        }

        // 荷兰国旗问题
        public static int first, last;

        public static void partition(int[] arr, int l, int r, int x) {
            first = l;
            last = r;
            int i = l;
            while (i <= last) {
                if (arr[i] == x) {
                    i++;
                } else if (arr[i] < x) {
                    swap(arr, first++, i++);
                } else {
                    swap(arr, i, last--);
                }
            }
        }

        public static void swap(int[] arr, int i, int j) {
            int tmp = arr[i];
            arr[i] = arr[j];
            arr[j] = tmp;
        }
}
//leetcode submit region end(Prohibit modification and deletion)
}