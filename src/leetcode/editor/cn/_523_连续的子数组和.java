package editor.cn;

//给你一个整数数组 nums 和一个整数 k ，编写一个函数来判断该数组是否含有同时满足下述条件的连续子数组： 
//
// 
// 子数组大小 至少为 2 ，且 
// 子数组元素总和为 k 的倍数。 
// 
//
// 如果存在，返回 true ；否则，返回 false 。 
//
// 如果存在一个整数 n ，令整数 x 符合 x = n * k ，则称 x 是 k 的一个倍数。0 始终视为 k 的一个倍数。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [23,2,4,6,7], k = 6
//输出：true
//解释：[2,4] 是一个大小为 2 的子数组，并且和为 6 。 
//
// 示例 2： 
//
// 
//输入：nums = [23,2,6,4,7], k = 6
//输出：true
//解释：[23, 2, 6, 4, 7] 是大小为 5 的子数组，并且和为 42 。 
//42 是 6 的倍数，因为 42 = 7 * 6 且 7 是一个整数。
// 
//
// 示例 3： 
//
// 
//输入：nums = [23,2,6,4,7], k = 13
//输出：false
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 105 
// 0 <= nums[i] <= 109 
// 0 <= sum(nums[i]) <= 231 - 1 
// 1 <= k <= 231 - 1 
// 
// Related Topics 数组 哈希表 数学 前缀和 
// 👍 561 👎 0

import java.util.HashMap;

public class _523_连续的子数组和 {
    public static void main(String[] args) {
        Solution solution = new _523_连续的子数组和().new Solution();
        int[] nums={23,2,4,6,7};
        solution.checkSubarraySum(nums,6);
    }


    // 超时，双层for循环遍历前缀和，时间复杂度O(n^2)
    //leetcode submit region begin(Prohibit modification and deletion)
//    class Solution {
//        public boolean checkSubarraySum(int[] nums, int k) {
//            int[] preSums = new int[nums.length + 1];
//            for (int i = 0; i < nums.length; i++) {
//                preSums[i + 1] = preSums[i] + nums[i];
//            }
//
//            for (int i = 1; i < preSums.length; i++) {
//                for (int j = i+1; j < preSums.length; j++) {
//                    if ((preSums[j]-preSums[i-1])%k==0){
//                        return true;
//                    }
//                }
//            }
//
//            return false;
//        }
//    }

    class Solution {
        public boolean checkSubarraySum(int[] nums, int k) {
            int[] preSums = new int[nums.length + 1];
            for (int i = 0; i < nums.length; i++) {
                preSums[i + 1] = preSums[i] + nums[i];
            }

            HashMap<Integer, Integer> complementMapIdx = new HashMap<>();

            for (int i = 0; i < preSums.length; i++) {
                int complement = preSums[i] % k;
                if (complementMapIdx.containsKey(complement)) {
                    if (i-complementMapIdx.get(complement)>1){
                        return true;
                    }
                }else {
                    complementMapIdx.put(complement,i);
                }
            }

            return false;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
