package offer;

import java.util.Stack;

/**
 * Created by perryFan on 2019/1/29.
 * <p>
 * 用两个栈实现一个队列。队列的声明如下，请实现它的两个函数appendTail和deleteHead，
 * 分别完成在队列尾部插入结点 和 在队列头部删除结点的功能
 */
public class problem_05_TwoStackQueue {
    public static class MList<T> {
        private Stack<T> stack1 = new Stack<>(); // 压入栈
        private Stack<T> stack2 = new Stack<>(); // 弹出栈

        public MList() {
        }

        // 添加操作，在队列尾部插入结点
        public void appendTail(T t) {
            stack1.add(t);
        }

        // 删除操作，在队列头部删除结点
        public T deleteHead() {

            // 先判断弹出栈是否为空，如果为空就将插入栈的所有数据弹出栈
            // 并且将弹出的数据压入弹出栈中。
            if (stack2.isEmpty()) {
                while (!stack1.isEmpty()) {
                    stack2.add(stack1.pop());
                }
            }

            // 如果弹出栈中还没有数据就抛出异常
            if (stack2.isEmpty()) {
                throw new RuntimeException("No more elements.");
            }

            // 返回弹出栈的栈顶元素，对应的就是队首元素
            return stack2.pop();
        }
    }
}
