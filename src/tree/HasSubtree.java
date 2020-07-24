package tree;

/**
 * 题目描述
 * 输入两棵二叉树A，B，判断B是不是A的子结构。（ps：我们约定空树不是任意一个树的子结构）
 */
// 2020.2.20
// 2020.7.24
public class HasSubtree {
    public boolean HasSubtree(TreeNode root1, TreeNode root2) {
        if (root1 == null || root2 == null)
            return false;
        return HasSubtree(root1.left, root2) || HasSubtree(root1.right, root2) || HasNext(root1, root2);
    }

    private boolean HasNext(TreeNode root1, TreeNode root2) {
        if (root2 == null)
            return true;
        if (root1 == null)
            return false;
        if (root1.val != root2.val)
            return false;
        return HasNext(root1.left, root2.left) && HasNext(root1.right, root2.right);
    }
}
