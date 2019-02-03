package offer;

/**
 * Created by perryFan on 2019/2/3.
 * 题目16：二叉树的镜像
 */
public class problem_16_MirrorOfBinaryTree {
    public static class BinaryTreeNode {
        int value;
        BinaryTreeNode left;
        BinaryTreeNode right;
    }

    public static void mirror(BinaryTreeNode node) {
        if (node != null) {
            BinaryTreeNode tmp = node.left;
            node.left = node.right;
            node.right = tmp;

            mirror(node.left);
            mirror(node.right);
        }
    }
}
