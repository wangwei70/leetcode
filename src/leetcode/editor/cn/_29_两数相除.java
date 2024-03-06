package editor.cn;

//给你两个整数，被除数 dividend 和除数 divisor。将两数相除，要求 不使用 乘法、除法和取余运算。 
//
// 整数除法应该向零截断，也就是截去（truncate）其小数部分。例如，8.345 将被截断为 8 ，-2.7335 将被截断至 -2 。 
//
// 返回被除数 dividend 除以除数 divisor 得到的 商 。 
//
// 注意：假设我们的环境只能存储 32 位 有符号整数，其数值范围是 [−231, 231 − 1] 。本题中，如果商 严格大于 231 − 1 ，则返回 2
//31 − 1 ；如果商 严格小于 -231 ，则返回 -231 。 
//
// 
//
// 示例 1: 
//
// 
//输入: dividend = 10, divisor = 3
//输出: 3
//解释: 10/3 = 3.33333.. ，向零截断后得到 3 。 
//
// 示例 2: 
//
// 
//输入: dividend = 7, divisor = -3
//输出: -2
//解释: 7/-3 = -2.33333.. ，向零截断后得到 -2 。 
//
// 
//
// 提示： 
//
// 
// -231 <= dividend, divisor <= 231 - 1 
// divisor != 0 
// 
// Related Topics 位运算 数学 
// 👍 1218 👎 0

import com.sun.org.apache.bcel.internal.generic.IF_ACMPEQ;

public class _29_两数相除 {
    public static void main(String[] args) {
        Solution solution = new _29_两数相除().new Solution();
        System.out.println(Integer.MIN_VALUE);
        System.out.println(Integer.MAX_VALUE);
        System.out.println(solution.divide(-2147483648, -1));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        // 暴力解法 超时....
        public int divide(int dividend, int divisor) {
            // 负数
            boolean negative = false;

            if ((dividend < 0 && divisor > 0) || (dividend > 0 && divisor < 0)) {
                negative = true;
            }

            int negDivid = negativeNum(dividend);
            int negDivis = negativeNum(divisor);

            int res = 0;
            int sum = 0;
            while (sum >= negDivid) {
                res++;
                sum += negDivis;
                if (sum < negDivid) {
                    res--;
                }
            }

            if (negative) return -res;
            return res;
        }

        private int negativeNum(int dividend) {
            if (dividend>0){
                return -dividend;
            }
            return dividend;
        }


    }
//leetcode submit region end(Prohibit modification and deletion)

}
