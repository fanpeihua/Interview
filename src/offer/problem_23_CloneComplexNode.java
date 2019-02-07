package offer;

/**
 * Created by perryFan on 2019/2/7.
 */
public class problem_23_CloneComplexNode {

    /**
     * 复杂链表结点
     */
    public static class ComplexListNode {
        int value;
        ComplexListNode next;
        ComplexListNode sibling;
    }

    /**
     * 实现函复制一个复杂链表。在复杂链表中，每个结点除了有一个next字段指向下一个结点外，
     * 还有一个sibling字段指向链表中的任意结点或者NULL
     *
     * @param head 链表表头结点
     * @return 复制结点的头结点
     */
    public static ComplexListNode clone(ComplexListNode head) {
        // 如果链表为空就直接返回空
        if (head == null) {
            return null;
        }

        // 先复制结点
        cloneNodes(head);
        // 再链接sibling字段
        connectNodes(head);
        // 将整个链表拆分，返回复制链表的头结点
        return reconnectNodes(head);
    }

    /**
     * 复制一个链表，并且将复制后的结点插入到被复制的结点后面，只链接复制结点的next字段
     *
     * @param head 待复制链表的头结点
     */
    public static void cloneNodes(ComplexListNode head) {
        // 如果链表不空，进行复制操作
        while (head != null) {
            // 创建一个新的结点
            ComplexListNode tmp = new ComplexListNode();
            // 将被复制结点的值传给复制结点
            tmp.value = head.value;
            // 复制结点的next指向下一个要被复制的结点
            tmp.next = head.next;
            // 被复制结点的next指向复制结点
            head.next = tmp;
            // 到些处就已经完成了一个结点的复制并且插入到被复制结点的后面
            // heed指向下一个被复制结点的位置
            head = tmp.next;
        }
    }

    /**
     * 设置复制结点的sibling字段
     *
     * @param head 链表的头结
     */
    public static void connectNodes(ComplexListNode head) {
        // 如链表不为空
        while (head != null) {
            // 当前处理的结点sibling字段不为空，则要设置其复制结点的sibling字段
            if (head.sibling != null) {
                // 复制结点的sibling指向被复制结点的sibling字段的下一个结点
                // head.next：表求复制结点，
                // head.sibling：表示被复制结点的sibling所指向的结点，
                // 它的下一个结点就是它的复制结点
                head.next.sibling = head.sibling.next;
            }
            // 指向下一个要处理的复制结点
            head = head.next.next;
        }
    }

    /**
     * 刚复制结点和被复制结点拆开，还原被复制的链表，同时生成复制链表
     *
     * @param head 链表的头结点
     * @return 复制链表的头结点
     */
    public static ComplexListNode reconnectNodes(ComplexListNode head) {

        // 当链表为空就直接返回空
        if (head == null) {
            return null;
        }

        // 用于记录复制链表的头结点
        ComplexListNode newHead = head.next;
        // 用于记录当前处理的复制结点
        ComplexListNode pointer = newHead;
        // 被复制结点的next指向下一个原链表结点
        head.next = newHead.next;
        // 指向新的被复制结点
        head = head.next;

        while (head != null) {
            // pointer指向复制结点
            pointer.next = head.next;
            pointer = pointer.next;
            // head的下一个指向复制结点的下一个结点，即原来链表的结点
            head.next = pointer.next;
            // head指向下一个原来链表上的结点
            head = pointer.next;
        }

        // 返回复制链表的头结点
        return newHead;
    }

}
