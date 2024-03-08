package editor.cn;

//给定一个由非重叠的轴对齐矩形的数组 rects ，其中 rects[i] = [ai, bi, xi, yi] 表示 (ai, bi) 是第 i 个矩形的左
//下角点，(xi, yi) 是第 i 个矩形的右上角点。设计一个算法来随机挑选一个被某一矩形覆盖的整数点。矩形周长上的点也算做是被矩形覆盖。所有满足要求的点必须等
//概率被返回。 
//
// 在给定的矩形覆盖的空间内的任何整数点都有可能被返回。 
//
// 请注意 ，整数点是具有整数坐标的点。 
//
// 实现 Solution 类: 
//
// 
// Solution(int[][] rects) 用给定的矩形数组 rects 初始化对象。 
// int[] pick() 返回一个随机的整数点 [u, v] 在给定的矩形所覆盖的空间内。 
// 
//
// 
// 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入: 
//["Solution", "pick", "pick", "pick", "pick", "pick"]
//[[[[-2, -2, 1, 1], [2, 2, 4, 6]]], [], [], [], [], []]
//输出: 
//[null, [1, -2], [1, -1], [-1, -2], [-2, -2], [0, 0]]
//
//解释：
//Solution solution = new Solution([[-2, -2, 1, 1], [2, 2, 4, 6]]);
//solution.pick(); // 返回 [1, -2]
//solution.pick(); // 返回 [1, -1]
//solution.pick(); // 返回 [-1, -2]
//solution.pick(); // 返回 [-2, -2]
//solution.pick(); // 返回 [0, 0] 
//
// 
//
// 提示： 
//
// 
// 1 <= rects.length <= 100 
// rects[i].length == 4 
// -109 <= ai < xi <= 109 
// -109 <= bi < yi <= 109 
// xi - ai <= 2000 
// yi - bi <= 2000 
// 所有的矩形不重叠。 
// pick 最多被调用 104 次。 
// 
// Related Topics 水塘抽样 数组 数学 二分查找 有序集合 前缀和 随机化 
// 👍 152 👎 0

import java.util.HashMap;
import java.util.Random;

public class _497_非重叠矩形中的随机点 {
    public static void main(String[] args) {
//        int[][] rects ={{35330199,-46858448,35330694,-46856950}};
        int[][] rects = {
                {82918473, -57180867, 82918476, -57180863},
                {83793579, 18088559, 83793580, 18088560},
                {66574245, 26243152, 66574246, 26243153},
                {72983930, 11921716, 72983934, 11921720}
        };
        Solution solution = new _497_非重叠矩形中的随机点().new Solution(rects);
        int idx = 0;
        while (idx < 1000000) {
            idx++;
            int[] pick = solution.pick();

            int chose = solution.chose;
            int[] rect = rects[chose];
            int a = rect[0];
            int b = rect[1];
            int x = rect[2];
            int y = rect[3];
            if (pick[0] >= a && pick[0] <= x && pick[1] >= b && pick[1] <= y) {
//                System.out.println("yes");
            } else {
                System.out.println("no");
            }
        }
    }


    // 错误答案，先随机选择一个矩形，再在矩形中随机选取一个点，这样每个点的选取概率是不一样的
    // 比如有两个矩形，一个矩形的面积是1，一个矩形的面积是4，按照这种解法，第一个矩形中只有一个点，
    // 它被选中的概率为1/2，而另外一个矩形中每个点的概率是1/8，这样就不均衡了
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        HashMap<Integer, Integer> count = new HashMap();
        Random random = new Random();
        int[][] rects;
        int chose;

        public Solution(int[][] rects) {
            this.rects = rects;
            for (int i = 0; i < rects.length; i++) {
                int a = rects[i][0];
                int b = rects[i][1];
                int x = rects[i][2];
                int y = rects[i][3];
                count.put(i, (x - a + 1) * (y - b + 1));
            }
        }

        public int[] pick() {
            // 选矩形
            int idx1 = random.nextInt(count.size());
            chose = idx1;
            int[] rect = rects[idx1];
            int a = rect[0];
            int b = rect[1];
            int x = rect[2];
            int y = rect[3];

            // 选坐标
            int idx2 = random.nextInt(count.get(idx1));

            // 横坐标
            int i = idx2 % (x - a + 1);
            int aa = a + i;
            // 纵坐标
            int j = idx2 / (x - a + 1);
            int bb = b + j;

            return new int[]{aa, bb};
        }
    }

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(rects);
 * int[] param_1 = obj.pick();
 */
//leetcode submit region end(Prohibit modification and deletion)

}
