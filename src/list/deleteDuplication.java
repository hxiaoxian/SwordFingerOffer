package list;

/**
 * 在一个排序的链表中，存在重复的结点，请删除该链表中重复的结点，重复的结点不保留，返回链表头指针。
 * 例如，链表1->2->3->3->4->4->5 处理后为 1->2->5
 */
// 2020.2.20
public class deleteDuplication {
    // 递归
    public ListNode deleteDuplication(ListNode pHead) {
        if (pHead == null || pHead.next == null)
            return pHead;
        ListNode next = pHead.next;
        if (pHead.val == next.val) {
            while (next != null && pHead.val == next.val) {
                next = next.next;
            }
            return deleteDuplication(next);
        } else {
            pHead.next = deleteDuplication(pHead.next);
            return pHead;
        }
    }


    // 迭代
    public ListNode deleteDuplication1(ListNode pHead) {
        if (pHead == null || pHead.next == null)
            return pHead;
        ListNode dummy = new ListNode(-1);
        dummy.next = pHead;
        ListNode pre = dummy;
        ListNode cur = dummy.next;
        while (cur != null) {
            if (cur.next != null && cur.val == cur.next.val) {
                while (cur.next != null && cur.val == cur.next.val)
                    cur = cur.next;
                cur = cur.next;
                pre.next = cur;
            } else {
                pre = pre.next;
                cur = cur.next;
            }
        }
        return dummy.next;
    }
}
