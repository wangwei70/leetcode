package editor.cn;

//给你一个二元数组 nums ，和一个整数 goal ，请你统计并返回有多少个和为 goal 的 非空 子数组。 
//
// 子数组 是数组的一段连续部分。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,0,1,0,1], goal = 2
//输出：4
//解释：
//有 4 个满足题目要求的子数组：[1,0,1]、[1,0,1,0]、[0,1,0,1]、[1,0,1]
// 
//
// 示例 2： 
//
// 
//输入：nums = [0,0,0,0,0], goal = 0
//输出：15
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 3 * 104 
// nums[i] 不是 0 就是 1 
// 0 <= goal <= nums.length 
// 
// Related Topics 数组 哈希表 前缀和 滑动窗口 
// 👍 309 👎 0

import java.util.HashMap;

public class _930_和相同的二元子数组 {
    public static void main(String[] args) {
        Solution solution = new _930_和相同的二元子数组().new Solution();
        int[] nums = {0, 0, 0, 0, 0, 0, 1, 0, 0, 0};
        int goal = 0;
        System.out.println(solution.numSubarraysWithSum(nums, goal));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int numSubarraysWithSum(int[] nums, int goal) {
            HashMap<Integer, Integer> preSum = new HashMap<>();
            preSum.put(0, 1);

            int temp = 0;
            int res = 0;
            for (int i = 0; i < nums.length; i++) {
                temp += nums[i];
                if (preSum.containsKey(temp - goal)) {
                    res += preSum.get(temp - goal);
                }
                preSum.put(temp, preSum.getOrDefault(temp, 0) + 1);
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
