//给你一个正整数数组 nums 。每一次操作中，你可以从 nums 中选择 任意 一个数并将它减小到 恰好 一半。（注意，在后续操作中你可以对减半过的数继续执
//行操作） 
//
// 请你返回将 nums 数组和 至少 减少一半的 最少 操作数。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [5,19,8,1]
//输出：3
//解释：初始 nums 的和为 5 + 19 + 8 + 1 = 33 。
//以下是将数组和减少至少一半的一种方法：
//选择数字 19 并减小为 9.5 。
//选择数字 9.5 并减小为 4.75 。
//选择数字 8 并减小为 4 。
//最终数组为 [5, 4.75, 4, 1] ，和为 5 + 4.75 + 4 + 1 = 14.75 。
//nums 的和减小了 33 - 14.75 = 18.25 ，减小的部分超过了初始数组和的一半，18.25 >= 33/2 = 16.5 。
//我们需要 3 个操作实现题目要求，所以返回 3 。
//可以证明，无法通过少于 3 个操作使数组和减少至少一半。
// 
//
// 示例 2： 
//
// 
//输入：nums = [3,8,20]
//输出：3
//解释：初始 nums 的和为 3 + 8 + 20 = 31 。
//以下是将数组和减少至少一半的一种方法：
//选择数字 20 并减小为 10 。
//选择数字 10 并减小为 5 。
//选择数字 3 并减小为 1.5 。
//最终数组为 [1.5, 8, 5] ，和为 1.5 + 8 + 5 = 14.5 。
//nums 的和减小了 31 - 14.5 = 16.5 ，减小的部分超过了初始数组和的一半， 16.5 >= 31/2 = 15.5 。
//我们需要 3 个操作实现题目要求，所以返回 3 。
//可以证明，无法通过少于 3 个操作使数组和减少至少一半。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 10⁵ 
// 1 <= nums[i] <= 10⁷ 
// 
//
// Related Topics 贪心 数组 堆（优先队列） 👍 85 👎 0


package com.leetcode.leetcode.editor.cn;

import java.util.PriorityQueue;

public class MinimumOperationsToHalveArraySum {
    public static void main(String[] args) {
        Solution solution = new MinimumOperationsToHalveArraySum().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        // 提交时把halveArray1改名为halveArray
        public static int halveArray1(int[] nums) {
            // 大根堆
            PriorityQueue<Double> heap = new PriorityQueue<>((a, b) -> b.compareTo(a));
            double sum = 0;
            for (int num : nums) {
                heap.add((double) num);
                sum += num;
            }
            // sum，整体累加和，-> 要减少的目标！
            sum /= 2;
            int ans = 0;
            // minus是总体减少的幅度
            for (double minus = 0, cur; minus < sum; ans++, minus += cur) {
                // 当前减少的幅度，也是减少后的数字大小
                cur = heap.poll() / 2;
                heap.add(cur);
            }
            return ans;
        }

        public static int MAXN = 100001;

        public static long[] heap = new long[MAXN];

        public static int size;

        // 提交时把halveArray2改名为halveArray
        public static int halveArray(int[] nums) {
            size = nums.length;
            long sum = 0;
            for (int i = size - 1; i >= 0; i--) {
                // 乘以2的20次方
                heap[i] = (long) nums[i] << 20;
                sum += heap[i];
                heapify(i);
            }
            sum /= 2;
            int ans = 0;
            for (long minus = 0; minus < sum; ans++) {
                heap[0] /= 2;
                minus += heap[0];
                heapify(0);
            }
            return ans;
        }

        public static void heapify(int i) {
            int l = i * 2 + 1;
            while (l < size) {
                int best = l + 1 < size && heap[l + 1] > heap[l] ? l + 1 : l;
                best = heap[best] > heap[i] ? best : i;
                if (best == i) {
                    break;
                }
                swap(best, i);
                i = best;
                l = i * 2 + 1;
            }
        }

        public static void swap(int i, int j) {
            long tmp = heap[i];
            heap[i] = heap[j];
            heap[j] = tmp;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)
}