package num0059;

import java.util.Arrays;

/**
 * @author niewenlong
 * @date 2022/7/11 12:50
 * @description 59. 螺旋矩阵 II
 * @leetCodeUrl <a href="https://leetcode.cn/problems/spiral-matrix-ii">...</a>
 **/
public class Main {
    public int[][] generateMatrix(int n) {
        //循环次数
        int loop = n / 2;
        int[][] result = new int[n][n];
        int startIndexY = 0;
        int startIndexX = 0;
        int num = 1;
        if ((n & 1) == 1) {
            result[loop][loop] = n * n;
        }
        for (int i = 0; i < loop; i++) {
            //从左到右
            for (; startIndexY < n - i - 1; startIndexY++) {
                result[startIndexX][startIndexY] = num++;
            }

            //从上到下
            for (; startIndexX < n - i - 1; startIndexX++) {
                result[startIndexX][startIndexY] = num++;
            }

            //从右到左
            for (; startIndexY > i; startIndexY--) {
                result[startIndexX][startIndexY] = num++;
            }

            //从下到上
            for (; startIndexX > i; startIndexX--) {
                result[startIndexX][startIndexY] = num++;
            }
            startIndexX++;
            startIndexY++;
        }

        return result;
    }

    public static void main(String[] args) {
        Main main = new Main();
        System.out.println(Arrays.deepToString(main.generateMatrix(20)));
    }
}
