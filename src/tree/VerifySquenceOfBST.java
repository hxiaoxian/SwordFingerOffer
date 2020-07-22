package tree;


/**
 * 题目描述
 * 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。
 * 如果是则输出Yes,否则输出No。假设输入的数组的任意两个数字都互不相同。
 */

// 类比前序遍历
// 2020.2.20
public class VerifySquenceOfBST {
    public boolean VerifySquenceOfBST(int[] sequence) {
        if (sequence.length == 0 || sequence == null)
            return false;
        return help(sequence, 0, sequence.length - 1);
    }

    private boolean help(int[] sequence, int start, int end) {
        if (start >= end)
            return true;
        int i;
        // 根节点，利用二叉搜索树 左子树节点值都小于根结点，右子树结点值都大于根节点，进行递归判断。
        int root = sequence[end];
        for (i = start; i < end; i++) {
            if (sequence[i] > root)
                break;
        }
        for (int j = i; j < end; j++) {
            if (sequence[j] < root)
                return false;
        }
        return help(sequence, start, i - 1) && help(sequence, i, end - 1);
    }
}
