package editor.cn;
import java.lang.Math;

//给出二叉 搜索 树的根节点，该树的节点值各不相同，请你将其转换为累加树（Greater Sum Tree），使每个节点 node 的新值等于原树中大于或等于
// node.val 的值之和。 
//
// 提醒一下，二叉搜索树满足下列约束条件： 
//
// 
// 节点的左子树仅包含键 小于 节点键的节点。 
// 节点的右子树仅包含键 大于 节点键的节点。 
// 左右子树也必须是二叉搜索树。 
// 
//
// 注意：本题和 1038: https://leetcode-cn.com/problems/binary-search-tree-to-greater-s
//um-tree/ 相同 
//
// 
//
// 示例 1： 
//
// 
//
// 输入：[4,1,6,0,2,5,7,null,null,null,3,null,null,null,8]
//输出：[30,36,21,36,35,26,15,null,null,null,33,null,null,null,8]
// 
//
// 示例 2： 
//
// 输入：root = [0,null,1]
//输出：[1,null,1]
// 
//
// 示例 3： 
//
// 输入：root = [1,0,2]
//输出：[3,3,2]
// 
//
// 示例 4： 
//
// 输入：root = [3,2,4,1]
//输出：[7,9,4,10]
// 
//
// 
//
// 提示： 
//
// 
// 树中的节点数介于 0 和 104 之间。 
// 每个节点的值介于 -104 和 104 之间。 
// 树中的所有值 互不相同 。 
// 给定的树为二叉搜索树。 
// 
// Related Topics 树 深度优先搜索 二叉搜索树 二叉树 
// 👍 970 👎 0

public class _538_把二叉搜索树转换为累加树 {
    public static void main(String[] args) {
        Solution solution = new _538_把二叉搜索树转换为累加树().new Solution();
        TreeNode node4 = new TreeNode(8);
        TreeNode node3 = new TreeNode(7,null,node4);
        TreeNode node2 = new TreeNode(5);
        TreeNode node1 = new TreeNode(6,node2,node3);

        TreeNode node8 = new TreeNode(3);
        TreeNode node7 = new TreeNode(2,null,node8);
        TreeNode node6 = new TreeNode(0);
        TreeNode node5 = new TreeNode(1,node6,node7);

        TreeNode node9 = new TreeNode(4, node5, node1);
        TreeNode node = solution.convertBST(node9);
        System.out.println(node);
    }
//leetcode submit region begin(Prohibit modification and deletion)

    class Solution {
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
        private int maxVal=0;
        public TreeNode convertBST(TreeNode root) {
            if (root == null) return null;
            TreeNode right = convertBST(root.right);
            int newVal=root.val+maxVal;
            maxVal=newVal;
            TreeNode left = convertBST(root.left);

            TreeNode treeNode = new TreeNode(newVal,left,right);
            return treeNode;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
