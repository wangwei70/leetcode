package editor.cn;

//给你一个字符串 s ，它只包含三种字符 a, b 和 c 。 
//
// 请你返回 a，b 和 c 都 至少 出现过一次的子字符串数目。 
//
// 
//
// 示例 1： 
//
// 输入：s = "abcabc"
//输出：10
//解释：包含 a，b 和 c 各至少一次的子字符串为 "abc", "abca", "abcab", "abcabc", "bca", "bcab", "bc
//abc", "cab", "cabc" 和 "abc" (相同字符串算多次)。
// 
//
// 示例 2： 
//
// 输入：s = "aaacb"
//输出：3
//解释：包含 a，b 和 c 各至少一次的子字符串为 "aaacb", "aacb" 和 "acb" 。
// 
//
// 示例 3： 
//
// 输入：s = "abc"
//输出：1
// 
//
// 
//
// 提示： 
//
// 
// 3 <= s.length <= 5 x 10^4 
// s 只包含字符 a，b 和 c 。 
// 
// Related Topics 哈希表 字符串 滑动窗口 
// 👍 110 👎 0

import java.util.HashMap;

public class _1358_包含所有三种字符的子字符串数目 {
    public static void main(String[] args) {
        Solution solution = new _1358_包含所有三种字符的子字符串数目().new Solution();

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int numberOfSubstrings(String s) {
            int length = s.length();
            int left = 0;
            int right = 0;
            int letterCount = 0;
            HashMap<Character, Integer> map = new HashMap<>();
            int res=0;
            while (right < length) {
                char rightChar = s.charAt(right);
                map.put(rightChar, map.getOrDefault(rightChar, 0) + 1);
                if (map.get(rightChar) == 1) {
                    letterCount++;
                }

                while (letterCount == 3) {
                    res+=length-right;
                    char leftChar = s.charAt(left);
                    map.put(leftChar,map.get(leftChar)-1);
                    if (map.get(leftChar)==0){
                        letterCount--;
                    }
                    left++;
                }

                right++;
            }

            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
