package editor.cn;

//给定整数数组 nums 和整数 k，请返回数组中第 k 个最大的元素。 
//
// 请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。 
//
// 你必须设计并实现时间复杂度为 O(n) 的算法解决此问题。 
//
// 
//
// 示例 1: 
//
// 
//输入: [3,2,1,5,6,4], k = 2
//输出: 5
// 
//
// 示例 2: 
//
// 
//输入: [3,2,3,1,2,4,5,5,6], k = 4
//输出: 4 
//
// 
//
// 提示： 
//
// 
// 1 <= k <= nums.length <= 105 
// -104 <= nums[i] <= 104 
// 
// Related Topics 数组 分治 快速选择 排序 堆（优先队列） 
// 👍 2384 👎 0

public class _215_数组中的第K个最大元素 {
    public static void main(String[] args) {
        Solution solution = new _215_数组中的第K个最大元素().new Solution();
        int[] nums={2,1};
        solution.findKthLargest(nums,2);
        for (int num : nums) {
            System.out.println(num);
        }
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int findKthLargest(int[] nums, int k) {
            if (nums.length==1)  return 1;
            quickSort(nums,0,nums.length-1,nums.length-k);
            return nums[nums.length-k];
        }

        private void quickSort(int[] nums, int start, int end, int k) {
            if (start >= end) {
                return;
            };

            int base = nums[start];
            int l = start;
            int r = end;
            while (l < r) {
                while (l < r && nums[r] >= base) {
                    r--;
                }
                while (l < r && nums[l] <= base) {
                    l++;
                }

                if (l != r) {
                    int temp = nums[l];
                    nums[l] = nums[r];
                    nums[r] = temp;
                }
            }

            nums[start] = nums[l];
            nums[l] = base;
//            if (l == k) {
//                return;
//            }

            quickSort(nums, start, l - 1, k);
            quickSort(nums, l + 1, end, k);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
