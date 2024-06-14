package editor.cn;

//给定一个 排序好 的数组 arr ，两个整数 k 和 x ，从数组中找到最靠近 x（两数之差最小）的 k 个数。返回的结果必须要是按升序排好的。 
//
// 整数 a 比整数 b 更接近 x 需要满足： 
//
// 
// |a - x| < |b - x| 或者 
// |a - x| == |b - x| 且 a < b 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：arr = [1,2,3,4,5], k = 4, x = 3
//输出：[1,2,3,4]
// 
//
// 示例 2： 
//
// 
//输入：arr = [1,2,3,4,5], k = 4, x = -1
//输出：[1,2,3,4]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= k <= arr.length 
// 1 <= arr.length <= 104 
// arr 按 升序 排列 
// -104 <= arr[i], x <= 104 
// 
// Related Topics 数组 双指针 二分查找 排序 滑动窗口 堆（优先队列） 
// 👍 557 👎 0

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class _658_找到_K_个最接近的元素 {
    public static void main(String[] args) {
        Solution solution = new _658_找到_K_个最接近的元素().new Solution();
        int[] arr={1,2,3,4,5};
        System.out.println(solution.findClosestElements(arr, 4, 3));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<Integer> findClosestElements(int[] arr, int k, int x) {
            int len = arr.length;
            int[] diff = new int[len];
            for (int i = 0; i < len; i++) {
                diff[i] = Math.abs(arr[i] - x);
            }

            int left = 0;
            int right = 0;
            LinkedList<Integer> list = new LinkedList<>();
            LinkedList<Integer> res = new LinkedList<>();
            int winSum = 0;
            int minSum= Integer.MAX_VALUE;
            while (right < len) {
                list.addLast(arr[right]);
                winSum+=diff[right];

                while (right - left + 1 < k) {
                    right++;
                    list.addLast(arr[right]);
                    winSum += diff[right];
                }
                if (winSum<minSum){
                    res.clear();
                    res.addAll(list);
                    minSum=winSum;
                }
                list.removeFirst();
                winSum-=diff[left];
                left++;
                right++;
            }

            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
