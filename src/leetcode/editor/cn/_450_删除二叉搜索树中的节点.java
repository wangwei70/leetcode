package editor.cn;

//给定一个二叉搜索树的根节点 root 和一个值 key，删除二叉搜索树中的 key 对应的节点，并保证二叉搜索树的性质不变。返回二叉搜索树（有可能被更新）的
//根节点的引用。 
//
// 一般来说，删除节点可分为两个步骤： 
//
// 
// 首先找到需要删除的节点； 
// 如果找到了，删除它。 
// 
//
// 
//
// 示例 1: 
//
// 
//
// 
//输入：root = [5,3,6,2,4,null,7], key = 3
//输出：[5,4,6,2,null,null,7]
//解释：给定需要删除的节点值是 3，所以我们首先找到 3 这个节点，然后删除它。
//一个正确的答案是 [5,4,6,2,null,null,7], 如下图所示。
//另一个正确答案是 [5,2,6,null,4,null,7]。
//
//
// 
//
// 示例 2: 
//
// 
//输入: root = [5,3,6,2,4,null,7], key = 0
//输出: [5,3,6,2,4,null,7]
//解释: 二叉树不包含值为 0 的节点
// 
//
// 示例 3: 
//
// 
//输入: root = [], key = 0
//输出: [] 
//
// 
//
// 提示: 
//
// 
// 节点数的范围 [0, 104]. 
// -105 <= Node.val <= 105 
// 节点值唯一 
// root 是合法的二叉搜索树 
// -105 <= key <= 105 
// 
//
// 
//
// 进阶： 要求算法时间复杂度为 O(h)，h 为树的高度。 
// Related Topics 树 二叉搜索树 二叉树 
// 👍 1293 👎 0

public class _450_删除二叉搜索树中的节点 {
    public static void main(String[] args) {
        Solution solution = new _450_删除二叉搜索树中的节点().new Solution();

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
        public TreeNode deleteNode(TreeNode root, int key) {
            if (root == null) return null;
            if (root.val == key) {
                if (root.left == null && root.right == null) {
                    // 没有子节点
                    return null;
                } else if (root.left == null || root.right == null) {
                    // 只有一个子节点
                    return root.left == null ? root.right : root.left;
                } else {
                    // 有两个节点,找到右子树中最小的那个节点
                    TreeNode minNode = findMin(root.right);
                    // 删除最小节点
                    minNode.right = deleteNode(root.right, minNode.val);
                    minNode.left = root.left;
                    return minNode;
                }
            } else if (root.val < key) {
                root.right = deleteNode(root.right, key);
            } else {
                root.left = deleteNode(root.left, key);
            }
            return root;

        }

        private TreeNode findMin(TreeNode root) {
            while (root != null && root.left != null) {
                root = root.left;
            }
            return root;
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}
