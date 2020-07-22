package tree;

/**
 * 题目描述
 * 给定一棵二叉搜索树，请找出其中的第k小的结点。
 * 例如，（5，3，7，2，4，6，8）中，按结点数值大小顺序第三小结点的值为4。
 */
// 2020.2.20
public class KthNode {
    TreeNode result;
    int n;

    TreeNode KthNode(TreeNode pRoot, int k) {
        inOrder(pRoot, k);
        return result;
    }

    private void inOrder(TreeNode pRoot, int k) {
        if (pRoot == null || n > k)
            return;
        inOrder(pRoot.left, k);
        n++;
        if (n == k)
            result = pRoot;
        inOrder(pRoot.right, k);
    }

}
