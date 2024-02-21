package editor.cn;

//给定一个单链表的头节点 head ，其中的元素 按升序排序 ，将其转换为高度平衡的二叉搜索树。 
//
// 本题中，一个高度平衡二叉树是指一个二叉树每个节点 的左右两个子树的高度差不超过 1。 
//
// 
//
// 示例 1: 
//
// 
//
// 
//输入: head = [-10,-3,0,5,9]
//输出: [0,-3,9,-10,null,5]
//解释: 一个可能的答案是[0，-3,9，-10,null,5]，它表示所示的高度平衡的二叉搜索树。
// 
//
// 示例 2: 
//
// 
//输入: head = []
//输出: []
// 
//
// 
//
// 提示: 
//
// 
// head 中的节点数在[0, 2 * 104] 范围内 
// -105 <= Node.val <= 105 
// 
// Related Topics 树 二叉搜索树 链表 分治 二叉树 
// 👍 880 👎 0

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class _109_有序链表转换二叉搜索树 {
    public static void main(String[] args) {
        Solution solution = new _109_有序链表转换二叉搜索树().new Solution();
        ListNode listNode = new ListNode(-10, new ListNode(-3, new ListNode(0, new ListNode(5, new ListNode(9)))));
        TreeNode node = solution.sortedListToBST(listNode);
    }
//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
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
        public TreeNode sortedListToBST(ListNode head) {
            ListNode p = head;
            ArrayList<Integer> integers = new ArrayList<>();
            while (p != null) {
                integers.add(p.val);
                p = p.next;
            }
            Integer[] nums = integers.toArray(new Integer[0]);
            return generateTree(nums,0,nums.length-1);

        }

        private TreeNode generateTree(Integer[] nums, int start, int end) {
            if (start>end){
                return null;
            }
            if (start==end){
                return new TreeNode(nums[start]);
            }
            int mid=(end+start)/2;
            TreeNode left = generateTree(nums, start, mid - 1);
            TreeNode right = generateTree(nums,mid + 1, end);
            TreeNode node =new  TreeNode(nums[mid]);
            node.left=left;
            node.right=right;
            return node;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
