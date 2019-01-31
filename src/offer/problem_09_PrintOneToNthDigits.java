package offer;

/**
 * Created by perryFan on 2019/1/31.
 * 题目09：输入数字n，按顺序打印出从1到n位最大十进制的数值。
 * 比如输入3，则打印出1、2、3一直到最大三位数即999
 */
public class problem_09_PrintOneToNthDigits {

    public static void printOneToNthDigits(int n) {
        if (n < 1) {
            throw new RuntimeException("The input number must larger than 0");
        }
        int[] arr = new int[n];
        printOneToNthDigits(0, arr);
    }

    /**
     * 输入数字n，按顺序打印出从1到最大的n位十进制数
     *
     * @param n    当前处理的是第 n 个元素，从0开始计数
     * @param arr  存放结果的数组
     */
    public static void printOneToNthDigits(int n, int[] arr) {
        if (n >= arr.length) {
            printArray(arr);
        } else {
            for (int i = 0; i <= 9; i++) {
                arr[n] = i;
                printOneToNthDigits(n + 1, arr);
            }
        }
    }

    public static void printArray(int[] arr) {
        // 找第一个非0的元素
        int index = 0;
        while (index < arr.length && arr[index] == 0) {
            index++;
        }

        // 从第一个非0值到开始输出到最后的元素。
        for (int i = index; i < arr.length; i++) {
            System.out.print(arr[i]);
        }

        // 条件成立说明数组中有非零元素，所以需要换行
        if (index < arr.length) {
            System.out.println();
        }
    }
}
