package editor.cn;

//给你一个整数数组 nums 和两个整数 firstLen 和 secondLen，请你找出并返回两个非重叠 子数组 中元素的最大和，长度分别为 firstL
//en 和 secondLen 。 
//
// 长度为 firstLen 的子数组可以出现在长为 secondLen 的子数组之前或之后，但二者必须是不重叠的。 
//
// 子数组是数组的一个 连续 部分。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [0,6,5,2,2,5,1,9,4], firstLen = 1, secondLen = 2
//输出：20
//解释：子数组的一种选择中，[9] 长度为 1，[6,5] 长度为 2。
// 
//
// 示例 2： 
//
// 
//输入：nums = [3,8,1,3,2,1,8,9,0], firstLen = 3, secondLen = 2
//输出：29
//解释：子数组的一种选择中，[3,8,1] 长度为 3，[8,9] 长度为 2。
// 
//
// 示例 3： 
//
// 
//输入：nums = [2,1,5,6,0,9,5,0,3,8], firstLen = 4, secondLen = 3
//输出：31
//解释：子数组的一种选择中，[5,6,0,9] 长度为 4，[0,3,8] 长度为 3。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= firstLen, secondLen <= 1000 
// 2 <= firstLen + secondLen <= 1000 
// firstLen + secondLen <= nums.length <= 1000 
// 0 <= nums[i] <= 1000 
// 
// Related Topics 数组 动态规划 滑动窗口 
// 👍 278 👎 0

public class _1031_两个非重叠子数组的最大和 {
    public static void main(String[] args) {
        Solution solution = new _1031_两个非重叠子数组的最大和().new Solution();
//        int[] nums={0,6,5,2,2,5,1,9,4};
        int[] nums={1,0,1};
        System.out.println(solution.maxSumTwoNoOverlap(nums, 1, 1));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxSumTwoNoOverlap(int[] nums, int firstLen, int secondLen) {
            // preSum[i]表示nums中前i个数的和（前缀和）
            //dp1[i]表示nums中0到i的子数组中长度为firstLen的子数组的最大和（子数组的子数组最大和）
            //dp2[i]表示nums中0到i的子数组中长度为secondLen的子数组的最大和（子数组的子数组最大和）
            //dp3[i]表示nums中0到i的子数组中长度为secondLen和firstLen的子数组的最大和（子数组的子数组最大和）
            int n = nums.length;
            int[] preSum = new int[n+1];
            int[] dp1 = new int[n+1];
            int[] dp2 = new int[n+1];
            int[] dp3 = new int[n+1];


            for (int i = 1; i <= n; i++) {
                preSum[i] = preSum[i-1] + nums[i-1];
                if (i  >= firstLen) {
                    // 长度为firstLen的最大值有两种选择：不包含当前位置的子集和、包含当前位置的子集和
                    dp1[i] = Math.max(dp1[i - 1], preSum[i] - (i - firstLen < 0 ? 0 : preSum[i - firstLen]));
                }

                if (i  >= secondLen) {
                    // 长度为firstLen的最大值有两种选择：不包含当前位置的子集和、包含当前位置的子集和
                    dp2[i] = Math.max(dp2[i - 1], preSum[i] - (i - secondLen < 0 ? 0 : preSum[i - secondLen]));
                }

                if (i  >= firstLen + secondLen) {
                    // 包含两个符合长度的子集最大值有三种选择：不包括当前位置的子集和即dp3[i-1]、包含当前子集并且firstLen在前、包含当前子集并且firstLen在后
                    dp3[i] = Math.max(dp3[i - 1], preSum[i] - preSum[i - firstLen] + dp2[i - firstLen]);
                    dp3[i] = Math.max(dp3[i], preSum[i] - preSum[i - secondLen] + dp1[i - secondLen]);
                }
            }
            return dp3[n];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
