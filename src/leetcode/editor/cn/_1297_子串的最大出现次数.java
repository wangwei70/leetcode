package editor.cn;

//给你一个字符串 s ，请你返回满足以下条件且出现次数最大的 任意 子串的出现次数： 
//
// 
// 子串中不同字母的数目必须小于等于 maxLetters 。 
// 子串的长度必须大于等于 minSize 且小于等于 maxSize 。 
// 
//
// 
//
// 示例 1： 
//
// 输入：s = "aababcaab", maxLetters = 2, minSize = 3, maxSize = 4
//输出：2
//解释：子串 "aab" 在原字符串中出现了 2 次。
//它满足所有的要求：2 个不同的字母，长度为 3 （在 minSize 和 maxSize 范围内）。
// 
//
// 示例 2： 
//
// 输入：s = "aaaa", maxLetters = 1, minSize = 3, maxSize = 3
//输出：2
//解释：子串 "aaa" 在原字符串中出现了 2 次，且它们有重叠部分。
// 
//
// 示例 3： 
//
// 输入：s = "aabcabcab", maxLetters = 2, minSize = 2, maxSize = 3
//输出：3
// 
//
// 示例 4： 
//
// 输入：s = "abcde", maxLetters = 2, minSize = 3, maxSize = 3
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 10^5 
// 1 <= maxLetters <= 26 
// 1 <= minSize <= maxSize <= min(26, s.length) 
// s 只包含小写英文字母。 
// 
// Related Topics 哈希表 字符串 滑动窗口 
// 👍 89 👎 0

import java.util.HashMap;

public class _1297_子串的最大出现次数{
	public static void main(String[] args) {
		Solution solution = new _1297_子串的最大出现次数().new Solution();
//		String s="aababcaab";
//		String s="abcde";
		String s="bbacbadadc";
		System.out.println(solution.maxFreq(s, 2, 1, 1));
	}
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maxFreq(String s, int maxLetters, int minSize, int maxSize) {
		char[] chars = s.toCharArray();

		int n = chars.length;
		HashMap<String, Integer> map = new HashMap<>();
		HashMap<Character, Integer> windCharCount = new HashMap<>();
		int letterCount=0;
		for (int i = 0; i < minSize; i++) {
			char c = s.charAt(i);
			letterCount = addLetter(windCharCount, letterCount, c);
		}
		int max=0;
		if (letterCount<=maxLetters){
			map.put(s.substring(0,minSize),1);
			max=1;
		}


		for (int i = 1; i <= n-minSize; i++) {
			char c = s.charAt(i-1);
			letterCount = deleteLetter(windCharCount, letterCount, c);

			char c1 = s.charAt(i + minSize-1);
			letterCount = addLetter(windCharCount, letterCount, c1);
			String substring = s.substring(i, i + minSize );

			if (letterCount<=maxLetters){
				map.put(substring, map.getOrDefault(substring,0)+1);
				max=Math.max(max,map.get(substring));
			}

		}
		return max;
    }

	private int deleteLetter(HashMap<Character, Integer> windCharCount, int letterCount, char c) {
		windCharCount.put(c,windCharCount.get(c)-1);
		if (windCharCount.get(c).equals(0)){
			letterCount--;
		}
		return letterCount;
	}

	private int addLetter(HashMap<Character, Integer> windCharCount, int letterCount,  char c1) {
		windCharCount.put(c1,windCharCount.getOrDefault(c1,0)+1);
		if (windCharCount.get(c1).equals(1)){
			letterCount++;
		}
		return letterCount;
	}
}
//leetcode submit region end(Prohibit modification and deletion)

}
