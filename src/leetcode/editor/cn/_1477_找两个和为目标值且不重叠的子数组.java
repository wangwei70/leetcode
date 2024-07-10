package editor.cn;

//给你一个整数数组 arr 和一个整数值 target 。 
//
// 请你在 arr 中找 两个互不重叠的子数组 且它们的和都等于 target 。可能会有多种方案，请你返回满足要求的两个子数组长度和的 最小值 。 
//
// 请返回满足要求的最小长度和，如果无法找到这样的两个子数组，请返回 -1 。 
//
// 
//
// 示例 1： 
//
// 输入：arr = [3,2,2,4,3], target = 3
//输出：2
//解释：只有两个子数组和为 3 （[3] 和 [3]）。它们的长度和为 2 。
// 
//
// 示例 2： 
//
// 输入：arr = [7,3,4,7], target = 7
//输出：2
//解释：尽管我们有 3 个互不重叠的子数组和为 7 （[7], [3,4] 和 [7]），但我们会选择第一个和第三个子数组，因为它们的长度和 2 是最小值。
// 
//
// 示例 3： 
//
// 输入：arr = [4,3,2,6,2,3,4], target = 6
//输出：-1
//解释：我们只有一个和为 6 的子数组。
// 
//
// 示例 4： 
//
// 输入：arr = [5,5,4,4,5], target = 3
//输出：-1
//解释：我们无法找到和为 3 的子数组。
// 
//
// 示例 5： 
//
// 输入：arr = [3,1,1,1,5,1,2,1], target = 3
//输出：3
//解释：注意子数组 [1,2] 和 [2,1] 不能成为一个方案因为它们重叠了。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= arr.length <= 10^5 
// 1 <= arr[i] <= 1000 
// 1 <= target <= 10^8 
// 
// Related Topics 数组 哈希表 二分查找 动态规划 滑动窗口 
// 👍 145 👎 0

import java.util.HashMap;

public class _1477_找两个和为目标值且不重叠的子数组 {
    public static void main(String[] args) {
        Solution solution = new _1477_找两个和为目标值且不重叠的子数组().new Solution();
//        int[] arr={3,2,2,4,3};
//        int target=3;
        int[] arr={3,1,1,1,5,1,2,1};
        int target=3;
        System.out.println(solution.minSumOfLengths(arr, target));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int minSumOfLengths(int[] arr, int target) {
            // 定义一个dp数组，dp[i]表示arr中前i个数中满足target条件的最小子数组长度
            // 假设i为左指针，j为右指针，不断推进j，通过前缀和查询是否存在满足条件的i。
            // 如果i到j满足条件，那么dp[j]=min(dp[j-1],j-i+1)
            // 如果i到j不满足条件，那么dp[j]=dp[j-1];
            // 在右指针推进的过程中，如果找到满足条件的子数组，就更新答案，ans=Math.min(ans,j-i+1+dp[j])

            // key为前缀和，value为索引
            HashMap<Integer, Integer> preSum = new HashMap<>();
            preSum.put(0,0);
            int temp = 0;
            int[] dp = new int[arr.length + 1];
            dp[0] = arr.length;
            int res = Integer.MAX_VALUE;
            for (int i = 0; i < arr.length; i++) {
                temp = temp + arr[i];
                preSum.put(temp, i+1);
                if (preSum.containsKey(temp - target)) {
                    Integer leftIdx = preSum.get(temp - target);
                    int len = i - leftIdx + 1;
                    dp[i + 1] = Math.min(dp[i], len);
                    res = Math.min(res, len + dp[leftIdx]);
                } else {
                    dp[i + 1] = dp[i];
                }
            }
            if (res>arr.length){
                return -1;
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
