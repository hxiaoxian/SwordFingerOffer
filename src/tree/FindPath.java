package tree;

import java.util.ArrayList;

/**
 * 输入一颗二叉树的根节点和一个整数，打印出二叉树中结点值的和为输入整数的所有路径。
 * 路径定义为从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。(注意: 在返回值的list中，数组长度大的数组靠前)
 */
// 2020.2.20
public class FindPath {
    ArrayList<ArrayList<Integer>> result = new ArrayList<>();

    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
        backtrace(root, target, new ArrayList<>());
        return result;
    }

    private void backtrace(TreeNode root, int target, ArrayList<Integer> list) {
        if (root == null || target < 0)
            return;
        list.add(root.val);
        target -= root.val;
        if (root.left == null && root.right == null && target == 0)
            result.add(new ArrayList<>(list));
        else {
            backtrace(root.left, target, list);
            backtrace(root.right, target, list);
        }
        list.remove(list.size() - 1);
    }

}

