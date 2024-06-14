package editor.cn;

//给你一个 下标从 0 开始 的正整数数组 w ，其中 w[i] 代表第 i 个下标的权重。 
//
// 请你实现一个函数 pickIndex ，它可以 随机地 从范围 [0, w.length - 1] 内（含 0 和 w.length - 1）选出并返回一
//个下标。选取下标 i 的 概率 为 w[i] / sum(w) 。 
//
// 
// 
//
// 
// 例如，对于 w = [1, 3]，挑选下标 0 的概率为 1 / (1 + 3) = 0.25 （即，25%），而选取下标 1 的概率为 3 / (1 +
// 3) = 0.75（即，75%）。 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：
//["Solution","pickIndex"]
//[[[1]],[]]
//输出：
//[null,0]
//解释：
//Solution solution = new Solution([1]);
//solution.pickIndex(); // 返回 0，因为数组中只有一个元素，所以唯一的选择是返回下标 0。 
//
// 示例 2： 
//
// 
//输入：
//["Solution","pickIndex","pickIndex","pickIndex","pickIndex","pickIndex"]
//[[[1,3]],[],[],[],[],[]]
//输出：
//[null,1,1,1,1,0]
//解释：
//Solution solution = new Solution([1, 3]);
//solution.pickIndex(); // 返回 1，返回下标 1，返回该下标概率为 3/4 。
//solution.pickIndex(); // 返回 1
//solution.pickIndex(); // 返回 1
//solution.pickIndex(); // 返回 1
//solution.pickIndex(); // 返回 0，返回下标 0，返回该下标概率为 1/4 。
//
//由于这是一个随机问题，允许多个答案，因此下列输出都可以被认为是正确的:
//[null,1,1,1,1,0]
//[null,1,1,1,1,1]
//[null,1,1,1,0,0]
//[null,1,1,1,0,1]
//[null,1,0,1,0,0]
//......
//诸若此类。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= w.length <= 104 
// 1 <= w[i] <= 105 
// pickIndex 将被调用不超过 104 次 
// 
// Related Topics 数组 数学 二分查找 前缀和 随机化 
// 👍 322 👎 0

import java.util.Random;

public class _528_按权重随机选择 {
    public static void main(String[] args) {
        int[] nums = {1};
        Solution solution = new _528_按权重随机选择().new Solution(nums);
        for (int i = 0; i <10 ; i++) {
            System.out.println(solution.pickIndex());
        }
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        int[] w;
        int[] preSums;
        int maxVal;
        Random random = new Random();

        public Solution(int[] w) {
            this.w = w;
            preSums = new int[w.length + 1];
            for (int i = 0; i < w.length; i++) {
                preSums[i + 1] = preSums[i] + w[i];
            }
            maxVal = preSums[preSums.length - 1];
        }

        public int pickIndex() {
            int k = random.nextInt(maxVal);
            int l = 0;
            int r = preSums.length - 1;
            int res = -1;
            while (r - l > 1) {
                int mid = (r + l) / 2;
                if (preSums[mid] < k) {
                    l = mid;
                } else if (preSums[mid] > k) {
                    r = mid;
                } else if (preSums[mid] == k) {
                    return mid;
                }
            }
            return l;
        }
    }

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(w);
 * int param_1 = obj.pickIndex();
 */
//leetcode submit region end(Prohibit modification and deletion)

}
