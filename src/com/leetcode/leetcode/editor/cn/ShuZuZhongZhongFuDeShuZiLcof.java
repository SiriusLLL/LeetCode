//设备中存有 n 个文件，文件 id 记于数组 documents。若文件 id 相同，则定义为该文件存在副本。请返回任一存在副本的文件 id。 
//
// 
//
// 示例 1： 
//
// 
//输入：documents = [2, 5, 3, 0, 5, 0]
//输出：0 或 5
// 
//
// 
//
// 提示： 
//
// 
// 0 ≤ documents[i] ≤ n-1 
// 2 <= n <= 100000 
// 
//
// 
//
// Related Topics 数组 哈希表 排序 👍 1227 👎 0


package com.leetcode.leetcode.editor.cn;

import java.util.HashSet;
import java.util.Set;

public class ShuZuZhongZhongFuDeShuZiLcof{
    public static void main(String[] args) {
       Solution solution = new ShuZuZhongZhongFuDeShuZiLcof().new Solution();
    }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int findRepeatDocument(int[] documents) {
        Set<Integer> hmap = new HashSet<>();
        for (int doc : documents) {
            if (hmap.contains(doc)){
                return doc;
            }
            hmap.add(doc);
        }
        return -1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
}