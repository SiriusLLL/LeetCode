//设计一个类似堆栈的数据结构，将元素推入堆栈，并从堆栈中弹出出现频率最高的元素。 
//
// 实现 FreqStack 类: 
//
// 
// 
// FreqStack() 构造一个空的堆栈。 
// 
// void push(int val) 将一个整数 val 压入栈顶。 
// 
// int pop() 删除并返回堆栈中出现频率最高的元素。 
// 
// 如果出现频率最高的元素不只一个，则移除并返回最接近栈顶的元素。 
// 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：
//["FreqStack","push","push","push","push","push","push","pop","pop","pop",
//"pop"],
//[[],[5],[7],[5],[7],[4],[5],[],[],[],[]]
//输出：[null,null,null,null,null,null,null,5,7,5,4]
//解释：
//FreqStack = new FreqStack();
//freqStack.push (5);//堆栈为 [5]
//freqStack.push (7);//堆栈是 [5,7]
//freqStack.push (5);//堆栈是 [5,7,5]
//freqStack.push (7);//堆栈是 [5,7,5,7]
//freqStack.push (4);//堆栈是 [5,7,5,7,4]
//freqStack.push (5);//堆栈是 [5,7,5,7,4,5]
//freqStack.pop ();//返回 5 ，因为 5 出现频率最高。堆栈变成 [5,7,5,7,4]。
//freqStack.pop ();//返回 7 ，因为 5 和 7 出现频率最高，但7最接近顶部。堆栈变成 [5,7,5,4]。
//freqStack.pop ();//返回 5 ，因为 5 出现频率最高。堆栈变成 [5,7,4]。
//freqStack.pop ();//返回 4 ，因为 4, 5 和 7 出现频率最高，但 4 是最接近顶部的。堆栈变成 [5,7]。 
//
// 
//
// 提示： 
//
// 
// 0 <= val <= 10⁹ 
// push 和 pop 的操作数不大于 2 * 10⁴。 
// 输入保证在调用 pop 之前堆栈中至少有一个元素。 
// 
//
// Related Topics 栈 设计 哈希表 有序集合 👍 397 👎 0


package com.leetcode.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.HashMap;

public class MaximumFrequencyStack {
    //leetcode submit region begin(Prohibit modification and deletion)
    class FreqStack {

        // 记录最大次数
        private int topTimes;

        // 层数表 <层数, 对应的动态数组>
        private HashMap<Integer, ArrayList<Integer>> cntValues = new HashMap<>();

        // 频次表 <数字, 出现的次数>
        private HashMap<Integer, Integer> valueTimes = new HashMap<>();

        // 入栈
        public void push(int val) {
            // 修改频次表
            valueTimes.put(val, valueTimes.getOrDefault(val, 0) + 1);

            // 获取当前最大次数
            int curTopTimes = valueTimes.get(val);

            // 修改层数表(层数表的key就是最大频次)
            // 如果层数表的key中没有当前的最大频次，那么就新建一层
            if (!cntValues.containsKey(curTopTimes)) {
                cntValues.put(curTopTimes, new ArrayList<>());
            }
            // 在新加入的层中添加val
            ArrayList<Integer> curTimeValue = cntValues.get(curTopTimes);
            curTimeValue.add(val);

            // 修改最大次数（如果需要的话）
            topTimes = Math.max(topTimes, curTopTimes);
        }

        // 出栈
        public int pop() {
            // 修改层数表
            // 找到层数表中的最顶层，返回最右侧的数字
            ArrayList<Integer> topTimeValues = cntValues.get(topTimes);
            int ans = topTimeValues.remove(topTimeValues.size() - 1);
            // 当最顶层为空时删除该层，同时减少最大频次
            if (topTimeValues.size() == 0) {
                cntValues.remove(topTimes--);
            }

            // 修改频次表
            // 找到返回数字的频次
            int times = valueTimes.get(ans);
            // 如果该数字只剩一次，则在频次表中删除该数字
            if (times == 1) {
                valueTimes.remove(ans);
            } else {
                // 否则频次减1
                valueTimes.put(ans, times - 1);
            }
            return ans;
        }
    }

/**
 * Your FreqStack object will be instantiated and called as such:
 * FreqStack obj = new FreqStack();
 * obj.push(val);
 * int param_2 = obj.pop();
 */
//leetcode submit region end(Prohibit modification and deletion)
}