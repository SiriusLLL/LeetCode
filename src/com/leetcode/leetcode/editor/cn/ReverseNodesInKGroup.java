//给你链表的头节点 head ，每 k 个节点一组进行翻转，请你返回修改后的链表。 
//
// k 是一个正整数，它的值小于或等于链表的长度。如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。 
//
// 你不能只是单纯的改变节点内部的值，而是需要实际进行节点交换。 
//
// 
//
// 示例 1： 
// 
// 
//输入：head = [1,2,3,4,5], k = 2
//输出：[2,1,4,3,5]
// 
//
// 示例 2： 
//
// 
//
// 
//输入：head = [1,2,3,4,5], k = 3
//输出：[3,2,1,4,5]
// 
//
// 
//提示：
//
// 
// 链表中的节点数目为 n 
// 1 <= k <= n <= 5000 
// 0 <= Node.val <= 1000 
// 
//
// 
//
// 进阶：你可以设计一个只用 O(1) 额外内存空间的算法解决此问题吗？ 
//
// 
// 
//
// Related Topics 递归 链表 👍 2261 👎 0


package com.leetcode.leetcode.editor.cn;

public class ReverseNodesInKGroup {
    public static void main(String[] args) {
        Solution solution = new ReverseNodesInKGroup().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode() {}
     * ListNode(int val) { this.val = val; }
     * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */

    // 不要提交这个类
    public static class ListNode {
        public int val;
        public ListNode next;
    }

    class Solution {
        public ListNode reverseKGroup(ListNode head, int k) {

            // 处理第一组，记录起始和结束节点 ，并且返回第一组的头节点
            ListNode start = head;
            ListNode end = groupEnd(start, k);

            // 判空，null说明不够k个
            if (end == null) {
                return head;
            }
            head = end; // 最后就是要返回这个head
            reverse(start, end);

            // 反转之后，start变成了上一组的尾节点
            ListNode lastGroupEnd = start;
            while (lastGroupEnd.next != null) {

                // 让上一组尾部的下一个节点成为新一组的头部
                start = lastGroupEnd.next;

                // 找到新一组的尾部，继续反转
                end = groupEnd(start, k);
                // 判空，null说明不够k个
                if (end == null) {
                    return head;
                }
                reverse(start, end);
                lastGroupEnd.next = end;
                lastGroupEnd = start;
            }
            return head;
        }

        // 找到每组中的最后一个节点。
        // 返回的group，它的next指向第k+1个节点
        public ListNode groupEnd(ListNode group, int k) {
            while (--k != 0 && group != null) {
                group = group.next;
            }
            return group;
        }

        // 反转每一组链表，并且将新的尾部指向下一组的头部
        public void reverse(ListNode group, ListNode newGroup) {
            newGroup = newGroup.next;
            ListNode pre = null, cur = group, next = null;
            while (cur != newGroup) {
                next = cur.next;
                cur.next = pre;
                pre = cur;
                cur = next;
            }
            group.next = newGroup;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)
}