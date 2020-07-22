package list;


/**
 * 输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。要求不能创建任何新的结点，只能调整树中结点指针的指向。
 */
// 2020.2.20
public class Convert {
    TreeNode root;
    TreeNode pre;

    public TreeNode Convert(TreeNode pRootOfTree) {
        help(pRootOfTree);
        return root;
    }

    private void help(TreeNode pRootOfTree) {
        if (pRootOfTree == null)
            return;
        help(pRootOfTree.left);
        if (pre == null) {
            pre = pRootOfTree;
            root = pRootOfTree;
        } else {
            pRootOfTree.left = pre;
            pre.right = pRootOfTree;
            pre = pRootOfTree;
        }
        help(pRootOfTree.right);
    }
}


class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;
    }
}