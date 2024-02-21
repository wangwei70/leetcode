package editor.cn;

//某公司架构以二叉树形式记录，请返回该公司的层级数。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：root = [1, 2, 2, 3, null, null, 5, 4, null, null, 4]
//输出: 4
//解释: 上面示例中的二叉树的最大深度是 4，沿着路径 1 -> 2 -> 3 -> 4 或 1 -> 2 -> 5 -> 4 到达叶节点的最长路径上有 4 
//个节点。
// 
//
// 
//
// 提示： 
//
// 
// 节点总数 <= 10000 
// 
//
// 注意：本题与主站 104 题相同：https://leetcode-cn.com/problems/maximum-depth-of-binary-tre
//e/ 
//
// 
// Related Topics 树 深度优先搜索 广度优先搜索 二叉树 
// 👍 268 👎 0

import com.sun.org.apache.regexp.internal.RE;

public class _LCR_175_计算二叉树的深度{
	public static void main(String[] args) {
		Solution solution = new _LCR_175_计算二叉树的深度().new Solution();
		
	}
//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int calculateDepth(TreeNode root) {
    	if (root==null) return 0;
		int leftDepth = calculateDepth(root.left);
		int rightDepth = calculateDepth(root.right);

		return Math.max(leftDepth,rightDepth)+1;
	}
}
//leetcode submit region end(Prohibit modification and deletion)

}
