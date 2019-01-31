package offer;

/**
 * Created by perryFan on 2019/1/30.
 * 题目07： 斐波那契数列
 */
public class problem_07_FibonacciArray {

    public static long fibonacci(int n) {
        if (n <= 0) {
            return 0;
        }
        if (n == 1 || n == 2) {
            return 1;
        }

        // 第n-2个 Fibonacci数的值
        long prePre = 1;
        // 第n-1个 Fibonacci数的值
        long pre = 1;
        long current = 2;

        // 求解第n个 Fibonacci数的值
        for (int i = 3; i < n; i++) {
            // 求第i个 Fibonacci数的值
            current = prePre + pre;
            // 更新记录的结果，prePre原先记录第i-2个 Fibonacci数的值
            // 现在记录第i-1个Fibonacci数的值
            prePre = pre;
            // 更新记录的结果，pre原先记录第i-1个 Fibonacci数的值
            // 现在记录第i个Fibonacci数的值
            pre = current;
        }

        // 返回所求的结果
        return current;
    }
}
