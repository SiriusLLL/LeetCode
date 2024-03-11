//给你二叉树的根节点 root 和一个整数目标和 targetSum ，找出所有 从根节点到叶子节点 路径总和等于给定目标和的路径。 
//
// 叶子节点 是指没有子节点的节点。 
//
// 
// 
// 
// 
// 
//
// 示例 1： 
// 
// 
//输入：root = [5,4,8,11,null,13,4,7,2,null,null,5,1], targetSum = 22
//输出：[[5,4,11,2],[5,8,4,5]]
// 
//
// 示例 2： 
// 
// 
//输入：root = [1,2,3], targetSum = 5
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：root = [1,2], targetSum = 0
//输出：[]
// 
//
// 
//
// 提示： 
//
// 
// 树中节点总数在范围 [0, 5000] 内 
// -1000 <= Node.val <= 1000 
// -1000 <= targetSum <= 1000 
// 
//
// Related Topics 树 深度优先搜索 回溯 二叉树 👍 1090 👎 0


package com.leetcode.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class PathSumIi {
    public static void main(String[] args) {
        Solution solution = new PathSumIi().new Solution();
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
        public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
            List<List<Integer>> ans = new ArrayList<>();
            if (root != null) {
                List<Integer> path = new ArrayList<>();
                f(root, targetSum, 0, path, ans);
            }
            return ans;
        }


        public void f(TreeNode cur, int aim, int sum, List<Integer> path, List<List<Integer>> ans) {

            // 当遇到叶节点
            if (cur.left == null && cur.right == null) {
                if (cur.val + sum == aim) {// 并且达到要求，即sum == aim时
                    // 把路径补全
                    path.add(cur.val);
                    // 整条路经复制到ans中
                    copy(path, ans);
                    // 从路径中删除最后一个下标，给别的节点腾位置
                    path.remove(path.size() - 1);
                } // 遇到叶节点且不达标就跳出
            } else {
                // 不是叶节点
                // 先把当前节点加入path中，然后往下找
                path.add(cur.val);
                // 向左递归
                if (cur.left != null) {
                    f(cur.left, aim, sum + cur.val, path, ans);
                }
                // 向右递归
                if (cur.right != null) {
                    f(cur.right, aim, sum + cur.val, path, ans);
                }
                // 直到达到条件后删除最后一个下标
                path.remove(path.size() - 1);
            }
        }

        // 用于将path复制到ans中，保证path的复用性
        public void copy(List<Integer> path, List<List<Integer>> ans) {
            List<Integer> copy = new ArrayList<>(path);
            ans.add(copy);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)
}