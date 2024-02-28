//给你一棵二叉树的根节点 root ，返回树的 最大宽度 。 
//
// 树的 最大宽度 是所有层中最大的 宽度 。 
//
// 
// 
// 每一层的 宽度 被定义为该层最左和最右的非空节点（即，两个端点）之间的长度。将这个二叉树视作与满二叉树结构相同，两端点间会出现一些延伸到这一层的 
//null 节点，这些 null 节点也计入长度。 
// 
// 
//
// 题目数据保证答案将会在 32 位 带符号整数范围内。 
//
// 
//
// 示例 1： 
// 
// 
//输入：root = [1,3,2,5,3,null,9]
//输出：4
//解释：最大宽度出现在树的第 3 层，宽度为 4 (5,3,null,9) 。
// 
//
// 示例 2： 
// 
// 
//输入：root = [1,3,2,5,null,null,9,6,null,7]
//输出：7
//解释：最大宽度出现在树的第 4 层，宽度为 7 (6,null,null,null,null,null,7) 。
// 
//
// 示例 3： 
// 
// 
//输入：root = [1,3,2,5]
//输出：2
//解释：最大宽度出现在树的第 2 层，宽度为 2 (3,2) 。
// 
//
// 
//
// 提示： 
//
// 
// 树中节点的数目范围是 [1, 3000] 
// -100 <= Node.val <= 100 
// 
//
// Related Topics 树 深度优先搜索 广度优先搜索 二叉树 👍 625 👎 0


package com.leetcode.leetcode.editor.cn;

public class MaximumWidthOfBinaryTree {
    public static void main(String[] args) {
        Solution solution = new MaximumWidthOfBinaryTree().new Solution();
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

        public int MAXN = 3001;
        public TreeNode[] nq = new TreeNode[MAXN];
        public int[] iq = new int[MAXN];
        public int l, r;

        public int widthOfBinaryTree(TreeNode root) {
            // 初始化
            int ans = 1;
            l = r = 0;
            nq[r] = root;
            iq[r++] = 1;

            // 对整个队列的操作
            while (l < r) {
                // 记录队列大小
                int size = r - l;

                // 返回ans，即两端id相减的最大值 + 1
                ans = Math.max(ans, iq[r - 1] - iq[l] + 1);

                // 对每一层的操作
                for (int i = 0; i < size; i++) {
                    // 记录当前节点和对应的id
                    TreeNode node = nq[l];
                    int id = iq[l++];

                    // 如果左子节点存在，则将左子节点放入nq，对应的id放入iq
                    if (node.left != null) {
                        nq[r] = node.left;
                        iq[r++] = id * 2;
                    }
                    // 如果右子节点存在，则将右子节点放入nq，对应的id放入iq
                    if (node.right != null) {
                        nq[r] = node.right;
                        iq[r++] = id * 2 + 1;
                    }
                }
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)
}