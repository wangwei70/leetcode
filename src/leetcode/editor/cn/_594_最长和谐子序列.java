package editor.cn;

//和谐数组是指一个数组里元素的最大值和最小值之间的差别 正好是 1 。 
//
// 现在，给你一个整数数组 nums ，请你在所有可能的子序列中找到最长的和谐子序列的长度。 
//
// 数组的子序列是一个由数组派生出来的序列，它可以通过删除一些元素或不删除元素、且不改变其余元素的顺序而得到。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,3,2,2,5,2,3,7]
//输出：5
//解释：最长的和谐子序列是 [3,2,2,2,3]
// 
//
// 示例 2： 
//
// 
//输入：nums = [1,2,3,4]
//输出：2
// 
//
// 示例 3： 
//
// 
//输入：nums = [1,1,1,1]
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 2 * 104 
// -109 <= nums[i] <= 109 
// 
// Related Topics 数组 哈希表 计数 排序 滑动窗口 
// 👍 402 👎 0

import java.util.Arrays;
import java.util.HashMap;

public class _594_最长和谐子序列 {
    public static void main(String[] args) {
        Solution solution = new _594_最长和谐子序列().new Solution();
        int[] nums={1,3,2,2,5,2,3,7};
        System.out.println(solution.findLHS(nums));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
//        滑动窗口解法
//        public int findLHS(int[] nums) {
//            if (nums.length <= 1) {
//                return 0;
//            }
//            Arrays.sort(nums);
//            int left = 0;
//            int right = 0;
//            int maxWin=0;
//            int curWin=1;
//            while (left <= right&&right<nums.length) {
//                if (nums[right]-nums[left]<=1){
//                    if (nums[right]-nums[left]==1){
//                        maxWin=Math.max(curWin, maxWin);
//                    }
//                    right++;
//                    curWin++;
//                }else {
//                    left++;
//                    curWin--;
//                }
//
//
//            }
//            return maxWin;
//        }

        //hash解法
        public int findLHS(int[] nums) {
            HashMap<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < nums.length; i++) {
                int num = nums[i];
                map.put(num,map.getOrDefault(num,0)+1);
            }
            int max=0;
            for (Integer key : map.keySet()) {
                Integer smaller = map.getOrDefault(key - 1,0);
                Integer biger = map.getOrDefault(key + 1,0);
                if (biger==0&&smaller==0) continue;
                max=Math.max(max,Math.max(smaller,biger)+map.get(key));
            }
            return max;
        }


    }
//leetcode submit region end(Prohibit modification and deletion)

}
