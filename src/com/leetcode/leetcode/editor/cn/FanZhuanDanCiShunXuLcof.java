//你在与一位习惯从右往左阅读的朋友发消息，他发出的文字顺序都与正常相反但单词内容正确，为了和他顺利交流你决定写一个转换程序，把他所发的消息 message 转
//换为正常语序。 
//
// 注意：输入字符串 message 中可能会存在前导空格、尾随空格或者单词间的多个空格。返回的结果字符串中，单词间应当仅用单个空格分隔，且不包含任何额外的空
//格。 
//
// 
//
// 示例 1： 
//
// 
//输入: message = "the sky is blue"
//输出: "blue is sky the"
// 
//
// 示例 2： 
//
// 
//输入: message = "  hello world!  "
//输出: "world! hello"
//解释: 输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括。
// 
//
// 示例 3： 
//
// 
//输入: message = "a good   example"
//输出: "example good a"
//解释: 如果两个单词间有多余的空格，将反转后单词间的空格减少到只含一个。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= message.length <= 10^4 
// message 中包含英文大小写字母、空格和数字 
// message 中至少有一个单词 
// 
// 
//
// 注意： 
//
// 
// 本题与主站 151 题相同：https://leetcode-cn.com/problems/reverse-words-in-a-string/ 
// 
//
// 
//
// Related Topics 双指针 字符串 👍 319 👎 0


package com.leetcode.leetcode.editor.cn;

import java.util.LinkedList;
import java.util.Stack;

public class FanZhuanDanCiShunXuLcof {
    public static void main(String[] args) {
        Solution solution = new FanZhuanDanCiShunXuLcof().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String reverseMessage(String message) {
//            int left = 0, right = message.length() - 1;
//            while (left <= right && message.charAt(left) == ' ') {
//                ++left;
//            }
//            while (left <= right && message.charAt(right) == ' ') {
//                --right;
//            }
//            Stack<String> stack = new Stack<>();
//            String word = "";
//            while (left <= right) {
//                char c = message.charAt(left);
//                if (!word.isEmpty() && c == ' ') {
//                    stack.push(word);
//                    word = "";
//                } else if (c != ' ') {
//                    word += c;
//                }
//                left++;
//            }
//            stack.push(word);
//            String ans = "";
//            while (!stack.isEmpty()) {
//                ans += stack.pop();
//                if (!stack.isEmpty()) {
//                    ans += ' ';
//                }
//            }
//            return ans;


            message = message.trim();                               // 删除首尾空格
            int j = message.length() - 1, i = j;
            StringBuilder res = new StringBuilder();
            while (i >= 0) {
                while (i >= 0 && message.charAt(i) != ' ') i--;     // 搜索首个空格
                res.append(message.substring(i + 1, j + 1) + " ");  // 添加单词
                while (i >= 0 && message.charAt(i) == ' ') i--;     // 跳过单词间空格
                j = i;                                              // j 指向下个单词的尾字符
            }
            return res.toString().trim();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)
}