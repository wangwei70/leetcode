package editor.cn;

//车上最初有 capacity 个空座位。车 只能 向一个方向行驶（也就是说，不允许掉头或改变方向） 
//
// 给定整数 capacity 和一个数组 trips , trip[i] = [numPassengersi, fromi, toi] 表示第 i 次旅行有
// numPassengersi 乘客，接他们和放他们的位置分别是 fromi 和 toi 。这些位置是从汽车的初始位置向东的公里数。 
//
// 当且仅当你可以在所有给定的行程中接送所有乘客时，返回 true，否则请返回 false。 
//
// 
//
// 示例 1： 
//
// 
//输入：trips = [[2,1,5],[3,3,7]], capacity = 4
//输出：false
// 
//
// 示例 2： 
//
// 
//输入：trips = [[2,1,5],[3,3,7]], capacity = 5
//输出：true
// 
//
// 
//
// 提示： 
//
// 
// 1 <= trips.length <= 1000 
// trips[i].length == 3 
// 1 <= numPassengersi <= 100 
// 0 <= fromi < toi <= 1000 
// 1 <= capacity <= 105 
// 
// Related Topics 数组 前缀和 排序 模拟 堆（优先队列） 
// 👍 372 👎 0

public class _1094_拼车 {
    public static void main(String[] args) {
        Solution solution = new _1094_拼车().new Solution();
        int[][] trips={{9,0,1},{3,3,7}};
        boolean b = solution.carPooling(trips, 4);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean carPooling(int[][] trips, int capacity) {
            int[] diff = new int[1000];
            for (int i = 0; i < trips.length; i++) {
                int numPassengers = trips[i][0];
                int from = trips[i][1]-1;
                int to = trips[i][2]-1;
                diff[from]+=numPassengers;
                diff[to]-=numPassengers;
            }

            int[] res = new int[1000];
            res[0]=diff[0];
            if (res[0]>capacity) return false;
            for (int i = 1; i < diff.length; i++) {
                res[i]=diff[i]+res[i-1];
                if (res[i]>capacity){
                    return false;
                }
            }
            return true;

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
