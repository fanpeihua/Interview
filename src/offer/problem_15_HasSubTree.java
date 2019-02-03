package offer;

/**
 * Created by perryFan on 2019/2/3.
 * 题目15：树的子结构
 * 输入两个二叉树A和B，判断B是不是A 的子结构
 */
public class problem_15_HasSubTree {
    public static class BinaryTreeNode {
        int value;
        BinaryTreeNode left;
        BinaryTreeNode right;
    }

    public static boolean hasSubTree(BinaryTreeNode root1, BinaryTreeNode root2) {
        if (root1 == root2) {
            return true;
        }
        if (root2 == null) {
            return true;
        }
        if (root1 == null) {
            return false;
        }
        boolean result = false;

        if (root1.value == root2.value) {
            result = match(root1, root2);
        }
        if (result) {
            return true;
        }
        return hasSubTree(root1.left, root2) || hasSubTree(root1.right, root2);
    }

    public static boolean match(BinaryTreeNode root1, BinaryTreeNode root2) {
        if (root1 == root2) {
            return true;
        }
        if (root2 == null) {
            return false;
        }
        if (root1.value == root2.value) {
            return match(root1.left, root2.left) && match(root1.right, root2.right);
        }
        return false;
    }


}
