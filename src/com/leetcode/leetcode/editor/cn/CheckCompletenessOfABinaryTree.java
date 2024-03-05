//给你一棵二叉树的根节点
// root ，请你判断这棵树是否是一棵 完全二叉树 。 
//
// 在一棵 完全二叉树 中，除了最后一层外，所有层都被完全填满，并且最后一层中的所有节点都尽可能靠左。最后一层（第 h 层）中可以包含
// 1 到
// 2ʰ 个节点。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：root = [1,2,3,4,5,6]
//输出：true
//解释：最后一层前的每一层都是满的（即，节点值为 {1} 和 {2,3} 的两层），且最后一层中的所有节点（{4,5,6}）尽可能靠左。
// 
//
// 示例 2： 
//
// 
//
// 
//输入：root = [1,2,3,4,5,null,7]
//输出：false
//解释：值为 7 的节点不满足条件「节点尽可能靠左」。
// 
//
// 
//
// 提示： 
//
// 
// 树中节点数目在范围 [1, 100] 内 
// 1 <= Node.val <= 1000 
// 
//
// Related Topics 树 广度优先搜索 二叉树 👍 283 👎 0


package com.leetcode.leetcode.editor.cn;

public class CheckCompletenessOfABinaryTree {
    public static void main(String[] args) {
        Solution solution = new CheckCompletenessOfABinaryTree().new Solution();
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
        public int MAXN = 101;
        public TreeNode[] queue = new TreeNode[MAXN];
        public int l, r;

        public boolean isCompleteTree(TreeNode root) {
            // 判空
            if (root == null) {
                return true;
            }

            // 初始化
            l = r = 0;
            queue[r++] = root;
            // 子节点是否不全
            boolean leaf = false;

            while (l < r) {
                root = queue[l++];
                if ((root.left == null && root.right != null) // 有右无左的情况
                        || (leaf && (root.left != null || root.right != null)) // 子节点不全的情况
                ) {
                    return false;
                }
                // bfs
                if (root.left != null) {
                    queue[r++] = root.left;
                }
                if (root.right != null) {
                    queue[r++] = root.right;
                }

                // 遇到子节点不全的情况，将leaf置为true
                if (root.left == null || root.right == null) {
                    leaf = true;
                }
            }
            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)
}