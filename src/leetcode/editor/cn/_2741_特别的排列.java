package editor.cn;

//给你一个下标从 0 开始的整数数组 nums ，它包含 n 个 互不相同 的正整数。如果 nums 的一个排列满足以下条件，我们称它是一个特别的排列： 
//
// 
// 对于 0 <= i < n - 1 的下标 i ，要么 nums[i] % nums[i+1] == 0 ，要么 nums[i+1] % nums[i] 
//== 0 。 
// 
//
// 请你返回特别排列的总数目，由于答案可能很大，请将它对 109 + 7 取余 后返回。 
//
// 
//
// 示例 1： 
//
// 输入：nums = [2,3,6]
//输出：2
//解释：[3,6,2] 和 [2,6,3] 是 nums 两个特别的排列。
// 
//
// 示例 2： 
//
// 输入：nums = [1,4,3]
//输出：2
//解释：[3,1,4] 和 [4,1,3] 是 nums 两个特别的排列。
// 
//
// 
//
// 提示： 
//
// 
// 2 <= nums.length <= 14 
// 1 <= nums[i] <= 109 
// 
// Related Topics 位运算 数组 动态规划 状态压缩 
// 👍 55 👎 0

import java.util.HashMap;


public class _2741_特别的排列 {
    public static void main(String[] args) {
        Solution solution = new _2741_特别的排列().new Solution();
//        int[] nums = {20, 100, 50, 5, 10, 70, 7};
        int[] nums = {1, 2, 4, 8, 16, 32, 64, 128, 256, 512, 1024, 2048, 4096, 8192};
        System.out.println(solution.specialPerm(nums));
        System.out.println(87178291200L % 1000000007);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int specialPerm(int[] nums) {
            int[] used = new int[nums.length];
            HashMap<String, Long> mem = new HashMap<>();
            long res = backTrace(nums, used, -1, 0, mem, 0);
            long i = 1000000007L;
            return (int) (res % i);
        }
        public long backTrace(int[] nums, int[] used, int preIdx, int depth, HashMap<String, Long> mem, int u) {
            if (depth == nums.length) {
                return 1;
            }
            String key = preIdx + "#" + Integer.toBinaryString(u);
            if (mem.containsKey(key)) {
                return mem.get(key);
            }
            long res = 0;
            for (int i = 0; i < nums.length; i++) {
                boolean a = (used[i] == 0);
                boolean b = (preIdx == -1);
                boolean c1 = (preIdx != -1 && nums[preIdx] % nums[i] == 0);
                boolean c2 = (preIdx != -1 && nums[i] % nums[preIdx] == 0);
                if (a && (b || c1 || c2)) {
                    used[i] = 1;
                    int binaryIdx = u | 1 << (nums.length - i - 1);
                    res += backTrace(nums, used, i, depth + 1, mem, binaryIdx);
                    used[i] = 0;
                }
            }
            mem.put(key, res);
            return res;
        }

//        long res = 0;

//        public void backTrace(int[] nums, int[] used, LinkedList<Integer> list, HashMap<String, Long> mem, int u) {
//            if (list.size() == nums.length) {
//                res++;
//                return;
//            }
//            Integer preIdx = null;
//            Integer preNum = null;
//            if (list.size() > 0) {
//                preIdx = list.peekLast();
//                preNum = nums[preIdx];
//                String key = preNum + "#" + Integer.toBinaryString(u);
//                if (mem.containsKey(key)) {
//                    res += mem.get(key);
//                    return;
//                }
//            }
//
//
//            for (int i = 0; i < nums.length; i++) {
//                boolean a = (used[i] == 0);
//                boolean b = (preIdx == null);
//                boolean c1 = (preNum != null && preNum % nums[i] == 0);
//                boolean c2 = (preNum != null && nums[i] % preNum == 0);
//                if (a && (b || c1 || c2)) {
//                    long temp = res;
//                    used[i] = 1;
//                    list.add(i);
//                    int binaryIdx = u | 1 << (nums.length - i - 1);
//                    String str = Integer.toBinaryString(binaryIdx);
//                    String newKey = nums[i] + "#" + str;
//
//                    backTrace(nums, used, list, mem, binaryIdx);
//                    if (!mem.containsKey(newKey)) {
//                        mem.put(newKey, mem.getOrDefault(newKey, 0L) + (res - temp));
//                    }
//                    list.removeLast();
//                    used[i] = 0;
//                }
//
//            }
//        }


    }
//leetcode submit region end(Prohibit modification and deletion)

}
