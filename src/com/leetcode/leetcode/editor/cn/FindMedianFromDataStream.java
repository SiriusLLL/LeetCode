//中位数是有序整数列表中的中间值。如果列表的大小是偶数，则没有中间值，中位数是两个中间值的平均值。 
//
// 
// 例如 arr = [2,3,4] 的中位数是 3 。 
// 例如 arr = [2,3] 的中位数是 (2 + 3) / 2 = 2.5 。 
// 
//
// 实现 MedianFinder 类: 
//
// 
// MedianFinder() 初始化 MedianFinder 对象。 
// void addNum(int num) 将数据流中的整数 num 添加到数据结构中。 
// double findMedian() 返回到目前为止所有元素的中位数。与实际答案相差 10⁻⁵ 以内的答案将被接受。 
// 
//
// 示例 1： 
//
// 
//输入
//["MedianFinder", "addNum", "addNum", "findMedian", "addNum", "findMedian"]
//[[], [1], [2], [], [3], []]
//输出
//[null, null, null, 1.5, null, 2.0]
//
//解释
//MedianFinder medianFinder = new MedianFinder();
//medianFinder.addNum(1);    // arr = [1]
//medianFinder.addNum(2);    // arr = [1, 2]
//medianFinder.findMedian(); // 返回 1.5 ((1 + 2) / 2)
//medianFinder.addNum(3);    // arr[1, 2, 3]
//medianFinder.findMedian(); // return 2.0 
//
// 提示: 
//
// 
// -10⁵ <= num <= 10⁵ 
// 在调用 findMedian 之前，数据结构中至少有一个元素 
// 最多 5 * 10⁴ 次调用 addNum 和 findMedian 
// 
//
// Related Topics 设计 双指针 数据流 排序 堆（优先队列） 👍 934 👎 0


package com.leetcode.leetcode.editor.cn;

import java.util.PriorityQueue;

public class FindMedianFromDataStream {
    //leetcode submit region begin(Prohibit modification and deletion)
    class MedianFinder {
        private PriorityQueue<Integer> maxHeap;
        private PriorityQueue<Integer> minHeap;

        // 通过比较器构建大根堆和小根堆
        public MedianFinder() {
            maxHeap = new PriorityQueue<>((a, b) -> b - a);
            minHeap = new PriorityQueue<>((a, b) -> a - b);
        }

        // 添加数字
        public void addNum(int num) {
            // 如果大根堆为空，或者大根堆顶大于该数字，则加入大根堆
            if (maxHeap.isEmpty() || maxHeap.peek() >= num) {
                maxHeap.add(num);
            } else { // 否则加入小根堆
                minHeap.add(num);
            }

            // 当两个堆中的元素个数之差等于两个时，平衡两个堆
            balance();
        }

        // 寻找中位数
        public double findMedian() {
            // 如果大根堆和小根堆元素数量相同
            // 则返回两个堆顶的平均数
            if (maxHeap.size() == minHeap.size()) {
                return ((double) (maxHeap.peek() + minHeap.peek()) / 2);
            } else {
                // 否则返回元素数量较多的堆的堆顶
                return maxHeap.size() > minHeap.size() ? maxHeap.peek() : minHeap.peek();
            }
        }

        // 用于平衡两个堆
        private void balance() {
            if (Math.abs(maxHeap.size() - minHeap.size()) == 2) {
                // 如果大根堆元素更多，则将大根堆的堆顶放入小根堆
                if (maxHeap.size() > minHeap.size()) {
                    minHeap.add(maxHeap.poll());
                } else {// 否则将小根堆的堆顶放入大根堆
                    maxHeap.add(minHeap.poll());
                }
            }
        }
    }

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */
//leetcode submit region end(Prohibit modification and deletion)
}