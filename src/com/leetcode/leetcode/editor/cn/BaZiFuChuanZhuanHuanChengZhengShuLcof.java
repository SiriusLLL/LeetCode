//请你来实现一个 myAtoi(string s) 函数，使其能将字符串转换成一个 32 位有符号整数（类似 C/C++ 中的 atoi 函数）。 
//
// 函数 myAtoi(string s) 的算法如下： 
//
// 
// 读入字符串并丢弃无用的前导空格 
// 检查下一个字符（假设还未到字符末尾）为正还是负号，读取该字符（如果有）。 确定最终结果是负数还是正数。 如果两者都不存在，则假定结果为正。 
// 读入下一个字符，直到到达下一个非数字字符或到达输入的结尾。字符串的其余部分将被忽略。 
// 将前面步骤读入的这些数字转换为整数（即，"123" -> 123， "0032" -> 32）。如果没有读入数字，则整数为 0 。必要时更改符号（从步骤 
//2 开始）。 
// 如果整数数超过 32 位有符号整数范围 [−2³¹, 231 − 1] ，需要截断这个整数，使其保持在这个范围内。具体来说，小于 −2³¹ 的整数应该被固
//定为 −2³¹ ，大于 231 − 1 的整数应该被固定为 231 − 1 。 
// 返回整数作为最终结果。 
// 
//
// 注意： 
//
// 
// 本题中的空白字符只包括空格字符 ' ' 。 
// 除前导空格或数字后的其余字符串外，请勿忽略 任何其他字符。 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "42"
//输出：42
//解释：加粗的字符串为已经读入的字符，插入符号是当前读取的字符。
//第 1 步："42"（当前没有读入字符，因为没有前导空格）
//         ^
//第 2 步："42"（当前没有读入字符，因为这里不存在 '-' 或者 '+'）
//         ^
//第 3 步："42"（读入 "42"）
//           ^
//解析得到整数 42 。
//由于 "42" 在范围 [-2³¹, 2³¹ - 1] 内，最终结果为 42 。 
//
// 示例 2： 
//
// 
//输入：s = "   -42"
//输出：-42
//解释：
//第 1 步："   -42"（读入前导空格，但忽视掉）
//            ^
//第 2 步："   -42"（读入 '-' 字符，所以结果应该是负数）
//             ^
//第 3 步："   -42"（读入 "42"）
//               ^
//解析得到整数 -42 。
//由于 "-42" 在范围 [-2³¹, 2³¹ - 1] 内，最终结果为 -42 。
// 
//
// 示例 3： 
//
// 
//输入：s = "4193 with words"
//输出：4193
//解释：
//第 1 步："4193 with words"（当前没有读入字符，因为没有前导空格）
//         ^
//第 2 步："4193 with words"（当前没有读入字符，因为这里不存在 '-' 或者 '+'）
//         ^
//第 3 步："4193 with words"（读入 "4193"；由于下一个字符不是一个数字，所以读入停止）
//             ^
//解析得到整数 4193 。
//由于 "4193" 在范围 [-2³¹, 2³¹ - 1] 内，最终结果为 4193 。
// 
//
// 
//
// 提示： 
//
// 
// 0 <= s.length <= 200 
// s 由英文字母（大写和小写）、数字（0-9）、' '、'+'、'-' 和 '.' 组成 
// 
//
// 
//
// 注意：本题与主站 8 题相同：https://leetcode-cn.com/problems/string-to-integer-atoi/ 
//
// 
//
// Related Topics 字符串 👍 270 👎 0


package com.leetcode.leetcode.editor.cn;

public class BaZiFuChuanZhuanHuanChengZhengShuLcof {
    public static void main(String[] args) {
        Solution solution = new BaZiFuChuanZhuanHuanChengZhengShuLcof().new Solution();
        String str = "  2345fdsdf";
        System.out.println(solution.myAtoi(str));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int myAtoi(String str) {
            char[] c = str.trim().toCharArray();
            if (c.length == 0) {
                return 0;
            }

            // Integer.MAX_VALUE = 2147483647, 除以10是为了判断拼接上下一个数字之后是否越界
            int res = 0, bndry = Integer.MAX_VALUE / 10;
            int i = 1, sign = 1;
            if (c[0] == '-') {
                sign = -1;
            } else if (c[0] != '+') {
                i = 0;
            }
            for (int j = i; j < c.length; j++) {
                if (c[j] < '0' || c[j] > '9') {
                    break;
                }

                // 2147483647最后一位是7，res大于214748364则拼接下一个数必越界，或者res等于214748364时拼接大于7的数则越界
                if (res > bndry || res == bndry && c[j] > '7') {
                    // 如果溢出则返回最大或者最小整数值
                    return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
                }
                res = res * 10 + (c[j] - '0');
            }
            return sign * res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)
}