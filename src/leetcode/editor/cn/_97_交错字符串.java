package editor.cn;

//给定三个字符串 s1、s2、s3，请你帮忙验证 s3 是否是由 s1 和 s2 交错 组成的。 
//
// 两个字符串 s 和 t 交错 的定义与过程如下，其中每个字符串都会被分割成若干 非空 子字符串： 
//
// 
// s = s1 + s2 + ... + sn 
// t = t1 + t2 + ... + tm 
// |n - m| <= 1 
// 交错 是 s1 + t1 + s2 + t2 + s3 + t3 + ... 或者 t1 + s1 + t2 + s2 + t3 + s3 + ... 
// 
//
// 注意：a + b 意味着字符串 a 和 b 连接。 
//
// 
//
// 示例 1： 
//
// 
//输入：s1 = "aabcc", s2 = "dbbca", s3 = "aadbbcbcac"
//输出：true
// 
//
// 示例 2： 
//
// 
//输入：s1 = "aabcc", s2 = "dbbca", s3 = "aadbbbaccc"
//输出：false
// 
//
// 示例 3： 
//
// 
//输入：s1 = "", s2 = "", s3 = ""
//输出：true
// 
//
// 
//
// 提示： 
//
// 
// 0 <= s1.length, s2.length <= 100 
// 0 <= s3.length <= 200 
// s1、s2、和 s3 都由小写英文字母组成 
// 
//
// 
//
// 进阶：您能否仅使用 O(s2.length) 额外的内存空间来解决它? 
// Related Topics 字符串 动态规划 
// 👍 1017 👎 0

import java.util.HashMap;

public class _97_交错字符串 {
    public static void main(String[] args) {
        Solution solution = new _97_交错字符串().new Solution();
        String s1 = "aabcc";
        String s2 = "dbbca";
        String s3 = "aadbbcbcac";
        System.out.println(solution.isInterleave(s1, s2, s3));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isInterleave(String s1, String s2, String s3) {
            char[] chars1 = s1.toCharArray();
            char[] chars2 = s2.toCharArray();
            char[] chars3 = s3.toCharArray();
            if (chars3.length != chars1.length + chars2.length) return false;
            return isInterleave(0, 0, 0, chars1, chars2, chars3);
        }

        private HashMap<String, Boolean> mem = new HashMap<>();

        // 回溯加记忆化搜索
        public boolean isInterleave(int idx1, int idx2, int idx3, char[] chars1, char[] chars2, char[] chars3) {
            if (idx3 == chars3.length) {
                return true;
            }

            String key = generateKey(idx1, idx2, idx3);
            if (mem.containsKey(key)) {
                return mem.get(key);
            }

            if (idx1 < chars1.length && chars1[idx1] == chars3[idx3]) {
                if (isInterleave(idx1 + 1, idx2, idx3 + 1, chars1, chars2, chars3)) {
                    mem.put(generateKey(idx1 + 1, idx2, idx3 + 1), true);
                    return true;
                } else {
                    mem.put(generateKey(idx1 + 1, idx2, idx3 + 1), false);
                }

            }
            if (idx2 < chars2.length && chars2[idx2] == chars3[idx3]) {
                if (isInterleave(idx1, idx2 + 1, idx3 + 1, chars1, chars2, chars3)) {
                    mem.put(generateKey(idx1, idx2 + 1, idx3 + 1), true);
                    return true;
                } else {
                    mem.put(generateKey(idx1, idx2 + 1, idx3 + 1), false);
                }
            }
            return false;
        }

        private String generateKey(int idx1, int idx2, int idx3) {
            return idx1 + "_" + idx2 + "_" + idx3;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
