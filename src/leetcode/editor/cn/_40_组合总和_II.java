package editor.cn;

//给定一个候选人编号的集合 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。 
//
// candidates 中的每个数字在每个组合中只能使用 一次 。 
//
// 注意：解集不能包含重复的组合。 
//
// 
//
// 示例 1: 
//
// 
//输入: candidates = [10,1,2,7,6,1,5], target = 8,
//输出:
//[
//[1,1,6],
//[1,2,5],
//[1,7],
//[2,6]
//] 
//
// 示例 2: 
//
// 
//输入: candidates = [2,5,2,1,2], target = 5,
//输出:
//[
//[1,2,2],
//[5]
//] 
//
// 
//
// 提示: 
//
// 
// 1 <= candidates.length <= 100 
// 1 <= candidates[i] <= 50 
// 1 <= target <= 30 
// 
// Related Topics 数组 回溯 
// 👍 1518 👎 0

import java.util.*;

public class _40_组合总和_II {
    public static void main(String[] args) {
        Solution solution = new _40_组合总和_II().new Solution();
        int[] nums = {10, 1, 2, 7, 6, 1, 5};
        List<List<Integer>> lists = solution.combinationSum2(nums, 8);

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> combinationSum2(int[] candidates, int target) {
            for (int i = 0; i < candidates.length; i++) {
                count.put(candidates[i], count.getOrDefault(candidates[i], 0) + 1);
            }
            ArrayList<Integer> list = new ArrayList<>(count.keySet());
            int[] use = new int[candidates.length];
            Arrays.fill(use,0);
            backTrace(list,target,use,0);
            return res;
        }
        private LinkedList<Integer> temp = new LinkedList<>();
        private HashMap<Integer, Integer> count = new HashMap<>();
        private List<List<Integer>> res = new ArrayList<>();

        // 正确解法：数组重组+回溯，将数组中相同的数合并处理
        public void backTrace(ArrayList<Integer> list, int target, int[] use,int start) {
            if (target < 0) {
                return;
            }
            if (target == 0) {
                ArrayList<Integer> integers = new ArrayList<>(temp);
                res.add(integers);
                return;
            }

            for (int i = start; i < list.size(); i++) {
                if (use[i] == 1) {
                    continue;
                }
                Integer num = list.get(i);
                Integer count = this.count.get(num);
                use[i] = 1;
                for (int j = 1; j <= count; j++) {
                    temp.addLast(num);
                    backTrace(list, target - j * num, use,i+1);
                }
                for (int j = 1; j <= count; j++) {
                    temp.removeLast();
                }
                use[i] = 0;

            }
        }

        // 常规思维：回溯解法1，但是不满足题目中不能包含重复组合的要求
        //        public void backTrace(int[] candidates, int target, int[] use) {
//            if (target < 0) {
//                return;
//            }
//            if (target == 0) {
//                ArrayList<Integer> integers = new ArrayList<>();
//                for (int i = 0; i < use.length; i++) {
//                    if (use[i] == 1) {
//                        integers.add(candidates[i]);
//                    }
//                }
//                res.add(integers);
//                return;
//            }
//
//            for (int i = 0; i < candidates.length; i++) {
//                if (use[i] == 1) {
//                    continue;
//                }
//                int leftTarget = target - candidates[i];
//                use[i] = 1;
//                backTrace(candidates, leftTarget, use);
//                use[i] = 0;
//            }
//        }


        // 常规思维：回溯解法2，但是不满足题目中不能包含重复组合的要求
//        private List<List<Integer>> res = new ArrayList<>();
//        private LinkedList<Integer> temp = new LinkedList<Integer>();
//        public void backTrace(int[] candidates, int target, int idx) {
//            if (target == 0) {
//                ArrayList<Integer> integers = new ArrayList<>(temp);
//                res.add(integers);
//                return;
//            }
//            if (target < 0 || idx >= candidates.length) {
//                return;
//            }
//            // 选idx位置
//            int candidate = candidates[idx];
//            temp.addLast(candidate);
//            backTrace(candidates, target - candidate, idx + 1);
//            temp.removeLast();
//
//            // 不选idx位置
//            backTrace(candidates, target, idx + 1);
//        }






    }
//leetcode submit region end(Prohibit modification and deletion)

}
