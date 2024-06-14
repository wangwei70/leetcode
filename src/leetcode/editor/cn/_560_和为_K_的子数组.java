package editor.cn;

//给你一个整数数组 nums 和一个整数 k ，请你统计并返回 该数组中和为 k 的子数组的个数 。 
//
// 子数组是数组中元素的连续非空序列。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,1,1], k = 2
//输出：2
// 
//
// 示例 2： 
//
// 
//输入：nums = [1,2,3], k = 3
//输出：2
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 2 * 104 
// -1000 <= nums[i] <= 1000 
// -107 <= k <= 107 
// 
// Related Topics 数组 哈希表 前缀和 
// 👍 2277 👎 0

public class _560_和为_K_的子数组 {
    public static void main(String[] args) {
        Solution solution = new _560_和为_K_的子数组().new Solution();

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int subarraySum(int[] nums, int k) {
            int[] preSums = new int[nums.length + 1];
            for (int i = 0; i < nums.length; i++) {
                preSums[i + 1] = nums[i] + preSums[i];
            }

            int count = 0;
            for (int i = 0; i < preSums.length; i++) {
                for (int j = i + 1; j < preSums.length; j++) {
                    if (preSums[j] - preSums[i] == k) {
                        count++;
                    }
                }
            }
            return count;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
