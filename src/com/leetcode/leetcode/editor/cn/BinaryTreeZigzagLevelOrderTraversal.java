//给你二叉树的根节点 root ，返回其节点值的 锯齿形层序遍历 。（即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。 
//
// 
//
// 示例 1： 
// 
// 
//输入：root = [3,9,20,null,null,15,7]
//输出：[[3],[20,9],[15,7]]
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
// -100 <= Node.val <= 100 
// 
//
// Related Topics 树 广度优先搜索 二叉树 👍 862 👎 0


package com.leetcode.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeZigzagLevelOrderTraversal {
    public static void main(String[] args) {
        Solution solution = new BinaryTreeZigzagLevelOrderTraversal().new Solution();
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

        public int MAXN = 2001;
        public TreeNode[] queue = new TreeNode[MAXN];

        public int l, r;

        public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
            List<List<Integer>> ans = new ArrayList<>();
            if (root != null) {
                l = r = 0;
                queue[r++] = root;

                // false 代表从左往右
                // true 代表从右往左
                boolean reverse = false;

                while (l < r) {
                    int size = r - l;
                    ArrayList<Integer> list = new ArrayList<>();


                    // 1.节点值的收集过程（从队列中读取节点值）：左右交替
                    // i的作用
                    // reverse == false, 左 -> 右， l....r-1, 收集size个
                    // reverse == true,  右 -> 左， r-1....l, 收集size个

                    // j的作用
                    // 左 -> 右, i = i + 1
                    // 右 -> 左, i = i - 1
                    for (int i = reverse ? r - 1 : l, j = reverse ? -1 : 1, k = 0; k < size; i += j, k++) {
                        TreeNode cur = queue[i];
                        list.add(cur.val);
                    }

                    // 2.子节点的遍历过程（将节点值放入队列）：常规遍历
                    for (int i = 0; i < size; i++) {
                        TreeNode cur = queue[l++];
                        if (cur.left != null) {
                            queue[r++] = cur.left;
                        }
                        if (cur.right != null) {
                            queue[r++] = cur.right;
                        }
                    }
                    ans.add(list);
                    reverse = !reverse;
                }
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)
}