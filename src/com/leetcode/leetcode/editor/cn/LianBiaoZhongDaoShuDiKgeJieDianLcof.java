//给定一个头节点为 head 的链表用于记录一系列核心肌群训练项目编号，请查找并返回倒数第 cnt 个训练项目编号。 
//
// 
//
// 示例 1： 
//
// 
//输入：head = [2,4,7,8], cnt = 1
//输出：8 
//
// 
//
// 提示： 
//
// 
// 1 <= head.length <= 100 
// 0 <= head[i] <= 100 
// 1 <= cnt <= head.length 
// 
//
// 
//
// Related Topics 链表 双指针 👍 508 👎 0


package com.leetcode.leetcode.editor.cn;

import java.util.List;

public class LianBiaoZhongDaoShuDiKgeJieDianLcof{
    public static void main(String[] args) {
       Solution solution = new LianBiaoZhongDaoShuDiKgeJieDianLcof().new Solution();
       ListNode head = new ListNode(2);
       ListNode node = new ListNode(4);
       ListNode node2 = new ListNode(7);
       ListNode node3 = new ListNode(8);

        head.next = node;
        node.next = node2;
        node2.next = node3;
        int cnt = 3;
        solution.trainingPlan(head,cnt);
    }

public static class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public ListNode trainingPlan(ListNode head, int cnt) {
        int count = 0;
        ListNode cur = head;
        while (cur != null) {
            count ++;
            cur = cur.next;
        }
        int index = count - cnt;
        ListNode tmp = head;
        for (int i = 0; i < index; i++) {
            tmp = tmp.next;
        }
        return tmp;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}