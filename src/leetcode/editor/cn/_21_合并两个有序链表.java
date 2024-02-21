package editor.cn;

//将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。 
//
// 
//
// 示例 1： 
//
// 
//输入：l1 = [1,2,4], l2 = [1,3,4]
//输出：[1,1,2,3,4,4]
// 
//
// 示例 2： 
//
// 
//输入：l1 = [], l2 = []
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：l1 = [], l2 = [0]
//输出：[0]
// 
//
// 
//
// 提示： 
//
// 
// 两个链表的节点数目范围是 [0, 50] 
// -100 <= Node.val <= 100 
// l1 和 l2 均按 非递减顺序 排列 
// 
// Related Topics 递归 链表 
// 👍 3406 👎 0

public class _21_合并两个有序链表 {
    public static void main(String[] args) {
        Solution solution = new _21_合并两个有序链表().new Solution();
        ListNode node3 = new ListNode(4);
        ListNode node2 = new ListNode(2,node3);
        ListNode node1 = new ListNode(1,node2);
        ListNode node33 = new ListNode(4);
        ListNode node22 = new ListNode(3,node33);
        ListNode node11 = new ListNode(1,node22);
        solution.mergeTwoLists(node1,node11);
    }
//leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode() {}
     * ListNode(int val) { this.val = val; }
     * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */
    class Solution {
        public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
            ListNode l = list1;
            ListNode r = list2;
            ListNode head = new ListNode(-1);
            ListNode last = head;
            while (l != null || r != null) {
                if (l == null) {
                    last.next = r;
                    break;
                } else if (r == null) {
                    last.next = l;
                    break;
                } else if (l.val <= r.val) {
                    last.next = l;
                    l = l.next;
                } else {
                    last.next = r;
                    r = r.next;
                }
                last=last.next;
            }
            return head.next;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
