//给你链表的头结点 head ，请将其按 升序 排列并返回 排序后的链表 。 
//
// 
// 
//
// 
//
// 示例 1： 
// 
// 
//输入：head = [4,2,1,3]
//输出：[1,2,3,4]
// 
//
// 示例 2： 
// 
// 
//输入：head = [-1,5,3,4,0]
//输出：[-1,0,3,4,5]
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
// 链表中节点的数目在范围 [0, 5 * 10⁴] 内 
// -10⁵ <= Node.val <= 10⁵ 
// 
//
// 
//
// 进阶：你可以在 O(n log n) 时间复杂度和常数级空间复杂度下，对链表进行排序吗？ 
//
// Related Topics 链表 双指针 分治 排序 归并排序 👍 2210 👎 0


package com.leetcode.leetcode.editor.cn;

public class SortList {
    public static void main(String[] args) {
        Solution solution = new SortList().new Solution();
    }

    // 不要提交这个类
    public class ListNode {
        public int val;
        public ListNode next;
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
    class Solution {

        // 提交如下的方法
        // 时间复杂度O(n*logn)，额外空间复杂度O(1)，有稳定性
        // 注意为了额外空间复杂度O(1)，所以不能使用递归
        // 因为mergeSort递归需要O(log n)的额外空间
        public ListNode sortList(ListNode head) {
            int n = 0;
            ListNode cur = head;
            while (cur != null) {
                n++;
                cur = cur.next;
            }
            // l1...r1 每组的左部分
            // l2...r2 每组的右部分
            // next 下一组的开头
            // lastTeamEnd 上一组的结尾
            ListNode l1, r1, l2, r2, next, lastTeamEnd;
            for (int step = 1; step < n; step <<= 1) {
                // 第一组很特殊，因为要决定整个链表的头，所以单独处理
                l1 = head;
                r1 = findEnd(l1, step);
                l2 = r1.next;
                r2 = findEnd(l2, step);
                next = r2.next;
                r1.next = null;
                r2.next = null;
                merge(l1, r1, l2, r2);
                head = start;
                lastTeamEnd = end;
                while (next != null) {
                    l1 = next;
                    r1 = findEnd(l1, step);
                    l2 = r1.next;
                    if (l2 == null) {
                        lastTeamEnd.next = l1;
                        break;
                    }
                    r2 = findEnd(l2, step);
                    next = r2.next;
                    r1.next = null;
                    r2.next = null;
                    merge(l1, r1, l2, r2);
                    lastTeamEnd.next = start;
                    lastTeamEnd = end;
                }
            }
            return head;
        }

        // 包括s在内，往下数k个节点返回
        // 如果不够，返回最后一个数到的非空节点
        public ListNode findEnd(ListNode s, int k) {
            while (s.next != null && --k != 0) {
                s = s.next;
            }
            return s;
        }

        public ListNode start;

        public ListNode end;

        // l1...r1 -> null : 有序的左部分
        // l2...r2 -> null : 有序的右部分
        // 整体merge在一起，保证有序
        // 并且把全局变量start设置为整体的头，全局变量end设置为整体的尾
        public void merge(ListNode l1, ListNode r1, ListNode l2, ListNode r2) {
            ListNode pre;
            if (l1.val <= l2.val) {
                start = l1;
                pre = l1;
                l1 = l1.next;
            } else {
                start = l2;
                pre = l2;
                l2 = l2.next;
            }
            while (l1 != null && l2 != null) {
                if (l1.val <= l2.val) {
                    pre.next = l1;
                    pre = l1;
                    l1 = l1.next;
                } else {
                    pre.next = l2;
                    pre = l2;
                    l2 = l2.next;
                }
            }
            if (l1 != null) {
                pre.next = l1;
                end = r1;
            } else {
                pre.next = l2;
                end = r2;
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)
}