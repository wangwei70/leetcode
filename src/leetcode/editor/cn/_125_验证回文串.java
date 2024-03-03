package editor.cn;

//如果在将所有大写字符转换为小写字符、并移除所有非字母数字字符之后，短语正着读和反着读都一样。则可以认为该短语是一个 回文串 。 
//
// 字母和数字都属于字母数字字符。 
//
// 给你一个字符串 s，如果它是 回文串 ，返回 true ；否则，返回 false 。 
//
// 
//
// 示例 1： 
//
// 
//输入: s = "A man, a plan, a canal: Panama"
//输出：true
//解释："amanaplanacanalpanama" 是回文串。
// 
//
// 示例 2： 
//
// 
//输入：s = "race a car"
//输出：false
//解释："raceacar" 不是回文串。
// 
//
// 示例 3： 
//
// 
//输入：s = " "
//输出：true
//解释：在移除非字母数字字符之后，s 是一个空字符串 "" 。
//由于空字符串正着反着读都一样，所以是回文串。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 2 * 105 
// s 仅由可打印的 ASCII 字符组成 
// 
// Related Topics 双指针 字符串 
// 👍 734 👎 0

public class _125_验证回文串 {
    public static void main(String[] args) {
        Solution solution = new _125_验证回文串().new Solution();
        solution.isPalindrome("A man, a plan, a canal: Panama");
//        solution.isPalindrome(" ");


    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isPalindrome(String s) {
            String str = s.toLowerCase();
            char[] chars = str.toCharArray();
            int l = 0;
            int r = chars.length - 1;


            while (l <= r) {


                while (l <= r && !((chars[l] >= 97 && chars[l] <= 122) || (chars[l] >= 48 && chars[l] <= 57))) {
                    l++;
                }
                while (l <= r && !((chars[r] >= 97 && chars[r] <= 122) || (chars[r] >= 48 && chars[r] <= 57))) {
                    r--;
                }
                if (l >= r) {
                    return true;
                }
                if (chars[l] != chars[r]) {
                    return false;
                }
                l++;
                r--;
            }

            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
