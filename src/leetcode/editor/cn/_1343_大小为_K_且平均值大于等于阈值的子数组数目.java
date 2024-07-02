package editor.cn;

//给你一个整数数组 arr 和两个整数 k 和 threshold 。 
//
// 请你返回长度为 k 且平均值大于等于 threshold 的子数组数目。 
//
// 
//
// 示例 1： 
//
// 
//输入：arr = [2,2,2,2,5,5,5,8], k = 3, threshold = 4
//输出：3
//解释：子数组 [2,5,5],[5,5,5] 和 [5,5,8] 的平均值分别为 4，5 和 6 。其他长度为 3 的子数组的平均值都小于 4 （thres
//hold 的值)。
// 
//
// 示例 2： 
//
// 
//输入：arr = [11,13,17,23,29,31,7,5,2,3], k = 3, threshold = 5
//输出：6
//解释：前 6 个长度为 3 的子数组平均值都大于 5 。注意平均值不是整数。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= arr.length <= 105 
// 1 <= arr[i] <= 104 
// 1 <= k <= arr.length 
// 0 <= threshold <= 104 
// 
// Related Topics 数组 滑动窗口 
// 👍 58 👎 0

public class _1343_大小为_K_且平均值大于等于阈值的子数组数目{
	public static void main(String[] args) {
		Solution solution = new _1343_大小为_K_且平均值大于等于阈值的子数组数目().new Solution();
		int[] arr={2,2,2,2,5,5,5,8};
        System.out.println(solution.numOfSubarrays(arr, 3, 4));
    }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int numOfSubarrays(int[] arr, int k, int threshold) {
        int n = arr.length;
        int[] preSum = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            preSum[i]=preSum[i-1]+arr[i-1];
        }

        int count=0;
        int baseSum = k * threshold;
        for (int i = 0; i <= n-k; i++) {
            int sum=preSum[i+k]-preSum[i];
            if (sum>=baseSum){
                count++;
            }
        }
        return count;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
