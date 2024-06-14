package editor.cn;

//给你一个整数数组 nums ，找到其中最长严格递增子序列的长度。 
//
// 子序列 是由数组派生而来的序列，删除（或不删除）数组中的元素而不改变其余元素的顺序。例如，[3,6,2,7] 是数组 [0,3,1,6,2,2,7] 的子
//序列。 
// 
//
// 示例 1： 
//
// 
//输入：nums = [10,9,2,5,3,7,101,18]
//输出：4
//解释：最长递增子序列是 [2,3,7,101]，因此长度为 4 。
// 
//
// 示例 2： 
//
// 
//输入：nums = [0,1,0,3,2,3]
//输出：4
// 
//
// 示例 3： 
//
// 
//输入：nums = [7,7,7,7,7,7,7]
//输出：1
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 2500 
// -104 <= nums[i] <= 104 
// 
//
// 
//
// 进阶： 
//
// 
// 你能将算法的时间复杂度降低到 O(n log(n)) 吗? 
// 
// Related Topics 数组 二分查找 动态规划 
// 👍 3646 👎 0

public class _300_最长递增子序列 {
    public static void main(String[] args) {
        Solution solution = new _300_最长递增子序列().new Solution();
//        int[] nums={7,7,7,7,7,7,7};
        int[] nums={10,9,2,5,3,7,101,18};
        System.out.println(solution.lengthOfLIS(nums));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int lengthOfLIS(int[] nums) {
            int[] mem = new int[nums.length];
            mem[nums.length - 1] = 1;
            int res=1;
            for (int i = nums.length - 2; i >= 0; i--) {
                int temp= 0;
                for (int j = i + 1; j < nums.length; j++) {
                    if (nums[i] < nums[j]){
                        temp=Math.max(temp, mem[j]);
                    }
                }
                mem[i]=temp+1;
                res=Math.max(mem[i],res);
            }

            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
