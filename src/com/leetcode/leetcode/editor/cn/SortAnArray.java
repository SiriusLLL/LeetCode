//给你一个整数数组 nums，请你将该数组升序排列。 
//
// 
//
// 
// 
//
// 示例 1： 
//
// 
//输入：nums = [5,2,3,1]
//输出：[1,2,3,5]
// 
//
// 示例 2： 
//
// 
//输入：nums = [5,1,1,2,0,0]
//输出：[0,0,1,1,2,5]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 5 * 10⁴ 
// -5 * 10⁴ <= nums[i] <= 5 * 10⁴ 
// 
//
// Related Topics 数组 分治 桶排序 计数排序 基数排序 排序 堆（优先队列） 归并排序 👍 934 👎 0


package com.leetcode.leetcode.editor.cn;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] sortArray(int[] nums) {
        if (nums.length > 1) {
            mergeSort(nums);
        }
        return nums;
    }

    public static int MAXN = 50001;
    public static int[] help = new int[MAXN];

    // 方案一：递归
//    public static void mergeSort(int[] arr) {
//        sort(arr, 0, arr.length - 1);
//    }
//
//    public static void sort(int[] arr, int l, int r) {
//        // 数组里只有一个数字时直接返回
//        if (l == r) {
//            return;
//        }
//
//        // 取中点
//        int m = (l + r) / 2;
//        // 通过递归，二分拆解数组的每一个半区
//        sort(arr, l, m);
//        sort(arr, m + 1, r);
//        // 合并拆解的数组
//        merge(arr, l, m, r);
//    }

    // 方案二：非递归
    public static void mergeSort(int[] arr) {
        int n = arr.length;
        // stride <<= 1 步长翻倍
        for (int l, m, r, stride = 1; stride < n; stride <<= 1) {
            l = 0;
            while (l < n) {
                // 中点位置
                m = l + stride - 1;
                // 当右侧没有数字时break
                if (m + 1 >= n) {
                    break;
                }

                // 右侧有数字
                // 求右侧的右边界
                // 此时右侧的数字不一定够取，可能步长为4时，右侧只有不到4个数
                // 所以右边界可能的取值数量为 l+两倍步长-1（还没取到最后一个）或者n-1（取到最后一个了）
                // 此时右边界取它俩当中较小的那个即可
                r = Math.min(l + (stride << 1) - 1, n - 1);
                // 合并
                merge(arr, l, m, r);
                l = r + 1;
            }
        }
    }

    public static void merge(int[] arr, int l, int m, int r) {
        // 临时数组元素的下标
        int i = l;
        // 左半区第一个未排序的元素
        int a = l;
        // 右半区第一个未排序的元素
        int b = m + 1;

        // 合并
        // 左半区和右半区都有数字的情况，即左右半区的数字都没耗尽
        while (a <= m && b <= r) {
            // 左半区第一个元素更小，那么help[i++] = arr[a++]，先赋值再++，比较下一对
            // 右半区第一个元素更小，那么help[i++] = arr[b++]，先赋值再++，比较下一对
            help[i++] = arr[a] <= arr[b] ? arr[a++] : arr[b++];
        }

        // 左右半区最后必会有且只一个剩余了数字
        // 即a或b必有一个越界而另一个不越界，把不越界的那个数加到数组最后一位
        while (a <= m) {
            help[i++] = arr[a++];
        }
        while (b <= r) {
            help[i++] = arr[b++];
        }

        // 最后把辅助数组中的元素按顺序拷贝到原数组即可
        for (i = l; i <= r; i++) {
            arr[i] = help[i];
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
