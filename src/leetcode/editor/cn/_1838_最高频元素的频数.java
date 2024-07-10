package editor.cn;

//元素的 频数 是该元素在一个数组中出现的次数。 
//
// 给你一个整数数组 nums 和一个整数 k 。在一步操作中，你可以选择 nums 的一个下标，并将该下标对应元素的值增加 1 。 
//
// 执行最多 k 次操作后，返回数组中最高频元素的 最大可能频数 。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,2,4], k = 5
//输出：3
//解释：对第一个元素执行 3 次递增操作，对第二个元素执 2 次递增操作，此时 nums = [4,4,4] 。
//4 是数组中最高频元素，频数是 3 。 
//
// 示例 2： 
//
// 
//输入：nums = [1,4,8,13], k = 5
//输出：2
//解释：存在多种最优解决方案：
//- 对第一个元素执行 3 次递增操作，此时 nums = [4,4,8,13] 。4 是数组中最高频元素，频数是 2 。
//- 对第二个元素执行 4 次递增操作，此时 nums = [1,8,8,13] 。8 是数组中最高频元素，频数是 2 。
//- 对第三个元素执行 5 次递增操作，此时 nums = [1,4,13,13] 。13 是数组中最高频元素，频数是 2 。
// 
//
// 示例 3： 
//
// 
//输入：nums = [3,9,6], k = 2
//输出：1
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 105 
// 1 <= nums[i] <= 105 
// 1 <= k <= 105 
// 
// Related Topics 贪心 数组 二分查找 前缀和 排序 滑动窗口 
// 👍 301 👎 0

import java.util.Arrays;

public class _1838_最高频元素的频数 {
    public static void main(String[] args) {
        Solution solution = new _1838_最高频元素的频数().new Solution();
//        for (int i = 0; i < 3000; i++) {
//            System.out.print("1,");
//        }
        int[] nums = new int[30000];
        Arrays.fill(nums, 1);
        nums[nums.length-1]=100000;
        int k = 1;
//        int[] nums = {3, 9, 6};
//        int k = 2;
        System.out.println(solution.maxFrequency(nums, k));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxFrequency(int[] nums, int k) {
            Arrays.sort(nums);
            int left = 0;
            int res = 1;
            long K=k;
            for (int right = 1; right < nums.length; right++) {
                K -= (long)(right - left) * (nums[right] - nums[right - 1]);
                while (K < 0) {
                    K += nums[right] - nums[left];
                    left++;
                }
                res = Math.max(res, right - left + 1);

            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
