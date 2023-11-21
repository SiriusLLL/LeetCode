//给定单向链表的头指针和一个要删除的节点的值，定义一个函数删除该节点。 
//
// 返回删除后的链表的头节点。 
//
// 示例 1: 
//
// 
//输入: head = [4,5,1,9], val = 5
//输出: [4,1,9]
//解释: 给定你链表中值为 5 的第二个节点，那么在调用了你的函数之后，该链表应变为 4 -> 1 -> 9.
// 
//
// 示例 2: 
//
// 
//输入: head = [4,5,1,9], val = 1
//输出: [4,5,9]
//解释: 给定你链表中值为 1 的第三个节点，那么在调用了你的函数之后，该链表应变为 4 -> 5 -> 9.
// 
//
// 
//
// 说明： 
//
// 
// 题目保证链表中节点的值互不相同 
// 若使用 C 或 C++ 语言，你不需要 free 或 delete 被删除的节点 
// 
//
// 
//
// Related Topics 链表 👍 345 👎 0


package com.leetcode.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class ShanChuLianBiaoDeJieDianLcof {
    public static void main(String[] args) {
        Solution solution = new ShanChuLianBiaoDeJieDianLcof().new Solution();
        ListNode head = new ListNode(4);
        ListNode node = new ListNode(5);
        ListNode node2 = new ListNode(1);
        ListNode node3 = new ListNode(9);

        int val = 5;

        head.next = node;
        node.next = node2;
        node2.next = node3;
        System.out.println(solution.deleteNode(head, val));
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public ListNode deleteNode(ListNode head, int val) {
            if (head.val == val) return head.next;
            ListNode prev = head;
            ListNode cur = head.next;
            while (cur != null && cur.val != val) {
                prev = cur;
                cur = cur.next;
            }
            if (cur.val == val) {
                prev.next = cur.next;
            }
            return head;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}