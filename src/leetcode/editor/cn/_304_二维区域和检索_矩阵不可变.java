package editor.cn;

//给定一个二维矩阵 matrix，以下类型的多个请求： 
//
// 
// 计算其子矩形范围内元素的总和，该子矩阵的 左上角 为 (row1, col1) ，右下角 为 (row2, col2) 。 
// 
//
// 实现 NumMatrix 类： 
//
// 
// NumMatrix(int[][] matrix) 给定整数矩阵 matrix 进行初始化 
// int sumRegion(int row1, int col1, int row2, int col2) 返回 左上角 (row1, col1) 、右下
//角 (row2, col2) 所描述的子矩阵的元素 总和 。 
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
//["NumMatrix","sumRegion","sumRegion","sumRegion"]
//[[[[3,0,1,4,2],[5,6,3,2,1],[1,2,0,1,5],[4,1,0,1,7],[1,0,3,0,5]]],[2,1,4,3],[1,
//1,2,2],[1,2,2,4]]
//输出: 
//[null, 8, 11, 12]
//
//解释:
//NumMatrix numMatrix = new NumMatrix([[3,0,1,4,2],[5,6,3,2,1],[1,2,0,1,5],[4,1,
//0,1,7],[1,0,3,0,5]]);
//numMatrix.sumRegion(2, 1, 4, 3); // return 8 (红色矩形框的元素总和)
//numMatrix.sumRegion(1, 1, 2, 2); // return 11 (绿色矩形框的元素总和)
//numMatrix.sumRegion(1, 2, 2, 4); // return 12 (蓝色矩形框的元素总和)
// 
//
// 
//
// 提示： 
//
// 
// m == matrix.length 
// n == matrix[i].length 
// 1 <= m, n <= 200 
// -105 <= matrix[i][j] <= 105 
// 0 <= row1 <= row2 < m 
// 0 <= col1 <= col2 < n 
// 最多调用 104 次 sumRegion 方法 
// 
// Related Topics 设计 数组 矩阵 前缀和 
// 👍 551 👎 0

public class _304_二维区域和检索_矩阵不可变 {
    public static void main(String[] args) {
        int[][] matrix={{3,0,1,4,2},{5,6,3,2,1},{1,2,0,1,5},{4,1,0,1,7},{1,0,3,0,5}};

        _304_二维区域和检索_矩阵不可变.NumMatrix numMatrix = new _304_二维区域和检索_矩阵不可变.NumMatrix(matrix);

        System.out.println(numMatrix.sumRegion(2, 1, 4, 3));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
   static class NumMatrix {
        int[][] sums;

        public NumMatrix(int[][] matrix) {
            sums=new int[matrix.length][matrix[0].length];
            for (int i = 0; i < matrix.length; i++) {
                    for (int j = 0; j < matrix[0].length; j++) {
                    if (i == 0 && j == 0) {
                        sums[i][j] = matrix[0][0];
                    } else if (i == 0) {
                        sums[i][j] = sums[i][j - 1] + matrix[i][j];
                    } else if (j == 0) {
                        sums[i][j] = sums[i - 1][j] + matrix[i][j];
                    }else {
                        sums[i][j] = matrix[i][j]+sums[i - 1][j] + sums[i][j - 1] - sums[i - 1][j - 1];
                    }
                }
            }
        }

        public int sumRegion(int row1, int col1, int row2, int col2) {
            if (row1 == 0 && col1 == 0) {
                return sums[row2][col2];
            } else if (row1 == 0) {
                return sums[row2][col2] - sums[row2][col1 - 1];
            } else if (col1 == 0) {
                return sums[row2][col2] - sums[row1 - 1][col2];
            }

            return sums[row2][col2] - sums[row1 - 1][col2] - sums[row2][col1 - 1] + sums[row1 - 1][col1 - 1];
        }
    }

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */
//leetcode submit region end(Prohibit modification and deletion)

}
