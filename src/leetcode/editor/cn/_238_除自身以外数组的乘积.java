package editor.cn;

//给你一个整数数组 nums，返回 数组 answer ，其中 answer[i] 等于 nums 中除 nums[i] 之外其余各元素的乘积 。 
//
// 题目数据 保证 数组 nums之中任意元素的全部前缀元素和后缀的乘积都在 32 位 整数范围内。 
//
// 请 不要使用除法，且在 O(n) 时间复杂度内完成此题。 
//
// 
//
// 示例 1: 
//
// 
//输入: nums = [1,2,3,4]
//输出: [24,12,8,6]
// 
//
// 示例 2: 
//
// 
//输入: nums = [-1,1,0,-3,3]
//输出: [0,0,9,0,0]
// 
//
// 
//
// 提示： 
//
// 
// 2 <= nums.length <= 105 
// -30 <= nums[i] <= 30 
// 保证 数组 nums之中任意元素的全部前缀元素和后缀的乘积都在 32 位 整数范围内 
// 
//
// 
//
// 进阶：你可以在 O(1) 的额外空间复杂度内完成这个题目吗？（ 出于对空间复杂度分析的目的，输出数组 不被视为 额外空间。） 
// Related Topics 数组 前缀和 
// 👍 1734 👎 0

import java.util.Arrays;

public class _238_除自身以外数组的乘积 {
    public static void main(String[] args) {
        Solution solution = new _238_除自身以外数组的乘积().new Solution();

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] productExceptSelf(int[] nums) {
            int[] preMult = new int[nums.length + 1];
            int[] res = new int[nums.length];
            preMult[0] = 1;
            boolean zoreExists = false;
            for (int i = 1; i < preMult.length; i++) {
                if (nums[i - 1] == 0) {
                    return dealZore(i - 1, nums);
                }
                preMult[i] = preMult[i - 1] * nums[i - 1];
            }

            for (int i = 0; i < res.length; i++) {
                res[i] = preMult[preMult.length - 1] / nums[i];
            }
            return res;
        }

        public int[] dealZore(int idx, int[] nums) {
            int[] res = new int[nums.length];
            Arrays.fill(res, 0);
            int idxMuti=1;
            for (int i = 0; i < nums.length; i++) {
                if (i != idx) {
                    idxMuti*=nums[i];

                }
                if (idxMuti==0) break;
            }
            res[idx]=idxMuti;
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
