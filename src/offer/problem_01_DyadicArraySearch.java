package offer;

/**
 * Created by perryFan on 2019/1/28.
 * <p>
 * 题目01：二维数组中的查找
 * 在一个二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。
 * 请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 */
public class problem_01_DyadicArraySearch {

    public static boolean find(int[][] matrix, int number) {
        if (matrix == null || matrix.length < 1 || matrix[0].length < 1) {
            return false;
        }

        int rows = matrix.length;   // 数组的行数
        int cols = matrix[1].length; // 数组行的列数

        int row = 0;
        int col = cols - 1;// 起始开始的序号

        while (row >= 0 && row < rows && col >= 0 && col < cols) {
            if (matrix[row][col] == number) {  // 如果找到了就直接退出
                return true;
            } else if (matrix[row][col] > number) { // 如果找到的数比要找的数大，说明要找的数在当前数的左边
                col--;  // 列数减一，代表向左移动
            } else {    // 如果找到的数比要找的数小，说明要找的数在当前数的下边。
                row++;  // 行数加一，代表向下移动
            }
        }
        return false;
    }
}
