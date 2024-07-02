package editor.cn;

//请设计一个自助结账系统，该系统需要通过一个队列来模拟顾客通过购物车的结算过程，需要实现的功能有： 
//
// 
// get_max()：获取结算商品中的最高价格，如果队列为空，则返回 -1 
// add(value)：将价格为 value 的商品加入待结算商品队列的尾部 
// remove()：移除第一个待结算的商品价格，如果队列为空，则返回 -1 
// 
//
// 注意，为保证该系统运转高效性，以上函数的均摊时间复杂度均为 O(1) 
//
// 
//
// 示例 1： 
//
// 
//输入: 
//["Checkout","add","add","get_max","remove","get_max"]
//[[],[4],[7],[],[],[]]
//
//输出: [null,null,null,7,4,7]
// 
//
// 示例 2： 
//
// 
//输入: 
//["Checkout","remove","get_max"]
//[[],[],[]]
//
//输出: [null,-1,-1]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= get_max, add, remove 的总操作数 <= 10000 
// 1 <= value <= 10^5 
// 
//
// 
// Related Topics 设计 队列 单调队列 
// 👍 526 👎 0

import java.util.ArrayList;
import java.util.LinkedList;

public class _LCR_184_设计自助结算系统 {
    public static void main(String[] args) {


    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Checkout {

        public Checkout() {

        }

        private LinkedList<Integer> max = new LinkedList();
        private ArrayList<Integer> list = new ArrayList();

        public int get_max() {
            return max.size() == 0 ? -1 : max.peekFirst();
        }

        public void add(int value) {
            list.add(value);
            while (max.peekLast() != null && max.peekLast() < value) {
                max.pollLast();
            }
            max.addLast(value);
        }

        public int remove() {
            if (list.size() > 0) {
                Integer remove = list.remove(0);
                if (remove.equals(max.peekFirst())) {
                    max.pollFirst();
                }
                return remove;
            }
            return -1;
        }
    }

/**
 * Your Checkout object will be instantiated and called as such:
 * Checkout obj = new Checkout();
 * int param_1 = obj.get_max();
 * obj.add(value);
 * int param_3 = obj.remove();
 */
//leetcode submit region end(Prohibit modification and deletion)

}
