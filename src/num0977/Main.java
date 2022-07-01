package num0977;

import java.util.Arrays;

/**
 * @author niewenlong
 * @description 977. 有序数组的平方
 * @leetCodeUrl <a href="https://leetcode.cn/problems/squares-of-a-sorted-array">...</a>
 */
public class Main {
    public int[] sortedSquares(int[] nums) {
        int leftIndex = 0;
        int rightIndex = nums.length - 1;
        int newIndex = rightIndex;
        int[] result = new int[nums.length];
        while (leftIndex <= rightIndex) {
            int left = nums[leftIndex] * nums[leftIndex];
            int right = nums[rightIndex] * nums[rightIndex];
            if (left < right) {
                result[newIndex--] = right;
                rightIndex--;
            } else {
                result[newIndex--] = left;
                leftIndex++;
            }
        }
        return result;
    }


    public static void main(String[] args) {
        Main main = new Main();
        System.out.println(Arrays.toString(main.sortedSquares(new int[]{-7, -3, 2, 3, 11})));
    }
}