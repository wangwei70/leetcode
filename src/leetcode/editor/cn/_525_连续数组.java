package editor.cn;

//给定一个二进制数组 nums , 找到含有相同数量的 0 和 1 的最长连续子数组，并返回该子数组的长度。 
//
// 
//
// 示例 1: 
//
// 
//输入: nums = [0,1]
//输出: 2
//说明: [0, 1] 是具有相同数量 0 和 1 的最长连续子数组。 
//
// 示例 2: 
//
// 
//输入: nums = [0,1,0]
//输出: 2
//说明: [0, 1] (或 [1, 0]) 是具有相同数量0和1的最长连续子数组。 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 105 
// nums[i] 不是 0 就是 1 
// 
// Related Topics 数组 哈希表 前缀和 
// 👍 720 👎 0

public class _525_连续数组 {
    public static void main(String[] args) {
        Solution solution = new _525_连续数组().new Solution();
//        int[] nums = {0, 1};
        int[] nums = {0, 0, 1, 0, 0, 0, 1, 1};
        solution.findMaxLength(nums);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        //暴力破解，超时
//        public int findMaxLength(int[] nums) {
//            int n=0;
//            for (int i = 0; i < nums.length; i++) {
//                int sum = 0;
//                for (int j = i; j < nums.length; j++) {
//                    sum += nums[j];
//                    // 区间长度为偶数并且这段区间值的和为长度的一半
//                    int lenth = j - i + 1;
//                    if ((lenth & 1) == 0 && lenth == sum * 2) {
//                        n=Math.max(n,lenth);
//                    }
//                }
//            }
//            return n;
//        }

        // 前缀和优化
        public int findMaxLength(int[] nums) {

            int[] preSum = new int[nums.length + 1];
            for (int i = 1; i < preSum.length; i++) {
                preSum[i] = preSum[i - 1] + nums[i - 1];
            }

            int n = 0;
            for (int i = 1; i < preSum.length; i++) {
                if (preSum.length - i <= n) break;
                for (int j = preSum.length - 1; j >= 1; j--) {
                    int sum = preSum[j] - preSum[i - 1];
                    // 区间长度为偶数并且这段区间值的和为长度的一半
                    int lenth = j - i + 1;
                    if (lenth < n) break;
                    if ((lenth & 1) == 0 && lenth == sum * 2) {
                        n = Math.max(n, lenth);
                        break;
                    }
                }
            }
            return n;
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}
