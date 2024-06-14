package editor.cn;

//给定一个字符串 s 和一个字符串数组 words。 words 中所有字符串 长度相同。 
//
// s 中的 串联子串 是指一个包含 words 中所有字符串以任意顺序排列连接起来的子串。 
//
// 
// 例如，如果 words = ["ab","cd","ef"]， 那么 "abcdef"， "abefcd"，"cdabef"， "cdefab"，"efa
//bcd"， 和 "efcdab" 都是串联子串。 "acdbef" 不是串联子串，因为他不是任何 words 排列的连接。 
// 
//
// 返回所有串联子串在 s 中的开始索引。你可以以 任意顺序 返回答案。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "barfoothefoobarman", words = ["foo","bar"]
//输出：[0,9]
//解释：因为 words.length == 2 同时 words[i].length == 3，连接的子字符串的长度必须为 6。
//子串 "barfoo" 开始位置是 0。它是 words 中以 ["bar","foo"] 顺序排列的连接。
//子串 "foobar" 开始位置是 9。它是 words 中以 ["foo","bar"] 顺序排列的连接。
//输出顺序无关紧要。返回 [9,0] 也是可以的。
// 
//
// 示例 2： 
//
// 
//输入：s = "wordgoodgoodgoodbestword", words = ["word","good","best","word"]
//输出：[]
//解释：因为 words.length == 4 并且 words[i].length == 4，所以串联子串的长度必须为 16。
//s 中没有子串长度为 16 并且等于 words 的任何顺序排列的连接。
//所以我们返回一个空数组。
// 
//
// 示例 3： 
//
// 
//输入：s = "barfoofoobarthefoobarman", words = ["bar","foo","the"]
//输出：[6,9,12]
//解释：因为 words.length == 3 并且 words[i].length == 3，所以串联子串的长度必须为 9。
//子串 "foobarthe" 开始位置是 6。它是 words 中以 ["foo","bar","the"] 顺序排列的连接。
//子串 "barthefoo" 开始位置是 9。它是 words 中以 ["bar","the","foo"] 顺序排列的连接。
//子串 "thefoobar" 开始位置是 12。它是 words 中以 ["the","foo","bar"] 顺序排列的连接。 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 104 
// 1 <= words.length <= 5000 
// 1 <= words[i].length <= 30 
// words[i] 和 s 由小写英文字母组成 
// 
// Related Topics 哈希表 字符串 滑动窗口 
// 👍 1080 👎 0

import java.util.*;
import java.util.stream.Collectors;

