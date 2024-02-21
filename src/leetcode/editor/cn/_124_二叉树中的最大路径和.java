package editor.cn;

//二叉树中的 路径 被定义为一条节点序列，序列中每对相邻节点之间都存在一条边。同一个节点在一条路径序列中 至多出现一次 。该路径 至少包含一个 节点，且不一定
//经过根节点。 
//
// 路径和 是路径中各节点值的总和。 
//
// 给你一个二叉树的根节点 root ，返回其 最大路径和 。 
//
// 
//
// 示例 1： 
//
// 
//输入：root = [1,2,3]
//输出：6
//解释：最优路径是 2 -> 1 -> 3 ，路径和为 2 + 1 + 3 = 6 
//
// 示例 2： 
//
// 
//输入：root = [-10,9,20,null,null,15,7]
//输出：42
//解释：最优路径是 15 -> 20 -> 7 ，路径和为 15 + 20 + 7 = 42
// 
//
// 
//
// 提示： 
//
// 
// 树中节点数目范围是 [1, 3 * 104] 
// -1000 <= Node.val <= 1000 
// 
// Related Topics 树 深度优先搜索 动态规划 二叉树 
// 👍 2110 👎 0

public class _124_二叉树中的最大路径和 {
    public static void main(String[] args) {
        Solution solution = new _124_二叉树中的最大路径和().new Solution();
//        TreeNode treeNode2 = new TreeNode(2);
//        TreeNode treeNode3 = new TreeNode(3);
//        TreeNode root = new TreeNode(1, treeNode2, treeNode3);



//        TreeNode treeNode4_1 = new TreeNode(7);
//        TreeNode treeNode4_2 = new TreeNode(2);
//        TreeNode treeNode3_1 = new TreeNode(11, treeNode4_1, treeNode4_2);
//
//        TreeNode treeNode3_2 = new TreeNode(13);
//
//        TreeNode treeNode4_3 = new TreeNode(1);
//        TreeNode treeNode3_3 = new TreeNode(4, null, treeNode4_3);
//
//
//        TreeNode treeNode2_1 = new TreeNode(4, treeNode3_1, null);
//        TreeNode treeNode2_2 = new TreeNode(8, treeNode3_2, treeNode3_3);
//        TreeNode root = new TreeNode(5, treeNode2_1, treeNode2_2);


        TreeNode treeNode6_1 = new TreeNode(-6);
        TreeNode treeNode5_1 = new TreeNode(-6,treeNode6_1,null);
        TreeNode treeNode5_2 = new TreeNode(-6);

        TreeNode treeNode4_1 = new TreeNode(2,treeNode5_1,treeNode5_2);

        TreeNode treeNode3_1 = new TreeNode(-6);
        TreeNode treeNode3_2 = new TreeNode(2,treeNode4_1,null);

        TreeNode treeNode2_1 = new TreeNode(6);
        TreeNode treeNode2_2 = new TreeNode(-3,treeNode3_1,treeNode3_2);

        TreeNode root = new TreeNode(9, treeNode2_1, treeNode2_2);

        System.out.println(solution.maxPathSum(root));
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
        int maxSum = Integer.MIN_VALUE;

        public int maxPathSum(TreeNode root) {
            maxSumForContainCurrentNode(root);
            return maxSum;
        }

        public int maxSumForContainCurrentNode(TreeNode root) {
            if (root == null) {
                return 0;
            }

            int l = maxSumForContainCurrentNode(root.left);

            int r = maxSumForContainCurrentNode(root.right);

            int maxBranch = l > r ? l : r;

            int max = root.val;
            if (l > 0) {
                max += l;
            }
            if (r > 0) {
                max += r;
            }

            if (max > maxSum) {
                maxSum = max;
            }
            if (maxBranch + root.val<0){
                return 0;
            }
            return maxBranch + root.val;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
