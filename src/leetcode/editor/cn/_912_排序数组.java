package editor.cn;

//给你一个整数数组 nums，请你将该数组升序排列。 
//
// 
//
// 
// 
//
// 示例 1： 
//
// 
//输入：nums = [5,2,3,1]
//输出：[1,2,3,5]
// 
//
// 示例 2： 
//
// 
//输入：nums = [5,1,1,2,0,0]
//输出：[0,0,1,1,2,5]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 5 * 104 
// -5 * 104 <= nums[i] <= 5 * 104 
// 
// Related Topics 数组 分治 桶排序 计数排序 基数排序 排序 堆（优先队列） 归并排序 
// 👍 952 👎 0

import java.util.Arrays;
import java.util.stream.Stream;

public class _912_排序数组 {
    public static void main(String[] args) {
        Solution solution = new _912_排序数组().new Solution();
        int[] nums = {5, 2, 3, 1};
        solution.sortArray(nums);
        for (int num : nums) {
            System.out.println(num);
        }
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        // 归并算法、快速排序
        public int[] sortArray(int[] nums) {
//            temp = new int[nums.length];
//            mergeSort(nums, 0, nums.length - 1);
            quickSort(nums, 0, nums.length - 1);
            return nums;
        }

        private int[] temp;

        // 归并排序
        private void mergeSort(int[] nums, int start, int end) {
            if (start == end) {
                return;
            }

            int mid = (start + end) / 2;
            mergeSort(nums, start, mid);
            mergeSort(nums, mid + 1, end);

            merge(nums, start, mid, end);

        }

        private void merge(int[] nums, int start, int mid, int end) {
            for (int i = start; i <= end; i++) {
                temp[i] = nums[i];
            }
            int left = start;
            int right = mid + 1;
            for (int i = start; i <= end; i++) {

                if (left > mid) {
                    nums[i] = temp[right++];
                } else if (right > end) {
                    nums[i] = temp[left++];
                } else {
                    if (temp[left] < temp[right]) {
                        nums[i] = temp[left++];
                    } else {
                        nums[i] = temp[right++];
                    }
                }

            }
        }


        // 快速排序
        private void quickSort(int[] nums, int start, int end) {
            if (start >= end) {
                return;
            }
            int idx = partition(nums, start, end);
            quickSort(nums, start, idx-1);
            quickSort(nums, idx + 1, end);
        }

        private int partition(int[] nums, int start, int end) {
            int base = nums[start];
            int i = start;
            int j = end;
            while (i < j) {
                while (i < j && nums[j] >= base) {
                    // 后指针找比base小的数
                    j--;
                }
                while (i < j && nums[i] <= base) {
                    // 前指针找比base大的数
                    i++;
                }

                // 大的往后放，小的往前放
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;

            }

            nums[start] = nums[i];
            nums[i] = base;

            return i;
        }
    }


//leetcode submit region end(Prohibit modification and deletion)

}
