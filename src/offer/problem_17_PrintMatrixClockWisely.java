package offer;

/**
 * Created by perryFan on 2019/2/3.
 */
public class problem_17_PrintMatrixClockWisely {

    public static void printlnMatrixClockWisely(int[][] numbers) {
        if (numbers == null) {
            return;
        }

        int x = 0;
        int y = 0;

        while (x * 2 < numbers.length && y * 2 < numbers[0].length) {
            printMatrixInCircle(numbers, x, y);
        }
    }

    public static void printMatrixInCircle(int[][] numbers, int x, int y) {
        int rows = numbers.length;
        int cols = numbers[0].length;

        for (int i = y; i <= cols - y - 1; i++) {
            System.out.println(numbers[x][i] + " ");
        }

        if (rows - x - 1 > x) {
            for (int i = x + 1; i <= rows - x - 1; i++) {
                System.out.println(numbers[i][cols - y - 1] + " ");
            }
        }

        if (rows - x - 1 > x && cols - 1 - y > y) {
            for (int i = cols - y - 2; i >= y; i--) {
                System.out.println(numbers[rows - 1 - x][i] + "");
            }
        }

        if (cols - 1 - y > y && rows - 1 - x > x + 1) {
            for (int i = rows - 1 - x - 1; i >= x + 1; i--) {
                System.out.println(numbers[i][y] + " ");
            }
        }
    }
}
