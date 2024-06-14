package editor.cn;

//DNA序列 由一系列核苷酸组成，缩写为 'A', 'C', 'G' 和 'T'.。 
//
// 
// 例如， "ACGAATTCCG" 是一个 DNA序列 。 
// 
//
// 在研究 DNA 时，识别 DNA 中的重复序列非常有用。 
//
// 给定一个表示 DNA序列 的字符串 s ，返回所有在 DNA 分子中出现不止一次的 长度为 10 的序列(子字符串)。你可以按 任意顺序 返回答案。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"
//输出：["AAAAACCCCC","CCCCCAAAAA"]
// 
//
// 示例 2： 
//
// 
//输入：s = "AAAAAAAAAAAAA"
//输出：["AAAAAAAAAA"]
// 
//
// 
//
// 提示： 
//
// 
// 0 <= s.length <= 105 
// s[i]=='A'、'C'、'G' or 'T' 
// 
// Related Topics 位运算 哈希表 字符串 滑动窗口 哈希函数 滚动哈希 
// 👍 577 👎 0

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class _187_重复的DNA序列 {
    public static void main(String[] args) {
        Solution solution = new _187_重复的DNA序列().new Solution();

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<String> findRepeatedDnaSequences(String s) {
            ArrayList<String> res = new ArrayList<>();
            char[] chars = s.toCharArray();
            if (chars.length <= 10) return res;
            int left = 0;
            int right = 9;
            HashSet<String> set = new HashSet<>();
            while (right<chars.length) {
//                String str = String.copyValueOf(chars, left, 10);
                String str = s.substring(left,right+1);
                if (set.contains(str)&&!res.contains(str)){
                    res.add(str);
                }else {
                    set.add(str);
                }
                left++;
                right++;
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
