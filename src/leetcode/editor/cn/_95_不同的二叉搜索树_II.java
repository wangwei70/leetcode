package editor.cn;

//给你一个整数 n ，请你生成并返回所有由 n 个节点组成且节点值从 1 到 n 互不相同的不同 二叉搜索树 。可以按 任意顺序 返回答案。 
//
// 
//
// 
// 
// 示例 1： 
//
// 
//输入：n = 3
//输出：[[1,null,2,null,3],[1,null,3,2],[2,1,3],[3,1,null,null,2],[3,2,null,1]]
// 
//
// 示例 2： 
//
// 
//输入：n = 1
//输出：[[1]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 8 
// 
// 
// 
// Related Topics 树 二叉搜索树 动态规划 回溯 二叉树 
// 👍 1512 👎 0

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class _95_不同的二叉搜索树_II {
    public static void main(String[] args) {
        Solution solution = new _95_不同的二叉搜索树_II().new Solution();
        System.out.println(solution.generateTrees(3));
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
        private List[][] memo;
        public List<TreeNode> generateTrees(int n) {
            memo=new List[n+2][n+2];
            return traverse(1,n);
        }


        private List<TreeNode> traverse(int start, int end) {
            if (start > end) {
                return Collections.singletonList(new TreeNode(-1));
            }
            if (start == end) {
                return Collections.singletonList(new TreeNode(start));
            }

            ArrayList<TreeNode> returnNodes = new ArrayList<>();
            for (int i = start; i <= end; i++) {
                if (memo[start][i-1]==null){
                    List<TreeNode> leftTrees = traverse(start, i - 1);
                    memo[start][i-1]=leftTrees;
                }
                if (memo[i+1][end]==null){
                    List<TreeNode> rightTrees = traverse(i + 1, end);
                    memo[i+1][end]=rightTrees;
                }
                List<TreeNode> leftTrees=memo[start][i-1];
                List<TreeNode> rightTrees=memo[i+1][end];

                for (TreeNode leftTree : leftTrees) {
                    for (TreeNode rightTree : rightTrees) {
                        TreeNode root = new TreeNode(i);
                        if (leftTree.val != -1) {
                            root.left = leftTree;
                        }
                        if (rightTree.val != -1) {
                            root.right = rightTree;
                        }
                        returnNodes.add(root);
                    }
                }
            }

        return returnNodes;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
