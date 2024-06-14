package editor.cn;

//给你一个整数数组 coins ，表示不同面额的硬币；以及一个整数 amount ，表示总金额。 
//
// 计算并返回可以凑成总金额所需的 最少的硬币个数 。如果没有任何一种硬币组合能组成总金额，返回 -1 。 
//
// 你可以认为每种硬币的数量是无限的。 
//
// 
//
// 示例 1： 
//
// 
//输入：coins = [1, 2, 5], amount = 11
//输出：3 
//解释：11 = 5 + 5 + 1 
//
// 示例 2： 
//
// 
//输入：coins = [2], amount = 3
//输出：-1 
//
// 示例 3： 
//
// 
//输入：coins = [1], amount = 0
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// 1 <= coins.length <= 12 
// 1 <= coins[i] <= 231 - 1 
// 0 <= amount <= 104 
// 
// Related Topics 广度优先搜索 数组 动态规划 
// 👍 2824 👎 0

import java.util.Arrays;

public class _322_零钱兑换 {
    public static void main(String[] args) {
        Solution solution = new _322_零钱兑换().new Solution();
        int[] coins = {1,2,5};
//        int[] coins = {2};
//        int[] coins = {2, 5, 10, 1};

        System.out.println(solution.coinChange(coins, 11));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        int[] mem;

//        public int coinChange(int[] coins, int amount) {
//            mem = new int[amount + 1];
//            Arrays.fill(mem, -2);
//            return digui(coins, amount);
//        }
//
//        public int digui(int[] coins, int amount) {
//            if (amount < 0) {
//                return -1;
//            }
//            if (amount == 0) {
//                return 0;
//            }
//            if (mem[amount] >= -1) {
//                return mem[amount];
//            }
//
//            int min = amount;
//            boolean end = true;
//            for (int i = 0; i < coins.length; i++) {
//                int childRes = digui(coins, amount - coins[i]);
//                if (childRes < 0) {
//                    continue;
//                }
//                end = false;
//                min = Math.min(min, childRes);
//            }
//            if (mem[amount] == -2) {
//                mem[amount] = end ? -1 : min + 1;
//            }
//            return mem[amount];
//        }


        public int coinChange(int[] coins, int amount) {
            mem = new int[amount + 1];
            Arrays.fill(mem, -2);
            return xunhuan(coins, amount);
        }
        public int xunhuan(int[] coins, int amount) {
            mem[0] = 0;
            for (int i = 1; i <= amount; i++) {
                int res = i;
                boolean end = true;
                for (int j = 0; j < coins.length; j++) {
                    if (i - coins[j] >= 0) {
                        int childRes = mem[i - coins[j]];
                        if (childRes == -1) {
                            continue;
                        }
                        end = false;
                        res = Math.min(res, childRes);
                    }
                }
                mem[i] = end ? -1 :1+res;
            }
            return mem[amount];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
