package sort;

/**
 *
 */
// 快排思想：在数组中选择一个数，接下来把数组分为两部分，比选择的数小的数字移到数组的左边
// 比选择的数大的数字移到数组的右边
//  数组本身已经排好序，而每一轮排序时都以最后一个数字作为比较的标准，此时快排效率只有O（N^2）
// 2020.2.20
public class quicksort {
    // 递归版本快排
    public void quicksort(int[] arr, int left, int right) {
        if (left > right)
            return;
        int i = left;
        int j = right;
        int key = arr[left];
        while (i < j) {
            while (i < j && key <= arr[j])
                j--;
            arr[i] = arr[j];
            while (i < j && key >= arr[i])
                i++;
            arr[j] = arr[i];
        }
        arr[i] = key;
        quicksort(arr, left, i - 1);
        quicksort(arr, i + 1, right);
    }
}
