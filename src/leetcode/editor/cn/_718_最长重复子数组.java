package editor.cn;

//给两个整数数组 nums1 和 nums2 ，返回 两个数组中 公共的 、长度最长的子数组的长度 。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums1 = [1,2,3,2,1], nums2 = [3,2,1,4,7]
//输出：3
//解释：长度最长的公共子数组是 [3,2,1] 。
// 
//
// 示例 2： 
//
// 
//输入：nums1 = [0,0,0,0,0], nums2 = [0,0,0,0,0]
//输出：5
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums1.length, nums2.length <= 1000 
// 0 <= nums1[i], nums2[i] <= 100 
// 
// Related Topics 数组 二分查找 动态规划 滑动窗口 哈希函数 滚动哈希 
// 👍 1090 👎 0

public class _718_最长重复子数组 {
    public static void main(String[] args) {
        Solution solution = new _718_最长重复子数组().new Solution();
        int nums1[]={1,2,3,2,1};
        int nums2[]={3,2,1,4,7};
        System.out.println(solution.findLength(nums1, nums2));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int findLength(int[] nums1, int[] nums2) {

            int n1 = nums1.length;
            int n2 = nums2.length;
            int[][] dp = new int[n1][n2];
            int max=0;
            for (int i = 0; i < n2; i++) {
                dp[n1 - 1][i] = nums1[n1 - 1] == nums2[i] ? 1 : 0;
                max=Math.max(max,dp[n1 - 1][i]);
            }

            for (int i = 0; i < n1; i++) {
                dp[i][n2 - 1] = nums1[i] == nums2[n2 - 1] ? 1 : 0;
                max=Math.max(max,dp[i][n2 - 1]);
            }

            for (int i = n1 - 2; i >= 0; i--) {
                for (int j = n2 - 2; j >= 0; j--) {
                    if (nums1[i] == nums2[j]) {
                        dp[i][j] = dp[i + 1][j + 1] + 1;
                    } else {
                        dp[i][j] = 0;
                    }
                    max=Math.max(max,dp[i][j]);
                }
            }
            return max;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
