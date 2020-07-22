package list;

/**
 * 输入一个链表，反转链表后，输出新链表的表头。
 */
// 2020.2.20
public class ReverseList {
    //迭代
    public ListNode ReverseList(ListNode head) {
        ListNode node = head;
        ListNode pre = null;
        while (node != null) {
            ListNode next = node.next;
            node.next = pre;
            pre = node;
            node = next;
        }
        return pre;
    }

    //递归
    public ListNode ReverseList1(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode node = ReverseList1(head.next);
        head.next.next = head;
        head.next = null;
        return node;
    }
}


class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}