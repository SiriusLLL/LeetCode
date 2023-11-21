//待传输文件被切分成多个部分，按照原排列顺序，每部分文件编号均为一个 正整数（至少含有两个文件）。传输要求为：连续文件编号总和为接收方指定数字 target 
//的所有文件。请返回所有符合该要求的文件传输组合列表。 
//
// 注意，返回时需遵循以下规则： 
//
// 
// 每种组合按照文件编号 升序 排列； 
// 不同组合按照第一个文件编号 升序 排列。 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：target = 12
//输出：[[3, 4, 5]]
//解释：在上述示例中，存在一个连续正整数序列的和为 12，为 [3, 4, 5]。
// 
//
// 示例 2： 
//
// 
//输入：target = 18
//输出：[[3,4,5,6],[5,6,7]]
//解释：在上述示例中，存在两个连续正整数序列的和分别为 18，分别为 [3, 4, 5, 6] 和 [5, 6, 7]。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= target <= 10^5 
// 
//
// 
//
// Related Topics 数学 双指针 枚举 👍 568 👎 0


package com.leetcode.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class HeWeiSdeLianXuZhengShuXuLieLcof{
    public static void main(String[] args) {
       Solution solution = new HeWeiSdeLianXuZhengShuXuLieLcof().new Solution();
    }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[][] fileCombination(int target) {
        int i = 1;
        double j = 2.0;
        List<int[]> res = new ArrayList<>();
        while(i < j) {
            j = (-1 + Math.sqrt(1 + 4 * (2 * target + (long) i * i - i))) / 2;
            if(i < j && j == (int)j) {
                int[] ans = new int[(int)j - i + 1];
                for(int k = i; k <= (int)j; k++)
                    ans[k - i] = k;
                res.add(ans);
            }
            i++;
        }
        return res.toArray(new int[0][]);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
}