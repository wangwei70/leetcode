package editor.cn;

//给你一个二进制数组 nums ，你需要从中删掉一个元素。 
//
// 请你在删掉元素的结果数组中，返回最长的且只包含 1 的非空子数组的长度。 
//
// 如果不存在这样的子数组，请返回 0 。 
//
// 
//
// 提示 1： 
//
// 
//输入：nums = [1,1,0,1]
//输出：3
//解释：删掉位置 2 的数后，[1,1,1] 包含 3 个 1 。 
//
// 示例 2： 
//
// 
//输入：nums = [0,1,1,1,0,1,1,0,1]
//输出：5
//解释：删掉位置 4 的数字后，[0,1,1,1,1,1,0,1] 的最长全 1 子数组为 [1,1,1,1,1] 。 
//
// 示例 3： 
//
// 
//输入：nums = [1,1,1]
//输出：2
//解释：你必须要删除一个元素。 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 105 
// nums[i] 要么是 0 要么是 1 。 
// 
// Related Topics 数组 动态规划 滑动窗口 
// 👍 132 👎 0

public class _1493_删掉一个元素以后全为1的最长子数组 {
    public static void main(String[] args) {
        Solution solution = new _1493_删掉一个元素以后全为1的最长子数组().new Solution();
        int[] nums = {0, 1, 1, 1, 0, 1, 1, 0, 1};
        System.out.println(solution.longestSubarray(nums));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int longestSubarray(int[] nums) {
            int n = nums.length;
            int[] preSum = new int[n + 1];
            int left = 0;
            int res = 0;

            for (int right = 0; right < n; right++) {
                //前缀和
                preSum[right + 1] = preSum[right] + nums[right];

                int sum = preSum[right + 1] - preSum[left];
                int len = right - left + 1;
                // sum<len-1表示只有至少有2个0
                while (left < right && sum < len - 1) {
                    left++;
                    sum = preSum[right + 1] - preSum[left];
                    len = right - left + 1;
                }
                res = Math.max(len - 1, res);
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
