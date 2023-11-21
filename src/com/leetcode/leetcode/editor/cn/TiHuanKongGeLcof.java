//假定一段路径记作字符串 path，其中以 "." 作为分隔符。现需将路径加密，加密方法为将 path 中的分隔符替换为空格 " "，请返回加密后的字符串。 
//
//
// 
//
// 示例 1： 
//
// 
//输入：path = "a.aef.qerf.bb"
//
//输出："a aef qerf bb"
//
// 
//
// 
//
// 限制： 
//
// 0 <= path.length <= 10000 
//
// Related Topics 字符串 👍 568 👎 0


package com.leetcode.leetcode.editor.cn;

public class TiHuanKongGeLcof{
    public static void main(String[] args) {
       Solution solution = new TiHuanKongGeLcof().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String pathEncryption(String path) {
        StringBuilder res = new StringBuilder();
        for (Character c: path.toCharArray()){
            if(c == '.') {
                res.append(" ");
            } else {
                res.append(c);
            }
        }
        return res.toString();
    }
}
//leetcode submit region end(Prohibit modification and deletion)
}