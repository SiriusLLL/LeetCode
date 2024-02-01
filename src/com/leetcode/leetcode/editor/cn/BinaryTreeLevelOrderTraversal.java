//给你二叉树的根节点 root ，返回其节点值的 层序遍历 。 （即逐层地，从左到右访问所有节点）。 
//
// 
//
// 示例 1： 
// 
// 
//输入：root = [3,9,20,null,null,15,7]
//输出：[[3],[9,20],[15,7]]
// 
//
// 示例 2： 
//
// 
//输入：root = [1]
//输出：[[1]]
// 
//
// 示例 3： 
//
// 
//输入：root = []
//输出：[]
// 
//
// 
//
// 提示： 
//
// 
// 树中节点数目在范围 [0, 2000] 内 
// -1000 <= Node.val <= 1000 
// 
//
// Related Topics 树 广度优先搜索 二叉树 👍 1878 👎 0


package com.leetcode.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeLevelOrderTraversal {
    public static void main(String[] args) {
        Solution solution = new BinaryTreeLevelOrderTraversal().new Solution();
    }

    public static class TreeNode {
        public int val;
        public TreeNode left;
        public TreeNode right;
    }


    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode() {}
     * TreeNode(int val) { this.val = val; }
     * TreeNode(int val, TreeNode left, TreeNode right) {
     * this.val = val;
     * this.left = left;
     * this.right = right;
     * }
     * }
     */
    class Solution {
        // 如果测试数据量变大了就修改这个值
        public int MAXN = 2001;

        public TreeNode[] queue = new TreeNode[MAXN];

        public int l, r;

        public List<List<Integer>> levelOrder(TreeNode root) {
            List<List<Integer>> ans = new ArrayList<>();
            if (root != null) {
                // 队列清空
                l = r = 0;
                // 新来的root放到r位置，然后r++
                queue[r++] = root;

                while (l < r) { // 队列里还有数字

                    int size = r - l;
                    // 用这个数组处理每一层
                    ArrayList<Integer> list = new ArrayList<>();

                    // 处理每一层
                    for (int i = 0; i < size; i++) {
                        TreeNode cur = queue[l++];
                        // 弹出
                        list.add(cur.val);
                        // 有左加左，有右加右
                        if (cur.left != null) {
                            queue[r++] = cur.left;
                        }
                        if (cur.right != null) {
                            queue[r++] = cur.right;
                        }
                    }
                    // 每一层处理完的结果（小链表）放进ans（大链表）中
                    ans.add(list);
                }
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)
}