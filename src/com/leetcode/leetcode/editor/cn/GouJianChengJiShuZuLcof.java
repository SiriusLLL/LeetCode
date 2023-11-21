//为了深入了解这些生物群体的生态特征，你们进行了大量的实地观察和数据采集。数组 arrayA 记录了各个生物群体数量数据，其中 arrayA[i] 表示第 
//i 个生物群体的数量。请返回一个数组 arrayB，该数组为基于数组 arrayA 中的数据计算得出的结果，其中 arrayB[i] 表示将第 i 个生物群体的数
//量从总体中排除后的其他数量的乘积。 
//
// 
//
// 示例 1： 
//
// 
//输入：arrayA = [2, 4, 6, 8, 10]
//输出：[1920, 960, 640, 480, 384]
// 
//
// 
//
// 提示： 
//
// 
// 所有元素乘积之和不会溢出 32 位整数 
// arrayA.length <= 100000 
// 
//
// 
//
// Related Topics 数组 前缀和 👍 348 👎 0


package com.leetcode.leetcode.editor.cn;

public class GouJianChengJiShuZuLcof{
    public static void main(String[] args) {
       Solution solution = new GouJianChengJiShuZuLcof().new Solution();
       int[] arrayA = {1, 2, 0, 4, 5};
        System.out.println(solution.statisticalResult(arrayA));
    }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] statisticalResult(int[] arrayA) {
        if(arrayA.length == 0) return new int[0];
        int after = 1,n = arrayA.length;
        int[] before = new int[n];
        before[0] = 1;
        // 下标i前面的乘积：
        for(int i=1;i<n;i++){
            before[i] = before[i-1] * arrayA[i-1];
        }
        // 下标i后面的乘积:
        for(int i=n-2;i>-1;i--){
            after = after * arrayA[i+1]; //滚动数组
            // 每个before[i] 和 after[i]的乘积就是除了下标i所有元素的积
            before[i] *= after;
        }
        return before;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
}