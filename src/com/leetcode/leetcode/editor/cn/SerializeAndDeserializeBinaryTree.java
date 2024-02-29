//序列化是将一个数据结构或者对象转换为连续的比特位的操作，进而可以将转换后的数据存储在一个文件或者内存中，同时也可以通过网络传输到另一个计算机环境，采取相反方
//式重构得到原数据。 
//
// 请设计一个算法来实现二叉树的序列化与反序列化。这里不限定你的序列 / 反序列化算法执行逻辑，你只需要保证一个二叉树可以被序列化为一个字符串并且将这个字符串
//反序列化为原始的树结构。 
//
// 提示: 输入输出格式与 LeetCode 目前使用的方式一致，详情请参阅 LeetCode 序列化二叉树的格式。你并非必须采取这种方式，你也可以采用其他的
//方法解决这个问题。 
//
// 
//
// 示例 1： 
// 
// 
//输入：root = [1,2,3,null,null,4,5]
//输出：[1,2,3,null,null,4,5]
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
// 示例 4： 
//
// 
//输入：root = [1,2]
//输出：[1,2]
// 
//
// 
//
// 提示： 
//
// 
// 树中结点数在范围 [0, 10⁴] 内 
// -1000 <= Node.val <= 1000 
// 
//
// Related Topics 树 深度优先搜索 广度优先搜索 设计 字符串 二叉树 👍 1206 👎 0


package com.leetcode.leetcode.editor.cn;

public class SerializeAndDeserializeBinaryTree {

    public static class TreeNode {
        public int val;
        public TreeNode left;
        public TreeNode right;

        public TreeNode(int v) {
            val = v;
        }
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode(int x) { val = x; }
     * }
     */
// 二叉树可以通过先序、后序或者按层遍历的方式序列化和反序列化
// 但是，二叉树无法通过中序遍历的方式实现序列化和反序列化
// 因为不同的两棵树，可能得到同样的中序序列，即便补了空位置也可能一样。
// 比如如下两棵树
//         __2
//        /
//       1
//       和
//       1__
//          \
//           2
// 补足空位置的中序遍历结果都是{ null, 1, null, 2, null}
// 提交这个类
    public class Codec {

        public String serialize(TreeNode root) {
            StringBuilder builder = new StringBuilder();
            f(root, builder);
            return builder.toString();
        }

        // 前序遍历
        void f(TreeNode root, StringBuilder builder) {
            if (root == null) {
                builder.append("#,");
            } else {
                builder.append(root.val + ",");
                f(root.left, builder);
                f(root.right, builder);
            }
        }

        public TreeNode deserialize(String data) {
            String[] vals = data.split(",");
            cnt = 0;
            return g(vals);
        }

        // 当前数组消费到哪了
        public int cnt;

        TreeNode g(String[] vals) {
            String cur = vals[cnt++];
            if (cur.equals("#")) {
                return null;
            } else {
                TreeNode head = new TreeNode(Integer.valueOf(cur));
                head.left = g(vals);
                head.right = g(vals);
                return head;
            }
        }
    }

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));
//leetcode submit region end(Prohibit modification and deletion)
}