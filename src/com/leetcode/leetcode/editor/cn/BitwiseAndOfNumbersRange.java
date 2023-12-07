//给你两个整数 left 和 right ，表示区间 [left, right] ，返回此区间内所有数字 按位与 的结果（包含 left 、right 端点）
//。 
//
// 
//
// 示例 1： 
//
// 
//输入：left = 5, right = 7
//输出：4
// 
//
// 示例 2： 
//
// 
//输入：left = 0, right = 0
//输出：0
// 
//
// 示例 3： 
//
// 
//输入：left = 1, right = 2147483647
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// 0 <= left <= right <= 2³¹ - 1 
// 
//
// Related Topics 位运算 👍 486 👎 0


package com.leetcode.leetcode.editor.cn;

public class BitwiseAndOfNumbersRange {
    public static void main(String[] args) {
        Solution solution = new BitwiseAndOfNumbersRange().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int rangeBitwiseAnd(int left, int right) {
            while (left < right) {
                right = right - (right & -right);
            }
            return right;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)
}