public class _30_串联所有单词的子串 {
    public static void main(String[] args) {
        Solution solution = new _30_串联所有单词的子串().new Solution();
//        String s = "barfoothefoobarman";
//        String[] words = {"foo", "bar"};
        String s = "pjzkrkevzztxductzzxmxsvwjkxpvukmfjywwetvfnujhweiybwvvsrfequzkhossmootkmyxgjgfordrpapjuunmqnxxdrqrfgkrsjqbszgiqlcfnrpjlcwdrvbumtotzylshdvccdmsqoadfrpsvnwpizlwszrtyclhgilklydbmfhuywotjmktnwrfvizvnmfvvqfiokkdprznnnjycttprkxpuykhmpchiksyucbmtabiqkisgbhxngmhezrrqvayfsxauampdpxtafniiwfvdufhtwajrbkxtjzqjnfocdhekumttuqwovfjrgulhekcpjszyynadxhnttgmnxkduqmmyhzfnjhducesctufqbumxbamalqudeibljgbspeotkgvddcwgxidaiqcvgwykhbysjzlzfbupkqunuqtraxrlptivshhbihtsigtpipguhbhctcvubnhqipncyxfjebdnjyetnlnvmuxhzsdahkrscewabejifmxombiamxvauuitoltyymsarqcuuoezcbqpdaprxmsrickwpgwpsoplhugbikbkotzrtqkscekkgwjycfnvwfgdzogjzjvpcvixnsqsxacfwndzvrwrycwxrcismdhqapoojegggkocyrdtkzmiekhxoppctytvphjynrhtcvxcobxbcjjivtfjiwmduhzjokkbctweqtigwfhzorjlkpuuliaipbtfldinyetoybvugevwvhhhweejogrghllsouipabfafcxnhukcbtmxzshoyyufjhzadhrelweszbfgwpkzlwxkogyogutscvuhcllphshivnoteztpxsaoaacgxyaztuixhunrowzljqfqrahosheukhahhbiaxqzfmmwcjxountkevsvpbzjnilwpoermxrtlfroqoclexxisrdhvfsindffslyekrzwzqkpeocilatftymodgztjgybtyheqgcpwogdcjlnlesefgvimwbxcbzvaibspdjnrpqtyeilkcspknyylbwndvkffmzuriilxagyerjptbgeqgebiaqnvdubrtxibhvakcyotkfonmseszhczapxdlauexehhaireihxsplgdgmxfvaevrbadbwjbdrkfbbjjkgcztkcbwagtcnrtqryuqixtzhaakjlurnumzyovawrcjiwabuwretmdamfkxrgqgcdgbrdbnugzecbgyxxdqmisaqcyjkqrntxqmdrczxbebemcblftxplafnyoxqimkhcykwamvdsxjezkpgdpvopddptdfbprjustquhlazkjfluxrzopqdstulybnqvyknrchbphcarknnhhovweaqawdyxsqsqahkepluypwrzjegqtdoxfgzdkydeoxvrfhxusrujnmjzqrrlxglcmkiykldbiasnhrjbjekystzilrwkzhontwmehrfsrzfaqrbbxncphbzuuxeteshyrveamjsfiaharkcqxefghgceeixkdgkuboupxnwhnfigpkwnqdvzlydpidcljmflbccarbiegsmweklwngvygbqpescpeichmfidgsjmkvkofvkuehsmkkbocgejoiqcnafvuokelwuqsgkyoekaroptuvekfvmtxtqshcwsztkrzwrpabqrrhnlerxjojemcxel";
        String[] words = {"bar","foo","the"};
        System.out.println(solution.findSubstring(s, words));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    //超时。。。
    class Solution {
        public List<Integer> findSubstring(String s, String[] words) {
            char[] orginChars = s.toCharArray();
            ArrayList<Integer> res = new ArrayList<>();
            // 获取words的排列组合集
            backTrace(words, new int[words.length], 0, new StringBuilder());

            // 计算words中每个字符出现的次数
            HashMap<Character, Integer> need = new HashMap<>();
            int totalNeedCharNums = 0;
            for (int i = 0; i < words.length; i++) {
                char[] chars = words[i].toCharArray();
                for (int j = 0; j < chars.length; j++) {
                    need.put(chars[j], need.getOrDefault(chars[j], 0) + 1);
                    totalNeedCharNums++;
                }
            }

            // 多少个字符
            int groupCount = need.size();

            HashMap<Character, Integer> window = new HashMap<>();
            int slow = 0;
            int quick = 0;
            // 窗口字符分组的个数
            int finshChaNum = 0;
            // 窗口长度
            int childCharNum = 1;
            while (slow <= quick && quick < orginChars.length) {
                char rightChar = orginChars[quick];
                window.put(rightChar, window.getOrDefault(rightChar, 0) + 1);
                if (need.containsKey(rightChar) && window.get(rightChar).equals(need.get(rightChar))) {
                    finshChaNum++;
                }

                // 左指针右移
                while (finshChaNum == groupCount) {
                    // 找到的字符分组个数和需要的字符分组个数相同并且窗口字符总数和需要的字符总数相等
                    if (childCharNum == totalNeedCharNums  ) {
                        String childStr = String.copyValueOf(orginChars, slow, childCharNum);
                        if (strs.contains(childStr)){
                            res.add(slow);
                        }
                    }
                    char leftChar = orginChars[slow];
                    window.put(leftChar, window.get(leftChar) - 1);
                    slow++;
                    childCharNum--;
                    if (need.containsKey(leftChar)){
                        if ( window.get(leftChar) < need.get(leftChar)) {
                            finshChaNum--;
                        }
                    }
                }

                // 右指针右移
                quick++;
                childCharNum++;
            }

            return res;
        }

        Set<String> strs = new HashSet<>();

        public void backTrace(String[] words, int[] used, int chose, StringBuilder sb) {
            if (chose == words.length) {
                strs.add(sb.toString());
            }

            for (int i = 0; i < words.length; i++) {
                if (used[i] == 1) {
                    continue;
                }
                used[i] = 1;
                backTrace(words, used, chose + 1, sb.append(words[i]));
                sb.delete(sb.length() - words[i].length(), sb.length());
                used[i] = 0;
            }


        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
