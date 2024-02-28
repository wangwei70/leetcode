package editor.cn;

//给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。 
//
// 请注意 ，必须在不复制数组的情况下原地对数组进行操作。 
//
// 
//
// 示例 1: 
//
// 
//输入: nums = [0,1,0,3,12]
//输出: [1,3,12,0,0]
// 
//
// 示例 2: 
//
// 
//输入: nums = [0]
//输出: [0] 
//
// 
//
// 提示: 
// 
//
// 
// 1 <= nums.length <= 104 
// -231 <= nums[i] <= 231 - 1 
// 
//
// 
//
// 进阶：你能尽量减少完成的操作次数吗？ 
// Related Topics 数组 双指针 
// 👍 2305 👎 0

public class _283_移动零 {
    public static void main(String[] args) {
        Solution solution = new _283_移动零().new Solution();
        solution.moveZeroes(null);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public void moveZeroes(int[] nums) {
            int findZore = 0;
            int quick = 0;
            while (quick < nums.length) {
                while (findZore < nums.length &&nums[findZore] != 0) {
                    findZore++;
                }
                quick = findZore + 1;
                while (quick < nums.length && nums[quick] == 0) {
                    // 找到不为0的值，与前面的0进行位置交换
                    quick++;
                }
                if (quick>=nums.length){
                    break;
                }
                int temp = nums[quick];
                nums[quick] = nums[findZore];
                nums[findZore] = temp;
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
