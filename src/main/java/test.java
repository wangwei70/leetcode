import java.util.HashMap;
import java.util.Scanner;

/**
 * 题目描述
 * Y 是一个非常注重外表的人，当他检阅一个军训方阵时，他只会关注到方阵里“美丽值”最大的同学。
 * 现在给定一个 n * m 的军训方阵中每个同学的美丽值 a_{ij}，请求出每个 l * l 子矩阵中的最大美丽值。c
 * 解答要求时间限制：6000ms, 内存限制：256MB
 * 输入
 * 第一行三个整数 n, m, l 用空格隔开，意义如题目所示。
 * 接下来 n 行，每行 m 个整数表示该位置同学的美丽值。
 * 1 ≤ n, m ≤ 2000, l ≤ n, l ≤ m, -10**9 ≤ a_{i,j} ≤ 10**9
 * 输出
 * 输出一个 (n - l + 1) * (m - l + 1) 的矩阵 B。
 * 矩阵 B 中的元素 b_{ij} 表示以 (i, j) 为最左上角元素的 l * l 的子矩阵中的美丽值最大值。
 * 注意每一行行末都有一个额外空格。
 * 样例
 * 输入样例 1 复制
 * 5 4 3
 * 3 -1 2 1
 * 2 3 -10 2
 * 1 2 3 4
 * 2 2 5 -1
 * 1 5 2 -1
 * 输出样例 1
 * 3 4
 * 5 5
 * 5 5
 * <p>
 * <p>
 * 3 -1 2 1
 * 2
 */
public class test {
    public static void main(String[] args) {
//        int[] arr={3,-1,2,1};
//        int[] arr={4,3,6,-1,2,1};
        int[] arr={4,3,3,-1,3,1,7,8,0,-3};
        int[] res = get(arr, 4);
        for (int re : res) {
            System.out.println(re);
        }
    }

    public  static int[] get(int[] arr, int l) {
        int left = 0;
        int right = 0;
        int max = Integer.MIN_VALUE;
        HashMap<Integer, Integer> win = new HashMap<>();
        int[] res = new int[arr.length - l + 1];
        int idx=0;
        while (right < arr.length) {
            int rightNum = arr[right];
            win.put(rightNum, win.getOrDefault(right, 0) + 1);
            max = Math.max(max, rightNum);
            while (right - left + 1 == l) {
                res[idx]=max;
                idx++;
                int leftNum = arr[left];
                win.put(leftNum, win.get(leftNum) - 1);
                left++;
                if (leftNum == max && win.get(leftNum) == 0) {
                    max = getMax(left, right, arr);
                }
            }
            right++;
        }
        return res;
    }

    public static int getMax(int l, int r, int[] arr) {
        int max=Integer.MIN_VALUE;
        for (int i = l; i <=  r; i++) {
            max=Math.max(max,arr[i]);
        }
        return max;
    }
}
