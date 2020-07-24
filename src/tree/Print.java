package tree;


import java.util.*;

/**
 * 题目描述
 * 请实现一个函数按照之字形打印二叉树，
 * 即第一行按照从左到右的顺序打印，第二层按照从右至左的顺序打印，第三行按照从左到右的顺序打印，其他行以此类推。
 */
// 2020.2.20
// 2020.7.23
public class Print {
    // 双栈法,分别存放奇数层和偶数层节点
    public ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        if (pRoot == null)
            return new ArrayList<>();
        Stack<TreeNode> stack1 = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        stack1.push(pRoot);
        boolean level = true;
        while (!stack1.isEmpty() || !stack2.isEmpty()) {
            ArrayList<Integer> temp = new ArrayList<>();
            if (level) {
                temp.clear();
                while (!stack1.isEmpty()) {
                    TreeNode node = stack1.pop();
                    temp.add(node.val);
                    if (node.left != null)
                        stack2.push(node.left);
                    if (node.right != null)
                        stack2.push(node.right);
                }
            } else {
                temp.clear();
                while (!stack2.isEmpty()) {
                    TreeNode node = stack2.pop();
                    temp.add(node.val);
                    if (node.right != null)
                        stack1.push(node.right);
                    if (node.left != null)
                        stack1.push(node.left);
                }
            }
            result.add(temp);
            level = !level;
        }
        return result;
    }

    // 反转法，复杂度较高
    ArrayList<ArrayList<Integer>> Print1(TreeNode pRoot) {
        if (pRoot == null) {
            return new ArrayList<>();
        }
        Queue<TreeNode> queue = new LinkedList();
        ArrayList<ArrayList<Integer>> res = new ArrayList();
        boolean level = false;
        queue.add(pRoot);
        while (!queue.isEmpty()) {
            int size = queue.size();
            ArrayList<Integer> temp = new ArrayList();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                temp.add(node.val);
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            if (level)
                Collections.reverse(temp);
            res.add(temp);
            level = !level;
        }
        return res;
    }

    //头插法
    ArrayList<ArrayList<Integer>> Print2(TreeNode pRoot) {
        if (pRoot == null) {
            return new ArrayList<>();
        }
        Queue<TreeNode> queue = new LinkedList();
        ArrayList<ArrayList<Integer>> res = new ArrayList();
        boolean level = false;
        queue.add(pRoot);
        while (!queue.isEmpty()) {
            int size = queue.size();
            ArrayList<Integer> temp = new ArrayList();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (level)
                    temp.add(0, node.val);
                else
                    temp.add(node.val);
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            res.add(temp);
            level = !level;
        }
        return res;
    }

}
