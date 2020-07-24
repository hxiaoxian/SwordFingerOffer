package list;


/**
 * 给一个链表，若其中包含环，请找出该链表的环的入口结点，否则，输出null。
 */
// 2020.2.20
// 2020.7.24
public class EntryNodeOfLoop {
    public ListNode EntryNodeOfLoop(ListNode pHead) {
        if (pHead == null || pHead.next == null)
            return null;
        ListNode fast = pHead.next.next;
        ListNode slow = pHead.next;
        //得到环中节点个数
        while (fast != slow) {
            fast = fast.next.next;
            slow = slow.next;
        }
        slow = pHead;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }
}
