package offer;

/**
 * Created by perryFan on 2019/1/31.
 * 题目11：调整数组顺序使奇数位于偶数前面
 */
public class problem_11_ReorderOddEven {

    public static void reorderOddEven(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }

        // 从左向右记录偶数的位置
        int start = 0;
        // 从右向左记录奇数的位置
        int end = arr.length - 1;

        while (start < end) {

            // 找偶数
            while (start < end && arr[start] % 2 != 0) {
                start++;
            }
            // 找奇数
            while (start < end && arr[start] % 2 != 0) {
                end--;
            }

            // 找到后就将奇数和偶数交换位置
            int tmp = arr[start];
            arr[start] = arr[end];
            arr[end] = tmp;
        }
    }

}
