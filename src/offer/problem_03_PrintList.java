package offer;

import java.util.Stack;

/**
 * Created by perryFan on 2019/1/29.
 * 题目03：从尾到头打印链表
 * 输入个链表的头结点，从尾到头反过来打印出每个结点的值
 *
 */
public class problem_03_PrintList {
    /**
     * 结点对象
     */
    public static class ListNode {
        int val;    // 结点的值
        ListNode next; // 下一个结点
    }


    /**
     * 输入个链表的头结点，从尾到头反过来打印出每个结点的值
     * 使用栈的方式进行
     *
     * @param root
     */
    public static void printListInverselyUsingIteration(ListNode root) {
        Stack<ListNode> stack = new Stack<>();
        while (root != null) {
            stack.push(root);
            root = root.next;
        }
        ListNode tmp;
        while (!stack.isEmpty()) {
            tmp = stack.pop();
            System.out.println(tmp.val + " ");
        }
    }

    /**
     * 输入个链表的头结点，从尾到头反过来打印出每个结点的值
     * 使用递归的方式进行
     *
     * @param root
     */
    public static void printListInverselyUsingRecurion(ListNode root) {
        if (root != null) {
            printListInverselyUsingIteration(root);
            System.out.println(root.val + " ");
        }
    }


    public static void main(String[] args) {
        ListNode node = new ListNode();
        node.val = 1;
        node.next = new ListNode();
        node.next.val = 2;
        node.next.next = new ListNode();
        node.next.next.val = 3;
        problem_03_PrintList.printListInverselyUsingIteration(node);
    }

}
