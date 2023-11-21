//给定一个头节点为 head 的单链表用于记录一系列核心肌群训练编号，请将该系列训练编号 倒序 记录于链表并返回。 
//
// 
//
// 示例 1： 
//
// 
//输入：head = [1,2,3,4,5]
//输出：[5,4,3,2,1]
// 
//
// 
//
// 示例 2： 
//
// 
//输入：head = [1,2]
//输出：[2,1]
// 
//
// 
//
// 示例 3： 
//
// 
//输入：head = []
//输出：[]
// 
//
// 
//
// 提示： 
//
// 
// 链表中节点的数目范围是 [0, 5000] 
// -5000 <= Node.val <= 5000 
// 
//
// 
//
// 注意：本题与主站 206 题相同：https://leetcode-cn.com/problems/reverse-linked-list/ 
//
// 
//
// Related Topics 递归 链表 👍 629 👎 0


package com.leetcode.leetcode.editor.cn;

import java.util.List;
import java.util.Queue;

public class FanZhuanLianBiaoLcof{
    public static void main(String[] args) {
       Solution solution = new FanZhuanLianBiaoLcof().new Solution();
    }


public class ListNode {
  int val;
  ListNode next;
  ListNode() {}
  ListNode(int val) { this.val = val; }
  ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public ListNode trainningPlan(ListNode head) {
        ListNode node = head, prev = null;
        while (node != null) {
            ListNode tmp = node.next;
            node.next = prev;
            prev = node;
            node = tmp;
        }
        return prev;
    }
}

//leetcode submit region end(Prohibit modification and deletion)

}