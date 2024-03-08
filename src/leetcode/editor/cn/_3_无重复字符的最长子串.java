package editor.cn;

//给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。 
//
// 
//
// 示例 1: 
//
// 
//输入: s = "abcabcbb"
//输出: 3 
//解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
// 
//
// 示例 2: 
//
// 
//输入: s = "bbbbb"
//输出: 1
//解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
// 
//
// 示例 3: 
//
// 
//输入: s = "pwwkew"
//输出: 3
//解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
//     请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
// 
//
// 
//
// 提示： 
//
// 
// 0 <= s.length <= 5 * 104 
// s 由英文字母、数字、符号和空格组成 
// 
// Related Topics 哈希表 字符串 滑动窗口 
// 👍 10015 👎 0

import java.util.HashMap;

public class _3_无重复字符的最长子串 {
    public static void main(String[] args) {
        Solution solution = new _3_无重复字符的最长子串().new Solution();
//        solution.lengthOfLongestSubstring("abcabcbb");
//        System.out.println(solution.lengthOfLongestSubstring("pwwkew"));
        System.out.println(solution.lengthOfLongestSubstring("au"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int lengthOfLongestSubstring(String s) {
            if (s.length()<=1) return s.length();
            char[] chars = s.toCharArray();
            int left = 0;
            int right = 0;
            int maxLength = 0;
            int windLength = 0;
            HashMap<Character, Integer> window = new HashMap<>();
            while (right < chars.length) {
                char rightChar = chars[right];
                window.put(rightChar, window.getOrDefault(rightChar, 0) + 1);
                windLength++;

                // 左指针
                while (window.get(rightChar) > 1) {
                    char leftChar = chars[left];
                    window.put(leftChar, window.get(leftChar) - 1);
                    left++;
                    windLength--;
                }
                maxLength = Math.max(maxLength, windLength);
                right++;
            }

            return maxLength;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
