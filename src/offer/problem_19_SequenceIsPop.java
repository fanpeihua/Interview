package offer;

import java.util.Stack;

/**
 * Created by perryFan on 2019/2/7.
 * 题目19：输入两个整数序列，第一个序列表示栈的压入顺序，请判断二个序列是否为该栈的弹出顺序。
 * 假设压入栈的所有数字均不相等。
 */
public class problem_19_SequenceIsPop {
    public static boolean sequeseIsPop(int[] data1, int[] data2) {
        Stack<Integer> stack = new Stack<Integer>();

        for (int i = 0; i < data1.length; i++) {
            stack.push(data1[i]);

            while (stack.size() > 0 && stack.peek() == data2[i]) {
                stack.pop();
                i++;
            }
        }
        return stack.size() == 0;
    }
}
