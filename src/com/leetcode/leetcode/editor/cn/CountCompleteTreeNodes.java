//给你一棵 完全二叉树 的根节点 root ，求出该树的节点个数。 
//
// 完全二叉树 的定义如下：在完全二叉树中，除了最底层节点可能没填满外，其余每层节点数都达到最大值，并且最下面一层的节点都集中在该层最左边的若干位置。若最底层
//为第 h 层，则该层包含 1~ 2ʰ 个节点。 
//
// 
//
// 示例 1： 
// 
// 
//输入：root = [1,2,3,4,5,6]
//输出：6
// 
//
// 示例 2： 
//
// 
//输入：root = []
//输出：0
// 
//
// 示例 3： 
//
// 
//输入：root = [1]
//输出：1
// 
//
// 
//
// 提示： 
//
// 
// 树中节点的数目范围是[0, 5 * 10⁴] 
// 0 <= Node.val <= 5 * 10⁴ 
// 题目数据保证输入的树是 完全二叉树 
// 
//
// 
//
// 进阶：遍历树来统计节点是一种时间复杂度为 O(n) 的简单解决方案。你可以设计一个更快的算法吗？ 
//
// Related Topics 位运算 树 二分查找 二叉树 👍 1099 👎 0


package com.leetcode.leetcode.editor.cn;

public class CountCompleteTreeNodes {
    public static void main(String[] args) {
        Solution solution = new CountCompleteTreeNodes().new Solution();
    }

    // 不提交这个类
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
        public int countNodes(TreeNode root) {
            if (root == null) {
                return 0;
            }
            return f(root, 1, mostLeft(root, 1));
        }

        // cur : 当前来到的节点
        // level :  当前来到的节点在第几层
        // h : 整棵树的高度，不是cur这棵子树的高度
        // 求 : cur这棵子树上有多少节点
        public int f(TreeNode cur, int level, int h) {
            if (level == h) {
                return 1;
            }

            // 查一下右树的左子树是不是达到了整棵树的最大高度
            if (mostLeft(cur.right, level + 1) == h) {
                // 如果右树的左子树达到了整棵树的最大高度，说明cur节点的左子树是完整的
                // 1 << (h - level)代表左子树的节点个数，即2^(h - level)个
                // 再对cur节点的右子树递归计算
                return (1 << (h - level)) + f(cur.right, level + 1, h);

            } else {
                // 如果右树的左子树达不到整棵树的最大高度，说明cur节点的右子树是完整的
                // 1 << (h - level - 1)代表右子树的节点个数，即2^(h - level - 1)个
                // 再对cur节点的左子树递归计算
                return (1 << (h - level - 1)) + f(cur.left, level + 1, h);
            }
        }


        // 往左遍历用于获取树的高度
        public int mostLeft(TreeNode cur, int level) {
            while (cur != null) {
                level++;
                cur = cur.left;
            }
            return level - 1;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)
}