  //书店店员有一张链表形式的书单，每个节点代表一本书，节点中的值表示书的编号。为更方便整理书架，店员需要将书单倒过来排列，就可以从最后一本书开始整理，逐一将书放
//回到书架上。请倒序返回这个书单链表。 
//
// 
//
// 示例 1： 
//
// 
//输入：head = [3,6,4,1]
//
//输出：[1,4,6,3]
// 
//
// 
//
// 提示： 
//
// 0 <= 链表长度 <= 10000 
//
// Related Topics 栈 递归 链表 双指针 👍 464 👎 0

  
  package com.leetcode.leetcode.editor.cn;

  import java.util.ArrayList;
  import java.util.LinkedList;

  public class CongWeiDaoTouDaYinLianBiaoLcof{
      public static void main(String[] args) {
          Solution solution = new CongWeiDaoTouDaYinLianBiaoLcof().new Solution();
          ListNode head = new ListNode(3);
          ListNode node = new ListNode(6);
          ListNode node2 = new ListNode(4);
          ListNode node3 = new ListNode(1);

          head.next = node;
          node.next = node2;
          node2.next = node3;
          System.out.println(solution.reverseBookList(head));
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
//    public int[] reverseBookList(ListNode head) {
//        ListNode cur = head;
//        int count = 0;
//        while (cur != null) {
//            cur = cur.next;
//            count++;
//        }
//
//        int[] arr = new int[count];
//
//        cur = head;
//        count--;
//        while (cur != null && count >= 0) {
//            arr[count--] = cur.val;
//            cur = cur.next;
//        }
//        return arr;
//    }

//    // 方法一：递归
//    ArrayList<Integer> tmp = new ArrayList<Integer>();
//    public int[] reverseBookList(ListNode head) {
//        recur(head);
//        int[] res = new int[tmp.size()];
//        for(int i = 0; i < res.length; i++)
//            res[i] = tmp.get(i);
//        return res;
//    }
//    void recur(ListNode head) {
//        if(head == null) return;
//        recur(head.next);
//        tmp.add(head.val);
//    }

    // 方法二：辅助栈法
    public int[] reverseBookList(ListNode head) {
        LinkedList<Integer> stack = new LinkedList<Integer>();
        while(head != null) {
            stack.addLast(head.val);
            head = head.next;
        }
        int[] res = new int[stack.size()];
        for(int i = 0; i < res.length; i++)
            res[i] = stack.removeLast();
        return res;
    }

}
//leetcode submit region end(Prohibit modification and deletion)
}