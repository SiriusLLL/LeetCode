//给你一个整数数组 nums ，除某个元素仅出现 一次 外，其余每个元素都恰出现 三次 。请你找出并返回那个只出现了一次的元素。 
//
// 你必须设计并实现线性时间复杂度的算法且使用常数级空间来解决此问题。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [2,2,3,2]
//输出：3
// 
//
// 示例 2： 
//
// 
//输入：nums = [0,1,0,1,0,1,99]
//输出：99
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 3 * 10⁴ 
// -2³¹ <= nums[i] <= 2³¹ - 1 
// nums 中，除某个元素仅出现 一次 外，其余每个元素都恰出现 三次 
// 
//
// Related Topics 位运算 数组 👍 1167 👎 0


package com.leetcode.leetcode.editor.cn;

public class SingleNumberIi {
    public static void main(String[] args) {
        Solution solution = new SingleNumberIi().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int singleNumber(int[] nums) {
            return find(nums, 3);
        }

        public int find(int[] arr, int m) {
            int[] cnts = new int[32];
            for (int num : arr) {
                for (int i = 0; i < 32; i++) {

                    // 统计每个数字每一位上1的数量
                    cnts[i] += (num >> i) & 1;
                }
            }

            int ans = 0;
            for (int i = 0; i < 32; i++) {

                // 以 m = 3 为例
                // 如果第 i 位上的 1 的个数无法被 3 整除
                // 就说明我们要找的那个数在第 i 位上为 1
                if (cnts[i] % m != 0) {

                    // 因此，将ans的第 i 位设置为 1（1 向左移动 i 位）
                    ans = ans | (1 << i);
                }
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)
}