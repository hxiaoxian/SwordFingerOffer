package tree;

/**
 * 输入一棵二叉树，判断该二叉树是否是平衡二叉树。
 */
// 2020.2.20
// 2020.7.24
public class IsBalanced_Solution {
    private boolean flag = true;

    public boolean IsBalanced_Solution(TreeNode root) {
        help(root);
        return flag;
    }

    private int help(TreeNode root) {
        if (root == null || !flag)
            return 0;
        int left = help(root.left);
        int right = help(root.right);
        if (Math.abs(left - right) > 1)
            flag = false;
        return 1 + Math.max(left, right);
    }

}
