package editor.cn;

//给你两个单词 word1 和 word2， 请返回将 word1 转换成 word2 所使用的最少操作数 。 
//
// 你可以对一个单词进行如下三种操作： 
//
// 
// 插入一个字符 
// 删除一个字符 
// 替换一个字符 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：word1 = "horse", word2 = "ros"
//输出：3
//解释：
//horse -> rorse (将 'h' 替换为 'r')
//rorse -> rose (删除 'r')
//rose -> ros (删除 'e')
// 
//
// 示例 2： 
//
// 
//输入：word1 = "intention", word2 = "execution"
//输出：5
//解释：
//intention -> inention (删除 't')
//inention -> enention (将 'i' 替换为 'e')
//enention -> exention (将 'n' 替换为 'x')
//exention -> exection (将 'n' 替换为 'c')
//exection -> execution (插入 'u')
// 
//
// 
//
// 提示： 
//
// 
// 0 <= word1.length, word2.length <= 500 
// word1 和 word2 由小写英文字母组成 
// 
// Related Topics 字符串 动态规划 
// 👍 3401 👎 0

public class _72_编辑距离 {
    public static void main(String[] args) {
        Solution solution = new _72_编辑距离().new Solution();
        solution.minDistance("horse", "ros");
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int minDistance(String word1, String word2) {
            // mem[i][j]表示word1的前i个字母转换成word2的前j个字母所需要的最小转换次数
            int m = word1.length();
            int n = word2.length();
            int[][] mem = new int[m+1][n+1];
            for (int i = 1; i <= m; i++) {
                mem[i][0] = mem[i - 1][0] + 1;
            }
            for (int j = 1; j <= n; j++) {
                mem[0][j] = mem[0][j - 1] + 1;
            }

            for (int i = 1; i <= m; i++) {
                for (int j = 1; j <= n; j++) {
                    char c1 = word1.charAt(i-1);
                    char c2 = word2.charAt(j-1);
                    int update = c1 == c2 ? mem[i - 1][j - 1]:mem[i - 1][j - 1] + 1;
                    int add=mem[i][j-1]+1;
                    int delete=mem[i-1][j]+1;

                    int min=update<add?update:add;
                    min=min<delete?min:delete;
                    mem[i][j]=min;
                }
            }
            return mem[m][n];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
