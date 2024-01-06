//给你一个单链表的头节点 head ，请你判断该链表是否为回文链表。如果是，返回 true ；否则，返回 false 。 
//
// 
//
// 示例 1： 
// 
// 
//输入：head = [1,2,2,1]
//输出：true
// 
//
// 示例 2： 
// 
// 
//输入：head = [1,2]
//输出：false
// 
//
// 
//
// 提示： 
//
// 
// 链表中节点数目在范围[1, 10⁵] 内 
// 0 <= Node.val <= 9 
// 
//
// 
//
// 进阶：你能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？ 
//
// Related Topics 栈 递归 链表 双指针 👍 1842 👎 0


package com.leetcode.leetcode.editor.cn;

public class PalindromeLinkedList {
    public static void main(String[] args) {
        Solution solution = new PalindromeLinkedList().new Solution();
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

//// 不要提交这个类
//    public static class ListNode {
//        public int val;
//        public ListNode next;
//    }

    class Solution {
        public boolean isPalindrome(ListNode head) {
            // 判空
            if (head == null || head.next == null) {
                return true;
            }

            ListNode slow = head, fast = head;

            // 快慢指针找中点
            while (fast.next != null && fast.next.next != null) {
                slow = slow.next;
                fast = fast.next.next;
            }

            // 找到中点slow，然后将slow后面的节点逆序
            // head -> ... -> slow <- ... <- pre
            ListNode pre = slow;
            ListNode cur = pre.next;
            ListNode next = null;
            pre.next = null;
            while (cur != null) {
                next = cur.next;
                cur.next = pre;
                pre = cur;
                cur = next;
            }

            // 分别从左往右和从右往左遍历并对比每一对节点的值是否相等
            ListNode left = head;
            ListNode right = pre;
            boolean ans = true;
            while (left != null && right != null) {
                if (left.val != right.val) {
                    ans = false;
                    break;
                }
                left = left.next;
                right = right.next;
            }

            // 将链表复原
            cur = pre.next;
            pre.next = null;
            next = null;
            while (cur != null) {
                next = cur.next;
                cur.next = pre;
                pre = cur;
                cur = next;
            }

            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)
}