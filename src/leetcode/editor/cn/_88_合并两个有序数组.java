package editor.cn;

//给你两个按 非递减顺序 排列的整数数组 nums1 和 nums2，另有两个整数 m 和 n ，分别表示 nums1 和 nums2 中的元素数目。 
//
// 请你 合并 nums2 到 nums1 中，使合并后的数组同样按 非递减顺序 排列。 
//
// 注意：最终，合并后数组不应由函数返回，而是存储在数组 nums1 中。为了应对这种情况，nums1 的初始长度为 m + n，其中前 m 个元素表示应合并
//的元素，后 n 个元素为 0 ，应忽略。nums2 的长度为 n 。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
//输出：[1,2,2,3,5,6]
//解释：需要合并 [1,2,3] 和 [2,5,6] 。
//合并结果是 [1,2,2,3,5,6] ，其中斜体加粗标注的为 nums1 中的元素。
// 
//
// 示例 2： 
//
// 
//输入：nums1 = [1], m = 1, nums2 = [], n = 0
//输出：[1]
//解释：需要合并 [1] 和 [] 。
//合并结果是 [1] 。
// 
//
// 示例 3： 
//
// 
//输入：nums1 = [0], m = 0, nums2 = [1], n = 1
//输出：[1]
//解释：需要合并的数组是 [] 和 [1] 。
//合并结果是 [1] 。
//注意，因为 m = 0 ，所以 nums1 中没有元素。nums1 中仅存的 0 仅仅是为了确保合并结果可以顺利存放到 nums1 中。
// 
//
// 
//
// 提示： 
//
// 
// nums1.length == m + n 
// nums2.length == n 
// 0 <= m, n <= 200 
// 1 <= m + n <= 200 
// -109 <= nums1[i], nums2[j] <= 109 
// 
//
// 
//
// 进阶：你可以设计实现一个时间复杂度为 O(m + n) 的算法解决此问题吗？ 
// Related Topics 数组 双指针 排序 
// 👍 2337 👎 0

import java.util.Arrays;

public class _88_合并两个有序数组 {
    public static void main(String[] args) {
        Solution solution = new _88_合并两个有序数组().new Solution();
        int[] nums1 = {2, 0};
        int m = 1;
        int[] nums2 = {1};
        int n = 1;
        solution.merge(nums1, m, nums2, n);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public void merge(int[] nums1, int m, int[] nums2, int n) {
            int[] temp = Arrays.copyOf(nums1, nums1.length);
            int idx = 0;
            int idx1 = 0;
            int idx2 = 0;
            while (idx1 < m && idx2 < n) {
                if (temp[idx1] > nums2[idx2]) {
                    nums1[idx] = nums2[idx2];
                    idx2++;
                } else {
                    nums1[idx] = temp[idx1];
                    idx1++;
                }
                idx++;
            }
            if (idx1 >= m) {
                for (int i = idx2; i < n; i++) {
                    nums1[idx] = nums2[i];
                    idx++;
                }
            } else {
                for (int i = idx1; i < m ; i++) {
                    nums1[idx] = temp[i];
                    idx++;
                }
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
