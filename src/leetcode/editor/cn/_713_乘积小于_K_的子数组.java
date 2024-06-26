package editor.cn;

//给你一个整数数组 nums 和一个整数 k ，请你返回子数组内所有元素的乘积严格小于 k 的连续子数组的数目。
// 
//
// 示例 1： 
//
// 
//输入：nums = [10,5,2,6], k = 100
//输出：8
//解释：8 个乘积小于 100 的子数组分别为：[10]、[5]、[2],、[6]、[10,5]、[5,2]、[2,6]、[5,2,6]。
//需要注意的是 [10,5,2] 并不是乘积小于 100 的子数组。
// 
//
// 示例 2： 
//
// 
//输入：nums = [1,2,3], k = 0
//输出：0 
//
// 
//
// 提示: 
//
// 
// 1 <= nums.length <= 3 * 104 
// 1 <= nums[i] <= 1000 
// 0 <= k <= 106 
// 
// Related Topics 数组 滑动窗口 
// 👍 784 👎 0

public class _713_乘积小于_K_的子数组 {
    public static void main(String[] args) {
        Solution solution = new _713_乘积小于_K_的子数组().new Solution();
        int[] nums = {10, 9, 10, 4, 3, 8, 3, 3, 6, 2, 10, 10, 9, 3};
        System.out.println(solution.numSubarrayProductLessThanK(nums, 19));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int numSubarrayProductLessThanK(int[] nums, int k) {
            int n = nums.length;
            int left = 0;
            int right = 0;
            int count = 0;
            int winMuti = 1;
            while (right < n) {
                winMuti = winMuti * nums[right];
                while (winMuti >= k && left <= right) {

                    winMuti = winMuti / nums[left];
                    left++;
                }
                count += right - left + 1;
                right++;


            }
            return count;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
