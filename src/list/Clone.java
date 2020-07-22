package list;

import java.util.HashMap;

/**
 * 输入一个复杂链表（每个节点中有节点值，以及两个指针，一个指向下一个节点，另一个特殊指针指向任意一个节点）
 * 返回结果为复制后复杂链表的head。（注意，输出结果中请不要返回参数中的节点引用，否则判题程序会直接返回空）
 */
// 哈希表
// 时间复杂度O（N)
// 空间复杂度O（N)

//  1.复制链表节点并链接 2.复制随机指针  3.奇偶拆分链表
// 时间复杂度O（N)
// 空间复杂度O（1)
//
// 2020.2.20
public class Clone {
    public RandomListNode Clone(RandomListNode pHead) {
        if (pHead == null)
            return null;
        HashMap<RandomListNode, RandomListNode> map = new HashMap<>();
        RandomListNode p = pHead;
        while (p != null) {
            map.put(p, new RandomListNode(p.data));
            p = p.next;
        }
        p = pHead;
        while (p != null) {
            map.get(p).next = map.get(p.next);
            map.get(p).random = map.get(p.random);
            p = p.next;
        }
        return map.get(pHead);
    }
}


class RandomListNode {
    int data;
    RandomListNode next = null;
    RandomListNode random = null;

    RandomListNode(int data) {
        this.data = data;
    }
}