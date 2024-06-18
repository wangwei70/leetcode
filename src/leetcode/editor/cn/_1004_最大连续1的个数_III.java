package editor.cn;

//给定一个二进制数组 nums 和一个整数 k，如果可以翻转最多 k 个 0 ，则返回 数组中连续 1 的最大个数 。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,1,1,0,0,0,1,1,1,1,0], K = 2
//输出：6
//解释：[1,1,1,0,0,1,1,1,1,1,1]
//粗体数字从 0 翻转到 1，最长的子数组长度为 6。 
//
// 示例 2： 
//
// 
//输入：nums = [0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1], K = 3
//输出：10
//解释：[0,0,1,1,1,1,1,1,1,1,1,1,0,0,0,1,1,1,1]
//粗体数字从 0 翻转到 1，最长的子数组长度为 10。 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 105 
// nums[i] 不是 0 就是 1 
// 0 <= k <= nums.length 
// 
// Related Topics 数组 二分查找 前缀和 滑动窗口 
// 👍 703 👎 0

public class _1004_最大连续1的个数_III{
	public static void main(String[] args) {
		Solution solution = new _1004_最大连续1的个数_III().new Solution();
		int[] nums={0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1};
		System.out.println(solution.longestOnes(nums, 3));
	}
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int longestOnes(int[] nums, int k) {
		int n = nums.length;
		int left=0;
		int right=0;
		int maxLen=0;
		int zeroCount=0;
		while (right<n){
			if (nums[right]==0){
				zeroCount++;
			}
			while (zeroCount>k){
				if (nums[left]==0){
					zeroCount--;
				}
				left++;
			}
			maxLen=Math.max(maxLen, right-left+1);
			right++;
		}
		return maxLen;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
