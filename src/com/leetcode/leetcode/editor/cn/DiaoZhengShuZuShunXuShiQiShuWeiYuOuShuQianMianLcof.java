//教练使用整数数组 actions 记录一系列核心肌群训练项目编号。为增强训练趣味性，需要将所有奇数编号训练项目调整至偶数编号训练项目之前。请将调整后的训练项
//目编号以 数组 形式返回。 
//
// 
//
// 示例 1： 
//
// 
//输入：actions = [1,2,3,4,5]
//输出：[1,3,5,2,4] 
//解释：为正确答案之一 
//
// 
//
// 提示： 
//
// 
// 0 <= actions.length <= 50000 
// 0 <= actions[i] <= 10000 
// 
//
// 
//
// Related Topics 数组 双指针 排序 👍 326 👎 0


package com.leetcode.leetcode.editor.cn;

public class DiaoZhengShuZuShunXuShiQiShuWeiYuOuShuQianMianLcof {
    public static void main(String[] args) {
        Solution solution = new DiaoZhengShuZuShunXuShiQiShuWeiYuOuShuQianMianLcof().new Solution();
        int[] actions = {1, 2, 3, 4, 5};
        System.out.println(solution.trainingPlan(actions));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] trainingPlan(int[] actions) {
            int i = 0, j = actions.length - 1, tmp;
            while(i < j) {
                while(i < j && (actions[i] & 1) == 1) i++;
                while(i < j && (actions[j] & 1) == 0) j--;
                tmp = actions[i];
                actions[i] = actions[j];
                actions[j] = tmp;
            }
            return actions;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)
}