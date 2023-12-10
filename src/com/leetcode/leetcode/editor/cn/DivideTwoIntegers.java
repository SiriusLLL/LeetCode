//给你两个整数，被除数 dividend 和除数 divisor。将两数相除，要求 不使用 乘法、除法和取余运算。 
//
// 整数除法应该向零截断，也就是截去（truncate）其小数部分。例如，8.345 将被截断为 8 ，-2.7335 将被截断至 -2 。 
//
// 返回被除数 dividend 除以除数 divisor 得到的 商 。 
//
// 注意：假设我们的环境只能存储 32 位 有符号整数，其数值范围是 [−2³¹, 231 − 1] 。本题中，如果商 严格大于 231 − 1 ，则返回 2
//31 − 1 ；如果商 严格小于 -2³¹ ，则返回 -2³¹ 。 
//
// 
//
// 示例 1: 
//
// 
//输入: dividend = 10, divisor = 3
//输出: 3
//解释: 10/3 = 3.33333.. ，向零截断后得到 3 。 
//
// 示例 2: 
//
// 
//输入: dividend = 7, divisor = -3
//输出: -2
//解释: 7/-3 = -2.33333.. ，向零截断后得到 -2 。 
//
// 
//
// 提示： 
//
// 
// -2³¹ <= dividend, divisor <= 2³¹ - 1 
// divisor != 0 
// 
//
// Related Topics 位运算 数学 👍 1205 👎 0


package com.leetcode.leetcode.editor.cn;

public class DivideTwoIntegers{
    public static void main(String[] args) {
       Solution solution = new DivideTwoIntegers().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
        public static int MIN = Integer.MIN_VALUE;

        public static int divide(int a, int b) {
            if (a == MIN && b == MIN) {
                // a和b都是整数最小
                return 1;
            }
            if (a != MIN && b != MIN) {
                // a和b都不是整数最小，那么正常去除
                return div(a, b);
            }
            if (b == MIN) {
                // a不是整数最小，b是整数最小
                return 0;
            }
            // a是整数最小，b是-1，返回整数最大，因为题目里明确这么说了
            if (b == neg(1)) {
                return Integer.MAX_VALUE;
            }
            // a是整数最小，b不是整数最小，b也不是-1
            a = add(a, b > 0 ? b : neg(b));
            int ans = div(a, b);
            int offset = b > 0 ? neg(1) : 1;
            return add(ans, offset);
        }

        // 必须保证a和b都不是整数最小值，返回a除以b的结果
        public static int div(int a, int b) {
            int x = a < 0 ? neg(a) : a;
            int y = b < 0 ? neg(b) : b;
            int ans = 0;
            for (int i = 30; i >= 0; i = minus(i, 1)) {
                if ((x >> i) >= y) {
                    ans |= (1 << i);
                    x = minus(x, y << i);
                }
            }
            return a < 0 ^ b < 0 ? neg(ans) : ans;
        }

        public static int add(int a, int b) {
            int ans = a;
            while (b != 0) {
                // ans : a和b无进位相加的结果
                ans = a ^ b;
                // b : a和b相加时的进位信息
                b = (a & b) << 1;
                a = ans;
            }
            return ans;
        }

        public static int minus(int a, int b) {
            return add(a, neg(b));
        }

        public static int neg(int n) {
            return add(~n, 1);
        }

        public static int multiply(int a, int b) {
            int ans = 0;
            while (b != 0) {
                if ((b & 1) != 0) {
                    // 考察b当前最右的状态！
                    ans = add(ans, a);
                }
                a <<= 1;
                b >>>= 1;
            }
            return ans;
        }
}
//leetcode submit region end(Prohibit modification and deletion)
}