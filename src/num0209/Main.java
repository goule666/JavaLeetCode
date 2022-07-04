package num0209;


/**
 * @author niewenlong
 * @description 209. 长度最小的子数组
 * @leetCodeUrl <a href="https://leetcode.cn/problems/minimum-size-subarray-sum">...</a>
 */
public class Main {
    public int minSubArrayLen(int target, int[] nums) {
        int result = 0;
        int sum;
        for (int i = 0; i < nums.length; i++) {
            sum = 0;
            for (int j = i; j < nums.length; j++) {
                sum += nums[j];
                if (sum >= target) {
                    if (result != 0) {
                        result = Math.min((j - i + 1), result);
                    } else {
                        result = j - i + 1;
                    }
                    break;
                }
            }
        }
        return result;
    }


    public static void main(String[] args) {
        Main main = new Main();
        main.minSubArrayLen(7, new int[]{});
    }
}