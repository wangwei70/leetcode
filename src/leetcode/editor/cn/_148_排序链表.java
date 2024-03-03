package editor.cn;

//给你链表的头结点 head ，请将其按 升序 排列并返回 排序后的链表 。 
//
// 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：head = [4,2,1,3]
//输出：[1,2,3,4]
// 
//
// 示例 2： 
//
// 
//输入：head = [-1,5,3,4,0]
//输出：[-1,0,3,4,5]
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
// 链表中节点的数目在范围 [0, 5 * 104] 内 
// -105 <= Node.val <= 105 
// 
//
// 
//
// 进阶：你可以在 O(n log n) 时间复杂度和常数级空间复杂度下，对链表进行排序吗？ 
// Related Topics 链表 双指针 分治 排序 归并排序 
// 👍 2248 👎 0

public class _148_排序链表 {
    public static void main(String[] args) {
        Solution solution = new _148_排序链表().new Solution();
        ListNode node = new ListNode(4, new ListNode(2, new ListNode(1, new ListNode(3))));
        ListNode node1 = solution.sortList(node);

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

        // 递归后序位置进行排序，超时，n^2时间复杂度
//        public ListNode sortList(ListNode head) {
//            if (head == null) {
//                return null;
//            }
//            if (head.next == null) {
//                return head;
//            }
//            ListNode node = sortList(head.next);
//
//            ListNode newHead = node;
//            ListNode pre = null;
//            ListNode current = node;
//            while (current != null && head.val >= current.val) {
//                pre = current;
//                current = current.next;
//            }
//            if (pre != null) {
//                pre.next = head;
//            }else {
//                newHead=head;
//            }
//            head.next = current;
//
//            return newHead;
//
//        }

        public ListNode sortList(ListNode head) {
            if (head == null) return null;


//            ListNode current = head;
//            while (current.next != null) {
//                current = current.next;
//            }

            return sortList(head, null);
        }

        public ListNode sortList(ListNode head, ListNode tail) {
            if (head == tail) {
                head.next=null;
                return head;
            }

            ListNode midNode = getMid(head, tail);

            ListNode next = midNode.next;
            ListNode left = sortList(head, midNode);
            ListNode right = sortList(next, tail);
            ListNode merge = merge(left, right);
            return merge;
        }

        int maxIdx = -1;
        int idx = -1;

        private ListNode getMid(ListNode head, ListNode tail) {
             maxIdx = -1;
             idx = -1;
            findMid(head, tail);
            return mid;
        }

        private ListNode merge(ListNode left, ListNode right) {
            ListNode head = new ListNode(-1);
            ListNode l = left;
            ListNode r = right;
            ListNode cur=head;
            while (l != null && r != null) {
                if (l.val<r.val){
                    cur.next=l;
                    l=l.next;
                }else {
                    cur.next=r;
                    r=r.next;
                }
                 cur=cur.next;
            }
            if (l==null){
                cur.next=r;
            }
            if (r==null){
                cur.next=l;
            }
            return head.next;
        }


        ListNode mid = null;

        private void findMid(ListNode node, ListNode tail) {
            maxIdx++;
            idx++;
            if (node == tail) {
                return;
            }
            findMid(node.next, tail);
            idx--;
            if (idx == maxIdx / 2) {
                mid = node;
                return;
            }
        }


    }
//leetcode submit region end(Prohibit modification and deletion)

}
