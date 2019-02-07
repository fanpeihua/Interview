package offer;

import java.util.Stack;

/**
 * Created by perryFan on 2019/2/7.
 * 题目18：定义栈的数据结构，请在该类型中实现一个能够得到栈的最小数的min 函数。
 * 在该栈中，调用min、push 及pop的时间复杂度都是O(1)。
 */
public class problem_18_MinStack {
    private Stack<Integer> stack = new Stack<Integer>();
    //辅助栈：栈顶永远保存stack中当前的最小的元素
    private Stack<Integer> minStack = new Stack<Integer>();

    public void push(int data) {
        stack.push(data); // 直接往栈中添加数据
        if (minStack.size() == 0 || data < minStack.peek()) {
            minStack.push(data);
        } else {
            minStack.add(minStack.peek()); // peek方法返回的是栈顶的元素
        }
    }

    public int pop() throws Exception {
        if (stack.size() == 0) {
            throw new Exception("栈中为空");
        }
        int data = stack.pop();
        minStack.pop();  // 核心代码
        return data;
    }

    public int min() throws Exception {
        if (minStack.size() == 0) {
            throw new Exception("栈中空了");
        }
        return minStack.peek();
    }
}
