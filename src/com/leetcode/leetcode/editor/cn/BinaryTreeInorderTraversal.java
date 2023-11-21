//给定一个二叉树的根节点 root ，返回 它的 中序 遍历 。 
//
// 
//
// 示例 1： 
// 
// 
//输入：root = [1,null,2,3]
//输出：[1,3,2]
// 
//
// 示例 2： 
//
// 
//输入：root = []
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：root = [1]
//输出：[1]
// 
//
// 
//
// 提示： 
//
// 
// 树中节点数目在范围 [0, 100] 内 
// -100 <= Node.val <= 100 
// 
//
// 
//
// 进阶: 递归算法很简单，你可以通过迭代算法完成吗？ 
//
// Related Topics 栈 树 深度优先搜索 二叉树 👍 1956 👎 0


package com.leetcode.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinaryTreeInorderTraversal {
    public static void main(String[] args) {
        Solution solution = new BinaryTreeInorderTraversal().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

//    class Solution {
//        public List<Integer> inorderTraversal(TreeNode root) {
//            List<Integer> ans = new ArrayList<>();
//            if (root == null) {
//                return new ArrayList<>();
//            }
//            ans.addAll(inorderTraversal(root.left));
//            ans.add(root.val);
//            ans.addAll(inorderTraversal(root.right));
//            return ans;
//        }
//    }

    class Solution {
        public List<Integer> inorderTraversal(TreeNode root) {
            List<Integer> ans = new ArrayList<>();
            if (root != null) {
                Stack<TreeNode> stack = new Stack<>();
                while (!stack.isEmpty() || root != null) {
                    if (root != null) {
                        stack.push(root);
                        root = root.left;
                    } else {
                        root = stack.pop();
                        ans.add(root.val);
                        root = root.right;
                    }
                }
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)
}