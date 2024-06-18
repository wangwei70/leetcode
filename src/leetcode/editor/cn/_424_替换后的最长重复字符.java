package editor.cn;

//给你一个字符串 s 和一个整数 k 。你可以选择字符串中的任一字符，并将其更改为任何其他大写英文字符。该操作最多可执行 k 次。 
//
// 在执行上述操作后，返回 包含相同字母的最长子字符串的长度。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "ABAB", k = 2
//输出：4
//解释：用两个'A'替换为两个'B',反之亦然。
// 
//
// 示例 2： 
//
// 
//输入：s = "AABABBA", k = 1
//输出：4
//解释：
//将中间的一个'A'替换为'B',字符串变为 "AABBBBA"。
//子串 "BBBB" 有最长重复字母, 答案为 4。
//可能存在其他的方法来得到同样的结果。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 105 
// s 仅由大写英文字母组成 
// 0 <= k <= s.length 
// 
// Related Topics 哈希表 字符串 滑动窗口 
// 👍 861 👎 0

import java.util.ArrayList;
import java.util.HashMap;

public class _424_替换后的最长重复字符 {
    public static void main(String[] args) {
        Solution solution = new _424_替换后的最长重复字符().new Solution();
        String s = "ABAB";
        System.out.println(solution.characterReplacement(s, 2));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int characterReplacement(String s, int k) {
            char[] chars = s.toCharArray();
            HashMap<Character, Integer> windowCharCount = new HashMap<>();
            int left = 0;
            int right = 0;
            int windowCharMaxCount = 1;
            int maxLen = 0;
            while (right < chars.length) {
                windowCharCount.put(chars[right], windowCharCount.getOrDefault(chars[right], 0) + 1);
                windowCharMaxCount = Math.max(windowCharMaxCount, windowCharCount.get(chars[right]));
                while (right - left + 1 - windowCharMaxCount > k) {
                    windowCharCount.put(chars[left], windowCharCount.get(chars[left]) - 1);

                    // 求窗口中最大的字符数量
                    for (Character aChar : windowCharCount.keySet()) {
                        windowCharMaxCount = Math.max(windowCharMaxCount, windowCharCount.get(aChar));
                    }

                    left++;
                }
                maxLen = Math.max(maxLen, right - left + 1);
                right++;
            }
            return maxLen;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
