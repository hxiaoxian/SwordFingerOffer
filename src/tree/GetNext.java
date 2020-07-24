package tree;

/**
 * 题目描述
 * 给定一个二叉树和其中的一个结点，请找出中序遍历顺序的下一个结点并且返回。
 * 注意，树中的结点不仅包含左右子结点，同时包含指向父结点的指针。
 */
//分三种情况考虑
// 2020.2.20
// 2020.7.24
public class GetNext {
    public TreeLinkNode GetNext(TreeLinkNode node) {
        if (node.right != null) {
            TreeLinkNode temp = node.right;
            while (temp.left != null)
                temp = temp.left;
            return temp;
        }
        if (node.next != null && node.next.left == node)
            return node.next;
        if (node.next != null) {
            TreeLinkNode father = node.next;
            while (father.next != null && father.next.right == father)
                father = father.next;
            return father.next;
        }
        return null;
    }
}

class TreeLinkNode {
    int val;
    TreeLinkNode left = null;
    TreeLinkNode right = null;
    TreeLinkNode next = null;

    TreeLinkNode(int val) {
        this.val = val;
    }
}