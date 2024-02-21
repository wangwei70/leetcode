package editor.cn;

//给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。 
//
// 
//
// 示例 1： 
//
// 
//输入：head = [1,2,3,4,5], n = 2
//输出：[1,2,3,5]
// 
//
// 示例 2： 
//
// 
//输入：head = [1], n = 1
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：head = [1,2], n = 1
//输出：[1]
// 
//
// 
//
// 提示： 
//
// 
// 链表中结点的数目为 sz 
// 1 <= sz <= 30 
// 0 <= Node.val <= 100 
// 1 <= n <= sz 
// 
//
// 
//
// 进阶：你能尝试使用一趟扫描实现吗？ 
// Related Topics 链表 双指针 
// 👍 2778 👎 0

public class _19_删除链表的倒数第N个结点 {
    public static void main(String[] args) {
        Solution solution = new _19_删除链表的倒数第N个结点().new Solution();
        ListNode node55 = new ListNode(5);
        ListNode node44 = new ListNode(4,node55);
        ListNode node33 = new ListNode(3,node44);
        ListNode node22 = new ListNode(2,node33);
        ListNode node11 = new ListNode(1,node22);
        solution.removeNthFromEnd(node11,2);
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
        public ListNode removeNthFromEnd(ListNode head, int n) {
            searchIdx(head, n + 1);
            if (pre != null) {
                if (pre.next!=null){
                    pre.next = pre.next.next;
                }
            } else {
                head = head.next;
            }
            return head;
        }

        private int idx;
        private ListNode pre;

        private void searchIdx(ListNode head, int n) {
            if (head == null) {
                idx = 0;
                return;
            }
            searchIdx(head.next, n);
            idx++;
            if (n == idx) {
                pre = head;
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
