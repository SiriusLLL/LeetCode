//给定一个数组 nums ，如果 i < j 且 nums[i] > 2*nums[j] 我们就将 (i, j) 称作一个重要翻转对。 
//
// 你需要返回给定数组中的重要翻转对的数量。 
//
// 示例 1: 
//
// 
//输入: [1,3,2,3,1]
//输出: 2
// 
//
// 示例 2: 
//
// 
//输入: [2,4,3,5,1]
//输出: 3
// 
//
// 注意: 
//
// 
// 给定数组的长度不会超过50000。 
// 输入数组中的所有数字都在32位整数的表示范围内。 
// 
//
// Related Topics 树状数组 线段树 数组 二分查找 分治 有序集合 归并排序 👍 430 👎 0


package com.leetcode.leetcode.editor.cn;

public class ReversePairs {
    public static void main(String[] args) {
        Solution solution = new ReversePairs().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public static int MAXN = 50001;

        public static int[] help = new int[MAXN];

        public static int reversePairs(int[] arr) {
            return counts(arr, 0, arr.length - 1);
        }

        // 统计l...r范围上，翻转对的数量，同时l...r范围统计完后变有序
        // 时间复杂度O(n * logn)
        public static int counts(int[] arr, int l, int r) {
            if (l == r) {
                return 0;
            }
            int m = (l + r) / 2;
            return counts(arr, l, m) + counts(arr, m + 1, r) + merge(arr, l, m, r);
        }

        public static int merge(int[] arr, int l, int m, int r) {
            // 统计部分
            int ans = 0;
            for (int i = l, j = m + 1; i <= m; i++) {
                while (j <= r && (long) arr[i] > (long) arr[j] * 2) {
                    j++;
                }
                ans += j - m - 1;
            }
            // 正常merge
            int i = l;
            int a = l;
            int b = m + 1;
            while (a <= m && b <= r) {
                help[i++] = arr[a] <= arr[b] ? arr[a++] : arr[b++];
            }
            while (a <= m) {
                help[i++] = arr[a++];
            }
            while (b <= r) {
                help[i++] = arr[b++];
            }
            for (i = l; i <= r; i++) {
                arr[i] = help[i];
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)
}