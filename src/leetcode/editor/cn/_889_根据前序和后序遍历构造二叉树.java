package editor.cn;

//给定两个整数数组，preorder 和 postorder ，其中 preorder 是一个具有 无重复 值的二叉树的前序遍历，postorder 是同一棵
//树的后序遍历，重构并返回二叉树。 
//
// 如果存在多个答案，您可以返回其中 任何 一个。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：preorder = [1,2,4,5,3,6,7], postorder = [4,5,2,6,7,3,1]
//输出：[1,2,3,4,5,6,7]
// 
//
// 示例 2: 
//
// 
//输入: preorder = [1], postorder = [1]
//输出: [1]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= preorder.length <= 30 
// 1 <= preorder[i] <= preorder.length 
// preorder 中所有值都 不同 
// postorder.length == preorder.length 
// 1 <= postorder[i] <= postorder.length 
// postorder 中所有值都 不同 
// 保证 preorder 和 postorder 是同一棵二叉树的前序遍历和后序遍历 
// 
// Related Topics 树 数组 哈希表 分治 二叉树 
// 👍 331 👎 0

public class _889_根据前序和后序遍历构造二叉树 {
    public static void main(String[] args) {
        Solution solution = new _889_根据前序和后序遍历构造二叉树().new Solution();
        int preorder[] ={1,2,4,5,3,6,7};
        int postorder[] ={4,5,2,6,7,3,1};

        solution.constructFromPrePost(preorder,postorder);
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
        public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
            int end = preorder.length - 1;
            return buildTree(preorder, 0, end, postorder, 0, end);
        }


        public TreeNode buildTree(int[] preorder, int inStart, int inEnd, int[] postorder, int postStart, int postEnd) {
            if (inStart < 0 || inEnd < 0 || postStart < 0 || postEnd < 0 ||
                    inStart >= preorder.length || inEnd >= preorder.length || postStart >= preorder.length || postEnd >= preorder.length
                    || inStart > inEnd || postStart > postEnd) {
                return null;
            }

            // 构造根节点
            int rootVal = preorder[inStart];
            TreeNode root = new TreeNode(rootVal);

            if (inStart==inEnd){
                return root;
            }

            // 后序数组中找左子树根索引
            if (inStart + 1 >= preorder.length) {
                return null;
            }

            int leftRootVal = preorder[inStart + 1];
            int leftRootIdxOfPost = -1;
            for (int i = postStart; i <= postEnd; i++) {
                if (postorder[i] == leftRootVal) {
                    leftRootIdxOfPost = i;
                    break;
                }
            }


            // 找到两个数组中左子树的索引位，递归生成左子树
            root.left = buildTree(preorder, inStart + 1, leftRootIdxOfPost - postStart + inStart + 1, postorder, postStart, leftRootIdxOfPost);
            // 找到两个数组中右子树的索引位，递归生成右子树
            root.right = buildTree(preorder, inEnd - postEnd + 2 + leftRootIdxOfPost, inEnd, postorder, leftRootIdxOfPost + 1, postEnd - 1);

            return root;

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
