package editor.cn;

//给定两个整数数组 preorder 和 inorder ，其中 preorder 是二叉树的先序遍历， inorder 是同一棵树的中序遍历，请构造二叉树并
//返回其根节点。 
//
// 
//
// 示例 1: 
//
// 
//输入: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
//输出: [3,9,20,null,null,15,7]
// 
//
// 示例 2: 
//
// 
//输入: preorder = [-1], inorder = [-1]
//输出: [-1]
// 
//
// 
//
// 提示: 
//
// 
// 1 <= preorder.length <= 3000 
// inorder.length == preorder.length 
// -3000 <= preorder[i], inorder[i] <= 3000 
// preorder 和 inorder 均 无重复 元素 
// inorder 均出现在 preorder 
// preorder 保证 为二叉树的前序遍历序列 
// inorder 保证 为二叉树的中序遍历序列 
// 
// Related Topics 树 数组 哈希表 分治 二叉树 
// 👍 2153 👎 0

public class _105_从前序与中序遍历序列构造二叉树 {
    public static void main(String[] args) {
        Solution solution = new _105_从前序与中序遍历序列构造二叉树().new Solution();
        int[] preorder = {1, 2};
        int[] inorder = {2, 1};
        solution.buildTree(preorder, inorder);
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
        public TreeNode buildTree(int[] preorder, int[] inorder) {
            return buildTree(preorder, inorder, 0, preorder.length - 1, 0, inorder.length - 1);
        }

        public TreeNode buildTree(int[] preorder, int[] inorder, int preStart, int preEnd, int inStart, int inEnd) {
            if (preEnd < preStart || inEnd < inStart) {
                return null;
            }
            // 前序序列的第一个位置是根节点的值
            int rootVal = preorder[preStart];
            if (preEnd == preStart) {
                return new TreeNode(rootVal);
            }

            // 获取中序序列中根节点位置
            int rootIdx = -1;
            for (int i = inStart; i <= inEnd; i++) {
                if (rootVal == inorder[i]) {
                    rootIdx = i;
                    break;
                }
            }
            // 左子树
            TreeNode leftNode = buildTree(preorder, inorder, preStart + 1, rootIdx - inStart + preStart, inStart, rootIdx - 1);

            // 右子树
            TreeNode rightNode = buildTree(preorder, inorder, rootIdx - inStart + preStart + 1, preEnd, rootIdx + 1, inEnd);

            return new TreeNode(rootVal, leftNode, rightNode);

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
