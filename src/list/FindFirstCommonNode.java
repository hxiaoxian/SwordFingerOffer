package list;

/**
 * 输入两个链表，找出它们的第一个公共结点。
 * <p>
 * 蛮力法O（mn）
 * 辅助栈O(m+n) 额外空间
 * 遍历法O(m+n)
 */
// 2020.2.20
public class FindFirstCommonNode {
    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        ListNode p1 = pHead1;
        ListNode p2 = pHead2;
        while (p1 != p2) {
            p1 = (p1 == null) ? pHead2 : p1.next;
            p2 = (p2 == null) ? pHead1 : p2.next;
        }
        return p1;
    }
}
