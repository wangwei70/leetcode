package editor.cn;

//给你一个链表的头节点 head 和一个特定值 x ，请你对链表进行分隔，使得所有 小于 x 的节点都出现在 大于或等于 x 的节点之前。 
//
// 你应当 保留 两个分区中每个节点的初始相对位置。 
//
// 
//
// 示例 1： 
//
// 
//输入：head = [1,4,3,2,5,2], x = 3
//输出：[1,2,2,4,3,5]
// 
//
// 示例 2： 
//
// 
//输入：head = [2,1], x = 2
//输出：[1,2]
// 
//
// 
//
// 提示： 
//
// 
// 链表中节点的数目在范围 [0, 200] 内 
// -100 <= Node.val <= 100 
// -200 <= x <= 200 
// 
// Related Topics 链表 双指针 
// 👍 806 👎 0

public class _86_分隔链表 {
    public static void main(String[] args) {
        Solution solution = new _86_分隔链表().new Solution();
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(5,node1);
        ListNode node3 = new ListNode(2,node2);
        ListNode node4 = new ListNode(3,node3);
        ListNode node5 = new ListNode(4,node4);
        ListNode node6 = new ListNode(1,node5);

        solution.partition(node6,3);
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
        public ListNode partition(ListNode head, int x) {
            ListNode lower = new ListNode(-1);
            ListNode l = lower;

            ListNode higher = new ListNode(-1);
            ListNode h = higher;

            // 原链表指针
            ListNode temp = head;

            while (temp != null) {
                if (temp.val < x) {
                    l.next = temp;
                    l = l.next;
                } else {
                    h.next = temp;
                    h = h.next;
                }
                temp = temp.next;
            }

            l.next = higher.next;
            h.next=null;
            return lower.next;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
