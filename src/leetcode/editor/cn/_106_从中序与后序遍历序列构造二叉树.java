package editor.cn;

//给定两个整数数组 inorder 和 postorder ，其中 inorder 是二叉树的中序遍历， postorder 是同一棵树的后序遍历，请你构造并
//返回这颗 二叉树 。 
//
// 
//
// 示例 1: 
//
// 
//输入：inorder = [9,3,15,20,7], postorder = [9,15,7,20,3]
//输出：[3,9,20,null,null,15,7]
// 
//
// 示例 2: 
//
// 
//输入：inorder = [-1], postorder = [-1]
//输出：[-1]
// 
//
// 
//
// 提示: 
//
// 
// 1 <= inorder.length <= 3000 
// postorder.length == inorder.length 
// -3000 <= inorder[i], postorder[i] <= 3000 
// inorder 和 postorder 都由 不同 的值组成 
// postorder 中每一个值都在 inorder 中 
// inorder 保证是树的中序遍历 
// postorder 保证是树的后序遍历 
// 
// Related Topics 树 数组 哈希表 分治 二叉树 
// 👍 1154 👎 0

public class _106_从中序与后序遍历序列构造二叉树 {
    public static void main(String[] args) {
        Solution solution = new _106_从中序与后序遍历序列构造二叉树().new Solution();

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
        public TreeNode buildTree(int[] inorder, int[] postorder) {
            int endIdx = inorder.length - 1;
            return buildTree(inorder,0, endIdx,postorder,0,endIdx);
        }

        public TreeNode buildTree(int[] inorder, int inStart, int inEnd, int[] postorder, int postStart, int postEnd) {
            if (inStart<0||inEnd<0||postStart<0||postEnd<0||
                    inStart>=inorder.length||inEnd>=inorder.length||postStart>=inorder.length||postEnd>=inorder.length
                    ||inStart>inEnd||postStart>postEnd){
                return null;
            }

            int rootVal = postorder[postEnd];
            TreeNode root = new TreeNode(rootVal);

            // 中序数组中找root索引
            int rootIdxOfIn = -1;
            for (int i = inStart; i <= inEnd; i++) {
                if (inorder[i] == rootVal) {
                    rootIdxOfIn = i;
                }
            }


            // 找到两个数组中左子树的索引位，递归生成左子树
            root.left = buildTree(inorder, inStart, rootIdxOfIn - 1, postorder, postStart, postStart + (rootIdxOfIn - 1 - inStart));
            // 找到两个数组中右子树的索引位，递归生成右子树
            root.right = buildTree(inorder,rootIdxOfIn+1,inEnd,postorder,postEnd-inEnd+rootIdxOfIn,postEnd-1);

            return root;

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
