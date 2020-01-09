package sort;

/**
 * 题目描述
 * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
 * 输入一个非递减排序的数组的一个旋转，输出旋转数组的最小元素。
 * 例如数组{3,4,5,1,2}为{1,2,3,4,5}的一个旋转，该数组的最小值为1。
 * NOTE：给出的所有元素都大于0，若数组大小为0，请返回0。
 */
public class minNumberInRotateArray {
    public int minNumberInRotateArray(int[] array) {
        int start = 0;
        int end = array.length - 1;
        int index = start;
        while (array[start] >= array[end]) {
            if (end - start == 1) {
                index = end;
                break;
            }
            index = (start + end) >>> 1;
            // 三个值都相同则进行顺序查找
            if (array[start] == array[index] && array[index] == array[end])
                return help(array, start, end);
            if (array[index] >= array[end]) {
                start = index;
            } else {
                end = index;
            }
        }
        return array[index];
    }

    private int help(int[] array, int left, int right) {
        int result = array[left];
        for (int i = left + 1; i <= right; i++) {
            if (array[i] < result)
                result = array[i];
        }
        return result;
    }
}

