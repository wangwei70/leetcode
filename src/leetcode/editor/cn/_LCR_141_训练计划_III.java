package editor.cn;

//给定一个头节点为 head 的单链表用于记录一系列核心肌群训练编号，请将该系列训练编号 倒序 记录于链表并返回。 
//
// 
//
// 示例 1： 
//
// 
//输入：head = [1,2,3,4,5]
//输出：[5,4,3,2,1]
// 
//
// 
//
// 示例 2： 
//
// 
//输入：head = [1,2]
//输出：[2,1]
// 
//
// 
//
// 示例 3： 
//
// 
//输入：head = []
//输出：[]
// 
//
// 
//
// 提示： 
//
// 
// 链表中节点的数目范围是 [0, 5000] 
// -5000 <= Node.val <= 5000 
// 
//
// 
//
// 注意：本题与主站 206 题相同：https://leetcode-cn.com/problems/reverse-linked-list/ 
//
// 
// Related Topics 递归 链表 
// 👍 632 👎 0

public class _LCR_141_训练计划_III{
	public static void main(String[] args) {
		Solution solution = new _LCR_141_训练计划_III().new Solution();
		
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
class Solution {
	private ListNode last;
    public ListNode trainningPlan(ListNode head) {
    	if (head==null){
    		return null;
		}
		if (head.next == null) {
			last = head;
			return head;
		}
		;
		ListNode newHead = trainningPlan(head.next);
		if (last != null) {
			head.next=null;
			last.next = head;
			last = head;
		}
		return newHead;
    }


}
//leetcode submit region end(Prohibit modification and deletion)

}
