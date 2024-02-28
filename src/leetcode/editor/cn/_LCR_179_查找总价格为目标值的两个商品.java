package editor.cn;

//购物车内的商品价格按照升序记录于数组 price。请在购物车中找到两个商品的价格总和刚好是 target。若存在多种情况，返回任一结果即可。 
//
// 示例 1： 
//
// 
//输入：price = [3, 9, 12, 15], target = 18
//输出：[3,15] 或者 [15,3]
// 
//
// 示例 2： 
//
// 
//输入：price = [8, 21, 27, 34, 52, 66], target = 61
//输出：[27,34] 或者 [34,27]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= price.length <= 10^5 
// 1 <= price[i] <= 10^6 
// 1 <= target <= 2*10^6 
// 
// Related Topics 数组 双指针 二分查找 
// 👍 288 👎 0

public class _LCR_179_查找总价格为目标值的两个商品 {
    public static void main(String[] args) {
        Solution solution = new _LCR_179_查找总价格为目标值的两个商品().new Solution();

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] twoSum(int[] price, int target) {
            int l = 0;
            int r = price.length - 1;

            while (price[l] + price[r] != target && l < r) {
                if (price[l] + price[r] < target) {
                    l++;
                }
                if (price[l] + price[r] > target) {
                    r--;
                }
            }
            int[] res = {price[l],price[r]};
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
