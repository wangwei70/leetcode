package editor.cn;

//给定一个单链表 L 的头节点 head ，单链表 L 表示为： 
//
// 
//L0 → L1 → … → Ln - 1 → Ln
// 
//
// 请将其重新排列后变为： 
//
// 
//L0 → Ln → L1 → Ln - 1 → L2 → Ln - 2 → … 
//
// 不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：head = [1,2,3,4]
//输出：[1,4,2,3] 
//
// 示例 2： 
//
// 
//
// 
//输入：head = [1,2,3,4,5]
//输出：[1,5,2,4,3] 
//
// 
//
// 提示： 
//
// 
// 链表的长度范围为 [1, 5 * 104] 
// 1 <= node.val <= 1000 
// 
// Related Topics 栈 递归 链表 双指针 
// 👍 1431 👎 0

public class _143_重排链表 {
    public static void main(String[] args) {
        Solution solution = new _143_重排链表().new Solution();
        ListNode listNode = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        solution.reorderList(listNode);
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
        public void reorderList(ListNode head) {
            // 快慢指针找到链表中间位置
            ListNode slow = head;
            ListNode quick = head;

            while (slow != null && quick != null) {
                if (quick.next == null) {
                  break;
                }
                slow = slow.next;
                quick = quick.next.next;
            }

            // 根据中间位置拆分成两个链表
            ListNode halfOfBehind = slow.next;
            slow.next = null;

            // 反转后半部分链表
            if (halfOfBehind != null) {
                halfOfBehind = reverse(halfOfBehind);
            }

            // 合并两个链表
            ListNode p1 = head;
            ListNode p2 = halfOfBehind;
            while (p1 != null && p2 != null) {
                ListNode temp1 = p1.next;
                ListNode temp2 = p2.next;
                p2.next = p1.next;
                p1.next = p2;

                p1 = temp1;
                p2 = temp2;
            }
        }

        private ListNode last;

        private ListNode reverse(ListNode head) {
            if (head.next == null) {
                last = head;
                return head;
            }
            ;
            ListNode newHead = reverse(head.next);
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
