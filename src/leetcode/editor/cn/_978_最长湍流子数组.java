package editor.cn;

//给定一个整数数组 arr ，返回 arr 的 最大湍流子数组的长度 。 
//
// 如果比较符号在子数组中的每个相邻元素对之间翻转，则该子数组是 湍流子数组 。 
//
// 更正式地来说，当 arr 的子数组 A[i], A[i+1], ..., A[j] 满足仅满足下列条件时，我们称其为湍流子数组： 
//
// 
// 若 i <= k < j ：
//
// 
// 当 k 为奇数时， A[k] > A[k+1]，且 
// 当 k 为偶数时，A[k] < A[k+1]； 
// 
// 
// 或 若 i <= k < j ：
// 
// 当 k 为偶数时，A[k] > A[k+1] ，且 
// 当 k 为奇数时， A[k] < A[k+1]。 
// 
// 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：arr = [9,4,2,10,7,8,8,1,9]
//输出：5
//解释：arr[1] > arr[2] < arr[3] > arr[4] < arr[5] 
//
// 示例 2： 
//
// 
//输入：arr = [4,8,12,16]
//输出：2
// 
//
// 示例 3： 
//
// 
//输入：arr = [100]
//输出：1
// 
//
// 
//
// 提示： 
//
// 
// 1 <= arr.length <= 4 * 104 
// 0 <= arr[i] <= 109 
// 
// Related Topics 数组 动态规划 滑动窗口 
// 👍 250 👎 0

public class _978_最长湍流子数组 {
    public static void main(String[] args) {
        Solution solution = new _978_最长湍流子数组().new Solution();
//        int[] arr = {9, 4, 2, 10, 7, 8, 8, 1, 9};
        int[] arr = {100,100,100};
        System.out.println(solution.maxTurbulenceSize(arr));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxTurbulenceSize(int[] arr) {
            int n = arr.length;
            if (n < 2) {
                return n;
            }
            if (n == 2) {
                return arr[0] == arr[1] ? 1 : n;
            }
            int left = 0;
            int right = 1;
            int lastNum = arr[left];
            // true表示下一个数要比前一个大，false表示下一个数比前一个数小
            Boolean biggerOrSmaller = arr[right] > lastNum;
            int maxLen = 0;
            int winLen = 2;
            while (right < n) {
                // 不满足湍流子数组条件
                if (!((biggerOrSmaller && arr[right] > lastNum) || (!biggerOrSmaller && arr[right] < lastNum))) {
                    if (lastNum == arr[right]) {
                        left = right;
                        lastNum = arr[right];
                        right++;
                        winLen = 2;
                        if (right < n) {
                            biggerOrSmaller = arr[right] > lastNum;
                        }
                        continue;
                    } else {
                        winLen = 2;
                        left = right - 1;
                        lastNum = arr[left];
                        biggerOrSmaller = arr[right] > lastNum;
                        continue;
                    }
                }
                maxLen = Math.max(maxLen, winLen);
                biggerOrSmaller = !biggerOrSmaller;
                lastNum = arr[right];
                winLen++;
                right++;

            }
            return maxLen==0?1:maxLen;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
