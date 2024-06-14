package editor.cn;

//给定一个包含非负整数的 m x n 网格 grid ，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。 
//
// 说明：每次只能向下或者向右移动一步。 
//
// 
//
// 示例 1： 
//
// 
//输入：grid = [[1,3,1],[1,5,1],[4,2,1]]
//输出：7
//解释：因为路径 1→3→1→1→1 的总和最小。
// 
//
// 示例 2： 
//
// 
//输入：grid = [[1,2,3],[4,5,6]]
//输出：12
// 
//
// 
//
// 提示： 
//
// 
// m == grid.length 
// n == grid[i].length 
// 1 <= m, n <= 200 
// 0 <= grid[i][j] <= 200 
// 
// Related Topics 数组 动态规划 矩阵 
// 👍 1683 👎 0

public class _64_最小路径和 {
    public static void main(String[] args) {
        Solution solution = new _64_最小路径和().new Solution();
        int[][] grid = {{1, 3, 1}, {1, 5, 1}, {4, 2, 1}};
        System.out.println(solution.minPathSum(grid));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {


//        标准回溯算法  复杂度 O(2^(n)) 超时
//        public int minPathSum(int[][] grid) {
//            minSum = Integer.MAX_VALUE;
//            pathSum = grid[0][0];
//            backTrace(grid, 0, 0);
//            return minSum;
//        }
//        int minSum;
//        int pathSum ;
//        public void backTrace(int[][] grid, int x, int y) {
//
//            if (x == grid.length - 1 && y == grid[0].length - 1) {
//                minSum = Math.min(minSum, pathSum);
//                return;
//            }
//
//            if (x < grid.length - 1) {
//                pathSum += grid[x + 1][y];
//                backTrace(grid, x + 1, y);
//                pathSum -= grid[x + 1][y];
//            }
//
//            if (y < grid[0].length - 1) {
//                pathSum += grid[x][y + 1];
//                backTrace(grid, x, y + 1);
//                pathSum -= grid[x][y + 1];
//            }
//        }


        //        mem[x][y] 表示gird中从grid[0][0]和grid[x][y]的子矩阵的最优路线（最优子解）
        //       mem[x][y]=grid[x][y]+min(mem[x-1][y],mem[x][y-1]);
        //        mem(0,0)=gird[0],[0]
        // 动态规划算法 O(n*n)
        public int minPathSum(int[][] grid) {
            int[][] mem = new int[grid.length][grid[0].length];
            mem[0][0] = grid[0][0];

            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[0].length; j++) {
                    if (i == 0 && j == 0) {
                        continue;
                    }

                    int a = Integer.MAX_VALUE;
                    if (i - 1 >= 0) {
                        a = mem[i - 1][j]+grid[i][j];
                    }
                    int b = Integer.MAX_VALUE;
                    if (j - 1 >= 0) {
                        b = mem[i][j - 1]+grid[i][j];
                    }
                    mem[i][j]=Math.min(a,b);

                }
            }
            return mem[grid.length-1][grid[0].length-1];
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}
