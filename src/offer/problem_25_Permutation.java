package offer;


/**
 * Created by perryFan on 2019/2/11.
 * 题目25：排列字符串
 * 输入一个字符串，打印出该字符串中字符的所有排列。
 * 例如输入字符串abc。则打印出由字符a、b、c 所能排列出来的所有字符串abc、acb、bac 、bca、cab 和cba 。
 */
public class problem_25_Permutation {
    public static void permutation(char[] chars) {
        if (chars == null || chars.length < 1) {
            return;
        }

        permutation(chars, 0);
    }

    public static void permutation(char[] chars, int begin) {
        if (chars.length - 1 == begin) {
            System.out.print(new String(chars));
        } else {
            char tmp;
            for (int i = begin; i < chars.length; i++) {
                tmp = chars[begin];
                chars[begin] = chars[i];
                chars[i] = tmp;

                permutation(chars, begin + 1);
            }
        }
    }
}
