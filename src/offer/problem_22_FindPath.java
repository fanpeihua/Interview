package offer;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by perryFan on 2019/2/7.
 * 题目22：输入一棵二叉树和一个整数， 打印出二叉树中结点值的和为输入整数的所有路径。
 * 从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。
 */
public class problem_22_FindPath {
    public static class BinaryTreeNode {
        int value;
        BinaryTreeNode left;
        BinaryTreeNode right;
    }

    /**
     * 输入一棵二叉树和一个整数， 打印出二叉树中结点值的和为输入整数的所有路径。
     * 从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。
     *
     * @param root        树的根结点
     * @param expectedSum 要求的路径和
     */
    public static void findPath(BinaryTreeNode root, int expectedSum) {
        // 创建一个链表，用于存放根结点到当前处理结点的所经过的结点
        List<Integer> list = new ArrayList<>();

        // 如果根结点不为空，就调用辅助处理方法
        if (root != null) {
            findPath(root, 0, expectedSum, list);
        }
    }

    /**
     * @param root        当前要处理的结点
     * @param curSum      当前记录的和（还未加上当前结点的值）
     * @param expectedSum 要求的路径和
     * @param result      根结点到当前处理结点的所经过的结点，（还未包括当前结点）
     */
    public static void findPath(BinaryTreeNode root, int curSum,
                                int expectedSum, List<Integer> result) {
        if (root != null) {
            curSum += root.value;
            result.add(root.value);
            if (curSum < expectedSum) {
                findPath(root.left, curSum, expectedSum, result);
                findPath(root.right, curSum, expectedSum, result);
            } else if (curSum == expectedSum) {
                if (root.left == null && root.right == null) {
                    System.out.println(result);
                }
            }
            result.remove(result.size() - 1);
        }
    }

}
