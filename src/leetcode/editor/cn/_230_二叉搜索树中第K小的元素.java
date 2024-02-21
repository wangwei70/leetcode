package editor.cn;

//给定一个二叉搜索树的根节点 root ，和一个整数 k ，请你设计一个算法查找其中第 k 个最小元素（从 1 开始计数）。 
//
// 
//
// 示例 1： 
//
// 
//输入：root = [3,1,4,null,2], k = 1
//输出：1
// 
//
// 示例 2： 
//
// 
//输入：root = [5,3,6,2,4,null,null,1], k = 3
//输出：3
// 
//
// 
//
// 
//
// 提示： 
//
// 
// 树中的节点数为 n 。 
// 1 <= k <= n <= 104 
// 0 <= Node.val <= 104 
// 
//
// 
//
// 进阶：如果二叉搜索树经常被修改（插入/删除操作）并且你需要频繁地查找第 k 小的值，你将如何优化算法？ 
// Related Topics 树 深度优先搜索 二叉搜索树 二叉树 
// 👍 797 👎 0

public class _230_二叉搜索树中第K小的元素 {
    public static void main(String[] args) {
        Solution solution = new _230_二叉搜索树中第K小的元素().new Solution();
//        TreeNode treeNode3 = new TreeNode(2);
//        TreeNode treeNode2_1 = new TreeNode(1, null, treeNode3);
//        TreeNode treeNode2_2 = new TreeNode(4);
//        TreeNode treeNode1 = new TreeNode(3, treeNode2_1, treeNode2_2);


        TreeNode treeNode4 = new TreeNode(1);
        TreeNode treeNode3_1 = new TreeNode(2, treeNode4, null);
        TreeNode treeNode3_2 = new TreeNode(4);
        TreeNode treeNode2_1 = new TreeNode(3, treeNode3_1, treeNode3_2);
        TreeNode treeNode2_2 = new TreeNode(6);
        TreeNode treeNode1 = new TreeNode(5, treeNode2_1, treeNode2_2);

        System.out.println(solution.kthSmallest(treeNode1, 3));

//        solution.travese(treeNode1,0);
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
        public int kthSmallest(TreeNode root, int k) {
            travese(root,k);
            return res;
        }

        private int res = -1;

        private int idx = 0;
        public void travese(TreeNode root,int k){
            if (root==null){
                return;
            }

            travese(root.left,k);
            idx++;
            if (idx==k){
                 res=root.val;
                 return;
            }
            travese(root.right,k);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
