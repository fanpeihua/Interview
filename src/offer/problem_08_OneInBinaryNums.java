package offer;

/**
 * Created by perryFan on 2019/1/31.
 * 题目08：二进制中1的个数
 * 请实现一个函数，输入一个整数，输出该数二进制表示中1的个数。例如把9表示成二进制1001，有2位1。
 * 因此如果输入9，该函数输出2。
 */
public class problem_08_OneInBinaryNums {

    public static int numberOfOne(int n) {
        int result = 0;

        for (int i = 0; i < 32; i++) {
            result += (n & 1);
            n >>>= 1;
        }
        return result;
    }

    public static int numberOfOne2(int n) {
        int result = 0;
        while (n != 0) {
            result++;
            n = (n - 1) & n;
        }
        return result;
    }
}
