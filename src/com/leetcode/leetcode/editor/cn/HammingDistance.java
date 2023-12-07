//两个整数之间的 汉明距离 指的是这两个数字对应二进制位不同的位置的数目。 
//
// 给你两个整数 x 和 y，计算并返回它们之间的汉明距离。 
//
// 
//
// 示例 1： 
//
// 
//输入：x = 1, y = 4
//输出：2
//解释：
//1   (0 0 0 1)
//4   (0 1 0 0)
//       ↑   ↑
//上面的箭头指出了对应二进制位不同的位置。
// 
//
// 示例 2： 
//
// 
//输入：x = 3, y = 1
//输出：1
// 
//
// 
//
// 提示： 
//
// 
// 0 <= x, y <= 2³¹ - 1 
// 
//
// Related Topics 位运算 👍 722 👎 0


package com.leetcode.leetcode.editor.cn;

public class HammingDistance {
    public static void main(String[] args) {
        Solution solution = new HammingDistance().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int hammingDistance(int x, int y) {
            return cntOne(x ^ y);
        }

        // 数n中有几个1
        // 先以2位为单位数，然后以4位为单位数...一直数到每16位里有几个1，相加即得结果
        public int cntOne(int n) {
            // 5 = 0101
            n = (n & 0x55555555) + ((n >>> 1) & 0x55555555);
            // 3 = 0011
            n = (n & 0x33333333) + ((n >>> 2) & 0x33333333);
            // f = 1111
            n = (n & 0x0f0f0f0f) + ((n >>> 4) & 0x0f0f0f0f);
            n = (n & 0x00ff00ff) + ((n >>> 8) & 0x00ff00ff);
            n = (n & 0x0000ffff) + ((n >>> 16) & 0x0000ffff);
            return n;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)
}