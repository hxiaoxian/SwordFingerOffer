package list;

/**
 * 输入一个链表，输出该链表中倒数第k个结点。
 */
// 2020.2.20
public class FindKthToTail {
    public ListNode FindKthToTail(ListNode head, int k) {
        if (head == null)
            return null;
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && k-- > 0) {
            fast = fast.next;
        }
        if (k > 0)
            return null;
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }
}
