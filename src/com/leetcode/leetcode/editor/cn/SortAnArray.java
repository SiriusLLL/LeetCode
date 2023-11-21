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

////归并排序
//class Solution {
//    public int[] sortArray(int[] nums) {
//        if (nums.length > 1) {
//            mergeSort(nums);
//        }
//        return nums;
//    }
//
//    public static int MAXN = 50001;
//    public static int[] help = new int[MAXN];
//
//    // 方案一：递归
////    public static void mergeSort(int[] arr) {
////        sort(arr, 0, arr.length - 1);
////    }
////
////    public static void sort(int[] arr, int l, int r) {
////        // 数组里只有一个数字时直接返回
////        if (l == r) {
////            return;
////        }
////
////        // 取中点
////        int m = (l + r) / 2;
////        // 通过递归，二分拆解数组的每一个半区
////        sort(arr, l, m);
////        sort(arr, m + 1, r);
////        // 合并拆解的数组
////        merge(arr, l, m, r);
////    }
//
//    // 方案二：非递归
//    public static void mergeSort(int[] arr) {
//        int n = arr.length;
//        // stride <<= 1 步长翻倍
//        for (int l, m, r, stride = 1; stride < n; stride <<= 1) {
//            l = 0;
//            while (l < n) {
//                // 中点位置
//                m = l + stride - 1;
//                // 当右侧没有数字时break
//                if (m + 1 >= n) {
//                    break;
//                }
//
//                // 右侧有数字
//                // 求右侧的右边界
//                // 此时右侧的数字不一定够取，可能步长为4时，右侧只有不到4个数
//                // 所以右边界可能的取值数量为 l+两倍步长-1（还没取到最后一个）或者n-1（取到最后一个了）
//                // 此时右边界取它俩当中较小的那个即可
//                r = Math.min(l + (stride << 1) - 1, n - 1);
//                // 合并
//                merge(arr, l, m, r);
//                l = r + 1;
//            }
//        }
//    }
//
//    public static void merge(int[] arr, int l, int m, int r) {
//        // 临时数组元素的下标
//        int i = l;
//        // 左半区第一个未排序的元素
//        int a = l;
//        // 右半区第一个未排序的元素
//        int b = m + 1;
//
//        // 合并
//        // 左半区和右半区都有数字的情况，即左右半区的数字都没耗尽
//        while (a <= m && b <= r) {
//            // 左半区第一个元素更小，那么help[i++] = arr[a++]，先赋值再++，比较下一对
//            // 右半区第一个元素更小，那么help[i++] = arr[b++]，先赋值再++，比较下一对
//            help[i++] = arr[a] <= arr[b] ? arr[a++] : arr[b++];
//        }
//
//        // 左右半区最后必会有且只一个剩余了数字
//        // 即a或b必有一个越界而另一个不越界，把不越界的那个数加到数组最后一位
//        while (a <= m) {
//            help[i++] = arr[a++];
//        }
//        while (b <= r) {
//            help[i++] = arr[b++];
//        }
//
//        // 最后把辅助数组中的元素按顺序拷贝到原数组即可
//        for (i = l; i <= r; i++) {
//            arr[i] = help[i];
//        }
//    }
//}

//// 随机快排
//class Solution {
//    public static int first, last;
//
//    public int[] sortArray(int[] nums) {
//        if (nums.length > 1) {
//            quickSort(nums, 0, nums.length - 1);
//        }
//        return nums;
//    }
//
//    public static void quickSort(int[] arr, int l, int r) {
//        if (l >= r) {
//            return;
//        }
//
//        int x = arr[l + (int) (Math.random() * (r - l + 1))];
//        partition(arr, l, r, x);
//
//        // 为了防止底层的递归过程覆盖全局变量
//        // 这里用临时变量记录first、last
//        int left = first;
//        int right = last;
//        quickSort(arr, l, left - 1);
//        quickSort(arr, right + 1, r);
//    }
//
//    // 已知arr[l....r]范围上一定有x这个值
//    // 划分数组 <x放左边，==x放中间，>x放右边
//    // 把全局变量first, last，更新成==x区域的左右边界
//    public static void partition(int[] arr, int l, int r, int x) {
//        first = l;
//        last = r;
//        int i = l;
//        while (i <= last) {
//            if (arr[i] == x) {
//                i++;
//            } else if (arr[i] < x) {
//                swap(arr, first++, i++);
//            } else {
//                swap(arr, i, last--);
//            }
//        }
//    }
//
//    public static void swap(int[] arr, int i, int j) {
//        int tmp = arr[i];
//        arr[i] = arr[j];
//        arr[j] = tmp;
//    }
//}

//// 堆排序
class Solution {
    public static int[] sortArray(int[] nums) {
        if (nums.length > 1) {
            // heapSort1为从顶到底建堆然后排序
            // heapSort2为从底到顶建堆然后排序
            // 用哪个都可以
            // heapSort1(nums);
            heapSort2(nums);
        }
        return nums;
    }

    // i位置的数，向上调整大根堆
    // arr[i] = x，x是新来的！往上看，直到不比父亲大，或者来到0位置(顶)
    public static void heapInsert(int[] arr, int i) {
        // 新来的数与父亲位置的数作比较，直到不比父亲位置的数字大
        while (arr[i] > arr[(i - 1) / 2]) {
            // 如果大于父亲位置的数，则交换
            swap(arr, i, (i - 1) / 2);
            // 自己来到父亲位置，重复这个过程
            i = (i - 1) / 2;
        }
    }

    // i位置的数，变小了，又想维持大根堆结构
    // 向下调整大根堆
    // 当前堆的大小为size
    public static void heapify(int[] arr, int i, int size) {
        int l = i * 2 + 1;
        while (l < size) {
            // 有左孩子，l
            // 右孩子，l+1
            // 评选，最强的孩子，是哪个下标的孩子
            int best = l + 1 < size && arr[l + 1] > arr[l] ? l + 1 : l;
            // 上面已经评选了最强的孩子，接下来，当前的数和最强的孩子之间，最强下标是谁
            best = arr[best] > arr[i] ? best : i;
            if (best == i) {
                break;
            }
            swap(arr, best, i);
            i = best;
            l = i * 2 + 1;
        }
    }

    public static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    // 从顶到底建立大根堆，O(n * logn)
    // 依次弹出堆内最大值并排好序，O(n * logn)
    // 整体时间复杂度O(n * logn)
    public static void heapSort1(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            heapInsert(arr, i);
        }
        int size = n;
        while (size > 1) {
            swap(arr, 0, --size);
            heapify(arr, 0, size);
        }
    }

    // 从底到顶建立大根堆，O(n)
    // 依次弹出堆内最大值并排好序，O(n * logn)
    // 整体时间复杂度O(n * logn)
    public static void heapSort2(int[] arr) {
        int n = arr.length;
        for (int i = n - 1; i >= 0; i--) {
            heapify(arr, i, n);
        }
        int size = n;
        while (size > 1) {
            swap(arr, 0, --size);
            heapify(arr, 0, size);
        }
    }

}
//leetcode submit region end(Prohibit modification and deletion)
