package editor.cn;

//给你二叉树的根结点 root ，请你将它展开为一个单链表： 
//
// 
// 展开后的单链表应该同样使用 TreeNode ，其中 right 子指针指向链表中下一个结点，而左子指针始终为 null 。 
// 展开后的单链表应该与二叉树 先序遍历 顺序相同。 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：root = [1,2,5,3,4,null,6]
//输出：[1,null,2,null,3,null,4,null,5,null,6]
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
//输入：root = [0]
//输出：[0]
// 
//
// 
//
// 提示： 
//
// 
// 树中结点数在范围 [0, 2000] 内 
// -100 <= Node.val <= 100 
// 
//
// 
//
// 进阶：你可以使用原地算法（O(1) 额外空间）展开这棵树吗？ 
// Related Topics 栈 树 深度优先搜索 链表 二叉树 
// 👍 1596 👎 0

public class _114_二叉树展开为链表 {
    public static void main(String[] args) {
        Solution solution = new _114_二叉树展开为链表().new Solution();

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
        public void flatten(TreeNode root) {
            if (root == null) return;
            traverse(root);
        }

        // 返回值为链表的最后一个节点，且不为null
        public TreeNode traverse(TreeNode node) {
            TreeNode leftHead = node.left;
            TreeNode rightHead = node.right;
            // 叶子节点直接返回
            if (leftHead == null && rightHead == null) {
                return node;
            }

            TreeNode last=null;
            node.left = null;
            if (leftHead != null) {
                // 左子树不为null
                TreeNode leftLast = traverse(leftHead);
                // 中序位置进行处理，获取到左子树链表
                node.right = leftHead;
                leftLast.right = rightHead;
                last=leftLast;
            } else {
                // 左子树为null，右子树不为null
                node.right = rightHead;
            }

            if (rightHead != null) {
                TreeNode rightLast = traverse(rightHead);
                last=rightLast;
            }
            return last;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
