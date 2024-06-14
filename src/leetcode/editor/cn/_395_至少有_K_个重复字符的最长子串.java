package editor.cn;

//给你一个字符串 s 和一个整数 k ，请你找出 s 中的最长子串， 要求该子串中的每一字符出现次数都不少于 k 。返回这一子串的长度。 
//
// 如果不存在这样的子字符串，则返回 0。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "aaabb", k = 3
//输出：3
//解释：最长子串为 "aaa" ，其中 'a' 重复了 3 次。
// 
//
// 示例 2： 
//
// 
//输入：s = "ababbc", k = 2
//输出：5
//解释：最长子串为 "ababb" ，其中 'a' 重复了 2 次， 'b' 重复了 3 次。 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 104 
// s 仅由小写英文字母组成 
// 1 <= k <= 105 
// 
// Related Topics 哈希表 字符串 分治 滑动窗口 
// 👍 882 👎 0

import java.util.HashMap;

public class _395_至少有_K_个重复字符的最长子串 {
    public static void main(String[] args) {
        Solution solution = new _395_至少有_K_个重复字符的最长子串().new Solution();
//        solution.longestSubstring("aaabbb", 3);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        // 错误的滑动窗口解法，存在没有考虑到的情况
//        public int longestSubstring(String s, int k) {
//            char[] chars = s.toCharArray();
//            HashMap<Character, Integer> window = new HashMap<>();
//            int maxLen = 0;
//            int left = 0;
//            int right = 0;
//            int winCharGroupNum = 0;
//            int winFinshGroupNum = 0;
//            int winLen = 0;
//            boolean find = false;
//            while (left <= right && right < chars.length) {
//                char rightChar = chars[right];
//                if (!window.containsKey(rightChar) || window.get(rightChar) == 0) {
//                    winCharGroupNum++;
//
//                }
//                window.put(rightChar, window.getOrDefault(rightChar, 0) + 1);
//                winLen++;
//                if (window.get(rightChar) == k) {
//                    winFinshGroupNum++;
//                }
//
//                if (winCharGroupNum == winFinshGroupNum){
//                    maxLen = Math.max(maxLen, winLen);
//                    if (!find){
//                        find = true;
//                    }
//                }
//
//                // 左指针右移
//                if (find && winCharGroupNum > winFinshGroupNum) {
//                    find = false;
//                    char leftChar = chars[left];
//                    window.put(leftChar, window.get(leftChar) - 1);
//                    if (window.get(leftChar) < k) {
//                        winFinshGroupNum--;
//                    }
//                    if (window.get(leftChar) == 0) {
//                        winCharGroupNum--;
//                    }
//                    winLen--;
//                    left++;
//
//                }
//                right++;
//            }
//            return maxLen;
//        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
