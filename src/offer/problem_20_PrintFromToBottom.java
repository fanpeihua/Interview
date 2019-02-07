package offer;


import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by perryFan on 2019/2/7.
 * 题目20：上往下打印出二叉树的每个结点，同一层的结点按照从左向右的顺序打印。
 */
public class problem_20_PrintFromToBottom {
    public static class BinaryTreeNode {
        int value;
        BinaryTreeNode left;
        BinaryTreeNode right;
    }

    public static void printFromToBottom(BinaryTreeNode root) {
        if (root != null) {
            // 用于存放还未遍历的元素
            Queue<BinaryTreeNode> list = new LinkedList<>();
            // 将根结点入队
            list.add(root);
            // 用于记录当前处理的结点
            BinaryTreeNode curNode;

            // 队列非空则进行处理
            while (!list.isEmpty()) {
                // 删除队首元素
                curNode = list.remove();
                System.out.println(curNode.value + " ");

                // 如果左子结点不为空，则左子结点入队
                if (curNode.left != null) {
                    list.add(curNode.left);
                }
                if (curNode.left != null) {
                    list.add(curNode.right);
                }
            }
        }
    }
}
