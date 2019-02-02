package offer;

/**
 * Created by perryFan on 2019/2/1.
 * 题目13：反转单链表
 */
public class problem_13_ReverseList {

    public static class Node {
        Node nextNode;
    }

    private static Node reverseHead(Node head) {
        if (head == null) {
            return head;
        }
        Node pre = head;
        Node cur = head.nextNode;
        Node next = null;
        while (cur != null) {
            next = cur.nextNode;
            cur.nextNode = pre;
            pre = cur;
            cur = next;
        }
        head.nextNode = null;
        head = pre;
        return head;
    }
}
